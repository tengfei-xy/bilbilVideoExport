package esjon;
import java.util.ArrayList;
import java.util.List;
public class Support_formats {
    private int quality;

    private String format;

    private String new_description;

    private String display_desc;

    private String superscript;

    private List<String> codecs;

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
    public void setNew_description(String new_description){
        this.new_description = new_description;
    }
    public String getNew_description(){
        return this.new_description;
    }
    public void setDisplay_desc(String display_desc){
        this.display_desc = display_desc;
    }
    public String getDisplay_desc(){
        return this.display_desc;
    }
    public void setSuperscript(String superscript){
        this.superscript = superscript;
    }
    public String getSuperscript(){
        return this.superscript;
    }
    public void setCodecs(List<String> codecs){
        this.codecs = codecs;
    }
    public List<String> getCodecs(){
        return this.codecs;
    }
}
