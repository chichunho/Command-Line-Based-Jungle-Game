package clj;

import clj.controller.Controller;
import clj.controller.Player;
import clj.controller.Request;
import clj.model.Model;
import clj.model.Response;
import clj.view.View;

public class App 
{
    public static void main( String[] args )
    {
        View view = new View();
        Controller controller = new Controller(view);
        Model model = new Model(view);

        boolean isEndGame = false;

        Request request;
        Response response;

        Player[] players;
        Player currentPlayer;

        players = controller.getUserInfo();

        int turn = 0;

        while(!isEndGame){
            currentPlayer = players[turn%2];

            request = controller.getUserRequest();
            response = model.run(currentPlayer, request);
            isEndGame = response.getIsEndGame();
        }

        /*TODO print some message to notice the players the game has ended */
    }
}
