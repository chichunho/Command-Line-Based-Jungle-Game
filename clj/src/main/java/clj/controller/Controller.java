package clj.controller;

import clj.view.View;

public class Controller {
    
    View view;

    public Controller(View view){
        this.view = view;
    }

    /**
     * validate
     */
    private boolean validatePiece(){
        return true;
    }

    private boolean validateDirection(){

        return true;
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
