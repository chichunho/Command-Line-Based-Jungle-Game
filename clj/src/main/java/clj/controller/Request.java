package clj.controller;

public class Request {

    private int abs_x, abs_y;
    private int dx,dy;

    public Request(){
        this.dx = 0;  this.dy = 0;
    }



    protected void setAbs_x(int x){
        this.abs_x = Math.abs(x);
    }

    protected void setAbs_y(int y){
        this.abs_x = Math.abs(y);
    }


    public int getAbs_x(){
        return this.abs_x;
    }

    public int getAbs_y(){
        return this.abs_y;
    }

    protected void setDx(int x){
        this.dx = Math.abs(x);
    }

    protected void setDy(int y){
        this.dy = Math.abs(y);
    }


    public int getDx(){
        return this.dx;
    }

    public int getDy(){
        return this.dy;
    }







}
