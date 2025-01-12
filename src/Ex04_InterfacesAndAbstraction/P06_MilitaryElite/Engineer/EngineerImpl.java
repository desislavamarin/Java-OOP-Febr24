package Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Engineer;

import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Repair.Repair;
import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Soldier.SpecialisedSoldierImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class EngineerImpl extends SpecialisedSoldierImpl implements  Engineer{

    private Collection<Repair> repairs;
    public EngineerImpl(int id, String firstName, String lastName,
                        double salary, String corps, Collection<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.setRepairs(repairs);
    }

    private void setRepairs(Collection<Repair> repairs) {
        if (null == repairs) {
            this.repairs = new ArrayList<>();
        } else {
            this.repairs = repairs;
        }
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }
}
