package com.walloce.utils;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PraseHtmlUtils {
    /**
     * 解析页面数据获取天气信息
     * @return
     */
    public String weatherMessage() {
        Map<String, Map<String,String>> weatherinfo = new HashMap<String, Map<String,String>>();
        Map<String, String> infoMap = new HashMap<String, String>();
        try {
            //根据url获取网页内容
            Document doc = Jsoup.connect("http://www.soweather.com/").get();
            Elements imgTag = doc.getElementById("lefts").getElementsByAttribute("src");
            //获取天气图片的src地址
            String src = imgTag.attr("src");
            infoMap.put("imgurl", src);

            //获取温度的数据
            Element wenduElement = doc.getElementById("rights").getElementsByIndexEquals(0).get(0);
            String wendu = wenduElement.html();
            infoMap.put("wendu", wendu);

            //获取天气状况的数据
            Element tianqiElement = doc.getElementById("rights").getElementsByIndexEquals(1).get(1);
            String tianqi = tianqiElement.html();
            infoMap.put("tianqi", tianqi);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        weatherinfo.put("soweatherinfo", infoMap);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(weatherinfo);
        return jsonObject.toString();
    }
}
