package clj.model;

import clj.Coordinate;

public abstract class Piece implements Party{

    private final String animal;
    private final int rank;
    private final int party;
    private boolean trapped = false;
    private boolean inWater = false;

    public Piece(String animal, int rank, int party){
        this.animal = animal;
        this.rank = rank;
        this.party = party;
    }

    public String getAnimal(){
        return this.animal;
    }

    public int getRank(){
        return this.rank;
    }

    @Override
    public int getParty(){
        return this.party;
    }

    protected void setTrapped(boolean trapped){
        this.trapped = trapped;
    }

    protected boolean isTrapped(){
        return this.trapped;
    }

    protected void setInWater(boolean inWater){
        this.inWater = inWater;
    }

    protected boolean isInWater(){
        return this.inWater;
    }

    /**
     * For animal other than Lion and Tiger,
     * this function works the same as current x + dx and current y + dy.
     * For Lion and Tiger,
     * this function will check if the destination is a water square,
     * if yes, it will find the next non-water square and set there as destination,
     * given that no piece is located in the mid way.
     * Any pieces located in the mid way will stop the searching and return the coordinate
     * where it meet the piece.
     * @param   dest    The destination decided by the user
     * @return  A Coordinate object of the final destination decided by the game logic
     */
    abstract protected Coordinate calFinalDest(Coordinate dest);

    /**
     * This function determines if this piece can capture another piece
     * @param another   Another piece
     * @return          A boolean value
     */
    abstract protected boolean canCapture(Piece another);

    /**
     * This function determine if this piece can move to the destination
     * @param dest      A Coordinate object of the destination
     * @return          A boolean value
     */
    abstract protected boolean canMoveTo(BoardObj dest);
}
