package clj.controller;

import clj.model.Party;

public class PlayerTest implements Party{

    private String name;
    private int party;

    protected PlayerTest(String name, int party){
        this.name = name;
    }

    public String getName(){
        return null;
    }

    @Override
    public int getParty() {
        return this.party;
    }
}
