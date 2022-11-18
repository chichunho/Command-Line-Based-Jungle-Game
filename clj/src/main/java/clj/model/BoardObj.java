package clj.model;

public class BoardObj implements Party{

    private final String objType;
    private final int party;

    /**
     * The constructor of BoardObj
     * @param objType
     * @param party
     */
    protected BoardObj(String objType, int party){
        this.objType = objType;
        this.party = party;
    }

    /**
     * This function return the type name of the BoardObj.
     * @return      The string that describe the BoardObj.
     */
    public String getType(){
        return this.objType;
    }

    @Override
    public int getParty(){
        return this.party;
    }
}
