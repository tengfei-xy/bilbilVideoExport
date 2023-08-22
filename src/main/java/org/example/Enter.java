package org.example;

public class Enter {
    public static void main(String[] args) throws Exception {

        bilUrl bilUrl = new bilUrl("https://m.bilibili.com/video/BV1fv411p79E");

        // 有cookie的话，能获取到更高的清晰度
        bilUrl.cookie = "";
    
        bilUrl.getACID();
        bilUrl.getUrl();

        File file = new File();
        file.videoURL = bilUrl.videoURL;
        file.audioURL = bilUrl.audioURL;
        file.codecType = bilUrl.codecType;
        file.title = bilUrl.title;
        file.downloadVideo();
//        file.downloadAudio();
    }
}