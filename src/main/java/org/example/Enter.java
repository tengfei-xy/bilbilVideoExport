package org.example;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Enter {
    public static void main(String[] args) throws Exception {

        bilUrl bilUrl = new bilUrl();
        bilUrl.url = "https://m.bilibili.com/video/BV1dP411474Z";
        // 有cookie的话，能获取到更高的清晰度
        bilUrl.cookie = "";
    
        bilUrl.getACID();
        System.out.printf("名称:%s\n",bilUrl.title);
        bilUrl.getUrl();

        File file = new File();
        file.videoURL = bilUrl.videoURL;
        file.audioURL = bilUrl.audioURL;
        file.codecType = bilUrl.codecType;
        file.title = bilUrl.title;
        file.download();
    }
}