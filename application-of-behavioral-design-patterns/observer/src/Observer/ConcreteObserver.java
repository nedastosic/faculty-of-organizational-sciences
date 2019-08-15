
package Observer;

import DomainClasses.DKIntervencija;
import AbstractProductC.Kontroler;

public class ConcreteObserver implements Observer
{ Kontroler kon;
   
  public ConcreteObserver(Kontroler kon1) {kon=kon1;}  
  
   @Override
   public void Update(int sifraIntervencije)
    { DKIntervencija tekucain = (DKIntervencija) kon.getDKObject();
      if (tekucain!=null)
              {
                 if (sifraIntervencije == tekucain.getSifraIntervencije())
                   { kon.nadjiDomenskiObjekat();
                   }     
              }  
    }
   
   
   
}

