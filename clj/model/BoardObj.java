package clj.model;

public class BoardObj implements Party{

    private final String objType;
    private final int party;


    protected BoardObj(String objType, int party){
        this.objType = objType;
        this.party = party;
    }

    public String getType(){
        return this.objType;
    }

    public int getParty(){
        return this.party;
    }
}
