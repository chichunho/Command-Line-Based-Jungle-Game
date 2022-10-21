package clj.model;

public class Response {
    private int messageId;
    private String[] arguments;
    private boolean isEndGame;
    
    protected Response(){
        this.messageId = -1;
        this.isEndGame = false;
    }

    public int getMsgId(){
        return this.messageId;
    }

    public String[] getArguments(){
        return this.arguments;
    }

    public boolean getIsEndGame(){
        return this.isEndGame;
    }
}
