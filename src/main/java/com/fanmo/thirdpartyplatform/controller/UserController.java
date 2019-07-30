package com.fanmo.thirdpartyplatform.controller;

import com.fanmo.thirdpartyplatform.persistence.dao.AccountRepository;
import com.fanmo.thirdpartyplatform.persistence.dao.BranchRepository;
import com.fanmo.thirdpartyplatform.persistence.dao.MerchantRepository;
import com.fanmo.thirdpartyplatform.persistence.model.Account;
import com.fanmo.thirdpartyplatform.utils.MD5;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


@Api(tags = "用户注册和登录")
@RestController
@RequestMapping(value="/thirdpartyplatform/user")
public class UserController {
	
	@Autowired
	private MerchantRepository merchantRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private AccountRepository accountRepository;


	@ApiOperation(value = "注册药师账号")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
			@ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String"),
			@ApiImplicitParam(name = "mobile", value = "手机号", required = true, dataType = "String"),
			@ApiImplicitParam(name = "code", value = "推码，默认是 '123456'", required = true, dataType = "String")
	})
	@ApiResponses({
			@ApiResponse(code=200,message = "{'code':'状态码', 'msg':'错误消息'}"),
	})
	@RequestMapping(value="/register", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map<String,String> userRegister(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {

					Map<String, String> resultMap = new HashMap<String, String>();

					String username = request.getParameter("username");
					String password = request.getParameter("password");
					String name = request.getParameter("name");
					String mobile = request.getParameter("mobile");
					String code = request.getParameter("code");

					if(code == null || !code.equals("123456")){
						resultMap.put("msg", "推码错误！");
						resultMap.put("code","2");
						return resultMap;
					}

					
					Account account = accountRepository.findByUsername(username);
					
					if(account == null)
					{
						Account account_new = new Account();
						account_new.setUsername(username);
						
						MessageDigest md = MessageDigest.getInstance("MD5");
				        md.update(password.getBytes("UTF-8"));
				        String password_encypted = MD5.byteArrayToHexString(md.digest());
						account_new.setPassword(password_encypted);

						account_new.setName(name);
						account_new.setCode(code);
						account_new.setMobile(mobile);
						
						accountRepository.save(account_new);

						resultMap.put("msg", "注册成功！");
						resultMap.put("code","0");
						
						return resultMap;
					}else {
						resultMap.put("msg", "该用户名已被注册！");
						resultMap.put("code","1");

						return resultMap;
					}
	}

	@ApiOperation(value = "药师登录接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
	})
	@ApiResponses({
			@ApiResponse(code=200,message = "{'code':'状态码', 'msg':'错误消息','type':'用户类型','username':'用户账号'}"),
	})
	@RequestMapping(value="/login", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map<String,String> userLogin(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes("UTF-8"));
        String password_encypted = MD5.byteArrayToHexString(md.digest());
        
        System.out.println(password);
        System.out.println(password_encypted);
		
		Account account = accountRepository.findByUsernameAndPassword(username, password_encypted);
		
		if(account != null)
		{
//			if(NewOrderPrompt.branchSocket.containsKey(username))
//			{
//				return Collections.singletonMap("result", "islogin");
//			}else {
//
//				System.out.println(session.getId());
//
//				final ServletContext context = session.getServletContext();
//				context.setAttribute(session.getId(), session);
				
				Map<String, String> resultMap = new HashMap<String, String>();
				resultMap.put("code","0");
				resultMap.put("msg", "登录成功！");
				resultMap.put("type", "B");
				resultMap.put("username", username);
				return resultMap;
//			}
		}else {
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put("code","1");
			resultMap.put("msg", "登录失败！");
			return resultMap;
			//return Collections.singletonMap("result", "failed");
		}
	}
}
