/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author NEDA
 */
public class AppointmentItem extends GeneralDomainObject {
    private int appointment;
    private int orderNo;
    private Service service;
    private int quantity;
    private int no;

    public AppointmentItem() {
    }

    public AppointmentItem(Service service, int quantity) {
        this.service = service;
        this.quantity = quantity;
    }

    public int getAppointment() {
        return appointment;
    }

    
    public int getOrderNo() {
        return orderNo;
    }

    public Service getService() {
        return service;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getNo() {
        return no;
    }
    
    

    public void setAppointment(int appointment) {
        this.appointment = appointment;
    }
    
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNo(int no) {
        this.no = no;
    }
    
    

    @Override
    public String getTableName() {
        return "appointment_item";
    }

    @Override
    public List<GeneralDomainObject> getList(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String setAtrValue() {
        return "appointment = " + appointment + ", "
                + "service = " + service.getId() + ", "
                + "quantity = " + quantity;
    }

    @Override
    public String getAtrValue1() {
        return service.getId() + ", " + quantity;
    }

    @Override
    public String getWhereConditionFind() {
        return "ai.appointment";
    }

    @Override
    public String getNameByColumn(int column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralDomainObject getNewRecord(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinClauseFind() {
        return " ai JOIN service s ON (ai.service = s.id)";
    }

    @Override
    public String getWhereConditionUpdate() {
        return "appointment = " + appointment + " AND " + "orderNo = " + orderNo;
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
    public String getWhereConditionFindList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GeneralDomainObject> getNewRecords(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnNames() {
        return " (appointment, service, quantity) ";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(GeneralDomainObject gdo) {
        int a = ((AppointmentItem) gdo).getService().getId();
        if (((AppointmentItem) gdo).getService().getId() == service.getId()) {
            return true;
        }
        return false;
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
        final AppointmentItem other = (AppointmentItem) obj;
        if (!Objects.equals(this.service, other.service)) {
            return false;
        }
        return true;
    }

    @Override
    public String getJoinClauseUpdate() {
        return " ai JOIN appointment a";
    }

    @Override
    public String getAtrValue2() {
        return appointment + ", " + service.getId() + ", " + quantity;
    }

}
