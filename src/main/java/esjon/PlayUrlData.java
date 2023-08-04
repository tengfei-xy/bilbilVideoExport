package esjon;

public class PlayUrlData {
    private int code;

    private String message;

    private int ttl;

    private Data data;

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setTtl(int ttl){
        this.ttl = ttl;
    }
    public int getTtl(){
        return this.ttl;
    }
    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }
}
