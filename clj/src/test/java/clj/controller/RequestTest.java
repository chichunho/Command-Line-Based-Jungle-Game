package clj.controller;

public class RequestTest {

    private int dx;
    private int dy;

    private Coordinate coordinate;

    private PlayerTest player;

    public RequestTest(PlayerTest player, Coordinate coordinate, int dx, int dy){
        this.dx = 0;
        this.dy = 0;
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

    public PlayerTest getPlayer(){
        return this.player;
    }
}
