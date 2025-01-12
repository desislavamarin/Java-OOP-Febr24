package climbers.models.climber;

import climbers.common.ExceptionMessages;
import climbers.models.roster.Roster;

public class BaseClimber implements Climber{

    private static final int DEFAULT_CLIMBER_STRENGTH = 30;

    private String name;
    private double strength;
    private Roster roster;

    public BaseClimber(String name, double strength) {
        this.setName(name);
        this.setStrength(strength);
    }

    @Override
    public void climb() {
        double climbStrength = this.getClass().getSimpleName()
                .equals("WallClimber") ? 30 : 60;

        this.setStrength(Math.max(0, this.strength - climbStrength));
    }

    @Override
    public boolean canClimb() {
        return this.strength > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getStrength() {
        return this.strength;
    }

    @Override
    public Roster getRoster() {
        return this.roster;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setStrength(double strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }
}
