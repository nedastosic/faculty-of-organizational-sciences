/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NEDA
 */
public class Dentist extends GeneralDomainObject {

    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;

    public Dentist() {
    }

    public Dentist(int id, String name, String surname, String username, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getTableName() {
        return "dentist";
    }

    @Override
    public List<GeneralDomainObject> getList(ResultSet resultSet) throws Exception {
        List<GeneralDomainObject> list = new LinkedList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            Dentist dentist = new Dentist(id, name, surname, username, password);
            list.add(dentist);
        }
        return list;
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", " + "name=" + (name == null ? null : "'" + name + "'") + ", " + "surname=" + (surname == null ? null : "'" + surname + "'") + ", " + "username=" + (username == null ? null : "'" + username + "'") + ", " + "password=" + (password == null ? null : "'" + password + "'");
    }

    @Override
    public String getAtrValue1() {
        return id + ", " + (name == null ? null : "'" + name + "'") + ", " + (surname == null ? null : "'" + surname + "'") + ", " + (username == null ? null : "'" + username + "'") + ", " + (password == null ? null : "'" + password + "'");
    }

    @Override
    public String getWhereConditionFind() {
        return "username = " + "'" + username + "'" + " AND " + "password = " + "'" + password + "'";
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"id", "name", "surname", "username", "password"};
        return names[column];
    }

    @Override
    public GeneralDomainObject getNewRecord(ResultSet rs) throws SQLException {
        return new Dentist(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("username"), rs.getString("password"));
    }

    @Override
    public String getJoinClauseFind() {
        return "";
    }

    @Override
    public String getWhereConditionUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return name + " " + surname;
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
        if(((Dentist)gdo).getId() == id){
            return true;
        }
        return false;
    }

    @Override
    public String getWhereConditionFindList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GeneralDomainObject> getNewRecords(ResultSet rs) throws SQLException {
        List<GeneralDomainObject> list = new LinkedList<>();
        do{
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String username = rs.getString("username");
            String password = rs.getString("password");
            Dentist dentist = new Dentist(id, name, surname, username, password);
            list.add(dentist);
        }while(rs.next());
        return list;
    }

    @Override
    public String getColumnNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinClauseUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Dentist other = (Dentist) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String getAtrValue2() {
        return getAtrValue1();
    }
    
    

}
