

package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKIntervencija;

public abstract class Kontroler { //Caretaker
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    DKIntervencija in;   
    DKIntervencija memento;
    String poruka;
         
}
