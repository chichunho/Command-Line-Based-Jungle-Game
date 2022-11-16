package clj.controller;

public class Coordinate {

    private int col, row;

    // TODO fill the javadoc
    /**
     * Constructor of object Coordinate
     * @param pos
     */
    public Coordinate(String pos){
        int [] temp = this.convertToAbs(pos);
        this.col = temp[0];
        this.row = temp[1];
    }

    // TODO fill the javadoc
    /**
     * 
     * @param x
     * @param y
     */
    public Coordinate(int col, int row){
        this.col = col;
        this.row = row;
    }

    /**
     * This function convert the string format position to 
     * absolute integer format position on board
     * @param   pos     The position string in format of {[A-G][1-9]}
     * @return          An integer array with length 2, [0]->x, [1]->y
     */
    private int[] convertToAbs(String pos){
        int temp[] = new int [2];
        temp[0] = pos.charAt(0)-65;
        temp[1] = 9-(pos.charAt(1)-'0');

        return temp;
    }

    // TODO fill the javadoc
    /**
     * 
     * @return
     */
    public int getCol(){
        return this.col;
    }

    // TODO fill the javadoc
    /**
     * 
     * @return
     */
    public int getRow(){
        return this.row;
    }
}
