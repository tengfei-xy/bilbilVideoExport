package esjon;
import java.util.List;
public class Data {
    private String from;

    private String result;

    private String message;

    private int quality;

    private String format;

    private int timelength;

    private String accept_format;

    private List<String> accept_description;

    private List<Integer> accept_quality;

    private int video_codecid;

    private String seek_param;

    private String seek_type;

    private Dash dash;

    private List<Support_formats> support_formats;

    private String high_format;

    private int last_play_time;

    private int last_play_cid;

    public void setFrom(String from){
        this.from = from;
    }
    public String getFrom(){
        return this.from;
    }
    public void setResult(String result){
        this.result = result;
    }
    public String getResult(){
        return this.result;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setQuality(int quality){
        this.quality = quality;
    }
    public int getQuality(){
        return this.quality;
    }
    public void setFormat(String format){
        this.format = format;
    }
    public String getFormat(){
        return this.format;
    }
    public void setTimelength(int timelength){
        this.timelength = timelength;
    }
    public int getTimelength(){
        return this.timelength;
    }
    public void setAccept_format(String accept_format){
        this.accept_format = accept_format;
    }
    public String getAccept_format(){
        return this.accept_format;
    }
    public void setAccept_description(List<String> accept_description){
        this.accept_description = accept_description;
    }
    public List<String> getAccept_description(){
        return this.accept_description;
    }
    public void setAccept_quality(List<Integer> accept_quality){
        this.accept_quality = accept_quality;
    }
    public List<Integer> getAccept_quality(){
        return this.accept_quality;
    }
    public void setVideo_codecid(int video_codecid){
        this.video_codecid = video_codecid;
    }
    public int getVideo_codecid(){
        return this.video_codecid;
    }
    public void setSeek_param(String seek_param){
        this.seek_param = seek_param;
    }
    public String getSeek_param(){
        return this.seek_param;
    }
    public void setSeek_type(String seek_type){
        this.seek_type = seek_type;
    }
    public String getSeek_type(){
        return this.seek_type;
    }
    public void setDash(Dash dash){
        this.dash = dash;
    }
    public Dash getDash(){
        return this.dash;
    }
    public void setSupport_formats(List<Support_formats> support_formats){
        this.support_formats = support_formats;
    }
    public List<Support_formats> getSupport_formats(){
        return this.support_formats;
    }
    public void setHigh_format(String high_format){
        this.high_format = high_format;
    }
    public String getHigh_format(){
        return this.high_format;
    }
    public void setLast_play_time(int last_play_time){
        this.last_play_time = last_play_time;
    }
    public int getLast_play_time(){
        return this.last_play_time;
    }
    public void setLast_play_cid(int last_play_cid){
        this.last_play_cid = last_play_cid;
    }
    public int getLast_play_cid(){
        return this.last_play_cid;
    }
}
