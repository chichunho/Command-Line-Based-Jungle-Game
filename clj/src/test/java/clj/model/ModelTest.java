package clj.model;

import clj.controller.Request;
import clj.controller.Coordinate;
import clj.view.View;

public class ModelTest {
    
    Board board;
    View view;

    public ModelTest(View view){
        board = new Board();
        this.view = view;
    }

    public ModelTest(){
        board = new Board();
        this.view = null;
    }

    public Response run(Request request){
        return null;
    }

    /**
     * This function simulate the process of a player plays his/her movement.
     * This function will remove any piece at the destination and 
     * replaced by the piece picked up by the user.
     * The flags of the piece will be modified by this function internally.
     * @param from      The position of the piece that picked up by the player
     * @param to        The destination
     */
    private boolean play(Coordinate from, Coordinate to){
        return false;
    }

    /*
    temp testing function
     */

    public boolean testPlay(Coordinate form, int dx, int dy){return false; }

}