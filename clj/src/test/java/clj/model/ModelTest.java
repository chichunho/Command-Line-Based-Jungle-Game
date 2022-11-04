package clj.model;

import clj.controller.Request;
import clj.controller.Coordinate;
import clj.view.View;

public class ModelTest {
    
    Board board;
    View view;

    public Model(View view){
        this.board = new Board();
        this.view = view;
    }

    public  Board getBoard(){
        return board;
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
}
