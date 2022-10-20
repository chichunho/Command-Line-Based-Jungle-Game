package clj.controller;


public class Controller {

    private Request request = new Request();
    public Controller(){

    }

    private String userPiece;
    private String userDirect;

    public void setUserPiece(String input){
        this.userPiece = input;
    }

    public void setUserDirect(String input){
        this.userDirect = input;
    }

    /**
     * validate
     */
    private boolean validatePiece(String input){
        return true;
    }

    private boolean validateDirection(String input){

        return true;
    }

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
    public Request getRequest(){
        return request;
    }



}
