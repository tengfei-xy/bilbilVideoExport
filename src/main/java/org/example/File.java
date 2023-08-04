package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class File {
    public String videoURL;
    public String audioURL;
    public String codecType;
    public String title;
    private String codec(String s){
        if (s.equals("AVC")){
            return " -c:v copy";
        }else if (s.equals("HEVC")){
            return "";
        }else if(s.startsWith("AV1")) {
            return "";
        }
        return "";
    }

    public void download(){
        String command = String.format("ffmpeg -i %s -i %s %s -c:a copy -y %s.mp4",this.videoURL,this.audioURL,this.codec(this.codecType),this.title);
        System.out.println(command);
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
