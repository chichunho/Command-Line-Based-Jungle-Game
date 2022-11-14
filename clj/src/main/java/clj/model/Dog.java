package clj.model;

import clj.controller.Coordinate;

public class Dog extends Piece{

    protected Dog(int party){
        super("Dog", 3, party);
    }
    
    @Override
    protected Coordinate calFinalDest(Coordinate dest, Board board, int dx, int dy) {
        return dest;
    }

    @Override
    protected boolean canCapture(Piece another) {
        if (another == null){
            return true;
        }
        if (another.getParty() == this.getParty()){
            return false;
        }
        if (another.isTrapped()){
            return true;
        }
        if (this.getRank() >= another.getRank()){
            return true;
        }

        return false;
    }

    @Override
    protected boolean canMoveTo(BoardObj dest) {
        if (dest.getType().equals("Den") &&
            dest.getParty() == this.getParty()){
                return false;
        }
        if (dest.getType().equals("Water")){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "狗";
    }
    
}
