package clj.model;

import clj.controller.Request;
import clj.controller.Player;
import clj.view.View;

public class Model {
    
    Board board;
    View view;

    public Model(View view){
        board = new Board();
        this.view = view;
    }

    public Response run(Player player, Request request){
        return null;
    }
}
