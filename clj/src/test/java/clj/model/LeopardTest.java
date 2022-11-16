package clj.model;

import clj.controller.Coordinate;

public class LeopardTest extends PieceTest{

    protected LeopardTest(int party){
        super("Leopard", 5, party);
    }

    @Override
    protected Coordinate calFinalDest(Coordinate dest, BoardTest board, int dx, int dy) {
        return dest;
    }

    @Override
    protected int canCapture(PieceTest another) {
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
    protected int canMoveTo(BoardObjTest dest) {
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
        return "豹";
    }
    
}
