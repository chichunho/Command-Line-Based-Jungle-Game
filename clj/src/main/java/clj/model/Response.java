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

    public String getPieceAnimal(int col, int row){
        if (pieces[row][col] == null){
            return new String("");
        }
        return pieces[row][col].toString();
    }

    public int getPieceParty(int col, int row){
        return pieces[row][col].getParty();
    }
}
