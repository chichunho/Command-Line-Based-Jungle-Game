package clj.controller;

import clj.model.Party;

public class Player implements Party{

    private String name;
    private int party;

    protected Player(String name, int party){
        this.name = name;
        this.party = party;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int getParty() {
        return this.party;
    }
}
