package clj.model;

import clj.controller.Request;
import clj.controller.Coordinate;
import clj.controller.Player;
import clj.view.View;

public class Model {
    
    Board board;
    View view;

    public Model(View view){
        board = new Board();
        this.view = view;
    }

    public Response run(Player player, Request request){
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

        /* 
        Piece target = Pieces[to.getY()][to.getX()];

        target = Pieces[from.getY()][from.getX()];
        Pieces[from.getY()][from.getX()] = null;

        if (terrain[to.getY()][to.getX()].getType().equals("Water")){
            target.setInWater(true);
        }
        else{
            target.setInWater(false);
        }

        if (terrain[to.getY()][to.getX()].getType().equals("Trap")){
            target.setTrapped(true);
        }
        else{
            target.setTrapped(false);
        }
        */
        return false;
    }
}
