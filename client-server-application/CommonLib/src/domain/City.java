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
public class City extends GeneralDomainObject {

    private String postalCode;
    private String name;

    public City() {
    }

    public City(String postalCode, String name) {
        this.postalCode = postalCode;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String getTableName() {
        return "city";
    }

    @Override
    public List<GeneralDomainObject> getList(ResultSet resultSet) throws Exception {
        List<GeneralDomainObject> list = new LinkedList<>();
        while (resultSet.next()) {
            String postalCode = resultSet.getString("postalCode");
            String name = resultSet.getString("name");
            City city = new City(postalCode, name);
            list.add(city);
        }
        sortList(list);
        return list;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAtrValue1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereConditionFind() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNameByColumn(int column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralDomainObject getNewRecord(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortList(List<GeneralDomainObject> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                City c1 = (City)list.get(i);
                City c2 = (City)list.get(j);
                if(c1.getName().compareTo(c2.getName()) > 0){
                    City c = c1;
                    list.set(i, c2);
                    list.set(j, c);
                }
            }
        }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String getAtrValue2() {
        return getAtrValue1();
    }

}
