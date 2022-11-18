package clj.controller;

public class Request {

    private int dx;
    private int dy;

    private Coordinate coordinate;

    private Player player;
    /**
     * Constructor of Request object
     * @param Player
     * @param Coordinate
     * @param dx
     * @param dy
     */
    protected Request(Player player, Coordinate coordinate, int dx, int dy){
        this.dx = dx;
        this.dy = dy;
        this.coordinate = coordinate;
        this.player = player;
    }
    /**
    *
    * getter function of dx
    * @return dx
    *
    *
     */
    public int getDx(){
        return this.dx;
    }
    /**
    *
    * getter function of dy
    * @return dy
    *
    *
     */
    public int getDy(){
        return this.dy;
    }
    /**
    *
    * getter function for Coordinate object
    * @return Coordinate object
    *
    *
     */
    public Coordinate getCoord(){
        return coordinate;
    }
    /**
    *
    * getter function of player party
    * @return party of the player
    *
    *
     */
    public int getPlayerParty(){
        return this.player.getParty();
    }
    /**
    *
    * getter function of player name
    * @return name of the player
    *
    *
     */
    public String getPlayerName(){
        return this.player.getName();
    }

    /* Belows are constructor and methods used in test only */
    public Request(){}
    public Request testRequest(Player player, Coordinate coordinate, int dx, int dy){
        return new Request(player, coordinate, dx, dy);
    }
}
