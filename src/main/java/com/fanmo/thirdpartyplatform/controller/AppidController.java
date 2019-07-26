package com.fanmo.thirdpartyplatform.controller;

import com.fanmo.thirdpartyplatform.persistence.dao.AccountRepository;
import com.fanmo.thirdpartyplatform.persistence.dao.AppIdRepository;
import com.fanmo.thirdpartyplatform.persistence.model.Account;
import com.fanmo.thirdpartyplatform.persistence.model.AppId;
import com.fanmo.thirdpartyplatform.utils.MD5;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "添加和编辑用户信息")
@RestController
@RequestMapping(value="/appid")
public class AppidController {
    @Autowired
    private AppIdRepository appIdRepository;

    @Autowired
    private AccountRepository accountRepository;

    /**
     * 用户登录
     */
    @ApiOperation(value = "添加用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "b_username", value = "B端药师用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "platform_appid", value = "第三方平台appid", required = true, dataType = "String"),
            @ApiImplicitParam(name = "platform_secret", value = "第三方平台appsecret", required = true, dataType = "String"),
            @ApiImplicitParam(name = "minipro_name", value = "小程序名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "minipro_appid", value = "小程序appid", required = false, dataType = "String"),
            @ApiImplicitParam(name = "minipro_secret", value = "小程序秘钥", required = false, dataType = "String"),
            @ApiImplicitParam(name = "merchant_no", value = "商户号", required = false, dataType = "String"),
            @ApiImplicitParam(name = "merchant_secret", value = "商户秘钥", required = false, dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code=200,message = "{'code':'状态码', 'msg':'错误消息'}"),
    })

    @RequestMapping(value="/add", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String,String> addAppId(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String b_username = request.getParameter("b_username");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String platform_appid = request.getParameter("platform_appid");
        String platform_secret = request.getParameter("platform_secret");
        String minipro_name = request.getParameter("minipro_name");
        String minipro_appid = request.getParameter("minipro_appid");
        String minipro_secret = request.getParameter("minipro_secret");
        String merchant_no = request.getParameter("merchant_no");
        String merchant_secret = request.getParameter("merchant_secret");

        if(b_username == null || b_username.equals("")){
            Map<String, String> resultMap = new HashMap<String, String>();
            resultMap.put("msg", "b_username不能为空！");
            resultMap.put("code","1");

            return resultMap;
        }else{
            Account account = accountRepository.findByUsername(b_username);

            if(account == null){
                Map<String, String> resultMap = new HashMap<String, String>();
                resultMap.put("msg", "b_username账号不存在！");
                resultMap.put("code","3");

                return resultMap;
            }
        }

        if(username == null || username.equals("")){
            Map<String, String> resultMap = new HashMap<String, String>();
            resultMap.put("msg", "账号不能为空！");
            resultMap.put("code","1");

            return resultMap;
        }

        if(password == null || password.equals("")) {
            Map<String, String> resultMap = new HashMap<String, String>();
            resultMap.put("msg", "密码不能为空！");
            resultMap.put("code", "1");

            return resultMap;
        }

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes("UTF-8"));
        String password_encypted = MD5.byteArrayToHexString(md.digest());

//        System.out.println(password);
//        System.out.println(password_encypted);

//        AppId oldAppId = appIdRepository.findByUsernameAndPassword(username, password_encypted);

        AppId oldAppId = appIdRepository.findByUsername(username);

        if(oldAppId != null){
            Map<String, String> resultMap = new HashMap<String, String>();
            resultMap.put("code","2");
            resultMap.put("msg", "用户名已被占用！");
            return resultMap;
        }

        if(platform_appid != null){

            AppId appId = appIdRepository.findByPlatformAppid(platform_appid);

            if(appId != null){
                Map<String, String> resultMap = new HashMap<String, String>();
                resultMap.put("msg", "Appid已经存在！");
                resultMap.put("code","2");

                return resultMap;
            }else {

                AppId userAppid = new AppId();

                userAppid.setbUsername(b_username);
                userAppid.setUsername(username);
                userAppid.setPassword(password_encypted);
                userAppid.setPlatformAppid(platform_appid);
                userAppid.setPlatformSecret(platform_secret);
                userAppid.setMiniproName(minipro_name);
                userAppid.setMiniproAppid(minipro_appid);
                userAppid.setMiniproSecret(minipro_secret);
                userAppid.setMerchantNo(merchant_no);
                userAppid.setMerchantSecret(merchant_secret);

                appIdRepository.save(userAppid);

                Map<String, String> resultMap = new HashMap<String, String>();
                resultMap.put("msg", "Appid添加成功！");
                resultMap.put("code", "0");

                return resultMap;
            }
        }else{
            Map<String, String> resultMap = new HashMap<String, String>();
            resultMap.put("msg", "公众号APPID不能为空！");
            resultMap.put("code","1");

            return resultMap;
        }
    }

    @ApiOperation(value = "查找用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "b_username", value = "B端药师用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "公众号，小程序或者账号", required = false, dataType = "String")
    })

    @RequestMapping(value="/find", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<AppId> findAppId(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String b_username = request.getParameter("b_username");
        String name = request.getParameter("name");

        if(b_username == null || b_username.equals("")){
            return null;
        }

        List<AppId> resultList = null;

        if(name == null || name.equals("")) {
            resultList = appIdRepository.findAllByBUsername(b_username);
        }else{
            resultList = appIdRepository.findAllByPlatformNameOrMiniproNameOrUsername(name,name,name);
        }

        return resultList;
    }

    @ApiOperation(value = "编辑用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户信息编号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "b_username", value = "B端药师用户名", required = true, dataType = "String")
    })
    @RequestMapping(value="/findForEdit", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AppId findAppIdForEdit(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String id = request.getParameter("id");
        String b_username = request.getParameter("b_username");

        if(id == null || id.equals("")){
            return null;
        }

        if(b_username == null || b_username.equals("")){
            return null;
        }

        AppId result = appIdRepository.findByIdAndBUsername(Long.parseLong(id),b_username);

        return result;
    }

    @ApiOperation(value = "更新用户信息")
    @ApiResponses({
            @ApiResponse(code=200,message = "{'code':'状态码', 'msg':'错误消息'}"),
    })

    @RequestMapping(value="/update", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String,String> updateAppId(@RequestBody AppId appid) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        System.out.println(appid);

        Map<String, String> resultMap = new HashMap<String, String>();

        if(appid != null){
            AppId result = appIdRepository.findById(appid.getId());

            if(!result.getPassword().equals(appid.getPassword())){
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(appid.getPassword().getBytes("UTF-8"));
                String password_encypted = MD5.byteArrayToHexString(md.digest());
                appid.setPassword(password_encypted);
            }
            appIdRepository.save(appid);

            resultMap.put("msg", "更新成功！");
            resultMap.put("code","0");
        }else{
            resultMap.put("msg", "更新失败！");

            resultMap.put("code","1");
        }

        return resultMap;
    }
}
