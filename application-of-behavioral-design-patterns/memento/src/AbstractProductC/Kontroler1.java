package AbstractProductC;

import AbstractProductA.*;
import AbstractProductB.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKIntervencija;  
import Originator.Originator;

public final class Kontroler1 extends Kontroler {

    public Kontroler1(EkranskaForma ef1, BrokerBazePodataka bbp1) {
        ef = ef1;
        bbp = bbp1;
        Povezi();
    }

    void Povezi() {
        javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
        javax.swing.JButton Promeni = ef.getPanel().getPromeni();
        javax.swing.JButton Obrisi = ef.getPanel().getObrisi();
        javax.swing.JButton Nadji = ef.getPanel().getNadji();
        javax.swing.JButton Memento = ef.getPanel().getMemento();
        Kreiraj.addActionListener(new OsluskivacKreiraj(this));
        Promeni.addActionListener(new OsluskivacPromeni(this));
        Obrisi.addActionListener(new OsluskivacObrisi(this));
        Nadji.addActionListener(new OsluskivacNadji(this));
        Memento.addActionListener((e) -> {
            undoMemento();
        });

        javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraIntervencije1();
        SifraPrijave.addFocusListener(new OsluskivacNadji1(this));
    }

    void napuniDomenskiObjekatIzGrafickogObjekta() {
        in = new DKIntervencija();
        in.setSifraIntervencije(getInteger(ef.getPanel().getSifraIntervencije()));
        in.setJMBG(ef.getPanel().getJMBG());
        in.setSifraStomatologa(getInteger(ef.getPanel().getSifraStomatologa()));
        in.setUsluga(ef.getPanel().getUsluga());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatum()));
        in.setDatum(Datum);

    }

    void napuniGrafickiObjekatIzDomenskogObjekta(DKIntervencija in) {
        ef.getPanel().setSifraIntervencije(Integer.toString(in.getSifraIntervencije()));
        ef.getPanel().setJMBG(in.getJMBG());
        ef.getPanel().setSifraStomatologa(Integer.toString(in.getSifraStomatologa()));
        ef.getPanel().setUsluga(in.getUsluga());
        ef.getPanel().setDatum(in.getDatum());

    }

    void isprazniGrafickiObjekat() {

        ef.getPanel().setSifraIntervencije("");
        ef.getPanel().setJMBG("");
        ef.getPanel().setSifraStomatologa("0");
        ef.getPanel().setUsluga("Pregled");
        ef.getPanel().setDatum(new java.util.Date());
    }

    void prikaziPoruku() {
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

    boolean zapamtiDomenskiObjekat() {

        bbp.makeConnection();
        boolean signal = bbp.insertRecord(in);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Sistem je zapamtio novu intervenciju."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            poruka = "Sistem ne moze da zapamti novu intervenciju."; // Promenljivo!!!  
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;

    }

    boolean kreirajDomenskiObjekat() {
        boolean signal;
        in = new DKIntervencija();
        AtomicInteger counter = new AtomicInteger(0);

        bbp.makeConnection();
        if (!bbp.getCounter(in, counter)) {
            return false;
        }
        if (!bbp.increaseCounter(in, counter)) {
            return false;
        }

        in.setSifraIntervencije(counter.get());
        signal = bbp.insertRecord(in);
        if (signal == true) {
            bbp.commitTransation();
            napuniGrafickiObjekatIzDomenskogObjekta(in);
            poruka = "Sistem je kreirao novu intervenciju.";
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Sistem ne moze da kreira novu intervenciju.";
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean obrisiDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.deleteRecord(in);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Sistem je obrisao intervenciju.";
            isprazniGrafickiObjekat();
        } else {
            bbp.rollbackTransation();
            poruka = "Sistem ne moze da obrise intervenciju.";
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    void undoMemento() {
        in = memento;
        this.napuniGrafickiObjekatIzDomenskogObjekta(in);
        this.promeniDomenskiObjekat();
    }

    boolean promeniDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.updateRecord(in);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Sistem je promenio intervenciju."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Sistem ne moze da promeni intervenciju."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean nadjiDomenskiObjekat() {
        boolean signal;
        bbp.makeConnection();
        in = (DKIntervencija) bbp.findRecord(in); // Promenljivo!!!
        if (in != null) {
            napuniGrafickiObjekatIzDomenskogObjekta(in);
            poruka = "Sistem je nasao intervenciju."; // Promenljivo!!!
            signal = true;
        } else {
            isprazniGrafickiObjekat();
            poruka = "Sistem ne moze da nadje intervenciju."; // Promenljivo!!!
            signal = false;
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}

class OsluskivacZapamti implements ActionListener {

    Kontroler1 kon;

    OsluskivacZapamti(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.zapamtiDomenskiObjekat();

    }
}

class OsluskivacKreiraj implements ActionListener {

    Kontroler1 kon;

    OsluskivacKreiraj(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.kreirajDomenskiObjekat();

    }
}

class OsluskivacObrisi implements ActionListener {

    Kontroler1 kon;

    OsluskivacObrisi(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.obrisiDomenskiObjekat();

    }
}

class OsluskivacPromeni implements ActionListener {

    Kontroler1 kon;

    OsluskivacPromeni(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Originator or = new Originator();
        or.setMemento(kon.in);
        kon.memento = or.createMemento();

        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.promeniDomenskiObjekat();

    }
}

class OsluskivacNadji implements ActionListener {

    Kontroler1 kon;

    OsluskivacNadji(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }
}

class OsluskivacNadji1 implements FocusListener {

    Kontroler1 kon;

    OsluskivacNadji1(Kontroler1 kon1) {
        kon = kon1;
    }

    public void focusLost(java.awt.event.FocusEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }

    @Override
    public void focusGained(FocusEvent e) {

    }
}
