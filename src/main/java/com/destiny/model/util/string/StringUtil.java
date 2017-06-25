package com.destiny.model.util.string;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StringUtil {


    public static boolean isEmpty (String content){
        return StringUtils.isEmpty(content);
    }

    public static String unicode2String(String unicode) {
        if (StringUtil.isEmpty(unicode))
            return "";
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while ((i = unicode.indexOf("\\u", pos)) != -1) {
            sb.append(unicode.substring(pos, i));
            if (i + 5 < unicode.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(unicode.substring(i + 2, i + 6), 16));
            }
        }

        sb.append(unicode.substring(pos));


        return sb.toString();
    }

    public static String string2Unicode(String string) {

        if (StringUtil.isEmpty(string))
            return null;
        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }

        return unicode.toString();
    }

    public static String URLencode(String content, String format) {

        try {
            return URLEncoder.encode(content, format);
        } catch (UnsupportedEncodingException e) {
            System.out.println("encode failure !");
            return "";
        }
    }


    public static String URLencode(String content) {

        try {
            return URLEncoder.encode(content, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("encode failure !");
            return "";
        }
    }

    public static String URLdecode(String content) {

        try {
            return URLDecoder.decode(content, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("decode failure !");
            return "";
        }

    }

    public static String URLdecode(String content,String format) {

        try {
            return URLDecoder.decode(content, format);
        } catch (UnsupportedEncodingException e) {
            System.out.println("decode failure !");
            return "";
        }
    }
}
