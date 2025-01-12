package Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Privvate;

import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Soldier.SoldierImpl;

public abstract class PrivateImpl extends SoldierImpl implements Private{
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
