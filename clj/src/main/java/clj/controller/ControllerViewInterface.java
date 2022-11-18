package clj.controller;

/**
 * This provide a interface for Controller to update the View
 */
public interface ControllerViewInterface {
    /**
    * This function is to ask the players to input their name
    * @param counting of the function execution times
    */
    abstract void promptPlayerName(int count);

    /** 
    * This function prints the message of theteam distribution
    * @param p1, p2, p1Party
    */
    abstract void printPlayerInfo(String p1, String p2, int p1Party);
    
    /** 
    * This function prints the remind message of current turn
    * @param currentPlayer  The Player object
    * @param party          The number represent the player party
    */
    abstract void printTurnInfo(String currentPlayer, int party);
    
    /**
    * This function prints the message of asking player to select a piece
    */
    abstract void promptPlayerSelectPiece();
    
    /** 
    * This function prints the message of asking player to select the direction
    */
    abstract void promptPlayerSelectDirection();
    
    /**
    * This function prints the message of invalid input's length,
    * when player selecting the piece
    */
    abstract void alertPieceWrongLength();
    
    /**
    * This function prints the message of invalid input,
    * when selecting a piece that is not in the format of [A-G][1-9]
    */
    abstract void alertPieceWrongFormat();
    
    /**
    * This function prints the message of invalid input,
    * when direction input is not a character
    */
    abstract void alertDirectionWrongLength();
    
    /**
    * This function prints the message of invalid input,
    * when the direction is not 'w', 's', 'a', or 'd'.
    */
    abstract void alertDirectionWrongFormat();
}
