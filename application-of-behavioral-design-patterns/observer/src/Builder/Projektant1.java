

package Builder;


import AbstractProductA.EkranskaForma2;
import AbstractProductA.Panel;
import AbstractProductA.Panel1;
import AbstractProductC.Kontroler1;
import ConcreteSubject.BrokerBazePodataka1;
import Subject.Subject;


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
    public void kreirajBrokerBazePodataka (Subject sub) 
      { ss.bbp = new BrokerBazePodataka1(sub); 
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

