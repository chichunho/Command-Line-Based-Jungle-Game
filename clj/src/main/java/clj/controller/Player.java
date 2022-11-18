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

    /* Below are methods and constructor used in test only */
    public Player(){
        
    }
    public Player testPlayer(String name, int party){
        return new Player(name, party);
    }
}
