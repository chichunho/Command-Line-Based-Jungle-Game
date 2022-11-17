package clj.controller;

public interface ControllerViewInterface {
    abstract void promptPlayerName(int count);
    abstract void printPlayerInfo(String p1, String p2, int p1Party);
    abstract void printTurnInfo(String currentPlayer, int party);
    abstract void promptPlayerSelectPiece();
    abstract void promptPlayerSelectDirection();
    abstract void alertPieceWrongLength();
    abstract void alertPieceWrongFormat();
    abstract void alertDirectionWrongLength();
    abstract void alertDirectionWrongFormat();
}
