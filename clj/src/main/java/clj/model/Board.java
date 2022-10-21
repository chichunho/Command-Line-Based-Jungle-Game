package clj.model;

import clj.controller.Coordinate;

public class Board {

    private Piece[][] Pieces = new Piece[9][7];
    private BoardObj[][] terrain = new BoardObj[9][7];

    public Board(){

        /*
        // initialized the board, cover it with Land
        for (int i = 0; i < terrain.length; i++){
            for (int j = 0; j < terrain[0].length; j++){
                terrain[i][j] = new BoardObj("Land", 0);
            }
        }

        // TODO initialized specific squares as water squares

        // TODO initialized specific squares as Traps

        // TODO initialized specific squares as Dens

        // TODO initialized the pieces
        */

    }

    /**
     * This function return the piece at the specific position on board.
     * @param pos   The position of the piece
     * @return      The piece
     */
    public Piece pick(Coordinate pos){
        /*return Pieces[pos.getY()][pos.getX()];*/
        return null;
    }

    /**
     * This function return the type of the terrain at the specific position on board.
     * @param pos   The position of the terrain
     * @return      A String object represent the type of terrain
     */
    public String at(Coordinate pos){
        /*return terrain[pos.getY()][pos.getX()].getType();*/
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
    protected boolean play(Coordinate from, Coordinate to){

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
