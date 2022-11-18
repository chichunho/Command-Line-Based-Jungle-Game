package clj.controller;

import java.util.Scanner;
import java.util.Random;

public class Controller {
    
    Scanner scanner;
    ControllerViewInterface CVInter;
    ControllerModelInterface CMInter;

    public Controller(Scanner scanner, ControllerViewInterface CVInter, ControllerModelInterface CMInter){
        this.scanner = scanner;
        this.CVInter = CVInter;
        this.CMInter = CMInter;
    }
    // TODO fill the javadoc
    /**
     * This function validate user's input piece string
     * @param pos
     * @return boolean 
     */
    private boolean validatePiece(String pos){

        // if the string length is not 2, it must be invalid
        if (pos.length()!=2){
            CVInter.alertPieceWrongLength();
            return false;
        }

        // since the user index input format is [A-G][1-9]
        // [A-G] is col index
        // [1-9] is row index
        int col = pos.charAt(0);
        int row = pos.charAt(1);

        // validate the format [A-G][1-9]
        if (col < 'A' || col > 'G' || row < '1' || row > '9'){
            CVInter.alertPieceWrongFormat();
            return false;
        }

        return true;
    }

    // TODO fill the javadoc
    /**
     * this function validate user input direction string
     * @param pos
     * @return boolean
     */
    private boolean validateDirection(String pos){

        if (pos.length()!= 1){
            CVInter.alertDirectionWrongLength();
            return false;
        }
        char userDirect = Character.toLowerCase(pos.charAt(0));

        if (userDirect !='w' && userDirect != 's' && userDirect !='d' && userDirect !='a'){
            CVInter.alertDirectionWrongFormat();
            return false;
        }

        return true;
    }

    // TODO fill the javadoc
    /**
     * this fucntion prompt user to select piece and direction in every turn
     * @param currentPlayer
     * @return Request object
     */
    public int processUserRequest(Player currentPlayer){
        
        String userInputPiece;
        String userInputDirect;
        int userDirect[];
        Coordinate userCoor;
        int modelRet;

        CVInter.printTurnInfo(currentPlayer.getName(), currentPlayer.getParty());
        do {
            CVInter.promptPlayerSelectPiece();
            userInputPiece = scanner.nextLine();
        }while(validatePiece(userInputPiece)==false);

        do {
            CVInter.promptPlayerSelectDirection();
            userInputDirect = scanner.nextLine();
        }while(validateDirection(userInputDirect)==false);

        userDirect = parseDirection(userInputDirect);
        //Coordinate class already have constructor with string param, parsePiece() is not necessary
        userCoor = parsePiece(userInputPiece);  

        modelRet = CMInter.runRequest(new Request(currentPlayer, userCoor, userDirect[0], userDirect[1]));

        return modelRet;
    }

    // TODO fill the javadoc
    /**
     * this function parse user input direction string to integer array
     * @param pos
     * @return integer array,[0] is x, [1] is y
     */
    private int[] parseDirection(String direction) {
        //If userDirect pass validateDirect(), parse to request dx,dy
        int temp[] = new int[2];
        
        char userDirect = Character.toLowerCase(direction.charAt(0));
        // this follows the program array index
        // 'w' means move forward, so y-coordinate should -1
        // 'a' means move to the left, so x-coordinate should -1
        // 's' means move backward, so y-coordinate should +1,
        // 'd' means move to the right, so x-cooridnate should +1
        switch(userDirect){
            case 'w':
                temp[0] = 0;
                temp[1] = -1;
                break;
            case 'a':
                temp[0] = -1;
                temp[1] = 0;
                break;
            case 's':
                temp[0] = 0;
                temp[1] = 1;
                break;
            case 'd':
                temp[0] = 1;
                temp[1] = 0;
        }
        return temp;
    }

    // TODO fill the javadoc
    /**
     * This function parse user input piece string to coordinate object
     * @param pos
     * @return coordinate object
     */
    private Coordinate parsePiece(String pos){
        // if userPiece pass validatePiece, parse to coordinate
        Coordinate temp = new Coordinate(pos);
        return temp;
    }

    // TODO fill the javadoc
    /**
     * this function prompt user to input players' information at the start of the game
     * @return player object array
     */
    public Player[] getUserInfo() {

        // two variables to store the input
        String[] playerNames = new String[2];
        Player[] players = new Player[2];

        // ask for user input
        CVInter.promptPlayerName(0);
        playerNames[0] = scanner.nextLine();
        CVInter.promptPlayerName(1);
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

        CVInter.printPlayerInfo(players[0].getName(), players[1].getName(), players[0].getParty());

        return players;
    }
}
