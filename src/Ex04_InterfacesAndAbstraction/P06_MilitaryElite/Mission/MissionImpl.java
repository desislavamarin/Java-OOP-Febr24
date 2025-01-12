package Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Mission;

public class MissionImpl implements Mission{
    private String codeName;
    private State state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    @Override
    public String getCodeName() {
        return codeName;
    }

    public State getState() {
        return state;
    }

    @Override
    public void completeMission() {
        this.state = State.finished;
    }

    private void setState(String state) {
        this.state = State.valueOf(state);
    }
}
