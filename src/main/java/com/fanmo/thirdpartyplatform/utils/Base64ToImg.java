package com.fanmo.thirdpartyplatform.utils;

import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Mr Pan
 * on 2019/5/20.
 */
public class Base64ToImg {
    public static String GenerateImage(String imgStr, String imgFilePath,String rootPath) throws Exception {
        if (imgStr == null) // 图像数据为空
            return "";
        BASE64Decoder decoder = new BASE64Decoder();

        // Base64解码,对字节数组字符串进行Base64解码并生成图片
        imgStr = imgStr.replaceAll(" ", "+");
        System.out.println(imgStr);

        int start = imgStr.indexOf("/");
        int end = imgStr.indexOf(";");

        String format = imgStr.substring(start + 1, end);
        System.out.println("format: " + format);

        String target = "data:image/" + format + ";base64,";

        if(format.equals("jpeg")){
            format = "jpg";
        }

        byte[] b = decoder.decodeBuffer(imgStr.replace(target, ""));
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {// 调整异常数据
                b[i] += 256;
            }
        }
        String imgName = getRandomFileName() + "." + format;
        String dbUrl = "";
        // 生成jpeg图片D:\test\attendance\src\main\webapp\assets\images\leave
        imgFilePath = imgFilePath + imgName;//新生成的图片
        OutputStream out = new FileOutputStream(imgFilePath);
        out.write(b);
        out.flush();
        out.close();

        dbUrl = rootPath+"thumb_img/"+imgName;
        return dbUrl;
    }

    public static String getRandomFileName() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return rannum + str;// 当前时间
    }

}
