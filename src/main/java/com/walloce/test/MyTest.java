package com.walloce.test;

import com.walloce.utils.htmlprase.PraseHtmlUtils;
import com.walloce.utils.splitstr.SplitStr;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: YinYichang
 * @Date: 2018/7/18
 */
public class MyTest {
    public static void main(String[] args) {
       /* PraseHtmlUtils praseHtmlUtils = new PraseHtmlUtils();
        String message = praseHtmlUtils.weatherMessage();
        System.out.print(message);*/
        String str = "a,b,c,d,e,f,g,a,b,c,d,e,f,g,a,b,c,d,e,f,g,a,b,c,d,e,f,g,a,b,c,d,e,f,g,a,b,c,d,e,f,g";
        System.out.println(str.indexOf(",") + "---" + str.substring(0, 1) + "==" + str.substring(2, str.length()));
        long length = 10000000;
        //indexof字符串分割测试
        long begin = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            String[] strs = SplitStr.splitByIndex(str, ",");
        }
        long end = System.currentTimeMillis();
        System.out.println("indexof分割字符串用时："+(end - begin));

        begin = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            ArrayList<String> strs = SplitStr.splitByIndex1(str, ",");
        }
        end = System.currentTimeMillis();
        System.out.println("indexof1分割字符串用时："+(end - begin));

        //charAt字符串分割测试
        begin = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            String[] strs = SplitStr.splitByCharAt(str, ',');
        }
        end = System.currentTimeMillis();
        System.out.println("charAt分割字符串用时："+(end - begin));

        begin = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            ArrayList<String> strs = SplitStr.splitByCharAt1(str, ',');
        }
        end = System.currentTimeMillis();
        System.out.println("charAt1分割字符串用时："+(end - begin));

        //split字符串分割测试
        begin = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            String[] strs = str.split(",");
        }
        end = System.currentTimeMillis();
        System.out.println("split分割字符串用时："+(end - begin));

       /* String[] strs = SplitStr.splitByCharAt(str, ',');
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }*/
    }
}
