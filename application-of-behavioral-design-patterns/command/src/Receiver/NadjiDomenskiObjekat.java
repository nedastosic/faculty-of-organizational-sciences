
package Receiver;


import Client.Kontroler;
import DomainClasses.DKIntervencija;

 public class NadjiDomenskiObjekat { // Receiver
    
   Kontroler kon;
    
    
    public NadjiDomenskiObjekat(Kontroler kon1){kon=kon1;} 
     
    public boolean nadjiDomenskiObjekat(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    boolean signal;
    kon.getBrokerBazePodataka().makeConnection();
    DKIntervencija in = (DKIntervencija)kon.getBrokerBazePodataka().findRecord(kon.getDomenskiObjekat()); // Promenljivo!!!
    if (in != null) 
        { kon.napuniGrafickiObjekatIzDomenskogObjekta(in);
          kon.setPoruka("Sistem je nasao intervenciju."); 
          signal = true;
        }
        else
        { kon.isprazniGrafickiObjekat();
          kon.setPoruka("Sistem ne moze da nadje intervenciju."); 
          signal = false;
        }
    kon.prikaziPoruku();
    kon.getBrokerBazePodataka().closeConnection();
    return signal;  
}
    
}
