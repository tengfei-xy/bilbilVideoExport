package org.example;
import esjon.Audio;
import esjon.PlayUrlData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import esjon.Video;


// 生成的java类

public class HttpPostRequest {
    public static void main(String[] args) throws Exception {
        String avoid = "489358543";
        String cid = "1221237792";
        String cookie = "";

        // 设置请求的URL地址
        URL url = new URL("https://api.bilibili.com/x/player/playurl?fnval=80&avid=" + avoid + "&cid="+ cid);

        // 创建连接对象
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // 设置请求方法为POST
        con.setRequestMethod("GET");

        // 设置请求头
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("authority","api.bilibili.com");
        con.setRequestProperty("accept", "application/json, text/plain, */*");
        con.setRequestProperty("accept-language","zh-CN,zh;q=0.9");
        con.setRequestProperty("origin","https://m.bilibili.com");
        con.setRequestProperty("referer","https://m.bilibili.com/");
        con.setRequestProperty("sec-fetch-dest","empty");
        // 有cookie的话，能获取到更高的清晰度
        con.setRequestProperty("cookie",cookie);
        con.setRequestProperty("sec-fetch-mode","cors");
        con.setRequestProperty("sec-fetch-site","same-site");
        con.setRequestProperty("user-agent","Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1");


        con.setDoOutput(true);

        // 发送请求并获取响应
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // 打印响应结果
        System.out.println("HTTP状态码：" + status);
        System.out.println("响应内容：" + response.toString());

        Gson gson = new Gson();
        PlayUrlData data = gson.fromJson(response.toString(), PlayUrlData.class);
        for (Video x : data.getData().getDash().getVideo()) {
            System.out.printf("视频:类型:%s,清晰度:%sp,下载地址:%s\n",x.getMimeType(),x.getWidth(),x.getBaseUrl());
        }
        for (Audio x : data.getData().getDash().getAudio()) {
            System.out.printf("音频:下载地址:%s\n",x.getBaseUrl());
        }
    }
}