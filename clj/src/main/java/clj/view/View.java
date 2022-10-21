package clj.view;

import java.io.File;
import java.util.Scanner;

import clj.controller.Player;

public class View {

    private String[] messageArray;

    
    private void readfile(File fpath) {
        /*
        Scanner Reader = new Scanner(File);
        int x = 0;
        while (Reader.hasNextLine()) {
            this.messageArray[x] = Reader.nextLine();
            x++;
        }
        */
        /*
        TODO add expcptions for file reading process
        */
    }

    public void updateView(){
    }

    public InputForm getUserInput() {
        return null;
    }

    public Player[] getUserInfo() {
        return null;
    }
}
