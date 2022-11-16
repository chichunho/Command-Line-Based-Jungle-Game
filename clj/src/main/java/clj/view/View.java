package clj.view;

import clj.model.Response;

public class View {
    
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
    final int[] BLUE_X = {13, 1, 3, 11, 11, 9, 5, 1};
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
        }
    }
    public void printMessage(Response response){

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

            // when player try to capture another same party piece
            case 6:
                System.out.println("You cannot capture your pieces!");
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
        int pieceX = 0;
        int pieceY = 0;
        for (int i = 1; i < 19; i++){
            System.out.println();
            for (int j = 1; j < 15; j++){
                if (i%2 == 1 && j%2 == 1){
                    String pieceAnimalName = response.getPieceAnimal(pieceX, pieceY);
                    if (!pieceAnimalName.equals("")){
                        if (response.getPieceParty(pieceX, pieceY) == 1){
                            System.out.print(ANSI_RED + pieceAnimalName + ANSI_RESET);
                        }
                        else{
                            System.out.print(ANSI_BLUE + pieceAnimalName + ANSI_RESET);
                        }
                    }
                    else{
                        System.out.print('　');
                    }
                    pieceX++;
                }
                else{
                    System.out.print(board[i][j]);
                }
            }
            pieceY++;
        }
        /*
        for (int i=0; i<19; i++){
            System.out.println();
            for (int j=0; j<15; j++) {
                if (i==redlion_ycoordinate && j==redlion_xcoordinate && redlion_alive){
                    System.out.print(ANSI_RED + '獅' + ANSI_RESET);
                }
                else if (i==redtiger_ycoordinate && j==redtiger_xcoordinate && redtiger_alive) {
                    System.out.print(ANSI_RED + '虎' + ANSI_RESET);
                }
                else if (i==reddog_ycoordinate && j==reddog_xcoordinate && reddog_alive) {
                    System.out.print(ANSI_RED + '狗' + ANSI_RESET);
                }
                else if (i==redcat_ycoordinate && j==redcat_xcoordinate && redcat_alive) {
                    System.out.print(ANSI_RED + '貓' + ANSI_RESET);
                }
                else if (i==redrat_ycoordinate && j==redrat_xcoordinate && redrat_alive){
                    System.out.print(ANSI_RED + '鼠' + ANSI_RESET);
                }
                else if (i==redleopard_ycoordinate && j==redleopard_xcoordinate && redleopard_alive){
                    System.out.print(ANSI_RED + '豹' + ANSI_RESET);
                }
                else if (i==redwolf_ycoordinate && j==redwolf_xcoordinate && redwolf_alive){
                    System.out.print(ANSI_RED + '狼' + ANSI_RESET);
                }
                else if (i==redelephant_ycoordinate && j==redelephant_xcoordinate && redelephant_alive){
                    System.out.print(ANSI_RED + '象' + ANSI_RESET);
                }
                else if (i==blueelephant_ycoordinate && j==blueelephant_xcoordinate && blueelephant_alive){
                    System.out.print(ANSI_BLUE + '象' + ANSI_RESET);
                }
                else if (i==bluewolf_ycoordinate && j==bluewolf_xcoordinate && bluewolf_alive){
                    System.out.print(ANSI_BLUE + '狼' + ANSI_RESET);
                }
                else if (i==blueleopard_ycoordinate && j==blueleopard_xcoordinate && blueleopard_alive){
                    System.out.print(ANSI_BLUE + '豹' + ANSI_RESET);
                }
                else if (i==bluerat_ycoordinate && j==bluerat_xcoordinate && bluerat_alive){
                    System.out.print(ANSI_BLUE + '鼠' + ANSI_RESET);
                }
                else if (i==bluedog_ycoordinate && j==bluedog_xcoordinate && bluedog_alive) {
                    System.out.print(ANSI_BLUE + '狗' + ANSI_RESET);
                }
                else if (i==bluecat_ycoordinate && j==bluecat_xcoordinate && bluecat_alive) {
                    System.out.print(ANSI_BLUE + '貓' + ANSI_RESET);
                }
                else if (i==bluetiger_ycoordinate && j==bluetiger_xcoordinate && bluetiger_alive){
                    System.out.print(ANSI_BLUE + '虎' + ANSI_RESET);
                }
                else if (i==bluelion_ycoordinate && j==bluelion_xcoordinate && bluelion_alive) {
                    System.out.print(ANSI_BLUE + '獅' + ANSI_RESET);
                }
                else {
                    System.out.print((board[i][j]));
                }
            }
        }
        */
    }

    public void updateView(Response response){


        printMessage(response);

        /*
        // update the pieces information in View
        for (int i=0;i<9;i++){
            for (int j=0;j<7;j++){
                if (Objects.equals(response.getPieceAnimal(i,j), "Lion") && response.getPieceParty(i,j)==1){
                    redlion_xcoordinate = j*2+1;
                    redlion_ycoordinate = i*2+1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Tiger") && response.getPieceParty(i,j)==1) {
                    redtiger_xcoordinate = j * 2 + 1;
                    redtiger_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Dog") && response.getPieceParty(i,j)==1) {
                    reddog_xcoordinate = j * 2 + 1;
                    reddog_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Cat") && response.getPieceParty(i,j)==1) {
                    redcat_xcoordinate = j * 2 + 1;
                    redcat_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Rat") && response.getPieceParty(i,j)==1) {
                    redrat_xcoordinate = j * 2 + 1;
                    redrat_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Leopard") && response.getPieceParty(i,j)==1) {
                    redleopard_xcoordinate = j * 2 + 1;
                    redleopard_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Wolf") && response.getPieceParty(i,j)==1) {
                    redwolf_xcoordinate = j * 2 + 1;
                    redwolf_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Elephant") && response.getPieceParty(i,j)==1) {
                    redelephant_xcoordinate = j * 2 + 1;
                    redelephant_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Lion") && response.getPieceParty(i,j)==2){
                    redlion_xcoordinate = j*2+1;
                    redlion_ycoordinate = i*2+1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Tiger") && response.getPieceParty(i,j)==2) {
                    redtiger_xcoordinate = j * 2 + 1;
                    redtiger_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Dog") && response.getPieceParty(i,j)==2) {
                    reddog_xcoordinate = j * 2 + 1;
                    reddog_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Cat") && response.getPieceParty(i,j)==2) {
                    redcat_xcoordinate = j * 2 + 1;
                    redcat_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Rat") && response.getPieceParty(i,j)==2) {
                    redrat_xcoordinate = j * 2 + 1;
                    redrat_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Leopard") && response.getPieceParty(i,j)==2) {
                    redleopard_xcoordinate = j * 2 + 1;
                    redleopard_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Wolf") && response.getPieceParty(i,j)==2) {
                    redwolf_xcoordinate = j * 2 + 1;
                    redwolf_ycoordinate = i * 2 + 1;
                }
                else if (Objects.equals(response.getPieceAnimal(i,j), "Elephant") && response.getPieceParty(i,j)==2) {
                    redelephant_xcoordinate = j * 2 + 1;
                    redelephant_ycoordinate = i * 2 + 1;
                }
            }
        }
        */

        /*
        String lose_piece = response.getArguments()[3];
        String player = response.getArguments()[1];
        */

        /*
        // set the pieces is not alive when they are captured
        if (lose_piece!=null) {
            if (Objects.equals(player, "1")) {
                switch (lose_piece) {
                    case "Lion":
                        bluelion_alive = false;
                        break;

                    case "Tiger":
                        bluetiger_alive = false;
                        break;

                    case "Dog":
                        bluedog_alive = false;
                        break;

                    case "Cat":
                        bluecat_alive = false;
                        break;

                    case "Rat":
                        bluerat_alive = false;
                        break;

                    case "Leopard":
                        blueleopard_alive = false;
                        break;

                    case "Wolf":
                        bluewolf_alive = false;
                        break;

                    case "Elephant":
                        blueelephant_alive = false;
                        break;
                }
            }
            else if (Objects.equals(player, "2")) {
                switch (lose_piece) {
                    case "Lion":
                        redlion_alive = false;
                        break;

                    case "Tiger":
                        redtiger_alive = false;
                        break;

                    case "Dog":
                        reddog_alive = false;
                        break;

                    case "Cat":
                        redcat_alive = false;
                        break;

                    case "Rat":
                        redrat_alive = false;
                        break;

                    case "Leopard":
                        redleopard_alive = false;
                        break;

                    case "Wolf":
                        redwolf_alive = false;
                        break;

                    case "Elephant":
                        redelephant_alive = false;
                        break;
                }
            }
        }
        */
    }
}
