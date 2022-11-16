package clj.controller;

public class RequestTest {

    private int dx;
    private int dy;

    private Coordinate coordinate;

    private PlayerTest player;

    /* in test, this will become a public constructor */
    public RequestTest(PlayerTest player, Coordinate coordinate, int dx, int dy){
        this.dx = dx;
        this.dy = dy;
        this.coordinate = coordinate;
        this.player = player;
    }

    public int getDx(){
        return this.dx;
    }

    public int getDy(){
        return this.dy;
    }

    public Coordinate getCoord(){
        return coordinate;
    }

    public int getPlayerParty(){
        return this.player.getParty();
    }

    public String getPlayerName(){
        return this.player.getName();
    }
}
