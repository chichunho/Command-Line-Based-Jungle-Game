package clj.model;

import clj.controller.Coordinate;

public class BoardTest {

    private PieceTest[][] pieces = new PieceTest[9][7];
    private BoardObjTest[][] terrain = new BoardObjTest[9][7];
    private int[] pieceCount = new int[2];

    protected BoardTest(){

        // initialized the board, cover it with Land
        for (int i = 0; i < terrain.length; i++){
            for (int j = 0; j < terrain[0].length; j++){
                terrain[i][j] = new BoardObjTest("Land", 0);
            }
        }

        // water squares
        for (int i = 3; i < 6; i++){
            for (int j = 1; j < 3; j++){
                terrain[i][j] = new BoardObjTest("Water", 0);
            }
            for (int j = 4; j < 6; j++){
                terrain[i][j] = new BoardObjTest("Water", 0);
            }
        }

        // Traps
        terrain[0][2] = new BoardObjTest("Trap", 0);
        terrain[0][4] = new BoardObjTest("Trap", 0);
        terrain[1][3] = new BoardObjTest("Trap", 0);

        terrain[7][3] = new BoardObjTest("Trap", 0);
        terrain[8][2] = new BoardObjTest("Trap", 0);
        terrain[8][4] = new BoardObjTest("Trap", 0);

        // Dens
        terrain[0][3] = new BoardObjTest("Den", 1);
        terrain[8][3] = new BoardObjTest("Den", 2);

        // Pieces
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 7; j++){
                pieces[i][j] = null;
            }
        }
        pieces[0][0] = new LionTest(1);
        pieces[0][6] = new TigerTest(1);
        pieces[1][1] = new DogTest(1);
        pieces[1][5] = new CatTest(1);
        pieces[2][0] = new RatTest(1);
        pieces[2][2] = new LeopardTest(1);
        pieces[2][4] = new WolfTest(1);
        pieces[2][6] = new ElephantTest(1);

        pieces[8][6] = new LionTest(2);
        pieces[8][0] = new TigerTest(2);
        pieces[7][5] = new DogTest(2);
        pieces[7][1] = new CatTest(2);
        pieces[6][6] = new RatTest(2);
        pieces[6][4] = new LeopardTest(2);
        pieces[6][2] = new WolfTest(2);
        pieces[6][0] = new ElephantTest(2);

        // pieces count
        pieceCount[0] = 8;
        pieceCount[1] = 8;
    }

    /**
     * This function return the piece at the specific position on board.
     * @param pos   The position of the piece
     * @return      The piece
     */
    public PieceTest pick(Coordinate pos){
        return pieces[pos.getY()][pos.getX()];
    }

    /**
     * This function return the type of the terrain at the specific position on board.
     * @param pos   The position of the terrain
     * @return      A String object represent the type of terrain
     */
    public BoardObjTest at(Coordinate pos){
        return terrain[pos.getY()][pos.getX()];
    }

    /**
     * This function simulate the process of a player plays his/her movement.
     * This function will remove any piece at the destination and 
     * replaced by the piece picked up by the user.
     * The flags of the piece will be modified by this function internally.
     * @param from      The position of the piece that picked up by the player
     * @param to        The destination
     */
    protected void move(Coordinate from, Coordinate to){
        if (pieces[to.getY()][to.getX()] != null){
            int targetParty = pieces[to.getY()][to.getX()].getParty();
            pieceCount[targetParty-1]--;
        }
        pieces[to.getY()][to.getX()] = pieces[from.getY()][from.getX()];
        pieces[from.getY()][from.getX()] = null;
        if (terrain[to.getY()][to.getX()].getType().equals("Water")){
            pieces[to.getY()][to.getX()].setInWater(true);
        }
        else{
            pieces[to.getY()][to.getX()].setInWater(false);
        }
        if (terrain[to.getY()][to.getX()].getType().equals("Trap")){
            pieces[to.getY()][to.getX()].setTrapped(true);
        }
        else{
            pieces[to.getY()][to.getX()].setTrapped(false);
        }
    }

    public int[] getPieceCount(){
        return this.pieceCount;
    }

    public PieceTest[][] getPiecesLocation(){
        return this.pieces;
    }

    /* Functions below are for testing only */

    public void testSkip(Coordinate tigerPos, Coordinate tigerNewPos) {
        pieces[tigerNewPos.getY()][tigerNewPos.getX()] = pieces[tigerPos.getY()][tigerPos.getX()];
        pieces[tigerPos.getY()][tigerPos.getX()] = null;
    }

    public void testSetPiece(PieceTest piece, Coordinate pos){
        pieces[pos.getY()][pos.getX()] = piece;
        pieceCount[piece.getParty()-1]++;

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
        pieceCount[0] = 0;
        pieceCount[1] = 0;
    }

}
