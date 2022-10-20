package clj.controller;

public class Request {

    private int dx;
    private int dy;

    private Coordinate coordinate;

    protected Request(){
        this.dx = 0;
        this.dy = 0;
        this.coordinate = new Coordinate();
    }

    protected void setCoordX(int x){
        coordinate.setX(x);
    }

    protected void setCoordY(int y){
        coordinate.setY(y);
    }

    public int getDx(){
        return this.dx;
    }

    public int getDy(){
        return this.dy;
    }

    protected void setDx(int x){
        this.dx = x;
    }

    protected void setDy(int y){
        this.dy = y;
    }

    public Coordinate getCoordX(){
        return coordinate;
    }






}
