package clj.model;

import clj.Coordinate;

public class Elephant extends Piece{
    
    protected Elephant(int party){
        super("Elephant", 8, party);
    }

    @Override
    public boolean canCapture(Piece another){
        
        /* 
        // if there is no enemy piece
        // then this is always true
        if (another == null){
            return true;
        }

        // if another piece is trapped
        // then this is always true
        if (another.isTrapped()){
            return true;
        }

        // if the piece's party is the same as you
        // then this is always false
        if (another.getParty() == this.getParty()){
            return false;
        }
        
        // Since Elephant has the highest rank among all animal
        // no further rank comparison is needed
        */
        return true;
    }

    @Override
    public boolean canMoveTo(BoardObj dest){
        
        /*
        // if the destination is water
        // then this is always false
        if (dest.getType().equals("Water")){
            return false;
        }

        // if the destination is a den and the den's party is the same as you
        // then this is always false
        if (dest.getType().equals("Den") && dest.getParty() == this.getParty()){
            return false;
        }
        */

        return true;
    }

    @Override
    protected Coordinate calFinalDest(Coordinate dest){
        /*
        // since this is Elephant, no jump operation
        return dest;
        */
        return null;
    }
}
