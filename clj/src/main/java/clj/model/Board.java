package clj.model;

import clj.controller.Coordinate;

public class Board {

    private Piece[][] pieces = new Piece[9][7];
    private BoardObj[][] terrain = new BoardObj[9][7];
    private int[] pieceCount = new int[2];

    protected Board(){

        // initialized the board, cover it with Land
        for (int i = 0; i < terrain.length; i++){
            for (int j = 0; j < terrain[0].length; j++){
                terrain[i][j] = new BoardObj("Land", 0);
            }
        }

        // water squares
        for (int i = 3; i < 6; i++){
            for (int j = 1; j < 3; j++){
                terrain[i][j] = new BoardObj("Water", 0);
            }
            for (int j = 4; j < 6; j++){
                terrain[i][j] = new BoardObj("Water", 0);
            }
        }

        // Traps
        terrain[0][2] = new BoardObj("Trap", 0);
        terrain[0][4] = new BoardObj("Trap", 0);
        terrain[1][3] = new BoardObj("Trap", 0);

        terrain[7][3] = new BoardObj("Trap", 0);
        terrain[8][2] = new BoardObj("Trap", 0);
        terrain[8][4] = new BoardObj("Trap", 0);

        // Dens
        terrain[0][3] = new BoardObj("Den", 1);
        terrain[8][3] = new BoardObj("Den", 2);

        // Pieces
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 7; j++){
                pieces[i][j] = null;
            }
        }
        pieces[0][0] = new Lion(1);
        pieces[0][6] = new Tiger(1);
        pieces[1][1] = new Dog(1);
        pieces[1][5] = new Cat(1);
        pieces[2][0] = new Rat(1);
        pieces[2][2] = new Leopard(1);
        pieces[2][4] = new Wolf(1);
        pieces[2][6] = new Elephant(1);

        pieces[8][6] = new Lion(2);
        pieces[8][0] = new Tiger(2);
        pieces[7][5] = new Dog(2);
        pieces[7][1] = new Cat(2);
        pieces[6][6] = new Rat(2);
        pieces[6][4] = new Leopard(2);
        pieces[6][2] = new Wolf(2);
        pieces[6][0] = new Elephant(2);

        // pieces count
        pieceCount[0] = 8;
        pieceCount[1] = 8;
    }

    /**
     * This function return the piece at the specific position on board.
     * @param pos   The position of the piece
     * @return      The piece
     */
    public Piece pick(Coordinate pos){
        return pieces[pos.getY()][pos.getX()];
    }

    /**
     * This function return the type of the terrain at the specific position on board.
     * @param pos   The position of the terrain
     * @return      A String object represent the type of terrain
     */
    public BoardObj at(Coordinate pos){
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

    public Piece[][] getPiecesLocation(){
        return this.pieces;
    }
}
