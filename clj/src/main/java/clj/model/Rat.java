package clj.model;

import clj.controller.Coordinate;

public class Rat extends Piece{

    protected Rat(int party){
        super("Rat", 1, party);
    }

    @Override
    protected int canCapture(Piece another) {
        if (another == null){
            return 0;
        }
        if (another.getParty() == this.getParty()){
            return 1;
        }
        if (another.getAnimal().equals("Elephant")){
            if (this.isInWater()){
                return 3;
            }
            else{
                return 0;
            }
        }
        if (another.getAnimal().equals("Rat") &&
            this.isInWater() != another.isInWater()){
            return 4;
        }
        if (this.getRank() < another.getRank() &&
            !another.isTrapped()){
            return 2;
        }

        return 0;
    }

    @Override
    protected int canMoveTo(BoardObj dest) {
        if (dest.getType().equals("Den") &&
            dest.getParty() == this.getParty()){
                return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "鼠";
    }

    @Override
    protected Coordinate calFinalDest(Coordinate dest, Board baord, int dx, int dy) {
        return dest;
    }
    
}
