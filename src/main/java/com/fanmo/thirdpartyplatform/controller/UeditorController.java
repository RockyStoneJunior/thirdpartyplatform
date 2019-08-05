package com.fanmo.thirdpartyplatform.controller;

import com.fanmo.thirdpartyplatform.persistence.dao.ArticleRepository;
import com.fanmo.thirdpartyplatform.persistence.model.Article;
import com.fanmo.thirdpartyplatform.utils.Base64ToImg;
import com.fanmo.thirdpartyplatform.utils.ueditor.ActionEnter;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 用于处理关于ueditor插件相关的请求
 * @author lhh
 * @date 2019-06-19
 *
 * @refrence: https://blog.csdn.net/lhh143400/article/details/92802377
 */
@RestController
//@CrossOrigin
@RequestMapping("/thirdpartyplatform/ueditor")
public class UeditorController {

    @Autowired
    ArticleRepository articleRepository;


    @RequestMapping(value = "/exec")
    public String exec( HttpServletRequest request) throws UnsupportedEncodingException, JSONException {
        request.setCharacterEncoding("utf-8");
        String rootPath = request.getServletContext().getRealPath("/");

        System.out.println("Request from Ueditor: " + request.getRequestURI());

        String result = new ActionEnter( request, rootPath ).exec();

        //return new ActionEnter( request, rootPath ).exec();
        System.out.println("result: " + result);

//        JSONObject jsonObject =  JSON.parseObject(result);
//        System.out.println(jsonObject.get("url"));

        return result;
    }

    @RequestMapping(value = "/add_artical", method = {RequestMethod.POST})
    public Map<String, String> addArtical(@RequestBody Map artical){

        String b_username = (String) artical.get("b_username");

        System.out.println(artical);
        System.out.println(artical.get("b_username"));

        ArrayList article_list = (ArrayList) artical.get("articles");
        String groupid = UUID.randomUUID().toString();

        for(Object obj : article_list){
            Map article_item = (Map)obj;

            article_item.put("b_username", b_username);
            article_item.put("groupid", groupid);
            Article article_to_save = new Article(article_item);

            articleRepository.save(article_to_save);
        }

        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("msg", "文章上传成功！");
        resultMap.put("code", "0");

        return resultMap;
    }

    @RequestMapping(value = "/get_artical", method = {RequestMethod.GET})
    public List<Article> getArtical(){

        //List<Article> artical = articleRepository.findAllByPlatformName(platform_name);

        return articleRepository.findAllGroupbyGroupid();
    }

    @RequestMapping(value = "/upload_image", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addLeaveInfo(HttpServletRequest request,@RequestParam Map params)throws Exception
    {

        String rootPath = request.getServletContext().getRealPath("/");
        String urlString;
        urlString = Base64ToImg.GenerateImage(params.get("thumb_media_img").toString(),rootPath + "thumb_img/","http://192.168.31.114:10000/");


        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("msg", "图片上传成功！");
        resultMap.put("code", "0");
        resultMap.put("data", urlString);

        return resultMap;
    }
}