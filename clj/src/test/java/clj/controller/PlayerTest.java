package clj.controller;

import clj.model.Party;

public class PlayerTest implements Party{

    private String name;
    private int party;

    // this is a public constructor in test
    public PlayerTest(String name, int party){
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
