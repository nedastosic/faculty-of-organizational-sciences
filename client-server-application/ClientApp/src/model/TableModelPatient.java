/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.Patient;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NEDA
 */
public class TableModelPatient extends AbstractTableModel{
    List<Patient> patients = new LinkedList<>();
    String[] header = new String[]{"JMBG", "Name", "Surname"};

    public TableModelPatient(List<Patient> patients) {
        this.patients = patients;
    }   
    
    @Override
    public int getRowCount() {
        if (patients == null) {
            return 0;
        }
        return patients.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Patient patient = patients.get(rowIndex);
        switch(columnIndex){
            case 0:
                return patient.getJmbg();
            case 1:
                return patient.getName();
            case 2:
                return patient.getSurname();
            default:
                return "N/A";
        }        
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    public void refresh(List<Patient> patients){
        this.patients = patients;
        fireTableDataChanged();
    }
    
    public void refresh(){
        fireTableDataChanged();
    }
    
    public Patient getPatient(int rowIndex){
        return patients.get(rowIndex);
    }

    public List<Patient> getPatients() {
        return patients;
    }
    
    
}
