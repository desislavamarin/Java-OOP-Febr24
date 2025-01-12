package harpoonDiver.repositories;

import harpoonDiver.models.diver.Diver;

import java.util.*;

public class DiverRepository implements Repository<Diver> {

    private Collection<Diver> divers;

    public DiverRepository() {
        this.divers = new ArrayList<>();
    }

    @Override
    public void add(Diver diver) {
        this.divers.add(diver);
    }

    @Override
    public boolean remove(Diver diver) {
        return this.divers.remove(diver);
    }

    @Override
    public Diver byName(String name) {
        return this.divers.stream()
                .filter(diver -> name.equals(diver.getName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableCollection(this.divers);
    }
}
