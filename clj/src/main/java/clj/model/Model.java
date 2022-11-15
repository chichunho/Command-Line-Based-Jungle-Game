package clj.model;

import clj.controller.Request;
import clj.controller.Coordinate;
import clj.view.View;

public class Model {
    
    Board board;
    View view;

    public Model(View view){
        board = new Board();
        this.view = view;
    }

    public Response run(Request request){
        Piece pickedPiece = this.board.pick(request.getCoord());
        Coordinate dest = new Coordinate(request.getCoord().getX()+request.getDx(), request.getCoord().getY()+request.getDy());
        dest = pickedPiece.calFinalDest(dest, board, request.getDx(), request.getDy());

        if (isOutOfBound(dest)){
            String[] arguments = {Integer.toString(dest.getX()), Integer.toString(dest.getY())};
            Response response = new Response(1 ,arguments, board.getPiecesLocation(), false);
            return response;
        }

        int ret = pickedPiece.canMoveTo(board.at(dest));
        String[] arguments = new String[0];
        switch(ret){
            // when player try to move to his/her own den
            case 1:
                arguments = new String[3];
                arguments[0] = pickedPiece.toString();
                arguments[1] = Integer.toString(dest.getX());
                arguments[2] = Integer.toString(dest.getY());
                return new Response(2 ,arguments , board.getPiecesLocation(), false);
            // when the piece fail to enter the water square
            case 2:
                arguments = new String[3];
                arguments[0] = pickedPiece.getAnimal();
                arguments[1] = Integer.toString(dest.getX());
                arguments[2] = Integer.toString(dest.getY());
                return new Response(3, arguments, board.getPiecesLocation(), false);
        }
        
        ret = pickedPiece.canCapture(board.pick(dest));
        switch(ret){
            // when player try to capture another same party piece
            case 1:
                arguments = new String[3];
                arguments[0] = board.pick(dest).getAnimal();
                arguments[1] = Integer.toString(dest.getX());
                arguments[2] = Integer.toString(dest.getY());
                return new Response(4, arguments, board.getPiecesLocation(), false);
            // when player try to capture another higher rank piece, and it is not trapped
            case 2:
                arguments = new String[1];
                arguments[0] = board.pick(dest).getAnimal();
                return new Response(5, arguments, board.getPiecesLocation(), false);
            // when the rat is in water and try to capture elephant on land
            case 3:
                return new Response(6, arguments, board.getPiecesLocation(), false);
            // when the rat is in water and try to capture enemy rat on land, or vice versa
            case 4:
                return new Response(7, arguments, board.getPiecesLocation(), false);
        }
        
        board.move(request.getCoord(), dest);
        arguments = new String[3];
        arguments[0] = request.getPlayerName();
        arguments[1] = pickedPiece.getAnimal();
        arguments[2] = board.pick(dest).getAnimal();

        int[] pieceCount = board.getPieceCount();
        // both players have pieces to play
        if (pieceCount[0] > 0 && pieceCount[1] > 0){
            return new Response(8, arguments, board.getPiecesLocation(), false);
        }
        else{
            return new Response(9, arguments, board.getPiecesLocation(), true);
        }
    }

    private boolean isOutOfBound(Coordinate pos){
        if (pos.getY() > 8){
            return true;
        }
        if (pos.getX() > 6){
            return true;
        }
        return false;
    }
}
