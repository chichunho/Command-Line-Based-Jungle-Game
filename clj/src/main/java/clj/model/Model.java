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
            String[] arguments= {Integer.toString(dest.getX()), Integer.toString(dest.getY())};
            Response response = new Response(1 ,arguments , board.getPieceCount(), false);
            return response;
        }

        if (!pickedPiece.canMoveTo(board.at(dest))){

        }

        if (!pickedPiece.canCapture(board.pick(dest))){
            
        }

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

    private boolean isOutOfBound(Coordinate pos){
        return false;
    }
}
