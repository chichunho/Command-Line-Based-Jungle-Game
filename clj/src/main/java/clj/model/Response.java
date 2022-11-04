package clj.model;

import clj.controller.Coordinate;

public class Response {
    private int messageId;
    private String[] arguments;
    private boolean isEndGame;
    private Coordinate[] location;
    private int[] pieceCount;
    
    protected Response(int messageId, String[] arguments, int[] pieceCount, Coordinate[] location, boolean isEndGame){
        this.messageId = messageId;
        this.arguments = arguments;
        this.pieceCount = pieceCount;
        this.location = location;
        this.isEndGame = isEndGame;
    }

    public int getMsgId(){
        return this.messageId;
    }

    public String[] getArguments(){
        return this.arguments;
    }

    public int[] getPieceCount(){
        return this.pieceCount;
    }

    public Coordinate[] getLocation(){
        return this.location;
    }

    public boolean getIsEndGame(){
        return this.isEndGame;
    }
}
