package clj.model;

import clj.controller.Coordinate;

public class BoardTest {

    private PieceTest[][] pieces = new PieceTest[9][7];
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

    protected int move(Coordinate from, Coordinate to){
        return 0;
    }

    /* Functions below are for testing only */

    public void testSkip(Coordinate tigerPos, Coordinate tigerNewPos) {
    }

    public int[] testGetPieceCount() {
        return null;
    }
    public void testSetPiece(PieceTest piece, Coordinate pos){
        pieces[pos.getY()][pos.getX()] = piece;

    }
    public String testGetPosPiece(Coordinate pos){
        return pieces[pos.getY()][pos.getX()].getAnimal();
    }

    public void testEmptyBoardPieces(){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 7; j++){
                pieces[i][j] = null;
            }
        }
    }

}
