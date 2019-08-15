

package AbstractProductA;

import javax.swing.JFrame;


public abstract class EkranskaForma extends JFrame{
    
    public Panel getPanel() {return (Panel)getContentPane();}  
    public void setPanel(Panel pan1) {setContentPane(pan1);
        
    }
    public void prikaziEkranskuFormu(){setVisible(true);}
    abstract public void odrediDekoracijuForme();
}
