

package Builder;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;


public class Projektant3 extends Projektant {
    /*class SoftverskiSistem // Complex Product
           {  EkranskaForma ef; // AbstractProductA 
              BrokerBazePodataka bbp; // AbstractProductB 
              Kontroler kon; // AbstractProductC 
           }  */   
    //SoftverskiSistem ss;
    
    @Override
    public void kreirajSoftverskiSistem()
    { ss = new SoftverskiSistem();
    }
    
    @Override
    public void kreirajEkranskuFormu() 
      { Panel pan = new Panel1(); 
        ss.ef = new EkranskaForma1(); 
        ss.ef.setPanel(pan);
      }   
    
    @Override
    public void kreirajBrokerBazePodataka () 
      { ss.bbp = new BrokerBazePodataka1(); 
      }  
        
    @Override
    public void kreirajKontroler () 
      { ss.kon = new Kontroler2(ss.ef,ss.bbp); 
      }

    @Override
    public void prikaziEkranskuFormu() 
      { ss.ef.prikaziEkranskuFormu();
      }
}
