

package Builder;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;


public class Projektant1 extends Projektant {
    
    @Override
    public void kreirajSoftverskiSistem()
    { ss = new SoftverskiSistem();
    }
    
    @Override
    public void kreirajEkranskuFormu() 
      { Panel pan = new Panel1(); 
        ss.ef = new EkranskaForma2(); 
        ss.ef.setPanel(pan);
      }   
    
    @Override
    public void kreirajBrokerBazePodataka () 
      { ss.bbp = new BrokerBazePodataka1(); 
      }  
        
    @Override
    public void kreirajKontroler () 
      { ss.kon = new Kontroler1(ss.ef,ss.bbp); 
      }

    @Override
    public void prikaziEkranskuFormu() 
      { ss.ef.prikaziEkranskuFormu();
      }
}

