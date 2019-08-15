/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.util.AppointmentStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NEDA
 */
public class Appointment extends GeneralDomainObject {

    private int id;
    private Date date;
    private String note;
    private Patient patient;
    private Dentist dentist;
    private List<AppointmentItem> items;
    private double amount;
    private AppointmentStatus appointmentStatus;

    public Appointment() {
        appointmentStatus = AppointmentStatus.SCHEDULED;
    }

    public Appointment(int id, Date date, String time, String note, Patient patient, Dentist dentist, List<AppointmentItem> items) {
        this.id = id;
        this.date = date;
        this.note = note;
        this.patient = patient;
        this.dentist = dentist;
        this.items = items;
    }

    public Date getDate() {
        return date;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<AppointmentItem> getItems() {
        return items;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setItems(List<AppointmentItem> items) {
        this.items = items;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    @Override
    public String getTableName() {
        return "appointment";
    }

    @Override
    public List<GeneralDomainObject> getList(ResultSet resultSet) throws Exception {
        //List<GeneralDomainObject> list = new LinkedList<>();
        List<GeneralDomainObject> list = new ArrayList<>();
        while (resultSet.next()) {
            Appointment a = new Appointment();
            a.setId(resultSet.getInt("id"));
            Date d = resultSet.getTimestamp("date");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                a.setDate(sdf.parse(d.toString()));
            } catch (ParseException ex) {
                Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
            }
            a.setNote(resultSet.getString("note"));
            list.add(a);
        }
        return list;
    }

    @Override
    public String setAtrValue() {
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(date.getTime());
        return "date = " + "'" + sqlDate + "'" + ", "
                + "note = " + (note == null ? null : "'" + note + "'") + ", "
                + "dentist = " + dentist.getId() + ", "
                + "amount = " + amount + ", "
                + "status = " + (note == null ? null : "'" + appointmentStatus + "'");

    }

    @Override
    public String getAtrValue1() {
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(date.getTime());
        return "(" + "'" + sqlDate + "'" + ", "
                + (note == null ? null : "'" + note + "'") + ", "
                + (patient.getJmbg() == null ? null : "'" + patient.getJmbg() + "'") + ", "
                + dentist.getId() + ", "
                + amount + ", "
                + (appointmentStatus == null ? null : "'" + appointmentStatus + "'") + ")";

    }

    @Override
    public String getWhereConditionFind() {
        return "p.name = " + "'" + patient.getName() + "'" + " AND p.surname = " + "'" + patient.getSurname() + "'";
    }

    @Override
    public String getNameByColumn(int column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralDomainObject getNewRecord(ResultSet rs) throws SQLException {
        Appointment a = new Appointment();
        a.setId(rs.getInt("a.id"));
        Date d = rs.getTimestamp("a.date");

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm");
        try {
            a.setDate(sdf.parse(d.toString()));
            System.out.println(sdf.parse(d.toString()));
        } catch (ParseException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.setNote(rs.getString("a.note"));
        Patient p = new Patient(rs.getString("p.jmbg"), rs.getString("p.name"), rs.getString("p.surname"), rs.getDate("p.dateOfBirth"),
                rs.getString("p.email"), rs.getString("p.phone"), new Dentist(rs.getInt("dp.id"), rs.getString("dp.name"), rs.getString("dp.surname"), null, null),
                new City(rs.getString("c.postalCode"), rs.getString("c.name")), rs.getString("p.address"));
        a.setPatient(p);
        a.setDentist(new Dentist(rs.getInt("d.id"), rs.getString("d.name"), rs.getString("d.surname"), null, null));
        return a;
    }

    @Override
    public String getJoinClauseFind() {
        return " a JOIN patient p ON (a.patient = p.jmbg)"
                + "JOIN dentist d ON (a.dentist = d.id)"
                + "JOIN CITY c ON (p.city = c.postalCode)"
                + "JOIN dentist dp ON (p.createdDentist = dp.id)";
    }

    @Override
    public String getWhereConditionUpdate() {
        return "id = " + id;
    }

    @Override
    public List<GeneralDomainObject> getList() {
        List<GeneralDomainObject> list = new LinkedList<>();
        for (AppointmentItem ai : items) {
            list.add((GeneralDomainObject) ai);
        }
        return list;
    }

    @Override
    public void createList(ResultSet rs) throws Exception {
        //List<AppointmentItem> list = new LinkedList<>();
        List<AppointmentItem> list = new ArrayList<>();
        while (rs.next()) {
            AppointmentItem ai = new AppointmentItem();
            ai.setOrderNo(rs.getInt("ai.orderNo"));
            ai.setQuantity(rs.getInt("ai.quantity"));
            ai.setService(new Service(rs.getInt("s.id"), rs.getString("s.name"), rs.getDouble("s.price")));
            list.add(ai);
        }
        items = list;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appointment other = (Appointment) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(GeneralDomainObject gdo) {
        Appointment ap = (Appointment) gdo;
        return this.id == ap.getId();
    }

    @Override
    public String getWhereConditionFindList() {
        return id + "";
    }

    @Override
    public List<GeneralDomainObject> getNewRecords(ResultSet rs) throws SQLException {
        List<GeneralDomainObject> list = new LinkedList<>();
        do {
            Appointment a = new Appointment();
            a.setId(rs.getInt("a.id"));
            Date d = rs.getTimestamp("a.date");
            a.setDate(d);
            a.setNote(rs.getString("a.note"));
            Patient p = new Patient(rs.getString("p.jmbg"), rs.getString("p.name"), rs.getString("p.surname"), rs.getDate("p.dateOfBirth"),
                    rs.getString("p.email"), rs.getString("p.phone"), new Dentist(rs.getInt("dp.id"), rs.getString("dp.name"), rs.getString("dp.surname"), null, null),
                    new City(rs.getString("c.postalCode"), rs.getString("c.name")), rs.getString("p.address"));
            a.setPatient(p);
            a.setDentist(new Dentist(rs.getInt("d.id"), rs.getString("d.name"), rs.getString("d.surname"), null, null));
            a.setAppointmentStatus(AppointmentStatus.valueOf(rs.getString("a.status")));
            list.add(a);
        } while (rs.next());
        return list;
    }

    @Override
    public String getColumnNames() {
        return " (date, note, patient, dentist, amount, status) ";
    }

    @Override
    public String getJoinClauseUpdate() {
        return "";
    }

    @Override
    public String getAtrValue2() {
        return getAtrValue1();
    }

}
