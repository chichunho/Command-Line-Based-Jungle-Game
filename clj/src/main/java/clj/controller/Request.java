package clj.controller;

public class Request {

    protected int dx;
    protected int dy;

    private Coordinate coordinate = new Coordinate();
    public Request(){
        this.dx = 0;  this.dy = 0;

    }


    public int getDx(){
        return this.dx;
    }

    public int getDy(){
        return this.dy;
    }

    public void setDx(int z){
        this.dx = z;
    }

    public void setDy(int z){
        this.dy = z;
    }

    public Coordinate getCoor(){
        return coordinate;
    }






}
