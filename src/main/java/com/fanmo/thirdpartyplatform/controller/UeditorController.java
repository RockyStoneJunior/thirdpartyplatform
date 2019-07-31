package com.fanmo.thirdpartyplatform.controller;

import com.fanmo.thirdpartyplatform.utils.ueditor.ActionEnter;
import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

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
    //C:\Users\Administrator\AppData\Local\Temp\tomcat-docbase.8225506421906030130.10000
    @RequestMapping(value = "/exec")
    public String exec( HttpServletRequest request) throws UnsupportedEncodingException, JSONException {
        request.setCharacterEncoding("utf-8");
        String rootPath = request.getServletContext().getRealPath("/");

        return new ActionEnter( request, rootPath ).exec();
    }

}