package Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Engineer;

import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Repair.Repair;

import java.util.Collection;

public interface Engineer {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}
