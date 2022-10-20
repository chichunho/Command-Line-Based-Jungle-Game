package clj;

import clj.controller.Controller;
import clj.model.Model;
import clj.view.View;

public class App 
{
    public static void main( String[] args )
    {
        View view = new View();
        Controller controller = new Controller(view);
        Model model = new Model(view);
    }
}
