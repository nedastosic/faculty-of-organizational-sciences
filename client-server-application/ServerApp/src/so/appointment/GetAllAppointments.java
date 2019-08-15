/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.appointment;

import domain.Appointment;
import domain.GeneralDomainObject;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author NEDA
 */
public class GetAllAppointments extends AbstractGenericOperation{
    List<GeneralDomainObject> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Appointment)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = databaseBroker.getAll((Appointment)entity);
    }

    public List<GeneralDomainObject> getList() {
        return list;
    }
    
    
    
}
