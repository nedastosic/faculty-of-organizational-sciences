/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.login;

import controler.Controler;
import domain.Dentist;
import so.AbstractGenericOperation;

/**
 *
 * @author NEDA
 */
public class LoginSO extends AbstractGenericOperation {

    Dentist dentist;

    @Override
    protected void validate(Object entity) throws Exception {
        if(!(entity instanceof Dentist))
            throw new Exception("Invalid entity parameter!");
    }

    @Override
    protected void execute(Object entity) throws Exception {
        dentist = (Dentist) databaseBroker.findRecords((Dentist) entity, null).get(0);        
    }

    public Dentist getDentist() {
        return dentist;
    }

}
