package clj.view;

import clj.model.Response;
import clj.controller.ControllerViewInterface;
import clj.model.ModelViewInterface;

public class View implements ModelViewInterface, ControllerViewInterface{
    
    // The colour string the add colour to the pieces
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_BLUE = "\u001B[34m";

    // initialise the pieces location on the board
    final int[] RED_X = {1, 13, 3, 11, 1, 5, 9, 13};
    final int[] RED_Y = {1, 1, 3, 3, 5, 5, 5, 5};
    final int[] BLUE_X = {13, 1, 3, 11, 13, 9, 5, 1};
    final int[] BLUE_Y = {17, 17, 15, 15, 13, 13, 13, 13};
    final String[] ANIMAL_NAME = {"獅", "虎", "狗", "貓", "鼠", "豹", "狼", "象"};

        
    /** TODO fill the javadoc
    *
    * This function to print the initial board
    * @return Nothing
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

        // add pieces with colour to the board
        for (int i = 0; i < 8; i++){
            board[RED_Y[i]][RED_X[i]] = ANSI_RED + ANIMAL_NAME[i] + ANSI_RESET;
            board[BLUE_Y[i]][BLUE_X[i]] = ANSI_BLUE + ANIMAL_NAME[i] + ANSI_RESET;
        }
        
        // print [A-G], [1-9] beside the board for players to easy to read the board
        char colIndex = 'A';
        int rowIndex = 9;
        for (int i = 0; i < 19; i++){
            if (i%2 == 1){
                System.out.print(rowIndex+" ");
                rowIndex--;
            }
            else{
                System.out.print("  ");
            }
            for (int j = 0; j < 15; j++){
                System.out.print(board[i][j]);
            }
            System.out.print('\n');
        }

        for (int i = 0; i < 8; i++){
            if (i == 0){
                System.out.print("   ");
            }
            else{
                System.out.print((char)(colIndex+i-1)+"  ");
            }
        }
        System.out.println();
    }

    /** TODO fill the javadoc
    *
    * This function to receive the message and data from the model and call the printView function to print the view and print suitable message 
    * @param Response
    * @return Nothing
    */
    
    @Override
    public void modelUpdateView(Response response){

        String[] arguments = response.getArguments();

        printView(response);
        switch (response.getMsgId()) {
            // when no piece is selected
            case 1:
                System.out.println("No piece is selected.");
                System.out.println("Please input again.");
                break;
            // when the player choose the opponent's piece
            case 2:
                System.out.println("You can not choose opponent's piece.");
                System.out.println("Please input again.");
                break;
            // when pieces move out of bound
            case 3:
                System.out.println("The destination is out of bound!");
                System.out.println("Please input again.");
                break;

            // when player try to move to his/her own den
            case 4:
                System.out.println("You cannot enter your den!");
                System.out.println("Please input again.");
                break;
            // when the jump action of lion or tiger is interupted
            case 5:
                System.out.println(arguments[0]+" cannot jump over the river due to a piece in river blocking the way.");
                System.out.println("Please input again.");
                break;
            // when the piece fail to enter the water square
            case 6:
                System.out.println("This piece cannot enter the water square!");
                System.out.println("Please input again.");
                break;

            // when player try to move to square where containing a friendly piece
            case 7:
                System.out.println("One of your piece has already in that square!");
                System.out.println("Please input again.");
                break;
            // when player try to capture another higher rank piece, and it is not trapped
            case 8:
                System.out.println("You cannot capture higher rank pieces!");
                System.out.println("Please input again.");
                break;
            // when the rat is in water and try to capture elephant on land
            case 9:
                System.out.println("Rat in river cannot capture enemy elephant on land!");
                System.out.println("Please input again.");
                break;
            // when the rat is in water and try to capture enemy rat on land, or vice versa
            case 10:
                System.out.println("Rat in river cannot capture enemy rat on land, or vice versa!");
                System.out.println("Please input again.");
                break;
            // when the player move his/her piece to enemy's den
            case 11:
                System.out.println(arguments[0]+"\'s piece has moved to the enemy\'s den, "+arguments[0]+" wins!");
                break;
            // the piece is moved successfully or capture the enemy's piece
            case 12:
                if (arguments[2]!=null){
                    System.out.println("Player "+arguments[0]+"\'s "+arguments[1]+" capture enemy "+arguments[2]+"!");
                }
                else{
                    System.out.println("Player "+arguments[0]+"\'s "+arguments[1]+" is moved sucessfully.");
                }
                break;
            // when a player has no pieces to play
            case 13:
                System.out.println("Congratulations! Your opponent has no piece to play, " + arguments[0] + " win the game!");
                break;
        }
    }
    
    /** TODO fill the javadoc
    *
    * This function to print the View with upated data 
    * @param Response
    * @return Nothing
    */
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
        char colIndex = 'A';
        int rowIndex = 9;
        for (int i = 0; i < 19; i++){
            if (i%2 == 1){
                System.out.print(rowIndex+" ");
                rowIndex--;
            }
            else{
                System.out.print("  ");
            }
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

        for (int i = 0; i < 8; i++){
            if (i == 0){
                System.out.print("   ");
            }
            else{
                System.out.print((char)(colIndex+i-1)+"  ");
            }
        }
        System.out.println();
    }

    /** TODO fill the javadoc
    *
    * This function to ask the players to input their name
    * @param counting of the function execution times
    * @return Nothing
    */
    @Override
    public void promptPlayerName(int count) {
        if (count == 0){
            System.out.println("Please Enter the first player's name: ");
        }
        if (count == 1){
            System.out.print("Please enter the second player's name: ");
        }
    }

    /** TODO fill the javadoc
    *
    * This function to print the message of theteam distribution
    * @param p1, p2, p1Party
    * @return Nothing
    */
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

    /** TODO fill the javadoc
    *
    * This function to print it is who's trun
    * @param currentPlayer, currentPlayer's party
    * @return Nothing
    */
    @Override
    public void printTurnInfo(String currentPlayer, int party) {
        System.out.print("Now is "+currentPlayer);
        if (party == 1){
            System.out.print("(Red)");
        }
        else{
            System.out.print("(Blue)");
        }
        System.out.println("\'s turn.");
    }

    /** TODO fill the javadoc
    *
    * This function to print the message of asking player to select a piece
    * @return Nothing
    */
    @Override
    public void promptPlayerSelectPiece() {
        System.out.print("Please select Piece: ");
    }

    /** TODO fill the javadoc
    *
    * This function to print the message of asking player to select the direction
    * @return Nothing
    */
    @Override
    public void promptPlayerSelectDirection() {
        System.out.print("Please select Direction: ");
    }

    /** TODO fill the javadoc
    *
    * This function to print the message of player input invalid input when selecting a piece that is not in the format of 1 english letter and one number
    * @return Nothing
    */
    @Override
    public void alertPieceWrongLength() {
        System.out.println("Invalid input: input should consist 1 english letter and one number.");
    }

    /** TODO fill the javadoc
    *
    * This function to print the message of player input invalid input when selecting a piece that is not in the format of [A-G][1-9]
    * @return Nothing
    */
    @Override
    public void alertPieceWrongFormat() {
        System.out.println("Invalid input: The input should follow the format of [A-G][1-9], e.g. A3.");
    }

    /** TODO fill the javadoc
    *
    * This function to print the message of player input invalid input when selecting a piece that is not 1 character
    * @return Nothing
    */
    @Override
    public void alertDirectionWrongLength() {
        System.out.println("Invalid input: input should consists 1 character");
    }

    /** TODO fill the javadoc
    *
    * This function to print the message of player input invalid input when selecting a piece that is not 'w', 's', 'a', or 'd'.
    * @return Nothing
    */
    @Override
    public void alertDirectionWrongFormat() {
        System.out.println("Invalid Direction selected");
    }
}
