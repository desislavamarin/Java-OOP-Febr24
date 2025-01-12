package harpoonDiver.models.diver;

import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.seaCatch.BaseSeaCatch;
import harpoonDiver.models.seaCatch.SeaCatch;

import static harpoonDiver.common.ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY;

public abstract class BaseDiver implements Diver{

    private static final int DEFAULT_OXYGEN_CONSUMPTION = 30;
    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
    }

    @Override
    public void shoot() {
        this.oxygen -= DEFAULT_OXYGEN_CONSUMPTION;
        if (this.oxygen < 0) {
            this.oxygen = 0;
        }
        this.oxygen = Math.max(0, this.oxygen - DEFAULT_OXYGEN_CONSUMPTION);
    }

    @Override
    public boolean canDive() {
        return this.oxygen > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public SeaCatch getSeaCatch() {
        if (this.seaCatch == null) {
            this.initSeaCatch();
        }
        return this.seaCatch;
    }

    private void initSeaCatch() {
        this.seaCatch = new BaseSeaCatch();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }
}
