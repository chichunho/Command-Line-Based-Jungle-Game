package clj.model;

import clj.controller.Coordinate;

public class ElephantTest extends PieceTest{
    
    protected ElephantTest(int party){
        super("Elephant", 8, party);
    }

    @Override
    protected int canCapture(PieceTest another){
        
        if (another == null){
            return 0;
        }

        if (another.getParty() == this.getParty()){
            return 1;
        }
        
        return 0;
    }

    @Override
    protected int canMoveTo(BoardObjTest dest){
        
        if (dest.getType().equals("Den") && dest.getParty() == this.getParty()){
            return 1;
        }

        if (dest.getType().equals("Water")){
            return 2;
        }

        return 0;
    }

    @Override
    protected Coordinate calFinalDest(Coordinate dest, BoardTest dboard, int dx, int dy) {
        return dest;
    }

    @Override
    public String toString() {
        return "象";
    }
}
