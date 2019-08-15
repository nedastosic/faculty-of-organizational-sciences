/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NEDA
 */
public class Patient extends GeneralDomainObject {

    private String jmbg;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String email;
    private String phone;
    private Dentist createdDentist;
    private City city;
    private String address;

    public Patient() {
    }

    public Patient(String jmbg, String name, String surname, Date dateOfBirth, String email, String phone, Dentist createdDentist, City city, String address) {
        this.jmbg = jmbg;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
        this.createdDentist = createdDentist;
        this.city = city;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public City getCity() {
        return city;
    }

    public Dentist getCreatedDentist() {
        return createdDentist;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setCreatedDentist(Dentist createdDentist) {
        this.createdDentist = createdDentist;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getTableName() {
        return "patient";
    }

    @Override
    public List<GeneralDomainObject> getList(ResultSet resultSet) throws Exception {
        List<GeneralDomainObject> list = new LinkedList<>();
        while (resultSet.next()) {
            String jmbg = resultSet.getString("jmbg");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            Date dateOfBirth = resultSet.getDate("dateOfBirth");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");
            Patient patient = new Patient(jmbg, name, surname, dateOfBirth, email, phone, null, null, address);
            list.add(patient);
        }
        sortList(list);
        return list;
    }

    @Override
    public String setAtrValue() {
        java.sql.Date sqlDate = new java.sql.Date(dateOfBirth.getTime());
        return "name = " + (name == null ? null : "'" + name + "'") + ", "
                + "surname = " + (surname == null ? null : "'" + surname + "'") + ", "
                + "dateOfBirth = " + "'" + sqlDate + "'" + ", "
                + "email = " + (email == null ? null : "'" + email + "'") + ", "
                + "phone = " + (phone == null ? null : "'" + phone + "'") + ", "
                + "createdDentist = " + createdDentist.getId() + ", "
                + "city = " + (city.getPostalCode() == null ? null : "'" + city.getPostalCode() + "'") + ", "
                + "address = " + (address == null ? null : "'" + address + "'");
    }

    @Override
    public String getAtrValue1() {
        java.sql.Date sqlDate = new java.sql.Date(dateOfBirth.getTime());
        return (jmbg == null ? null : "'" + jmbg + "'") + ", "
                + (name == null ? null : "'" + name + "'") + ", "
                + (surname == null ? null : "'" + surname + "'") + ", "
                + "'" + sqlDate + "'" + ", "
                + (email == null ? null : "'" + email + "'") + ", "
                + (phone == null ? null : "'" + phone + "'") + ", "
                + createdDentist.getId() + ", "
                + (city.getPostalCode() == null ? null : "'" + city.getPostalCode() + "'") + ", "
                + (address == null ? null : "'" + address + "'");
    }

    @Override
    public String getWhereConditionFind() {
        return "p.name = " + "'" + name + "'" + " AND " + "p.surname = " + "'" + surname + "'";
    }

    @Override
    public String getWhereConditionUpdate() {
        return "jmbg = " + "'" + jmbg + "'";
    }

    @Override
    public String getNameByColumn(int column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralDomainObject getNewRecord(ResultSet rs) throws SQLException {
        Patient p = new Patient();
        p.setJmbg(rs.getString("p.jmbg"));
        p.setName(rs.getString("p.name"));
        p.setSurname(rs.getString("p.surname"));
        p.setDateOfBirth(rs.getDate("p.dateOfBirth"));
        p.setEmail(rs.getString("p.email"));
        p.setPhone(rs.getString("p.phone"));
        p.setCreatedDentist(new Dentist(rs.getInt("d.id"), rs.getString("d.name"), rs.getString("d.surname"), rs.getString("d.username"), rs.getString("d.password")));
        p.setCity(new City(rs.getString("c.name"), name));
        p.setAddress(rs.getString("p.address"));
        return p;
    }

    private void sortList(List<GeneralDomainObject> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Patient p1 = (Patient) list.get(i);
                Patient p2 = (Patient) list.get(j);
                if (p1.getName().compareTo(p2.getName()) > 0) {
                    Patient p = p1;
                    list.set(i, p2);
                    list.set(j, p);
                }
            }
        }
    }

    @Override
    public String getJoinClauseFind() {
        return " p JOIN dentist d ON p.createdDentist = d.id JOIN city c ON p.city = c.postalCode";
    }

    @Override
    public String toString() {
        return email + " " + phone + " " + createdDentist.getId() + " " + createdDentist.getName() + " " + city.getPostalCode() + " " + city.getName();
    }

    @Override
    public List<GeneralDomainObject> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createList(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(GeneralDomainObject gdo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereConditionFindList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GeneralDomainObject> getNewRecords(ResultSet rs) throws SQLException {
        List<GeneralDomainObject> list = new LinkedList<>();
        do {
            Patient p = new Patient();
            p.setJmbg(rs.getString("p.jmbg"));
            p.setName(rs.getString("p.name"));
            p.setSurname(rs.getString("p.surname"));
            p.setDateOfBirth(rs.getDate("p.dateOfBirth"));
            p.setEmail(rs.getString("p.email"));
            p.setPhone(rs.getString("p.phone"));
            p.setCreatedDentist(new Dentist(rs.getInt("d.id"), rs.getString("d.name"), rs.getString("d.surname"), rs.getString("d.username"), rs.getString("d.password")));
            p.setCity(new City(rs.getString("c.name"), name));
            p.setAddress(rs.getString("p.address"));
            list.add(p);
        } while (rs.next());
        return list;
    }

    @Override
    public String getColumnNames() {
        return " (jmbg, name, surname, dateOfBirth, email, phone, createdDentist, city, address)";
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
