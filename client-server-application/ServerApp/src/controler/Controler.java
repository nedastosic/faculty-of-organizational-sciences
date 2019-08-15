/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import database.DatabaseBroker;
import domain.Appointment;
import domain.City;
import domain.Dentist;
import domain.GeneralDomainObject;
import domain.Patient;
import domain.Service;
import domain.util.AppointmentStatus;
import java.util.ArrayList;
import java.util.List;
import so.AbstractGenericOperation;
import so.appointment.GetAllAppointments;
import so.appointment.SaveAppointmentSO;
import so.appointment.SearchAppointmentsSO;
import so.appointment.UpdateAppointmentSO;
import so.city.GetAllCitiesSO;
import so.dentist.GetAllDentistsSO;
import so.login.LoginSO;
import so.patient.SavePatientSO;
import so.patient.DeletePatientSO;
import so.patient.SearchPatientsSO;
import so.patient.UpdatePatientSO;
import so.service.GetAllServicesSO;
import thread.ClientThread;
import thread.ServerThread;
import util.SettingsLoader;

/**
 *
 * @author NEDA
 */
public class Controler {

    private static Controler instance;
    private DatabaseBroker dbb;
    private ServerThread server;
    private List<ClientThread> clients;

    private Controler() {
        clients = new ArrayList<>();
    }

    public static Controler getInstance() {
        if (instance == null) {
            instance = new Controler();
        }
        return instance;
    }

    public void addClient(ClientThread client) throws Exception {
        if (!clients.contains(client)) {
            clients.add(client);
        } else {
            throw new Exception("This dentist is already  logged in");
        }

    }

    public void setProperties(String port, String url, String user, String password) {
        SettingsLoader.getInstance().setProperties(port, url, user, password);
        dbb = new DatabaseBroker();
    }

    public Dentist logIn(Dentist dataDentist) throws Exception {
        AbstractGenericOperation so = new LoginSO();
        so.templateExecute(dataDentist);
        return ((LoginSO) so).getDentist();
    }

    public List<GeneralDomainObject> getAllCities() throws Exception {
        AbstractGenericOperation so = new GetAllCitiesSO();
        so.templateExecute(new City());
        return ((GetAllCitiesSO) so).getList();
    }

    public List<GeneralDomainObject> searchPatients(Patient dataPatient) throws Exception {
        AbstractGenericOperation so = new SearchPatientsSO();
        so.templateExecute(dataPatient);
        return ((SearchPatientsSO) so).getList();
    }

    public void savePatient(Patient data) throws Exception {
        AbstractGenericOperation so = new SavePatientSO();
        so.templateExecute(data);
    }

    public void updatePatient(Patient data) throws Exception {
        AbstractGenericOperation so = new UpdatePatientSO();
        so.templateExecute(data);
    }

    public void deletePatient(Patient data) throws Exception {
        AbstractGenericOperation so = new DeletePatientSO();
        so.templateExecute(data);
    }

    public List<GeneralDomainObject> getAllDentists() throws Exception {
        AbstractGenericOperation so = new GetAllDentistsSO();
        so.templateExecute(new Dentist());
        return ((GetAllDentistsSO) so).getList();
    }

    public List<GeneralDomainObject> getAllServices() throws Exception {
        AbstractGenericOperation so = new GetAllServicesSO();
        so.templateExecute(new Service());
        return ((GetAllServicesSO) so).getList();
    }

    public void saveAppointment(Appointment data) throws Exception {
        AbstractGenericOperation so = new SaveAppointmentSO();
        so.templateExecute(data);
    }

    public void startServer() {
        server = new ServerThread();
        server.start();
    }

    public void stopServer() {
        for (ClientThread ct : clients) {
            ct.stopClient();
        }
        server.stopServer();
    }

    public List<GeneralDomainObject> searchAppointments(Appointment app) throws Exception {
        AbstractGenericOperation so = new SearchAppointmentsSO();
        so.templateExecute(app);
        return ((SearchAppointmentsSO) so).getList();

    }

    public void updateAppointment(Appointment appointmentToUpdate) throws Exception {
        AbstractGenericOperation updateAppointment = new UpdateAppointmentSO();
        updateAppointment.templateExecute(appointmentToUpdate);
    }

    public void logOut(Dentist dentist) throws Exception {
        for (ClientThread ct : clients) {
            if (ct.getDentist().equals(dentist)) {

                return;
            }
        }
        throw new Exception("Log out failed!");
    }

    public void removeClient(ClientThread ct) {
        clients.remove(ct);
    }

    public List<GeneralDomainObject> findScheduledAppointments() throws Exception {
        AbstractGenericOperation so = new GetAllAppointments();
        so.templateExecute(new Appointment());
        List<GeneralDomainObject> list = ((GetAllAppointments) so).getList();
        for(GeneralDomainObject gdo : list){
            Appointment a = (Appointment)gdo;
            if(a.getAppointmentStatus() != AppointmentStatus.SCHEDULED){
                list.remove(a);
            }
        }
        return list;

    }
}
