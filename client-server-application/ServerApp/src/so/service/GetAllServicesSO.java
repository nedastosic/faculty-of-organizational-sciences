/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.service;

import domain.GeneralDomainObject;
import domain.Service;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author NEDA
 */
public class GetAllServicesSO extends AbstractGenericOperation{
    List<GeneralDomainObject> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Service)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = databaseBroker.getAll((Service) entity);
    }
    
    public List<GeneralDomainObject> getList() {
        return list;
    }
}
