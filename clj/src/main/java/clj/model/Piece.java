package clj.model;

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

    public boolean isTrapped(){
        return this.trapped;
    }

    protected void setInWater(boolean inWater){
        this.inWater = inWater;
    }

    public boolean isInWater(){
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
     * @param   board   Current game board in the system
     * @param   pos     The piece's currect position
     * @param   dx      The displacement along x-axis
     * @param   dy      The displacement along y-axis
     * @return  A Coordinate object of the destination
     */
    abstract protected Coordinate calFinalDest(Board board, Coordinate pos, int dx, int dy);

    /**
     * This function determines if this piece can capture another piece
     * @param another   Another piece
     * @return          A boolean value
     */
    abstract public boolean canCapture(Piece another);

    /**
     * This function determine if this piece can move to the destination
     * @param dest      A Coordinate object of the destination
     * @return          A boolean value
     */
    abstract public boolean canMoveTo(BoardObj dest);
}
