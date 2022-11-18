package clj.controller;

import clj.model.Party;

public class Player implements Party{

    private String name;
    private int party;
    /**
    *
    * Constructor of player class
    * @param name
    * @param party
    *
     */
    protected Player(String name, int party){
        this.name = name;
        this.party = party;
    }
    /**
    *
    * getter function of player name
    * @return name of the player
    *
    *
     */
    public String getName(){
        return this.name;
    }
    /**
    *
    * getter function of player party
    * inherits from party interface
    * @return party of the player
    *
    *
     */
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
