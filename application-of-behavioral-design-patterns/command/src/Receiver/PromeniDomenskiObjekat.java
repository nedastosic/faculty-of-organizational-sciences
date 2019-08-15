
 package Receiver;

 import Client.Kontroler;

 public class PromeniDomenskiObjekat { // Receiver
    
    Kontroler kon;
    
    
    public PromeniDomenskiObjekat(Kontroler kon1){kon=kon1;} 
     
    public boolean promeniDomenskiObjekat(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    kon.getBrokerBazePodataka().makeConnection();
    boolean signal = kon.getBrokerBazePodataka().updateRecord(kon.getDomenskiObjekat());
    if (signal==true) 
        { kon.getBrokerBazePodataka().commitTransation();
          kon.setPoruka("Sistem je promenio intervenciju."); 
        }
        else
        { kon.getBrokerBazePodataka().rollbackTransation();
          kon.isprazniGrafickiObjekat();
          kon.setPoruka("Sistem ne moze da promeni intervenciju."); 
        }
    kon.prikaziPoruku();
    kon.getBrokerBazePodataka().closeConnection();
    return signal;   
}
    
}
