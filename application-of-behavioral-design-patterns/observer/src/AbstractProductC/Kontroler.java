

package AbstractProductC;

import AbstractProductA.EkranskaForma;
import ConcreteSubject.BrokerBazePodataka;
import DomainClasses.DKIntervencija;
import DomainClasses.GeneralDObject;

public abstract class Kontroler {
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    DKIntervencija in;   
    String poruka;
    public GeneralDObject getDKObject(){return in;}
    public abstract void napuniDomenskiObjekatIzGrafickogObjekta(); 
    public abstract boolean nadjiDomenskiObjekat();
}
