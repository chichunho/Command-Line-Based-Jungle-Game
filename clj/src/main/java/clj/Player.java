package clj;

import clj.model.Party;

public class Player implements Party{

    private String name;
    private int party;

    public Player(String name){
        this.name = name;
    }

    public void setParty(int party){
        this.party = party;
    }

    public String getName(){
        return null;
    }

    @Override
    public int getParty() {
        // TODO Auto-generated method stub
        return -1;
    }
}
