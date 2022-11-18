package clj.model;

/**
 * This class provide the encapsulation for the infomation that view needed
 */
public class Response {
    private int messageId;
    private String[] arguments;
    private Piece[][] pieces;
    
    /**
     * The constructor of the Response
     * @param messageId     The message id that the model want view to print
     * @param arguments     The message arguments
     * @param pieces        The current array of pieces on board
     */
    protected Response(int messageId, String[] arguments, Piece[][] pieces){
        this.messageId = messageId;
        this.arguments = arguments;
        this.pieces = pieces;
    }

    /**
     * This function return the message id
     * @return      The message id
     */
    public int getMsgId(){
        return this.messageId;
    }

    /**
     * This function return the message arguments
     * @return      The array of string contains the message arguments
     */
    public String[] getArguments(){
        return this.arguments;
    }

    /**
     * This function return the Chinese chraacter that represent the animal at specific position on board
     * @param col   The column index
     * @param row   The row index
     * @return      The Chinese chraacter that represent the animal
     */
    public String getPieceAnimal(int col, int row){
        if (pieces[row][col] == null){
            return new String("");
        }
        return pieces[row][col].toString();
    }

    /**
     * This function return the party of the piece at specific position on board.
     * @param col   The column index
     * @param row   The row index
     * @return      The number representing the party of the piece
     */
    public int getPieceParty(int col, int row){
        return pieces[row][col].getParty();
    }
}
