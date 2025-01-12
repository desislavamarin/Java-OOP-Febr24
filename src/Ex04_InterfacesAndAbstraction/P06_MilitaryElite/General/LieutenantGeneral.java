package Ex04_InterfacesAndAbstraction.P06_MilitaryElite.General;

import Ex04_InterfacesAndAbstraction.P06_MilitaryElite.Privvate.Private;

import java.util.Collection;

public interface LieutenantGeneral {
    Collection<Private> getPrivates();
    void addPrivate (Private priv);
}
