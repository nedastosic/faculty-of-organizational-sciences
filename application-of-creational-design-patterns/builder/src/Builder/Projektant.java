

package Builder;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;


public abstract class Projektant {
      class SoftverskiSistem // Complex Product
           {  EkranskaForma ef; // AbstractProductA 
              BrokerBazePodataka bbp; // AbstractProductB 
              Kontroler kon; // AbstractProductC 
           }
      
       SoftverskiSistem ss;
               
       abstract public void kreirajEkranskuFormu();   
       abstract public void kreirajBrokerBazePodataka ();
       abstract public void kreirajKontroler ();
       abstract public void kreirajSoftverskiSistem();
       abstract public void prikaziEkranskuFormu();
}
