package clj.model;

import clj.controller.Coordinate;

public class Wolf extends Piece{

    protected Wolf(int party){
        super("Wolf", 4, party);
    }

    @Override
    protected int canCapture(Piece another) {
        if (another == null){
            return 0;
        }
        if (another.getParty() == this.getParty()){
            return 1;
        }
        if (this.getRank() < another.getRank() &&
            !another.isTrapped()){
            return 2;
        }

        return 0;
    }

    @Override
    protected int canMoveTo(BoardObj dest) {
        if (dest.getType().equals("Den") &&
            dest.getParty() == this.getParty()){
                return 1;
        }
        if (dest.getType().equals("Water")){
            return 2;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "狼";
    }

    @Override
    protected Coordinate calFinalDest(Coordinate dest, Board baord, int dx, int dy) {
        return dest;
    }
    
}
