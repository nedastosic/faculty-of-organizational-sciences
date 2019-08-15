/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import controler.Controler;
import domain.Dentist;
import form.appointment.FrmAppointment;
import form.patient.FrmPatient;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import session.Session;
import usecase.UseCase;

/**
 *
 * @author NEDA
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
        populateForm();
    }

    private void populateForm() {
        populateCurrentDentist();
        setScreenCenter();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCurrentDentist = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuPatient = new javax.swing.JMenu();
        jmNewPatient = new javax.swing.JMenuItem();
        jmSearchPatients = new javax.swing.JMenuItem();
        menuAppointment = new javax.swing.JMenu();
        jmNewAppointment = new javax.swing.JMenuItem();
        jmSearchAppointments = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dental clinic");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dentist"));

        lblCurrentDentist.setText("jLabel1");

        btnLogOut.setText("Log out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurrentDentist, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentDentist)
                    .addComponent(btnLogOut))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        menuPatient.setText("Patient");

        jmNewPatient.setText("New");
        jmNewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNewPatientActionPerformed(evt);
            }
        });
        menuPatient.add(jmNewPatient);

        jmSearchPatients.setText("Search");
        jmSearchPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSearchPatientsActionPerformed(evt);
            }
        });
        menuPatient.add(jmSearchPatients);

        jMenuBar1.add(menuPatient);

        menuAppointment.setText("Appointment");

        jmNewAppointment.setText("New");
        jmNewAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNewAppointmentActionPerformed(evt);
            }
        });
        menuAppointment.add(jmNewAppointment);

        jmSearchAppointments.setText("Search");
        jmSearchAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSearchAppointmentsActionPerformed(evt);
            }
        });
        menuAppointment.add(jmSearchAppointments);

        jMenuBar1.add(menuAppointment);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            Dentist d = Session.getInstance().getCurrentDentist();
            try {
                Controler.getInstance().logOut(d);
                JOptionPane.showMessageDialog(null, "You are logged out!");
                System.exit(0);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void jmNewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNewPatientActionPerformed
        Session.getInstance().setCurrentUseCase(UseCase.UC_NEW_PATIENT);
        JDialog frmNewPatient = new FrmPatient(null, true);
        frmNewPatient.setVisible(true);        
    }//GEN-LAST:event_jmNewPatientActionPerformed

    private void jmSearchPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSearchPatientsActionPerformed
        Session.getInstance().setCurrentUseCase(UseCase.UC_SEARCH_PATIENTS);
        JDialog frmSearchPatients = new FrmSearch(this, true);
        frmSearchPatients.setVisible(true);
    }//GEN-LAST:event_jmSearchPatientsActionPerformed

    private void jmNewAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNewAppointmentActionPerformed
        Session.getInstance().setCurrentUseCase(UseCase.UC_NEW_APPOINTMENT);
        JDialog frmNewAppointment = new FrmAppointment(this, true);
        frmNewAppointment.setVisible(true);      
    }//GEN-LAST:event_jmNewAppointmentActionPerformed

    private void jmSearchAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSearchAppointmentsActionPerformed
        Session.getInstance().setCurrentUseCase(UseCase.UC_SEARCH_APPOINTMENT);
        new FrmSearch(this, true).setVisible(true);
    }//GEN-LAST:event_jmSearchAppointmentsActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jmNewAppointment;
    private javax.swing.JMenuItem jmNewPatient;
    private javax.swing.JMenuItem jmSearchAppointments;
    private javax.swing.JMenuItem jmSearchPatients;
    private javax.swing.JLabel lblCurrentDentist;
    private javax.swing.JMenu menuAppointment;
    private javax.swing.JMenu menuPatient;
    // End of variables declaration//GEN-END:variables

    private void populateCurrentDentist() {
        Dentist current = Session.getInstance().getCurrentDentist();
        lblCurrentDentist.setText(current.getName() + " " + current.getSurname());
    }

    private void setScreenCenter() {
        setLocationRelativeTo(null);
    }
    
    public void ok(){
        JOptionPane.showMessageDialog(null, "ok");
    }
}