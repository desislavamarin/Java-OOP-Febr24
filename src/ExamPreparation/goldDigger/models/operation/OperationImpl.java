package ExamPreparation.goldDigger.models.operation;

import ExamPreparation.goldDigger.models.discoverer.Discoverer;
import ExamPreparation.goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation{
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        Collection<String> spots = spot.getExhibits();
        discoverers.forEach(discoverer -> {
            while (discoverer.canDig() && spots.iterator().hasNext()) {
                discoverer.canDig();
                String currentSpot = spots.iterator().next();
                discoverer.getMuseum().getExhibits().add(currentSpot);
                spots.remove(currentSpot);
            }
        });
    }
}
