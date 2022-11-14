package clj.model;

public class BoardObjTest implements Party{

    private final String objType;
    private final int party;


    protected BoardObjTest(String objType, int party){
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
