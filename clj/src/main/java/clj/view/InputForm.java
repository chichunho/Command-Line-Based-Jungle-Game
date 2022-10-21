package clj.view;

public class InputForm {

    String piecePos;
    char direction;

    public InputForm(){}

    protected void setPiecePos(String piecePos){
        this.piecePos = piecePos;
    }

    protected void setDirection(char direction){
        this.direction = direction;
    }

    public String getPiecePos(){
        return this.piecePos;
    }

    public char getDirection(){
        return this.direction;
    }
}
