package esjon;
import java.util.ArrayList;
import java.util.List;
public class Dash {
    private int duration;

    private double minBufferTime;

    private double min_buffer_time;

    private List<Video> video;

    private List<Audio> audio;

    private Dolby dolby;

    private String flac;

    public void setDuration(int duration){
        this.duration = duration;
    }
    public int getDuration(){
        return this.duration;
    }
    public void setMinBufferTime(double minBufferTime){
        this.minBufferTime = minBufferTime;
    }
    public double getMinBufferTime(){
        return this.minBufferTime;
    }
    public void setMin_buffer_time(double min_buffer_time){
        this.min_buffer_time = min_buffer_time;
    }
    public double getMin_buffer_time(){
        return this.min_buffer_time;
    }
    public void setVideo(List<Video> video){
        this.video = video;
    }
    public List<Video> getVideo(){
        return this.video;
    }
    public void setAudio(List<Audio> audio){
        this.audio = audio;
    }
    public List<Audio> getAudio(){
        return this.audio;
    }
    public void setDolby(Dolby dolby){
        this.dolby = dolby;
    }
    public Dolby getDolby(){
        return this.dolby;
    }
    public void setFlac(String flac){
        this.flac = flac;
    }
    public String getFlac(){
        return this.flac;
    }
}
