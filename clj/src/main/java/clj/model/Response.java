package clj.model;

import java.util.ArrayList;

public class Response {
    private int messageId;
    private String[] arguments;
    
    public Response(){
        messageId = -1;
    }

    protected void setMsgId(int id){
        this.messageId = id;
    }

    protected void setArguments(String[] arguments){
        this.arguments = arguments;
    }

    public int getMsgId(){
        return this.messageId;
    }

    public String[] getArguments(){
        return this.arguments;
    }
}
