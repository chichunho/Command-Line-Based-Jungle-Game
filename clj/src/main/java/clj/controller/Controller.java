package clj.controller;


public class Controller {
    
    View view;

    private String userPiece;
    private String userDirect;

    public Controller(View view){
        this.view = view;
    }

    /* 
    TODO 
    private variable can directly manipulate in class itself
    the follwoing 2 is redundant functions, can be removed 
    */
    public void setUserPiece(String input){
        this.userPiece = input;
    }

    public void setUserDirect(String input){
        this.userDirect = input;
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

    /*
    TODO
    following 2 functions can be set to private functions 
    */
    /**
     *
     * convert userinput to coordinate
     *
     */
    public void parseDirect() {
        //IF userDirect pass validateDirect(), parse to request dx,dy

    }

    public void parsePiece(){
        // if userPiece pass validatePiece, parse to coordinate

    }
    
    /*
    TODO
    redundant function, can be removed
    */
    public Request getRequest(){
        return request;
    }



}
