package org.example;

import com.google.gson.Gson;
import esjon.Audio;
import esjon.PlayUrlData;
import esjon.Video;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class bilUrl {
    public  String url;
    public long aid ;
    public long cid;
    public String cookie;
    public String title;
    public String videoURL;
    public String audioURL;
    public String codecType;
    public void getACID() throws IOException {
        URL url = new URL(this.url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setRequestProperty("authority","m.bilibili.com");
        con.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        con.setRequestProperty("accept-language","zh-CN,zh;q=0.9");
        con.setRequestProperty("sec-fetch-dest","empty");
        // 有cookie的话，能获取到更高的清晰度
        con.setRequestProperty("cookie",cookie);
        con.setRequestProperty("sec-fetch-mode","cors");
        con.setRequestProperty("sec-fetch-site","same-site");
        con.setRequestProperty("user-agent","Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1");

        con.setDoOutput(true);

        int  status = con.getResponseCode();

//        con是一个URLConnection对象，用于建立与指定URL之间的连接。
//        getInputStream()是URLConnection类的一个方法，用于获取与此连接关联的输入流。
//        InputStreamReader是一个读取字符的桥接器，它将字节流转换为字符流。
//        BufferedReader是一个带有缓冲功能的字符输入流，它可以有效地读取字符流并提供更高效的读取操作。
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuilder originalData = new StringBuilder();
        while((inputLine = in.readLine())!=null){
            originalData.append(inputLine);
        }
        in.close();
//        System.out.printf("HTTP状态码:%d\n",status);
//        System.out.printf("内容:%s",originalData.toString());

        // 解析html
        Document doc = Jsoup.parse(originalData.toString());
        this.title = doc.select("h1.title").first().text();

        Element div = doc.select("div#bilibiliPlayer").first().nextElementSibling();
        assert div != null;


        Element script2 = div.select("script:nth-of-type(2)").first();
        assert script2 != null;

        String script2Content = script2.html();
        String j = script2Content.substring(script2Content.indexOf("{"),script2Content.indexOf("}")+3);

        Gson gson = new Gson();
        SeekJson seekjson = gson.fromJson(j, SeekJson.class);
        aid = seekjson.getAid();
        cid = seekjson.getCid();
//        System.out.printf("aid=%d,cid=%d\n",aid,cid);
    }
    public void getUrl() throws IOException {

        // 设置请求的URL地址
        URL url = new URL(String.format("https://api.bilibili.com/x/player/playurl?fnval=80&avid=%s&cid=%s",Long.toString(this.aid), Long.toString(this.cid)));

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

        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

//         响应状态码
//        System.out.println("HTTP状态码：" + status);
//         响应内容
        System.out.println(response.toString());

        Gson gson = new Gson();
        PlayUrlData data = gson.fromJson(response.toString(), PlayUrlData.class);

        // 输出视频
        for (Video x : data.getData().getDash().getVideo()) {
            String avc = this.codec(x.getCodecs());
            System.out.printf("视频流:[%s][%dp][%s]下载地址:%s\n",x.getMimeType(),x.getWidth(),avc,x.getBaseUrl());
            if (this.codecType == null && avc.equals("AVC"))  {
                this.videoURL = data.getData().getDash().getVideo().get(1).getBaseUrl();
                this.codecType= this.codec(data.getData().getDash().getVideo().get(1).getCodecs());
            }
        }

        // 输出音频
        for (Audio x : data.getData().getDash().getAudio()) {
            System.out.printf("音频流:下载地址:%s\n",x.getBaseUrl());
        }
        this.audioURL = data.getData().getDash().getAudio().get(0).getBaseUrl();
    }
    private String codec(String s){
        if (s.startsWith("avc")){
            return "AVC";
        }else if (s.startsWith("hev")){
            return "HEVC";
        }else if(s.startsWith("av")) {
            return "AV1";
        }
        return "未知编码";
    }
}
