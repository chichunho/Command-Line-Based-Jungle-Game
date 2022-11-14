package clj.model;

import clj.controller.Coordinate;

public class LeopardTest extends PieceTest{

    protected LeopardTest(int party){
        super("Leopard", 5, party);
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
