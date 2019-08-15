
package Receiver;


import Client.Kontroler;
import DomainClasses.DKIntervencija;
import java.util.concurrent.atomic.AtomicInteger;

 public class KreirajDomenskiObjekat { // Receiver
    
   Kontroler kon;
     
    public KreirajDomenskiObjekat(Kontroler kon1){kon=kon1;} 
     
    public boolean kreirajDomenskiObjekat(){
    boolean signal;
    DKIntervencija in= new DKIntervencija(); 
    AtomicInteger counter = new AtomicInteger(0);
    
    kon.getBrokerBazePodataka().makeConnection();
    if (!kon.getBrokerBazePodataka().getCounter(in,counter)) return false;
    if (!kon.getBrokerBazePodataka().increaseCounter(in,counter)) return false;
          
    in.setSifraIntervencije(counter.get()); 
    signal = kon.getBrokerBazePodataka().insertRecord(in);
    if (signal==true) 
        { kon.getBrokerBazePodataka().commitTransation();
          kon.napuniGrafickiObjekatIzDomenskogObjekta(in);
          kon.setPoruka("Sistem je kreirao novu intervenciju."); 
        }
        else
        { kon.getBrokerBazePodataka().rollbackTransation();
         kon.isprazniGrafickiObjekat();
         kon.setPoruka("Sistem ne moze da kreira novu intervenciju."); 
        }
    kon.prikaziPoruku();
    kon.getBrokerBazePodataka().closeConnection();
    return signal;
}
    
}
