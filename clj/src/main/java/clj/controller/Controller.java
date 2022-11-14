package clj.controller;

import clj.view.View;

public class Controller {
    
    View view;
    Request request;
    public Controller(View view){
        this.view = view;
        
    }

    /**
     * validate
     */
    private boolean validatePiece(String pos){
        int col = toLowerCase(pos.charAt(0));
        int row = pos.charAt(1);

        if (col < 97 || col > 103 || row < 1 || row > 9){
            return false;
        }
        return true;
    }

    private boolean validateDirection(String pos){
        int userDirect = pos.charAt(0);

        return (userDirect==1 || userDirect== -1)? true : false ;
    }

    /*
    TODO
    encupsulate all operations into one public function
    */
    public Request getUserRequest(Player currentPlayer){
        return null;
    }
    /* 
    TODO
    following 2 functions can be set to private functions 
    */
    /**
     *
     * convert userinput to coordinate
     *
     */
    private int[] parseDirection() {
        //IF userDirect pass validateDirect(), parse to request dx,dy
        return null;
    }

    private Coordinate parsePiece(){
        // if userPiece pass validatePiece, parse to coordinate
        return null;
    }

    public Player[] getUserInfo() {
        return null;
    }
}
