

package AbstractProductA;



import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.GregorianCalendar;


// Promenljivo!!!
public class Panel1 extends Panel{

    /**
     * Creates new form Panel1
     */
    public Panel1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JMBG = new javax.swing.JFormattedTextField();
        SifraStomatologa = new javax.swing.JFormattedTextField();
        Usluga = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SifraIntervencije = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Kreiraj = new javax.swing.JButton();
        Promeni = new javax.swing.JButton();
        Obrisi = new javax.swing.JButton();
        Nadji = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Poruka = new javax.swing.JTextField();
        Datum = new datechooser.beans.DateChooserCombo();
        Memento = new javax.swing.JButton();

        JMBG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        JMBG.setName("JMBG"); // NOI18N
        JMBG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JMBGKeyPressed(evt);
            }
        });

        SifraStomatologa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        SifraStomatologa.setDoubleBuffered(true);
        SifraStomatologa.setName("SifraStomatologa"); // NOI18N
        SifraStomatologa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SifraStomatologaKeyPressed(evt);
            }
        });

        Usluga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pregled", "Popravka", "Vadjenje zuba", "Skidanje kamenca", "Stavljanje proteze", "Beljenje zuba" }));
        Usluga.setEditor(null);
        Usluga.setName("Usluga"); // NOI18N
        Usluga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UslugaKeyPressed(evt);
            }
        });

        jLabel1.setText("JMBG:");

        jLabel2.setText("Sifra stomatologa:");

        jLabel3.setText("Usluga");

        SifraIntervencije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SifraIntervencijeActionPerformed(evt);
            }
        });
        SifraIntervencije.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SifraIntervencijeKeyPressed(evt);
            }
        });

        jLabel4.setText("Sifra intervencije");

        jLabel5.setText("Datum:");

        Kreiraj.setText("Kreiraj");

        Promeni.setText("Promeni");

        Obrisi.setText("Obrisi");

        Nadji.setText("Nadji");
        Nadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NadjiActionPerformed(evt);
            }
        });

        jLabel6.setText("Poruka:");

        Poruka.setForeground(new java.awt.Color(255, 0, 0));
        Poruka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PorukaActionPerformed(evt);
            }
        });

        Datum.setFormat(2);

        Memento.setText("Memento");
        Memento.setName("Memento"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SifraStomatologa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SifraIntervencije, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Nadji))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Memento))))
                            .addComponent(Datum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Usluga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JMBG, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Kreiraj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Promeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Obrisi))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Poruka, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SifraIntervencije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Nadji))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SifraStomatologa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Memento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Usluga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kreiraj)
                    .addComponent(Promeni)
                    .addComponent(Obrisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Poruka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JMBGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JMBGKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                SifraStomatologa.requestFocusInWindow();
          } 
    }//GEN-LAST:event_JMBGKeyPressed

    private void SifraStomatologaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SifraStomatologaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                Usluga.requestFocusInWindow();
       } // TODO add your handling code here:
    }//GEN-LAST:event_SifraStomatologaKeyPressed

    private void UslugaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UslugaKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                SifraIntervencije.requestFocus();
          } // TODO add your handling code here:
    }//GEN-LAST:event_UslugaKeyPressed

    private void NadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NadjiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NadjiActionPerformed

    private void PorukaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PorukaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PorukaActionPerformed

    private void SifraIntervencijeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SifraIntervencijeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                JMBG.requestFocusInWindow();
          }
    }//GEN-LAST:event_SifraIntervencijeKeyPressed

    private void SifraIntervencijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SifraIntervencijeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SifraIntervencijeActionPerformed

          
    @Override   
    public void setSifraIntervencije(String SifraIntervencije1) {SifraIntervencije.setText(SifraIntervencije1);}
    @Override   
    public void setSifraStomatologa(String SifraStomatologa1){SifraStomatologa.setText(SifraStomatologa1);}
    @Override   
    public void setJMBG(String JMBG1){JMBG.setText(JMBG1);}
    @Override   
    public void setUsluga(String Usluga1){Usluga.setSelectedItem(Usluga);}

    /**
     *
     * @param Datum1
     */
    @Override   
    public void setDatum(Date Datum1) 
    {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(Datum1);
        Datum.setSelectedDate(gc);
    } 
    @Override   
    public void setPoruka(String Poruka1) {Poruka.setText(Poruka1);} 
    

    @Override
    public String getSifraIntervencije() {return SifraIntervencije.getText();}
    @Override
    public String getSifraStomatologa (){return SifraStomatologa.getText();}
    @Override
    public String getJMBG (){return JMBG.getText();}
    @Override
    public String getUsluga (){return Usluga.getSelectedItem().toString();}
    @Override
    public Date getDatum() {return Datum.getSelectedDate().getTime();}
    
     @Override
    public javax.swing.JButton getKreiraj(){return Kreiraj;}
     @Override
    public javax.swing.JButton getPromeni(){return Promeni;}
     @Override
    public javax.swing.JButton getObrisi(){return Obrisi;}
     @Override
    public javax.swing.JButton getNadji(){return Nadji;}
    @Override
    public javax.swing.JButton getMemento(){return Memento;}
     @Override
    public javax.swing.JTextField getSifraIntervencije1(){return SifraIntervencije;}
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo Datum;
    private javax.swing.JFormattedTextField JMBG;
    private javax.swing.JButton Kreiraj;
    private javax.swing.JButton Memento;
    private javax.swing.JButton Nadji;
    private javax.swing.JButton Obrisi;
    private javax.swing.JTextField Poruka;
    private javax.swing.JButton Promeni;
    private javax.swing.JTextField SifraIntervencije;
    private javax.swing.JFormattedTextField SifraStomatologa;
    private javax.swing.JComboBox<String> Usluga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
