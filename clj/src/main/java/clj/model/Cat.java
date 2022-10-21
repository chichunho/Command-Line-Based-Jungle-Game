package clj.model;

import clj.Coordinate;

public class Cat extends Piece{

    protected Cat(int party){
        super("Cat", 2, party);
    }
    
    @Override
    protected Coordinate calFinalDest(Coordinate dest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected boolean canCapture(Piece another) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean canMoveTo(BoardObj dest) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
