/* Panel.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */


package AbstractProductA;



import Observer.*;
import java.awt.event.KeyEvent;
import java.util.Date;

// Promenljivo!!!
public abstract class Panel extends javax.swing.JPanel{
       
      public abstract String getSifraIntervencije(); 
       public abstract javax.swing.JTextField getSifraIntervencije1(); 
       public abstract String getSifraStomatologa(); 
       public abstract String getJMBG(); 
       public abstract String getUsluga(); 
       public abstract Date getDatum(); 
       
       public abstract void setSifraIntervencije(String SifraIntervencije); 
       public abstract void setSifraStomatologa(String SifraStomatologa); 
       public abstract void setJMBG(String JMBG); 
       public abstract void setUsluga(String Usluga); 
       public abstract void setDatum(Date Datum); 
       
       public abstract void setPoruka(String Poruka);
       
       public abstract javax.swing.JButton getKreiraj(); 
       public abstract javax.swing.JButton getPromeni(); 
       public abstract javax.swing.JButton getObrisi(); 
       public abstract javax.swing.JButton getNadji();
       
       
}
