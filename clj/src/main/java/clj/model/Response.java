package clj.model;

public class Response {
    private int messageId;
    private String[] arguments;
    private boolean isEndGame;
    
    protected Response(int messageId, String[] arguments, boolean isEndGame){
        this.messageId = messageId;
        this.arguments = arguments;
        this.isEndGame = isEndGame;
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
