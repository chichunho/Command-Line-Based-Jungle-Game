package clj;

import clj.controller.Controller;
import clj.controller.Player;
import clj.controller.Request;
import clj.model.Model;
import clj.view.View;

public class App 
{
    public static void main( String[] args )
    {
        View view = new View();
        Controller controller = new Controller();
        Model model = new Model(view);

        Request request;
        int ret = 0;

        Player[] players;
        Player currentPlayer;

        int turn = 0;

        view.printInit();

        players = controller.getUserInfo();

        while(ret != 10 || ret != 12){
            currentPlayer = players[turn%2];

            request = controller.getUserRequest(currentPlayer);
            ret = model.run(request);
            if (ret > 9){
                turn++;
            } 
        }

        /*TODO print some message to notice the players the game has ended */
    }
}
