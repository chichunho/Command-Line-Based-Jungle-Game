package clj.model;

import clj.controller.Request;
import clj.controller.ControllerModelInterface;
import clj.controller.Coordinate;

public class Model implements ControllerModelInterface{
    
    Board board;
    ModelViewInterface MVInter;

    /**
     * The constructor of Model
     * @param MVInter   The concrete class that implemented the ModelViewInterface
     */
    public Model(ModelViewInterface MVInter){
        board = new Board();
        this.MVInter = MVInter;
    }

    @Override
    public int runRequest(Request request){
        // declare the string array for arguments with default 0 arguments
        String[] arguments = new String[0];

        // selected the piece according to the user input index
        Piece pickedPiece = this.board.pick(request.getCoord());

        // if no piece is on that index, update the view with message id 0
        if (pickedPiece == null){
            MVInter.modelUpdateView(new Response(1, arguments, board.getPiecesLocation()));
            return 1;
        }
        
        // if the piece selected by the player is not the same party with the player, update the view with message id 1
        if (pickedPiece.getParty() != request.getPlayerParty()){
            MVInter.modelUpdateView(new Response(2, arguments, board.getPiecesLocation()));
            return 2;
        }
        
        // calculate the destination
        Coordinate dest = new Coordinate(request.getCoord().getCol()+request.getDx(), request.getCoord().getRow()+request.getDy());
        
        // if the destination is out of bound
        if (isOutOfBound(dest)){
            MVInter.modelUpdateView(new Response(3 ,arguments, board.getPiecesLocation()));
            return 3;
        }
        
        // some pieces can jump, so the destination is calculate again
        dest = pickedPiece.calFinalDest(dest, board, request.getDx(), request.getDy());


        // test if the picked piece can capture the piece at the destination
        int ret = pickedPiece.canMoveTo(board.at(dest));
        switch(ret){
            // when player try to move to his/her own den
            case 1:
                MVInter.modelUpdateView(new Response(4 ,arguments , board.getPiecesLocation()));
                return 4;
            // when the piece fail to enter the water square
            case 2: 
                // if the piecked piece is Lion or Tiger and they fall to this branch,
                // it means a piece blocked in the mid-way during the jump action
                if (pickedPiece.getAnimal().equals("Lion") ||
                    pickedPiece.getAnimal().equals("Tiger")){
                    arguments = new String[1];
                    arguments[0] = pickedPiece.getAnimal();
                    MVInter.modelUpdateView(new Response(5, arguments, board.getPiecesLocation()));
                    return 5;
                }
                MVInter.modelUpdateView(new Response(6, arguments, board.getPiecesLocation()));
                return 6;
        }
        
        //test if the picked piece can move to the destination
        ret = pickedPiece.canCapture(board.pick(dest));
        switch(ret){
            // when player try to capture another same party piece
            case 1:
                MVInter.modelUpdateView(new Response(7, arguments, board.getPiecesLocation()));
                return 7;
            // when player try to capture another higher rank piece, and it is not trapped
            case 2:
                MVInter.modelUpdateView(new Response(8, arguments, board.getPiecesLocation()));
                return 8;
            // when the rat is in water and try to capture elephant on land
            case 3:
                MVInter.modelUpdateView(new Response(9, arguments, board.getPiecesLocation()));
                return 9;
            // when the rat is in water and try to capture enemy rat on land, or vice versa
            case 4:
                MVInter.modelUpdateView(new Response(10, arguments, board.getPiecesLocation()));
                return 10;
        }
        
        // prefill the arguments
        arguments = new String[4];
        arguments[0] = request.getPlayerName();
        arguments[1] = pickedPiece.getAnimal();
        if (board.pick(dest) == null){
            arguments[2] = null;
        }
        else{
            arguments[2] = board.pick(dest).getAnimal();
        } 

        // execute the move action
        board.move(request.getCoord(), dest);

        // if a player has moved his/her piece to enemy's den
        if (board.at(dest).getType().equals("Den")){
            arguments = new String[1];
            arguments[0] = request.getPlayerName();
            MVInter.modelUpdateView(new Response(11, arguments, board.getPiecesLocation()));
            return 11;
        }

        // obtain the piece count from the board
        int[] pieceCount = board.getPieceCount();

        // if both players have pieces to play
        if (pieceCount[0] > 0 && pieceCount[1] > 0){
            MVInter.modelUpdateView(new Response(12, arguments, board.getPiecesLocation()));
            return 12;
        }
        // if a player has no piece to play
        else{
            arguments = new String[1];
            arguments[0] = request.getPlayerName();
            MVInter.modelUpdateView(new Response(13, arguments, board.getPiecesLocation()));
            return 13;
        }
    }

    /**
     * This function test if the destination coordinate is out of bound
     * @param pos       The destination coordinate
     * @return          The boolean value indicate if the destination is out of bound
     */
    private boolean isOutOfBound(Coordinate pos){
        if (pos.getRow() < 0 || pos.getRow() > 8){
            return true;
        }
        if (pos.getCol() < 0 || pos.getCol() > 6){
            return true;
        }
        return false;
    }

    /* Belows are the methods used in test only */

    /**
     * A public function for calling the private method isOutOfBound
     * @param pos       The piece current position
     * @param dx        The desired displacement along the x-axis(column)
     * @param dy        The desired displacement along the y-axis(row)
     * @return          The boolean value indicate if the destination is out of bound
     */
    public boolean testIsOutOfBound(Coordinate pos, int dx, int dy){
        Coordinate dest = new Coordinate(pos.getCol()+dx, pos.getRow()+dy);
        return isOutOfBound(dest);
    }

    /**
     * A function that return the game board used by the current model.
     * This function aims to give a direct access to the game board.
     * @return      The current game board.
     */
    public Board testGetBoard(){
        return this.board;
    }
}
