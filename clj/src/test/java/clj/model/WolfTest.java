package clj.model;

import clj.controller.Coordinate;

public class WolfTest extends PieceTest{

    protected WolfTest(int party){
        super("Wolf", 4, party);
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
