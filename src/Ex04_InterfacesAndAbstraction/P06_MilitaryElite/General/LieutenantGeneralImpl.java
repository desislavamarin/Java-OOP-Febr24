package Ex04_InterfacesAndAbstraction.P06_MilitaryElite.General;

import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Privvate.Private;
import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Privvate.PrivateImpl;

import java.util.Collection;
import java.util.Collections;

public abstract class LieutenantGeneralImpl extends PrivateImpl implements  LieutenantGeneral {

    private Collection<Private> privates;
    public LieutenantGeneralImpl(int id, String firstName, String lastName,
                                 double salary, Collection<Private> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
    }

    @Override
    public Collection<Private> getPrivates() {
        return Collections.unmodifiableCollection(this.privates);
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }
}
