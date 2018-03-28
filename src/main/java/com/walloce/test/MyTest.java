package com.walloce.test;

import com.walloce.utils.PraseHtmlUtils;

public class MyTest {
    public static void main(String args[]) {
        PraseHtmlUtils praseHtmlUtils = new PraseHtmlUtils();
        String message = praseHtmlUtils.weatherMessage();
        System.out.print(message);
    }
}
