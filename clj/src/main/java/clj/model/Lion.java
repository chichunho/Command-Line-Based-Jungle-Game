package clj.model;

import clj.Coordinate;

public class Lion extends Piece{

    protected Lion(int party){
        super("Lion", 7, party);
    }

    @Override
    protected Coordinate calFinalDest(Coordinate dest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean canCapture(Piece another) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canMoveTo(BoardObj dest) {
        // TODO Auto-generated method stub
        return false;
    }
}
