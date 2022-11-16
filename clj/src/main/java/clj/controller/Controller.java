package clj.controller;

import java.util.Scanner;
import java.util.Random;

public class Controller {
    
    Request request;
    Scanner scanner;

    public Controller(Scanner scanner){
        this.scanner = scanner;
    }
    // TODO fill the javadoc
    /**
     * 
     * @param pos
     * @return
     */
    private boolean validatePiece(String pos){

        // if the string length is not 2, it must be invalid
        if (pos.length()!=2){
            System.out.println("Invalid input: input should consist 1 english letter and one number.");
            return false;
        }

        // since the user index input format is [A-G][1-9]
        // [A-G] is col index
        // [1-9] is row index
        int col = pos.charAt(0);
        int row = pos.charAt(1);

        // validate the format [A-G][1-9]
        if (col < 'A' || col > 'G' || row < '1' || row > '9'){
            System.out.println("Invalid input: The input should follow the format of [A-G][1-9], e.g. A3.");
            return false;
        }

        return true;
    }

    // TODO fill the javadoc
    /**
     * 
     * @param pos
     * @return
     */
    private boolean validateDirection(String pos){

        if (pos.length()!= 1){
            System.out.println("Invalid input: input should consists 1 character");
            return false;
        }
        char userDirect = Character.toLowerCase(pos.charAt(0));

        if (userDirect !='w' && userDirect != 's' && userDirect !='d' && userDirect !='a'){
            System.out.println("Invalid Direction selected");
            return false;
        }

        return true;
    }

    // TODO fill the javadoc
    /**
     * 
     * @param currentPlayer
     * @return
     */
    public Request getUserRequest(Player currentPlayer){
        
        String userInputPiece;
        String userInputDirect;
        int userDirect[];
        Coordinate userCoor;
        
        Request userReq;

        System.out.println("Now is "+currentPlayer.getName()+"\'s turn.");

        do {
            System.out.print("Please select Piece: ");
            userInputPiece = scanner.nextLine();
        }while(validatePiece(userInputPiece)==false);

        do {
            System.out.print("Please select Direction: ");
            userInputDirect = scanner.nextLine();
        }while(validateDirection(userInputDirect)==false);

        userDirect = parseDirection(userInputDirect);
        //Coordinate class already have constructor with string param, parsePiece() is not necessary
        userCoor = parsePiece(userInputPiece);  

        userReq = new Request(currentPlayer, userCoor, userDirect[0], userDirect[1]);

        return userReq;
    }

    // TODO fill the javadoc
    /**
     * 
     * @param pos
     * @return
     */
    private int[] parseDirection(String pos) {
        //If userDirect pass validateDirect(), parse to request dx,dy
        int temp[] = new int[2];
        
        // this follows the program array index
        // 'w' means move forward, so y-coordinate should -1
        // 'a' means move to the left, so x-coordinate should -1
        // 's' means move backward, so y-coordinate should +1,
        // 'd' means move to the right, so x-cooridnate should +1
        switch(pos){
            case "w":
                temp[0] = 0;
                temp[1] = -1;
                break;
            case "a":
                temp[0] = -1;
                temp[1] = 0;
                break;
            case "s":
                temp[0] = 0;
                temp[1] = 1;
                break;
            case "d":
                temp[0] = 1;
                temp[1] = 0;
        }
        return temp;
    }

    // TODO fill the javadoc
    /**
     * 
     * @param pos
     * @return
     */
    private Coordinate parsePiece(String pos){
        // if userPiece pass validatePiece, parse to coordinate
        Coordinate temp = new Coordinate(pos);
        return temp;
    }

    // TODO fill the javadoc
    /**
     * 
     * @return
     */
    public Player[] getUserInfo() {

        // two variables to store the input
        String[] playerNames = new String[2];
        Player[] players = new Player[2];

        // ask for user input
        System.out.print("Please Enter the first player's name: ");
        playerNames[0] = scanner.nextLine();

        System.out.print("Please enter the second player's name: ");
        playerNames[1] = scanner.nextLine();

        Random rand = new Random();

        // distribute the party to the player randomly
        if (rand.nextInt(2) == 0){
            players[0] = new Player(playerNames[0], 1);
            players[1] = new Player(playerNames[1], 2);
        }
        else{
            players[0] = new Player(playerNames[0], 2);
            players[1] = new Player(playerNames[1], 1);
        }

        // decide the first play randomly
        if (rand.nextInt(2) == 0){
            Player temp = players[0];
            players[0] = players[1];
            players[1] = temp;
        }

        for (int i = 0; i < 2; i++){
            System.out.print(players[i].getName()+" is Party ");
            if (players[i].getParty() == 1){
                System.out.println("Red.");
            }
            else{
                System.out.println("Blue.");
            }
        }

        return players;
    }
}
