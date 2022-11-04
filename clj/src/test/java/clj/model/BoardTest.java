package clj.model;

import clj.controller.Coordinate;

public class BoardTest{

    private PieceTest[][] Pieces = new PieceTest[9][7];
    private BoardObj[][] terrain = new BoardObj[9][7];
    private int pieceCount;

    protected BoardTest(){

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

    protected int move(Piece piece, Coordinate pos){
        return 0;
    }

    /*Belows are functions used in testing only*/

    public void setPiece(PieceTest piece, Coordinate pos){
        Pieces[pos.getY()][pos.getX()] = piece;

    }
    public String getPosPiece(Coordinate pos){
        return Pieces[pos.getY()][pos.getX()].getAnimal();
    }

}
