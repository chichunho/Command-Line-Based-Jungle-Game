package clj.controller;

import clj.view.View;
import java.util.Scanner;

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

        if (pos.length()!=2){
            printf("Invalid input: input should consists two elements");
            return false;
        }
        int col = toLowerCase(pos.charAt(0));
        int row = pos.charAt(1);

        
        if (col < 97 || col > 103 || row < 1 || row > 9){
            System.out.Println("Invalid piece selected.");
            return false;
        }
        return true;
    }

    private boolean validateDirection(String pos){
        if (pos.length()!= 1){
            printf("Invalid input: input should consists 1 character");
            return false;
        }
        char userDirect = toLowerCase(pos.charAt(0));

        if (userDirect!="w" || userDirect!= "s" || userDirect!="d" ||userDirect!="a"){
            System.out.Println("Invalid Direction selected");
            return false;
        }

        return true;
    }

    /*
    TODO
    encupsulate all operations into one public function
    */
    public Request getUserRequest(Player currentPlayer){
        Scanner scan = new Scanner(System.in);
        
        String userInputPiece;
        String userInputDirect;
        int userDirect[];
        Coordinate userCoor;
        
        Request userReq;

        do {
            System.out.Println("\rPlease selected Piece:\n");
            userInputPiece = nextLine();
        }while(validatePiece(userInputPiece)==false);

        do {
            System.out.Println("\rPlease selected Direction:\n");
            userInputDirect = nextLine();
        }while(validateDirection(userInputDirect)==false);

        userDirect = parseDirection(userInputDirect);
        //Coordinate class already have constructor with string param, parsePiece() is not necessary
        userCoor = parsePiece(userInputPiece);  

        userReq = new Request(currentPlayer, userCoor, userDirect[0], userDirect[1]);
        return userReq;
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
    private int[] parseDirection(String pos) {
        //IF userDirect pass validateDirect(), parse to request dx,dy
        int temp[] = new int[2];
        
        switch(pos){
            case "w":
                temp[0] = 0;temp[1] = 1;
                break;
            case "a":
                temp[0] = -1;temp[1] = 0;
                break;
            case "s":
                temp[0] = 1;temp[1] = 0;
                break;
            case "d":
                temp[0] = 0;temp[1] = -1;
                break;

        }


        return temp;
    }

    private Coordinate parsePiece(String pos){
        // if userPiece pass validatePiece, parse to coordinate
        Coordinate temp = new Coordinate(pos);
        return temp;
    }

    public String[] getUserInfo(Player player) {
        String userInfo[] = {player.getName(),player.getParty()};
        return userInfo;
    }
}
