package harpoonDiver.core;

import harpoonDiver.common.ConstantMessages;
import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;
import harpoonDiver.repositories.Repository;

import java.util.Collection;
import java.util.List;

public class ControllerImpl implements Controller{

    private Repository<Diver> diverRepository;
    private Repository<DivingSite> divingSiteRepository;
    private int divingCount;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
    }

    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver;
        switch (kind) {
            case "DeepWaterDiver":
                diver = new DeepWaterDiver(diverName);
                break;
            case "OpenWaterDiver":
                diver = new OpenWaterDiver(diverName);
                break;
            case "WreckDiver":
                diver = new WreckDiver(diverName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.DIVER_INVALID_KIND);
        }

        this.diverRepository.add(diver);

        return String.format(ConstantMessages.DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {

        DivingSite divingSite = new DivingSiteImpl(siteName);

        divingSite.getSeaCreatures().addAll(List.of(seaCreatures));

        this.divingSiteRepository.add(divingSite);

        return String.format(ConstantMessages.DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {

        Diver diver = this.diverRepository.byName(diverName);
        if (null == diver) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DIVER_DOES_NOT_EXIST, diverName));
        }
        this.diverRepository.remove(diver);

        return String.format(ConstantMessages.DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        Collection<Diver> divers = this.diverRepository.getCollection();

        if (divers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SITE_DIVERS_DOES_NOT_EXISTS);
        }

        DivingSite divingSite = this.divingSiteRepository.byName(siteName);
        DivingImpl diving = new DivingImpl();
        diving.searching(divingSite, divers);

        long removedDivers = divers.stream()
                .filter(diver -> !diver.canDive()).count();
        this.divingCount++;

        return String.format(ConstantMessages.SITE_DIVING, siteName, removedDivers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ConstantMessages.FINAL_DIVING_SITES, divingCount));
        sb.append(System.lineSeparator());
        sb.append(String.format(ConstantMessages.FINAL_DIVERS_STATISTICS));


        this.diverRepository.getCollection()
                .forEach(diver -> {
                    sb.append(System.lineSeparator());
                    sb.append(String.format(ConstantMessages.FINAL_DIVER_NAME, diver.getName()));
                    sb.append(System.lineSeparator());
                    sb.append(String.format(ConstantMessages.FINAL_DIVER_OXYGEN, diver.getOxygen()));
                    sb.append(System.lineSeparator());

                    Collection<String> seaCreatures = diver.getSeaCatch().getSeaCreatures();
                    String catchCreatures = seaCreatures.isEmpty() ? "None" :
                            String.join(ConstantMessages.FINAL_DIVER_CATCH_DELIMITER);
                    sb.append(String.format(ConstantMessages.FINAL_DIVER_CATCH, seaCreatures));

                    sb.append(String.format(ConstantMessages.FINAL_DIVER_CATCH, catchCreatures));

                });

        return sb.toString();
    }
}
