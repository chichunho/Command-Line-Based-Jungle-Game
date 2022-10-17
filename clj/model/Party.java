package clj.model;

public interface Party {
    /**
     * This function return the object's party.
     * 0->neutral,
     * 1->Red party,
     * 2->Blue party
     * @return      Party
     */
    int getParty();
}
