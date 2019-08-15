

package Builder;

import Client.Kontroler1;
import AbstractProductA.*;
import AbstractProductB.*;
import ConcreteCommand.SO;
import Invoker.Invoker;
import Invoker.Invoker1;



public class Projektant1 extends Projektant { // Invoker
    
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
      {   SO so = new SO();         
          ss.kon = new Kontroler1(ss.ef,ss.bbp,so); 
          
          Invoker in1 = new Invoker(so.sok,ss.kon.getEkranskaForma().getPanel().getKreiraj());
          Invoker in2 = new Invoker(so.sop,ss.kon.getEkranskaForma().getPanel().getPromeni()); 
          Invoker in3 = new Invoker(so.soo,ss.kon.getEkranskaForma().getPanel().getObrisi()); 
          Invoker in4 = new Invoker(so.son,ss.kon.getEkranskaForma().getPanel().getNadji());
          
          Invoker1 in11 = new Invoker1(so.son,ss.kon.getEkranskaForma().getPanel().getSifraIntervencije1());
      }

    @Override
    public void prikaziEkranskuFormu() 
      { ss.ef.prikaziEkranskuFormu();
      }
}

