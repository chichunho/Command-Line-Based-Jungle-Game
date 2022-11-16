package clj.controller;

public class Coordinate {

    private int x, y;

    // TODO fill the javadoc
    /**
     * Constructor of object Coordinate
     * @param pos
     */
    public Coordinate(String pos){
        int [] temp = this.convertToAbs(pos);
        this.x = temp[0];
        this.y = temp[1];
    }

    // TODO fill the javadoc
    /**
     * 
     * @param x
     * @param y
     */
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
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
    public int getX(){
        return this.x;
    }

    // TODO fill the javadoc
    /**
     * 
     * @return
     */
    public int getY(){
        return this.y;
    }
}
