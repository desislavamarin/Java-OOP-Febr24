package Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Spy;

import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Soldier.SoldierImpl;

public abstract class SpyImpl extends SoldierImpl implements Spy {
    private int codeNumber;
    public SpyImpl(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public int getCodeNumber() {
        return codeNumber;
    }
}
