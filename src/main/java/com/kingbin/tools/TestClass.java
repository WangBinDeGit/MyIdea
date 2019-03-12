package com.kingbin.tools;

import java.io.IOException;

/**
 * Created by jxd.
 * on 2018/12/7
 */
public class TestClass {


    public static void main(String[] args) throws IOException {

        String plainText = "admin张三admin张三admin张三";
        String subStr = "admin张三s";

        System.out.println("输出字符串"+StringUtil.isWhitespace(((CharSequence)plainText).charAt(0)));

        System.out.println("输出字符串"+StringUtil.containsWhitespace(plainText));

        System.out.println("输出字符串"+StringUtil.trimAll(plainText,'a')+".");

        System.out.println("输出字符串"+StringUtil.startsWithIgnoreCase(plainText,"qweqweqweqweqweqweqweqwe")+".");

        System.out.println("输出字符串"+StringUtil.find(plainText,subStr,2)+".");

    }
}
