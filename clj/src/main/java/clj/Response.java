package clj;

public class Response {
    
    private String message;
    private boolean isSuccess;

    protected void setMessage(String message){
        this.message = message;
    }

    protected void setIsSuccess(boolean isSuccess){
        this.isSuccess = isSuccess;
    }

    public String getMessage(){
        return this.message;
    }

    public boolean getIsSuccess(){
        return this.isSuccess;
    }
}
