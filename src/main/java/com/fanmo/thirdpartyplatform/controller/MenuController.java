package com.fanmo.thirdpartyplatform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fanmo.thirdpartyplatform.utils.*;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    @ResponseBody
    public Map<String, String> createMenu(@RequestBody Map request_menu) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //public String createMenu(@RequestBody Map[] menu) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        Menu new_menu = new Menu();
        List<Button> main_button = new ArrayList<Button>();

        try {

            String platform_name = (String)request_menu.get("platform_name");
            ArrayList menu_list = (ArrayList) request_menu.get("menu");

            Map menu[] = (Map[]) menu_list.toArray(new Map[menu_list.size()]);

            System.out.println("platform_name: " + platform_name);
            System.out.println("menu: " + menu_list.toString());

            for (int i = 0; i < menu.length; i++) {

                ArrayList sub_menu = (ArrayList) (menu[i].get("sub_menu"));

                List<Button> sub_button = new ArrayList<Button>();

                for (int j = 0; j < sub_menu.size(); j++) {

                    LinkedHashMap sub_menu_item = (LinkedHashMap) sub_menu.get(j);

                    if (sub_menu_item != null) {

                        if (sub_menu_item.get("type") != null) {
                            if (sub_menu_item.get("type").equals("miniprogram")) {
                                System.out.println(sub_menu_item.get("appid"));

                                MiniProButton miniProButton = new MiniProButton();
                                miniProButton.setName((String) sub_menu_item.get("name"));
                                miniProButton.setAppid((String) sub_menu_item.get("appid"));
                                miniProButton.setPagepath((String) sub_menu_item.get("link"));
                                miniProButton.setUrl("http://mp.weixin.qq.com");
                                miniProButton.setType("miniprogram");

                                sub_button.add(miniProButton);
                            } else if (sub_menu_item.get("type").equals("view")) {
                                ViewButton viewButton = new ViewButton();
                                viewButton.setName((String) sub_menu_item.get("name"));
                                viewButton.setUrl((String) sub_menu_item.get("link"));
                                viewButton.setType("view");

                                sub_button.add(viewButton);
                            } else if (sub_menu_item.get("type").equals("click")) {
                                ClickButton clickButton = new ClickButton();
                                clickButton.setName((String) sub_menu_item.get("name"));

                                String key = (String) sub_menu_item.get("key");
                                if (key == null || key.equals("")) {
                                    clickButton.setKey("33");
                                } else {
                                    clickButton.setKey(key);
                                }

                                clickButton.setType("click");

                                sub_button.add(clickButton);
                            }
                        }
                    }
                }

                Button button = new Button();
                button.setName((String) menu[i].get("main_menu"));
                button.setSub_button((Button[]) sub_button.toArray(new Button[sub_button.size()]));
                main_button.add(button);
            }

            System.out.println(main_button.size());

            new_menu.setButton((Button[]) main_button.toArray(new Button[main_button.size()]));

            //System.out.println(JSON.toJSON(MenuUtil.getMenu()).toString());
            //System.out.println(JSON.toJSON(new_menu).toString());

            String create_menu = JSON.toJSON(new_menu).toString();
            System.out.println(create_menu);
            String menu_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + getAccessToken();
            StringBuffer result = HttpUtil.httpsRequest(menu_url, "POST", create_menu);
            System.out.println(result);

            Map<String, String> resultMap = new HashMap<String, String>();
            resultMap.put("msg", result.toString());
            resultMap.put("code", "0");

            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();

            Map<String, String> resultMap = new HashMap<String, String>();
            resultMap.put("msg", "系统发生异常，菜单创建失败！");
            resultMap.put("code", "1");

            return resultMap;
        }
    }

    private String appid = "wxc6a0290ecf70a53d";
    private String secret = "c8822820e126922f20d12b82a5ecce35";

    private String access_token_requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
            + appid + "&secret=" + secret;

    public String getAccessToken() {
        try {
            System.out.println("微信公众号token定时任务开始");
            StringBuffer token_result = HttpUtil.httpsRequest(access_token_requestUrl, "GET", "");
            String token_string = new String(token_result);
            JSONObject obj = JSON.parseObject(token_string);
            System.out.println("微信公众号token----obj" + obj.toJSONString());
            return obj.get("access_token").toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
