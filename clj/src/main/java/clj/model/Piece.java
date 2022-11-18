package clj.model;

import clj.controller.Coordinate;

public abstract class Piece implements Party{

    private final String animal;
    private final int rank;
    private final int party;
    private boolean trapped = false;
    private boolean inWater = false;

    /**
     * The constructor of Piece
     * @param animal    The type of the animal
     * @param rank      The rank of the animal
     * @param party     The party of the animal
     */
    protected Piece(String animal, int rank, int party){
        this.animal = animal;
        this.rank = rank;
        this.party = party;
    }

    /**
     * This function returns the type of the animal
     * @return      The string that describe the animal type.
     */
    protected String getAnimal(){
        return this.animal;
    }

    /**
     * This function returns the rank of the animal
     * @return      The rank of the animal
     */
    protected int getRank(){
        return this.rank;
    }

    @Override
    public int getParty(){
        return this.party;
    }

    /**
     * This function sets the trapped status flag of the animal
     * @param trapped       A boolean value indicate the trapped status
     */
    protected void setTrapped(boolean trapped){
        this.trapped = trapped;
    }

    /**
     * This function returns the trapped status of the animal
     * @return      A boolean value indicate the trapped status
     */
    protected boolean isTrapped(){
        return this.trapped;
    }

    /**
     * This function sets the inWater status flag of the animal
     * @param inWater   A boolean value indicate if the animal is in water square
     */
    protected void setInWater(boolean inWater){
        this.inWater = inWater;
    }

    /**
     * This function returns the inWater status flag of the animal
     * @return      A boolean value indicate if the animal is in water square
     */
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
     * @return          A Coordinate object of the final destination decided by the game logic
     */
    abstract protected Coordinate calFinalDest(Coordinate dest, Board baord, int dx, int dy);

    /**
     * This function determines if this piece can capture another piece
     * @param another   Another piece
     * @return          A boolean value
     */
    abstract protected int canCapture(Piece another);

    /**
     * This function determine if this piece can move to the destination
     * @param dest      A Coordinate object of the destination
     * @return          A boolean value
     */
    abstract protected int canMoveTo(BoardObj dest);

    /**
     * This function override the default toString(),
     * only used for printing output.
     * For internal use, call method getAnimal() instead
     * @return          A Chinese character representing this piece
     */
    @Override
    abstract public String toString();
}
