/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author NEDA
 */
public interface Operation {
    public static final int OPERATION_LOGIN = 1;
    public static final int OPERATION_GET_ALL_CITIES = 2;
    public static final int OPERATION_SEARCH_PATIENTS = 3;
    public static final int OPERATION_SAVE_PATIENT = 4;
    public static final int OPERATION_UPDATE_PATIENT = 5;
    public static final int OPERATION_DELETE_PATIENT = 6;
    public static final int OPERATION_GET_ALL_DENTISTS = 7;
    public static final int OPERATION_GET_ALL_SERVICES = 8;
    public static final int OPERATION_SAVE_APPOINTMENT = 9;
    public static final int OPERATION_SEARCH_APPOINTMENTS = 10;
    public static final int OPERATION_SAVE_INVOICE = 11;    
    public static final int OPERATION_UPDATE_APPOINTMENT = 12;
    public static final int OPERATION_LOGOUT = 13;
    public static final int OPERATION_GET_SCHEDULED_APPOINTMENTS = 14;
}
