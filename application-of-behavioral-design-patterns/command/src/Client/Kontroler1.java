
package Client;

import AbstractProductA.*;
import AbstractProductB.*;
import ConcreteCommand.SO;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKIntervencija; 
import DomainClasses.GeneralDObject;
import ConcreteCommand.SOKreiraj;
import ConcreteCommand.SONadji;
import ConcreteCommand.SOObrisi;
import ConcreteCommand.SOPromeni;
import DomainClasses.DKIntervencija;

import Receiver.KreirajDomenskiObjekat;
import Receiver.NadjiDomenskiObjekat;
import Receiver.ObrisiDomenskiObjekat;
import Receiver.PromeniDomenskiObjekat;

public final class Kontroler1 extends Kontroler { // Client

    public Kontroler1(EkranskaForma ef1, BrokerBazePodataka bbp1, SO so) {
        ef = ef1;
        bbp = bbp1;
        Povezi(so);
    }

    void Povezi(SO so) {

        KreirajDomenskiObjekat kdo = new KreirajDomenskiObjekat(this);
        so.sok = new SOKreiraj(kdo); // povezivanje ConcreteCommand i Receiver

        PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(this);
        so.sop = new SOPromeni(pdo);

        ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(this);
        so.soo = new SOObrisi(odo);

        NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(this);
        so.son = new SONadji(ndo);

    }

// Promenljivo!!!  
    @Override
    public void napuniDomenskiObjekatIzGrafickogObjekta() {
        in = new DKIntervencija();
        in.setSifraIntervencije(getInteger(ef.getPanel().getSifraIntervencije()));
        in.setJMBG(ef.getPanel().getJMBG());
        in.setSifraStomatologa(getInteger(ef.getPanel().getSifraStomatologa()));
        in.setUsluga(ef.getPanel().getUsluga());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatum()));
        in.setDatum(Datum);

    }


    @Override
    public void napuniGrafickiObjekatIzDomenskogObjekta(GeneralDObject gdo) {
        DKIntervencija in = (DKIntervencija) gdo;
        ef.getPanel().setSifraIntervencije(Integer.toString(in.getSifraIntervencije()));
        ef.getPanel().setJMBG(in.getJMBG());
        ef.getPanel().setSifraStomatologa(Integer.toString(in.getSifraStomatologa()));
        ef.getPanel().setUsluga(in.getUsluga());
        ef.getPanel().setDatum(in.getDatum());

    }


    @Override
    public void isprazniGrafickiObjekat() {

        ef.getPanel().setSifraIntervencije("");
        ef.getPanel().setJMBG("");
        ef.getPanel().setSifraStomatologa("0");
        ef.getPanel().setUsluga("Pregled");
        ef.getPanel().setDatum(new java.util.Date());
    }

    @Override
    public void prikaziPoruku() {
        ef.getPanel().setPoruka(poruka);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ef.getPanel().setPoruka("");
            }
        }, 3000);

    }

    public int getInteger(String s) {
        int broj = 0;
        try {
            if (s != null) {
                broj = Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            broj = 0;
        }

        return broj;
    }

}
