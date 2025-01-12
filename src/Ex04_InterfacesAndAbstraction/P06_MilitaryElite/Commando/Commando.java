package Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Commando;

import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Mission.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}
