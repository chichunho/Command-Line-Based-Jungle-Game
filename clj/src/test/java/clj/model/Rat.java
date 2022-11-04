package clj.model;

import clj.controller.Coordinate;

public class Rat extends Piece{

    protected Rat(int party){
        super("Rat", 1, party);
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
