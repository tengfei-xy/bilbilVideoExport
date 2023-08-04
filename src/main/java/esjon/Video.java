package esjon;

import java.util.ArrayList;
import java.util.List;
public class Video
{
    private int id;

    private String baseUrl;

    private String base_url;

    private List<String> backupUrl;

    private List<String> backup_url;

    private int bandwidth;

    private String mimeType;

    private String mime_type;

    private String codecs;

    private int width;

    private int height;

    private String frameRate;

    private String frame_rate;

    private String sar;

    private int startWithSap;

    private int start_with_sap;

    private SegmentBase SegmentBase;

    private Segment_base segment_base;

    private int codecid;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }
    public String getBaseUrl(){
        return this.baseUrl;
    }
    public void setBase_url(String base_url){
        this.base_url = base_url;
    }
    public String getBase_url(){
        return this.base_url;
    }
    public void setBackupUrl(List<String> backupUrl){
        this.backupUrl = backupUrl;
    }
    public List<String> getBackupUrl(){
        return this.backupUrl;
    }
    public void setBackup_url(List<String> backup_url){
        this.backup_url = backup_url;
    }
    public List<String> getBackup_url(){
        return this.backup_url;
    }
    public void setBandwidth(int bandwidth){
        this.bandwidth = bandwidth;
    }
    public int getBandwidth(){
        return this.bandwidth;
    }
    public void setMimeType(String mimeType){
        this.mimeType = mimeType;
    }
    public String getMimeType(){
        return this.mimeType;
    }
    public void setMime_type(String mime_type){
        this.mime_type = mime_type;
    }
    public String getMime_type(){
        return this.mime_type;
    }
    public void setCodecs(String codecs){
        this.codecs = codecs;
    }
    public String getCodecs(){
        return this.codecs;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getWidth(){
        return this.width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return this.height;
    }
    public void setFrameRate(String frameRate){
        this.frameRate = frameRate;
    }
    public String getFrameRate(){
        return this.frameRate;
    }
    public void setFrame_rate(String frame_rate){
        this.frame_rate = frame_rate;
    }
    public String getFrame_rate(){
        return this.frame_rate;
    }
    public void setSar(String sar){
        this.sar = sar;
    }
    public String getSar(){
        return this.sar;
    }
    public void setStartWithSap(int startWithSap){
        this.startWithSap = startWithSap;
    }
    public int getStartWithSap(){
        return this.startWithSap;
    }
    public void setStart_with_sap(int start_with_sap){
        this.start_with_sap = start_with_sap;
    }
    public int getStart_with_sap(){
        return this.start_with_sap;
    }
    public void setSegmentBase(SegmentBase SegmentBase){
        this.SegmentBase = SegmentBase;
    }
    public SegmentBase getSegmentBase(){
        return this.SegmentBase;
    }
    public void setSegment_base(Segment_base segment_base){
        this.segment_base = segment_base;
    }
    public Segment_base getSegment_base(){
        return this.segment_base;
    }
    public void setCodecid(int codecid){
        this.codecid = codecid;
    }
    public int getCodecid(){
        return this.codecid;
    }
}