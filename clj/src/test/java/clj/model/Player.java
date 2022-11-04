package clj.model;

public class Player implements Party{

    private String name;
    private int party;

    protected Player(String name, int party){
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
