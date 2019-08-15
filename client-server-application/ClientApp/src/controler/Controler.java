/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import communication.Communication;
import domain.Appointment;
import domain.AppointmentItem;
import domain.City;
import domain.Dentist;
import domain.Patient;
import domain.Service;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author NEDA
 */
public class Controler {

    private static Controler instance;

    private Controler() {
    }

    public static Controler getInstance() {
        if (instance == null) {
            instance = new Controler();
        }
        return instance;
    }

    public Dentist logIn(String username, String password) throws Exception {
        Dentist dentist = new Dentist();
        dentist.setUsername(username);
        dentist.setPassword(password);
        Request request = new Request(Operation.OPERATION_LOGIN, dentist);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (Dentist) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public List<City> getAllCities() throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_CITIES);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        return (List<City>) response.getData();
    }

    public List<Patient> getSearchedPatients(String name, String surname) throws IOException, ClassNotFoundException, Exception {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setSurname(surname);
        Request request = new Request(Operation.OPERATION_SEARCH_PATIENTS, patient);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (LinkedList<Patient>) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public void savePatient(Patient patient) throws IOException, ClassNotFoundException, Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_SAVE_PATIENT);
        request.setData(patient);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return;
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public void updatePatient(Patient patient) throws IOException, ClassNotFoundException, Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_UPDATE_PATIENT);
        request.setData(patient);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return;
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public void deletePatient(Patient patient) throws IOException, ClassNotFoundException, Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_DELETE_PATIENT);
        request.setData(patient);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return;
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public List<Dentist> getAllDentists() throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_DENTISTS);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        return (List<Dentist>) response.getData();
    }

    public List<Service> getAllServices() throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_SERVICES);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        return (List<Service>) response.getData();
    }

    public void saveAppointment(Appointment appointment) throws IOException, ClassNotFoundException, Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_SAVE_APPOINTMENT);
        request.setData(appointment);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return;
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public List<Appointment> getSearchedAppointments(String name, String surname) throws IOException, ClassNotFoundException, Exception {
        Appointment appointment = new Appointment();
        Patient patient = new Patient();
        patient.setName(name);
        patient.setSurname(surname);
        appointment.setPatient(patient);
        Request request = new Request(Operation.OPERATION_SEARCH_APPOINTMENTS, appointment);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (LinkedList<Appointment>) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    

    public void updateAppointment(Appointment a, List<AppointmentItem> updatedItems) throws IOException, ClassNotFoundException, Exception {
       
        a.setItems(updatedItems);
        Request request = new Request();
        request.setOperation(Operation.OPERATION_UPDATE_APPOINTMENT);
        request.setData(a);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return;
        }
        Exception ex = (Exception) response.getError();
        throw ex;


    }

    public void updateAppointment(Appointment a) throws IOException, ClassNotFoundException, Exception {
        a.setItems(null);
        Request request = new Request();
        request.setOperation(Operation.OPERATION_UPDATE_APPOINTMENT);
        request.setData(a);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return;
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public void logOut(Dentist d) throws IOException, ClassNotFoundException, Exception {        
        Request request = new Request(Operation.OPERATION_LOGOUT, d);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();        
        Exception ex = (Exception) response.getError();
        if(response.getStatus() == ResponseStatus.ERROR)
            throw ex;
    }

    public List<Appointment> checkDentistAppointments() throws IOException, ClassNotFoundException, Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_SCHEDULED_APPOINTMENTS);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<Appointment>)response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    

}
