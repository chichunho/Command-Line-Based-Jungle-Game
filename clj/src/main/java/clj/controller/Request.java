package clj.controller;

public class Request {

    private int dx;
    private int dy;

    private Coordinate coordinate;

    private Player player;

    protected Request(Player player, Coordinate coordinate, int dx, int dy){
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

    public Player getPlayer(){
        return this.player;
    }
}
