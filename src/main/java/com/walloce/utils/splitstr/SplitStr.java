package com.walloce.utils.splitstr;

import org.jsoup.helper.StringUtil;

import java.util.ArrayList;

/**
 * @program: myUtils
 * @description:
 * @author: YinYichang
 * @create: 2018/07/18 10:24
 **/
public class SplitStr {

    /**
     * @Description: 通过indexof分割字符串
     * @Param: [str, regx]
     * @return: java.lang.String[]
     * @Author: YinYichang
     * @Date: 2018/7/18
     */
    public static String[] splitByIndex(String str, String regx) {
        //字符串截取的开始位置
        int begin = 0;
        //字符串截取的结束位置
        int limit = 0;
        //截取分割得到的字符串
        String splitStr = "";
        ArrayList<String> result = new ArrayList<String>();
        while (str.indexOf(regx) != -1) {
            //设置要截取的位置
            limit = str.indexOf(regx);
            splitStr = str.substring(begin, limit);
            //设置截取后的字符串
            str = str.substring(limit + 1, str.length());
            result.add(splitStr);
        }
        if (!StringUtil.isBlank(str)) {
            result.add(str);
        }
        String[] strs = new String[result.size()];
        return result.toArray(strs);
    }

    public static ArrayList<String> splitByIndex1(String str, String regx) {
        //字符串截取的开始位置
        int begin = 0;
        //字符串截取的结束位置
        int limit = 0;
        //截取分割得到的字符串
        String splitStr = "";
        ArrayList<String> result = new ArrayList<String>();
        while (str.indexOf(regx) != -1) {
            //设置要截取的位置
            limit = str.indexOf(regx);
            splitStr = str.substring(begin, limit);
            //设置截取后的字符串
            str = str.substring(limit + 1, str.length());
            result.add(splitStr);
        }
        if (!StringUtil.isBlank(str)) {
            result.add(str);
        }
        return result;
    }

    /**
     * @Description: 通过charAt分割字符串
     * @Param: [str, regx]
     * @return: java.lang.String[]
     * @Author: YinYichang
     * @Date: 2018/7/18
     */
    public static String[] splitByCharAt(String str, char regx) {
        //字符串截取的开始位置
        int begin = 0;
        //截取分割得到的字符串
        String splitStr = "";
        ArrayList<String> result = new ArrayList<String>();
        int length = str.length();
        //计数器
        int i = 0;
        for (i = 0; i < length;i++ ) {
            if (str.charAt(i) == regx) {
                splitStr = str.substring(begin, i);
                result.add(splitStr);
                str = str.substring(i + 1, length);
                length = str.length();
                i = 0;
            }
        }
        if (!StringUtil.isBlank(str)) {
            result.add(str);
        }
        String[] strs = new String[result.size()];
        return result.toArray(strs);
    }

    public static ArrayList<String> splitByCharAt1(String str, char regx) {
        //字符串截取的开始位置
        int begin = 0;
        //截取分割得到的字符串
        String splitStr = "";
        ArrayList<String> result = new ArrayList<String>();
        int length = str.length();
        //计数器
        int i = 0;
        for (i = 0; i < length;i++ ) {
            if (str.charAt(i) == regx) {
                splitStr = str.substring(begin, i);
                result.add(splitStr);
                str = str.substring(i + 1, length);
                length = str.length();
                i = 0;
            }
        }
        if (!StringUtil.isBlank(str)) {
            result.add(str);
        }
        return result;
    }
}
