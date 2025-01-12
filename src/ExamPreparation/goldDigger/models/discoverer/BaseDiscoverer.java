package ExamPreparation.goldDigger.models.discoverer;

import ExamPreparation.goldDigger.models.museum.BaseMuseum;
import ExamPreparation.goldDigger.models.museum.Museum;

import static ExamPreparation.goldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static ExamPreparation.goldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public abstract class BaseDiscoverer implements Discoverer{
    private String name;
    private double energy;
    private Museum museum;

    public BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }

    public void dig(){
        this.energy -= 15;
        if (energy < 0) {
            this.energy = 0;
        }
    }

    @Override
    public boolean canDig() {
        return this.energy > 0;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }
}
