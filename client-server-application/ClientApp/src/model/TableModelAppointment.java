/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.Appointment;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NEDA
 */
public class TableModelAppointment extends AbstractTableModel{
    List<Appointment> list;
    String[] header = new String[]{"ID", "Date", "Patient"};

    public TableModelAppointment(List<Appointment> items) {
        this.list = items;
    }       
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
       
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Appointment appointment = list.get(rowIndex);
        switch(columnIndex){
            case 0 : return appointment.getId();
            case 1 : SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
                return sdf.format(appointment.getDate());            
            case 2 : return appointment.getPatient().getName() + " " + appointment.getPatient().getSurname();
            default : return "N/A";
        }
    }
    
    public void refresh(List<Appointment> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    public Appointment getAppointment(int rowIndex){
        return list.get(rowIndex);
    }
}
