package clj;

import java.util.Scanner;

import clj.controller.Controller;
import clj.model.Model;
import clj.view.View;
import clj.controller.Player;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        View view = new View();
        Model model = new Model(view);
        Controller controller = new Controller(scanner, view, model);

        int ret = 0;

        Player[] players;
        Player currentPlayer;

        int turn = 0;

        players = controller.getUserInfo();

        view.printInit();

        while(ret != 11 && ret != 13){
            currentPlayer = players[turn%2];

            ret = controller.processUserRequest(currentPlayer);
            if (ret > 10){
                turn++;
            } 
        }

        scanner.close();
    }
}
