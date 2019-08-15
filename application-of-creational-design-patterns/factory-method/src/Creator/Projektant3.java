

package Creator;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;


public class Projektant3 extends Projektant { //ConcreteCreator
       
    @Override
    public EkranskaForma kreirajEkranskuFormu() 
      { Panel pan = new Panel1(); 
        EkranskaForma ef = new EkranskaForma1(); 
        ef.setPanel(pan);
        return ef;
      }   
    
    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka () 
      { return new BrokerBazePodataka1(); 
      }  
        
    @Override
    public Kontroler kreirajKontroler (EkranskaForma ef, BrokerBazePodataka bbp) 
      { return new Kontroler2(ef,bbp); 
      }
}
