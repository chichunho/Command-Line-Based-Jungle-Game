package clj.view;

import clj.model.Response;
import clj.controller.ControllerViewInterface;
import clj.model.ModelViewInterface;

public class View implements ModelViewInterface, ControllerViewInterface{
    
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_BLUE = "\u001B[34m";
    
    /*
    public static int redlion_xcoordinate = 1, redlion_ycoordinate = 1;
    public static int redtiger_xcoordinate = 13, redtiger_ycoordinate = 1;
    public static int reddog_xcoordinate = 3, reddog_ycoordinate = 3;
    public static int redcat_xcoordinate = 11, redcat_ycoordinate = 3;
    public static int redrat_xcoordinate = 1, redrat_ycoordinate = 5;
    public static int redleopard_xcoordinate = 5, redleopard_ycoordinate = 5;
    public static int redwolf_xcoordinate = 9, redwolf_ycoordinate = 5;
    public static int redelephant_xcoordinate = 13, redelephant_ycoordinate = 5;
    public static int bluelion_xcoordinate = 13, bluelion_ycoordinate = 17;
    public static int bluetiger_xcoordinate = 1, bluetiger_ycoordinate = 17;
    public static int bluedog_xcoordinate = 3, bluedog_ycoordinate = 15;
    public static int bluecat_xcoordinate = 11, bluecat_ycoordinate = 15;
    public static int bluerat_xcoordinate = 11, bluerat_ycoordinate = 13;
    public static int blueleopard_xcoordinate = 9, blueleopard_ycoordinate = 13;
    public static int bluewolf_xcoordinate = 5, bluewolf_ycoordinate = 13;
    public static int blueelephant_xcoordinate = 1, blueelephant_ycoordinate = 13;
    */

    final int[] RED_X = {1, 13, 3, 11, 1, 5, 9, 13};
    final int[] RED_Y = {1, 1, 3, 3, 5, 5, 5, 5};
    final int[] BLUE_X = {13, 1, 3, 11, 13, 9, 5, 1};
    final int[] BLUE_Y = {17, 17, 15, 15, 13, 13, 13, 13};
    final String[] ANIMAL_NAME = {"獅", "虎", "狗", "貓", "鼠", "豹", "狼", "象"};

    /*
    public static boolean redlion_alive = true, redtiger_alive = true, reddog_alive = true, redcat_alive = true, redrat_alive = true, redleopard_alive = true, redwolf_alive = true, redelephant_alive = true,
    bluelion_alive = true, bluetiger_alive = true, bluedog_alive = true, bluecat_alive = true, bluerat_alive = true, blueleopard_alive = true, bluewolf_alive = true, blueelephant_alive = true;
    */

    public void printInit(){

        // game board view with no pieces placed
        // 19 rows, 15 columns
        String[][] board = {
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","陷","|","穴","|","陷","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","　","|","陷","|","　","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","　","|","　","|","　","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","～","|","～","|","　","|","～","|","～","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","～","|","～","|","　","|","～","|","～","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","～","|","～","|","　","|","～","|","～","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","　","|","　","|","　","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","　","|","陷","|","　","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","陷","|","穴","|","陷","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"}};

        for (int i = 0; i < 8; i++){
            board[RED_Y[i]][RED_X[i]] = ANSI_RED + ANIMAL_NAME[i] + ANSI_RESET;
            board[BLUE_Y[i]][BLUE_X[i]] = ANSI_BLUE + ANIMAL_NAME[i] + ANSI_RESET;
        }

        for (int i = 0; i < 19; i++){
            for (int j = 0; j < 15; j++){
                System.out.print(board[i][j]);
            }
            System.out.print('\n');
        }
    }

    private void printMessage(Response response){

        String[] arguments = response.getArguments();

        printView(response);
        switch (response.getMsgId()) {
            // when no piece is selected
            case 1:
                System.out.println("No piece is selected, please input again.");
                break;
            // when the player choose the opponent's piece
            case 2:
                System.out.println("You can not choose opponent's piece, please input again.");
                break;
            // when pieces move out of bound
            case 3:
                System.out.println("The destination is out of bound!");
                break;

            // when player try to move to his/her own den
            case 4:
                System.out.println("You cannot enter your den!");
                break;

            // when the piece fail to enter the water square
            case 5:
                System.out.println("This piece cannot enter the water square!");
                break;

            // when player try to move to square where containing a friendly piece
            case 6:
                System.out.println("One of your piece has already in that square!");
                break;

            // when player try to capture another higher rank piece, and it is not trapped
            case 7:
                System.out.println("You cannot capture higher rank pieces!");
                break;

            // when the rat is in water and try to capture elephant on land
            case 8:
                System.out.println("Rat in river cannot capture enemy elephant on land!");
                break;

            // when the rat is in water and try to capture enemy rat on land, or vice versa
            case 9:
                System.out.println("Rat in river cannot capture enemy rat on land!");
                break;
            // when the player move his/her piece to enemy's den
            case 10:
                System.out.println(arguments[0]+"\'s piece has moved to the enemy\'s den, "+arguments[0]+" wins!");
                break;
            // the piece is moved successfully or capture the enemy's piece
            case 11:
                if (arguments[3]!=null){
                    System.out.println("Player "+arguments[0]+"\'s "+arguments[2]+" capture enemy "+arguments[3]+"!");
                }
                else{
                    System.out.println("Player "+arguments[0]+"\'s "+arguments[2]+" is moved sucessfully.");
                }
                break;
            // when a player has no pieces to play
            case 12:
                System.out.println("Congratulations! Your opponent has no piece to play, " + arguments[0] + " win the game!");
                break;
        }
    }
    public void printView(Response response){

        // game board view with no pieces placed
        // 19 rows, 15 columns
        String[][] board = {
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","陷","|","穴","|","陷","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","　","|","陷","|","　","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","　","|","　","|","　","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","～","|","～","|","　","|","～","|","～","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","～","|","～","|","　","|","～","|","～","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","～","|","～","|","　","|","～","|","～","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","　","|","　","|","　","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","　","|","陷","|","　","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"},
            {"|","　","|","　","|","陷","|","穴","|","陷","|","　","|","　","|"},
            {"—","－","—","－","—","－","—","－","—","－","—","－","—","－","—"}};

        // print the board with the piece location information
        int row = 0;
        int col = 0;
        for (int i = 0; i < 19; i++){
            for (int j = 0; j < 15; j++){
                if (i%2 == 1 && j%2 == 1){
                    String pieceAnimalName = response.getPieceAnimal(col, row);
                    if (!"".equals(pieceAnimalName)){
                        if (response.getPieceParty(col, row) == 1){
                            System.out.print(ANSI_RED + pieceAnimalName + ANSI_RESET);
                        }
                        else{
                            System.out.print(ANSI_BLUE + pieceAnimalName + ANSI_RESET);
                        }
                    }
                    else{
                        System.out.print(board[i][j]);
                    }
                    col++;
                }
                else{
                    System.out.print(board[i][j]);
                }
            }
            col = 0;
            row += i%2;
            System.out.print('\n');
        }
    }

    @Override
    public void modelUpdateView(Response response){
        printMessage(response);
    }

    @Override
    public void promptPlayerName(int count) {
        if (count == 0){
            System.out.println("Please Enter the first player's name: ");
        }
        if (count == 1){
            System.out.print("Please enter the second player's name: ");
        }
    }

    @Override
    public void printPlayerInfo(String p1, String p2, int p1Party) {
        if (p1Party == 1){
            System.out.println(p1+" is Party Red.");
            System.out.println(p2+" is Party Blue.");
        }
        else{
            System.out.println(p1+" is Party Blue.");
            System.out.println(p2+" is Party Red.");
        }
    }

    @Override
    public void printTurnInfo(String currentPlayer, int party) {
        System.out.print("Now is "+currentPlayer);
        if (party == 1){
            System.out.print("(Red)");
        }
        else{
            System.out.print("(Blue");
        }
        System.out.println("\'s turn.");
    }

    @Override
    public void promptPlayerSelectPiece() {
        System.out.print("Please select Piece: ");
    }

    @Override
    public void promptPlayerSelectDirection() {
        System.out.print("Please select Direction: ");
    }

    @Override
    public void alertPieceWrongLength() {
        System.out.println("Invalid input: input should consist 1 english letter and one number.");
    }

    @Override
    public void alertPieceWrongFormat() {
        System.out.println("Invalid input: The input should follow the format of [A-G][1-9], e.g. A3.");
    }

    @Override
    public void alertDirectionWrongLength() {
        System.out.println("Invalid input: input should consists 1 character");
    }

    @Override
    public void alertDirectionWrongFormat() {
        System.out.println("Invalid Direction selected");
    }
}
