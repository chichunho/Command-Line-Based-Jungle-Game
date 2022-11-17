package clj.model;

import clj.controller.Request;
import clj.controller.Coordinate;

public class Model {
    
    Board board;
    ModelViewInterface MVInter;

    public Model(ModelViewInterface MVInter){
        board = new Board();
        this.MVInter = MVInter;
    }

    public int run(Request request){
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
        // some pieces can jump, so the destination is calculate again
        dest = pickedPiece.calFinalDest(dest, board, request.getDx(), request.getDy());

        // if the destination is out of bound
        if (isOutOfBound(dest)){
            arguments = new String[2];
            arguments[0] = Integer.toString(dest.getCol());
            arguments[1] = Integer.toString(dest.getRow());
            MVInter.modelUpdateView(new Response(3 ,arguments, board.getPiecesLocation()));
            return 3;
        }

        // test if the picked piece can capture the piece at the destination
        int ret = pickedPiece.canMoveTo(board.at(dest));
        switch(ret){
            // when player try to move to his/her own den
            case 1:
                arguments = new String[3];
                arguments[0] = pickedPiece.toString();
                arguments[1] = Integer.toString(dest.getCol());
                arguments[2] = Integer.toString(dest.getRow());
                MVInter.modelUpdateView(new Response(4 ,arguments , board.getPiecesLocation()));
                return 4;
            // when the piece fail to enter the water square
            case 2:
                arguments = new String[3];
                arguments[0] = pickedPiece.getAnimal();
                arguments[1] = Integer.toString(dest.getCol());
                arguments[2] = Integer.toString(dest.getRow());
                MVInter.modelUpdateView(new Response(5, arguments, board.getPiecesLocation()));
                return 5;
        }
        
        ret = pickedPiece.canCapture(board.pick(dest));
        switch(ret){
            // when player try to capture another same party piece
            case 1:
                arguments = new String[3];
                arguments[0] = board.pick(dest).getAnimal();
                arguments[1] = Integer.toString(dest.getCol());
                arguments[2] = Integer.toString(dest.getRow());
                MVInter.modelUpdateView(new Response(6, arguments, board.getPiecesLocation()));
                return 6;
            // when player try to capture another higher rank piece, and it is not trapped
            case 2:
                arguments = new String[1];
                arguments[0] = board.pick(dest).getAnimal();
                MVInter.modelUpdateView(new Response(7, arguments, board.getPiecesLocation()));
                return 7;
            // when the rat is in water and try to capture elephant on land
            case 3:
                MVInter.modelUpdateView(new Response(8, arguments, board.getPiecesLocation()));
                return 8;
            // when the rat is in water and try to capture enemy rat on land, or vice versa
            case 4:
                MVInter.modelUpdateView(new Response(9, arguments, board.getPiecesLocation()));
                return 9;
        }
        
        arguments = new String[4];
        arguments[0] = request.getPlayerName();
        arguments[1] = Integer.toString(request.getPlayerParty());
        arguments[2] = pickedPiece.getAnimal();
        if (board.pick(dest) == null){
            arguments[3] = null;
        }
        else{
            arguments[3] = board.pick(dest).getAnimal();
        } 

        board.move(request.getCoord(), dest);

        // a player has moved his/her piece to enemy's den
        if (board.at(dest).getType().equals("Den")){
            arguments = new String[1];
            arguments[0] = request.getPlayerName();
            MVInter.modelUpdateView(new Response(10, arguments, board.getPiecesLocation()));
            return 10;
        }

        int[] pieceCount = board.getPieceCount();
        // both players have pieces to play
        if (pieceCount[0] > 0 && pieceCount[1] > 0){
            MVInter.modelUpdateView(new Response(11, arguments, board.getPiecesLocation()));
            return 11;
        }
        // a player has no piece to play
        else{
            MVInter.modelUpdateView(new Response(12, arguments, board.getPiecesLocation()));
            return 12;
        }
    }

    private boolean isOutOfBound(Coordinate pos){
        if (pos.getRow() < 0 || pos.getRow() > 8){
            return true;
        }
        if (pos.getCol() < 0 || pos.getCol() > 6){
            return true;
        }
        return false;
    }
}
