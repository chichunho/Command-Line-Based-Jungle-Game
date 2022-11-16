package clj;

import java.util.Scanner;

import clj.controller.Controller;
import clj.controller.Player;
import clj.controller.Request;
import clj.model.Model;
import clj.view.View;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        View view = new View();
        Controller controller = new Controller(scanner);
        Model model = new Model(view);

        Request request;
        int ret = 0;

        Player[] players;
        Player currentPlayer;

        int turn = 0;

        players = controller.getUserInfo();

        view.printInit();

        while(ret != 10 || ret != 12){
            currentPlayer = players[turn%2];

            request = controller.getUserRequest(currentPlayer);
            ret = model.run(request);
            if (ret > 9){
                turn++;
            } 
        }

        /*TODO print some message to notice the players the game has ended */

        scanner.close();
    }
}
