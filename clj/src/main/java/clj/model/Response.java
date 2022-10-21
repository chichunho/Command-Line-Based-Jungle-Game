package clj.model;

public class Response {
    private int messageId;
    private String[] arguments;
    private boolean isEndGame;
    
    public Response(){
        this.messageId = -1;
        this.isEndGame = false;
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

    protected void setIsEndGame(boolean isEndGame){
        this.isEndGame = isEndGame;
    }

    public boolean getIsEndGame(){
        return this.isEndGame;
    }
}
