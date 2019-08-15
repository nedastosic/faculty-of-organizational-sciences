/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controler.Controler;
import domain.Appointment;
import domain.Dentist;
import domain.GeneralDomainObject;
import domain.Patient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author NEDA
 */
public class ClientThread extends Thread {

    private Socket socket;  
    private Dentist dentist;
    boolean active;

    public ClientThread(Socket socket) {
        this.socket = socket;
        active = true;
    }

    @Override
    public void run() {
        try {
            handleRequest();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void handleRequest() throws IOException, ClassNotFoundException {
        while (active) {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Request request = (Request) in.readObject();
            Response response = new Response();
            
            try{
                int operation = request.getOperation();
                
                switch(operation){
                    case Operation.OPERATION_LOGIN:
                        Dentist loginDentist = (Dentist) request.getData();
                        Dentist dentist = Controler.getInstance().logIn(loginDentist);                        
                        response.setStatus(ResponseStatus.OK);
                        response.setData(dentist);     
                        this.dentist = dentist;
                        Controler.getInstance().addClient(this);
                        break;
                    case Operation.OPERATION_GET_ALL_CITIES:
                        List<GeneralDomainObject> cities = Controler.getInstance().getAllCities();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(cities); 
                        break;
                    case Operation.OPERATION_SEARCH_PATIENTS:
                        Patient searechedPatients = (Patient) request.getData();                        
                        List<GeneralDomainObject> patients = Controler.getInstance().searchPatients(searechedPatients);
                        response.setStatus(ResponseStatus.OK);
                        response.setData(patients); 
                        break;
                    case Operation.OPERATION_SAVE_PATIENT:
                        Patient savedPatient = (Patient) request.getData();   
                        Controler.getInstance().savePatient(savedPatient);
                        response.setStatus(ResponseStatus.OK);                        
                        break;
                    case Operation.OPERATION_UPDATE_PATIENT:
                        Patient updatedPatient = (Patient) request.getData();   
                        Controler.getInstance().updatePatient(updatedPatient);
                        response.setStatus(ResponseStatus.OK);                        
                        break;
                    case Operation.OPERATION_DELETE_PATIENT:
                        Patient deletedPatient = (Patient) request.getData();   
                        Controler.getInstance().deletePatient(deletedPatient);
                        response.setStatus(ResponseStatus.OK);                        
                        break;
                    case Operation.OPERATION_GET_ALL_DENTISTS:
                        List<GeneralDomainObject> dentists = Controler.getInstance().getAllDentists();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(dentists); 
                        break;
                    case Operation.OPERATION_GET_ALL_SERVICES:
                        List<GeneralDomainObject> services = Controler.getInstance().getAllServices();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(services); 
                        break;
                    case Operation.OPERATION_SAVE_APPOINTMENT:
                        Appointment savedAppointment = (Appointment) request.getData();   
                        Controler.getInstance().saveAppointment(savedAppointment);
                        response.setStatus(ResponseStatus.OK);                        
                        break;
                    case Operation.OPERATION_SEARCH_APPOINTMENTS:
                        Appointment searchedAppointments = (Appointment) request.getData();                        
                        List<GeneralDomainObject> appointments = Controler.getInstance().searchAppointments(searchedAppointments);
                        response.setStatus(ResponseStatus.OK);
                        response.setData(appointments); 
                        break;
                    case Operation.OPERATION_UPDATE_APPOINTMENT:
                        Appointment updatedAppointment = (Appointment) request.getData();   
                        Controler.getInstance().updateAppointment(updatedAppointment);
                        response.setStatus(ResponseStatus.OK);                        
                        break;
                    case Operation.OPERATION_GET_SCHEDULED_APPOINTMENTS:
                        List<GeneralDomainObject> dentistAppointments = Controler.getInstance().findScheduledAppointments();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(dentistAppointments); 
                        break;
                    case Operation.OPERATION_LOGOUT:
                        Dentist loggedOutDentist = (Dentist) request.getData();
                        Controler.getInstance().logOut(loggedOutDentist);                        
                        response.setStatus(ResponseStatus.OK);  
                        Controler.getInstance().removeClient(this);
                        sendResponse(response);
                        stopClient();
                        break;
                }
            
            }catch(Exception e){
                e.printStackTrace();
                response.setError(e);
                response.setStatus(ResponseStatus.ERROR);
            }
            
            sendResponse(response);
        }
    }

    public void sendResponse(Response response) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(response);        
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ClientThread other = (ClientThread) obj;
        if (!Objects.equals(this.dentist, other.dentist)) {
            return false;
        }
        return true;
    }

    public Dentist getDentist() {
        return dentist;
    }
    
    public void stopClient() {
        try {
            active = false;
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
