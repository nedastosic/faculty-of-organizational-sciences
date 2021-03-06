/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.patient;

import controler.Controler;
import domain.City;
import domain.Dentist;
import domain.Patient;
import java.awt.Color;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import session.Session;
import usecase.UseCase;

/**
 *
 * @author NEDA
 */
public class FrmPatient extends javax.swing.JDialog {
    java.awt.Dialog parent;
    /**
     * Creates new form FrmPatientt
     */
    public FrmPatient(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        populateForm();
        adjustForm();
        this.parent = parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCurrent = new javax.swing.JPanel();
        lblCurrentDentist = new javax.swing.JLabel();
        txtDateOfBirth = new javax.swing.JPanel();
        lblJMBG = new javax.swing.JLabel();
        txtJMBG = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        lblDateOfBirth = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblCity = new javax.swing.JLabel();
        cbCity = new javax.swing.JComboBox();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        lblDentist = new javax.swing.JLabel();
        txtDentist = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnAddPatient = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlCurrent.setBorder(javax.swing.BorderFactory.createTitledBorder("Dentist"));

        lblCurrentDentist.setText("jLabel1");

        javax.swing.GroupLayout pnlCurrentLayout = new javax.swing.GroupLayout(pnlCurrent);
        pnlCurrent.setLayout(pnlCurrentLayout);
        pnlCurrentLayout.setHorizontalGroup(
            pnlCurrentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurrentDentist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCurrentLayout.setVerticalGroup(
            pnlCurrentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentLayout.createSequentialGroup()
                .addComponent(lblCurrentDentist)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        txtDateOfBirth.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient"));

        lblJMBG.setText("JMBG:");

        txtJMBG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJMBGKeyTyped(evt);
            }
        });

        lblName.setText("Name:");

        lblSurname.setText("Surname:");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        txtSurname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSurnameKeyTyped(evt);
            }
        });

        lblDateOfBirth.setText("Date of birth:");

        lblEmail.setText("Email:");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        lblPhone.setText("Phone:");

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });

        lblCity.setText("City:");

        cbCity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblAddress.setText("Address:");

        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressKeyTyped(evt);
            }
        });

        lblDentist.setText("Dentist:");

        javax.swing.GroupLayout txtDateOfBirthLayout = new javax.swing.GroupLayout(txtDateOfBirth);
        txtDateOfBirth.setLayout(txtDateOfBirthLayout);
        txtDateOfBirthLayout.setHorizontalGroup(
            txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtDateOfBirthLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblDentist, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addComponent(lblSurname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDateOfBirth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtJMBG)
                    .addComponent(cbCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAddress)
                    .addComponent(txtName)
                    .addComponent(txtSurname)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(txtEmail)
                    .addComponent(txtPhone)
                    .addComponent(txtDentist))
                .addContainerGap())
        );
        txtDateOfBirthLayout.setVerticalGroup(
            txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtDateOfBirthLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJMBG)
                    .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSurname)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCity)
                    .addComponent(cbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txtDateOfBirthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDentist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDentist))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAddPatient.setText("Add");
        btnAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddPatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pnlCurrent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
        if (!required()) {
            JOptionPane.showMessageDialog(null, "Please enter all required fields!");
        } else {
            if (validation()) {
                Patient patient = createPatientFromInput();
                try {
                    Controler.getInstance().savePatient(patient);
                    int response = JOptionPane.showConfirmDialog(null, "Patient successfuly added! Do you want to add other patient?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        resetFields();
                    } else {
                        this.dispose();
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmPatient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(FrmPatient.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnAddPatientActionPerformed

    private Patient createPatientFromInput() {
        String jmbg = txtJMBG.getText().trim();
        String name = txtName.getText().trim();
        String surname = txtSurname.getText().trim();
        Date dateOfBirth = dateChooser.getDate();
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();
        Dentist createdDentist = Session.getInstance().getCurrentDentist();
        City city = (City) cbCity.getSelectedItem();
        String address = txtAddress.getText().trim();
        Patient patient = new Patient(jmbg, name, surname, dateOfBirth, email, phone, createdDentist, city, address);
        return patient;
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Session.getInstance().setCurrentUseCase(UseCase.UC_EDIT_PATIENT);
        adjustForm();
        Session.getInstance().setCurrentUseCase(UseCase.UC_VIEW_PATIENT);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (!required()) {
            JOptionPane.showMessageDialog(null, "Please enter all required fields!");
        } else {
            try {
                Patient patient = createPatientFromInput();
                Controler.getInstance().updatePatient(patient);
                JOptionPane.showMessageDialog(null, "Patient successfuly updated!");
                this.dispose();
                parent.dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmPatient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(FrmPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyTyped
        txtAddress.setBackground(Color.white);
    }//GEN-LAST:event_txtAddressKeyTyped

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        txtPhone.setBackground(Color.white);
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        txtEmail.setBackground(Color.white);
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtSurnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurnameKeyTyped
        txtSurname.setBackground(Color.white);
    }//GEN-LAST:event_txtSurnameKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        txtName.setBackground(Color.white);
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtJMBGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJMBGKeyTyped
        txtJMBG.setBackground(Color.white);
    }//GEN-LAST:event_txtJMBGKeyTyped

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int response = JOptionPane.showConfirmDialog(null, "Do you want to delete patient?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                return;
            }
            Patient patient = createPatientFromInput();
            Controler.getInstance().deletePatient(patient);
            JOptionPane.showMessageDialog(null, "Patient successfuly deleted!");
            this.dispose();
            parent.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(FrmPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbCity;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCurrentDentist;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblDentist;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblJMBG;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JPanel pnlCurrent;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JPanel txtDateOfBirth;
    private javax.swing.JTextField txtDentist;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtJMBG;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables

    private void populateCurrentDentist() {
        Dentist current = Session.getInstance().getCurrentDentist();
        lblCurrentDentist.setText(current.getName() + " " + current.getSurname());
    }

    private void setScreenCenter() {
        setLocationRelativeTo(null);
    }

    private void populateForm() {
        populateCurrentDentist();
        setScreenCenter();
        populateCbCity();
    }

    private void populateCbCity() {
        try {
            cbCity.removeAllItems();
            List<City> list = Controler.getInstance().getAllCities();
            for (City city : list) {
                cbCity.addItem(city);
            }
        } catch (IOException ex) {
            Logger.getLogger(FrmPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean required() {
        boolean ok = true;
        if (txtName.getText().isEmpty()) {
            txtName.setBackground(Color.red);
            ok = false;
        }
        if (txtSurname.getText().isEmpty()) {
            txtSurname.setBackground(Color.red);
            ok = false;
        }
        if (dateChooser.getDate() == null || dateChooser.getDate().toString().isEmpty()) {
            dateChooser.setBackground(Color.red);
            ok = false;
        }
        if (txtPhone.getText().isEmpty()) {
            txtPhone.setBackground(Color.red);
            ok = false;
        }
        if (txtAddress.getText().isEmpty()) {
            txtAddress.setBackground(Color.red);
            ok = false;
        }
        if (txtJMBG.getText().isEmpty()) {
            txtJMBG.setBackground(Color.red);
            ok = false;
        }
        return ok;
    }

    private void adjustForm() {
        switch (Session.getInstance().getCurrentUseCase()) {
            case UseCase.UC_NEW_PATIENT:
                setTitle("New patient");
                btnCancel.setVisible(true);
                btnAddPatient.setVisible(true);
                btnEdit.setVisible(false);
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);

                lblDentist.setVisible(false);

                cbCity.setEnabled(true);

                txtJMBG.setEnabled(true);
                txtAddress.setEnabled(true);
                txtDateOfBirth.setEnabled(true);
                txtPhone.setEnabled(true);
                txtName.setEnabled(true);
                txtSurname.setEnabled(true);
                txtEmail.setEnabled(true);
                txtDentist.setVisible(false);
                break;
            case UseCase.UC_VIEW_PATIENT:
                setTitle("View patient");
                btnCancel.setVisible(true);
                btnAddPatient.setVisible(false);
                btnEdit.setVisible(true);
                btnUpdate.setVisible(false);
                btnDelete.setVisible(true);

                lblDentist.setVisible(true);

                cbCity.setEnabled(false);

                txtJMBG.setEnabled(false);
                txtAddress.setEnabled(false);
                dateChooser.setEnabled(false);
                txtPhone.setEnabled(false);
                txtName.setEnabled(false);
                txtSurname.setEnabled(false);
                txtEmail.setEnabled(false);
                txtDentist.setVisible(true);
                txtDentist.setEnabled(false);
                setPatient();
                break;
            case UseCase.UC_SEARCH_PATIENTS:
                setTitle("Search patient");
                btnCancel.setVisible(true);
                btnAddPatient.setVisible(false);
                btnEdit.setVisible(true);
                btnUpdate.setVisible(false);
                btnDelete.setVisible(true);

                lblDentist.setVisible(true);

                cbCity.setEnabled(false);

                txtJMBG.setEnabled(false);
                txtAddress.setEnabled(false);
                dateChooser.setEnabled(false);
                txtPhone.setEnabled(false);
                txtName.setEnabled(false);
                txtSurname.setEnabled(false);
                txtEmail.setEnabled(false);
                txtDentist.setVisible(true);
                txtDentist.setEnabled(false);
                setPatient();
                break;

            case UseCase.UC_NEW_APPOINTMENT:
                setTitle("Search patient");
                btnCancel.setVisible(true);
                btnAddPatient.setVisible(false);
                btnEdit.setVisible(false);
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);

                lblDentist.setVisible(true);

                cbCity.setEnabled(false);

                txtJMBG.setEnabled(false);
                txtAddress.setEnabled(false);
                dateChooser.setEnabled(false);
                txtPhone.setEnabled(false);
                txtName.setEnabled(false);
                txtSurname.setEnabled(false);
                txtEmail.setEnabled(false);
                txtDentist.setVisible(true);
                txtDentist.setEnabled(false);
                setPatient();
                break;
            case UseCase.UC_EDIT_PATIENT:
                setTitle("Edit patient");
                btnCancel.setVisible(true);
                btnAddPatient.setVisible(false);
                btnEdit.setVisible(false);
                btnUpdate.setVisible(true);
                btnDelete.setVisible(false);

                lblDentist.setVisible(true);

                cbCity.setEnabled(true);

                txtJMBG.setEnabled(false);
                txtAddress.setEnabled(true);
                dateChooser.setEnabled(true);
                txtPhone.setEnabled(true);
                txtName.setEnabled(true);
                txtSurname.setEnabled(true);
                txtEmail.setEnabled(true);
                txtDentist.setVisible(true);
                txtDentist.setEnabled(false);
                setPatient();
                break;
        }

    }

    private void setPatient() {
        Patient patient = (Patient) Session.getInstance().getUseCaseParams();
        txtJMBG.setText(patient.getJmbg());
        txtName.setText(patient.getName());
        txtSurname.setText(patient.getSurname());
        txtEmail.setText(patient.getEmail());
        dateChooser.setDate(patient.getDateOfBirth());
        txtAddress.setText(patient.getAddress());
        txtPhone.setText(patient.getPhone());
        txtDentist.setText(patient.getCreatedDentist().getName() + " " + patient.getCreatedDentist().getSurname());
    }

    private void resetFields() {
        txtJMBG.setText("");
        txtName.setText("");
        txtSurname.setText("");
        txtEmail.setText("");
        dateChooser.setDate(null);
        txtAddress.setText("");
        txtPhone.setText("");
        cbCity.setSelectedIndex(0);
    }

    private boolean validation() {
        StringBuilder sb = new StringBuilder();
        boolean ok = true;
        sb.append("Please enter valid ");
        if (txtJMBG.getText().length() != 13) {
            ok = false;
            sb.append("jmbg");
        }
        if (!isValidEmailAddress(txtEmail.getText().trim())) {
            if (ok == true) {
                sb.append("email");
            } else {
                sb.append(", email");
            }
            ok = false;
        }
        if (dateChooser.getDate().after(new Date())) {
            if (ok == true) {
                sb.append("date of birth!");
            } else {
                sb.append(" and date of birth!");
            }
            ok = false;
        }
        if (!ok) {
            JOptionPane.showMessageDialog(null, sb.toString());
        }
        return ok;
    }

    public static boolean isValidEmailAddress(String email) {
        if (email.startsWith("@") || email.endsWith("@") || !email.contains("@")) {
            return false;
        }
        return true;
    }
}
