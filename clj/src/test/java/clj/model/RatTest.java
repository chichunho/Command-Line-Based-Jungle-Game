package clj.model;

import clj.controller.Coordinate;

public class RatTest extends PieceTest{

    protected RatTest(int party){
        super("Rat", 1, party);
    }
    
    @Override
    protected Coordinate calFinalDest(Coordinate dest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected boolean canCapture(PieceTest another) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean canMoveTo(BoardObjTest dest) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
