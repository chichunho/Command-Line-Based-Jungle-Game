package clj.model;

public class Response {
    private int messageId;
    private String[] arguments;
    private Piece[][] pieces;
    
    protected Response(int messageId, String[] arguments, Piece[][] pieces){
        this.messageId = messageId;
        this.arguments = arguments;
        this.pieces = pieces;
    }

    public int getMsgId(){
        return this.messageId;
    }

    public String[] getArguments(){
        return this.arguments;
    }

    public String getPieceAnimal(int x, int y){
        if (pieces[x][y] == null){
            return "";
        }
        return pieces[x][y].toString();
    }

    public int getPieceParty(int x, int y){
        return pieces[x][y].getParty();
    }
}
