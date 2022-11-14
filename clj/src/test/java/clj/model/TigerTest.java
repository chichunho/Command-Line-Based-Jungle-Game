package clj.model;

import clj.controller.Coordinate;

public class TigerTest extends PieceTest{

    protected TigerTest(int party){
        super("Tiger", 6, party);
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
