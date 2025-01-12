package climbers.repositories;

import climbers.models.climber.Climber;

import java.util.Collection;
import java.util.Collections;

public class ClimberRepository implements Repository<Climber>{

    private Collection<Climber> climbers;

    @Override
    public void add(Climber entity) {
        this.climbers.add(entity);
    }

    @Override
    public boolean remove(Climber entity) {
        return this.climbers.remove(entity);
    }

    @Override
    public Climber byName(String name) {
        return this.climbers.stream()
                .filter(climber -> name.equals(climber.getName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Climber> getCollection() {
        return Collections.unmodifiableCollection(this.climbers);
    }
}
