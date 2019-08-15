
package Originator;

import DomainClasses.DKIntervencija;


public class Originator {
    DKIntervencija dkin;
    
    public void setMemento(DKIntervencija dkin)
    { 
      this.dkin = dkin;
    }
    
    public DKIntervencija createMemento()
    { return new DKIntervencija(this.dkin);}
}
