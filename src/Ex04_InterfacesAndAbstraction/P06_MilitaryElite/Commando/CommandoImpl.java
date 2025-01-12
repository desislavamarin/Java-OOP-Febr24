package Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Commando;

import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Mission.Mission;
import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Soldier.SpecialisedSoldierImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Collection<Mission> missions;
    public CommandoImpl(int id, String firstName, String lastName,
                        double salary, String corps,
                        Collection<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.setMissions(missions);
    }

    public void setMissions(Collection<Mission> missions) {
        if (null == missions) {
            this.missions = new ArrayList<>();
        } else {
            this.missions = missions;
        }
    }

    @Override
    public void addMission(Mission mission) {
     this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

}
