package Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Soldier;

import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Privvate.PrivateImpl;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier{
    private Corps corps;
    public SpecialisedSoldierImpl(int id, String firstName,
                                  String lastName, double salary,
                                  String corps) {
        super(id, firstName, lastName, salary);

    }

    @Override
    public Corps getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = Corps.valueOf(corps);
    }
}

