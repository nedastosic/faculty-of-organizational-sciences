/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.appointment;

import domain.Appointment;
import domain.AppointmentItem;
import domain.util.GDOStatus;
import so.AbstractGenericOperation;

/**
 *
 * @author NEDA
 */
public class UpdateAppointmentSO extends AbstractGenericOperation {

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Appointment)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        Appointment a = (Appointment) entity;
        databaseBroker.updateRecord(a);
        if (a.getItems() != null) {
            for (AppointmentItem ai : a.getItems()) {
                switch (ai.getStatus()) {
                    case NEW:
                        databaseBroker.saveRecord(ai);
                        break;
                    case UPDATED:
                        databaseBroker.updateRecord(ai);
                        break;
                    case DELETED:
                        databaseBroker.deleteRecord(ai);
                        break;
                }
            }
        }
    }

}
