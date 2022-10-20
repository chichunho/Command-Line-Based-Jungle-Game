package clj.controller;

public class Coordinate {

    protected int x;
    protected int y;

    public Coordinate(){
        this.x = 0;
        this.y = 0;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int z){
        this.x = z;
    }
    public void setY(int z){
        this.y = z;
    }
}
