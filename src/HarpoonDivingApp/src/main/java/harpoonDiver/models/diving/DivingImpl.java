package harpoonDiver.models.diving;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;
import java.util.Iterator;

public class DivingImpl implements Diving{

    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {

        Collection<String> seaCreatures = divingSite.getSeaCreatures();
        Iterator<String> seaCreatureIterator = seaCreatures.iterator();

        divers.forEach(diver -> {
            while (diver.canDive() && seaCreatureIterator.hasNext()) {
                diver.shoot();
                String creature = seaCreatureIterator.next();
                diver.getSeaCatch().getSeaCreatures().add(creature);
                seaCreatures.remove(creature);
            }
        });
    }
}
