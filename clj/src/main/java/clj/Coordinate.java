package clj;

public class Coordinate {

    private int x, y;

    /**
     * Constructor of object Coordinate
     * @param pos
     */
    public Coordinate(String pos){
        int [] temp = this.convertToAbs(pos);
        this.x = temp[0];
        this.y = temp[1];
    }

    /**
     * Constructor of object Coordinate
     * Provide a copy function
     * @param pos
     * @return
     */
    public Coordinate(Coordinate old){
        this.x = old.getX();
        this.y = old.getY();
    }

    // code for convertToAbs
    /* 
    private int getPosX(String pos){
        int posX = pos.charAt(0);
        return posX-65;
    }

    private int getPosY(String pos){
        int posY = pos.charAt(1);
        return 9-posY;
    }
    */

    /**
     * This function convert the string format position to 
     * absolute integer format position on board
     * @param   pos     The position string in format of {[A-G][1-9]}
     * @return          An integer array with length 2, [0]->x, [1]->y
     */
    private int[] convertToAbs(String pos){
        return null;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}