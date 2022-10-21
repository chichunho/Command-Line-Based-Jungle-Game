package clj.controller;

import clj.view.View;

public class Controller {
    
    View view;

    private String userPiece;
    private String userDirect;

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
    Actually you can encupsulate all operations into one public function getUserInput()
    sth like:
    public Request getUserInput(){
        Request request = new Request();
        String coord;
        String direction;
        while(True){
            view.askUserInputCoord(); // may change
            coord = scanner.nextLine();
            if (validatePiece(coord)) break;
            view.alertUserWrongCoord(); // may change
        }
        // you may want to give user a choice to re-select the Piece
        while(True){
            view.askUserInputDirection(); // may change
            direction = scanner.nextLine();
            if (validateDirection(direction)) break;
            view.alertUserWrongDirection(); // may change
        }
        ...parse and set request content

        return request;
    }
    */
    public Request getUserInput(){
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
    private void parseDirect() {
        //IF userDirect pass validateDirect(), parse to request dx,dy

    }

    private void parsePiece(){
        // if userPiece pass validatePiece, parse to coordinate

    }

    public Player[] getUserInfo() {
        return null;
    }

    public Request getUserRequest() {
        return null;
    }




}
