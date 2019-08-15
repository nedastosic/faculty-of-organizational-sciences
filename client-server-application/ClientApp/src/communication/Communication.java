/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author NEDA
 */
public class Communication {

    private static Communication instance;
    private Socket socket;

    private Communication() throws IOException {        
        try {
            socket = new Socket("localhost", 9000);
        } catch (SocketException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Server is stopped, please try again!");
            System.exit(0);
        }
        
    }

    public static Communication getInstance() throws IOException {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public void sendRequest(Request request) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        try {
            outSocket.writeObject(request);
        } catch (SocketException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Server is stopped, please try again!");
            System.exit(0);
        }
        
    }

    public Response readResponse() throws IOException, ClassNotFoundException {
        ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
        return (Response) inSocket.readObject();
    }
}
