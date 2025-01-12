package climbers.repositories;

import climbers.models.mountain.Mountain;

import java.util.Collection;
import java.util.Collections;

public class MountainRepository implements Repository<Mountain> {

    private Collection<Mountain> mountains;

    @Override
    public void add(Mountain entity) {
        this.mountains.add(entity);
    }

    @Override
    public boolean remove(Mountain entity) {
        return this.mountains.remove(entity);
    }

    @Override
    public Mountain byName(String name) {
        return this.mountains.stream()
                .filter(mountain -> name.equals(mountain.getName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Mountain> getCollection() {
        return Collections.unmodifiableCollection(this.mountains);
    }
}
