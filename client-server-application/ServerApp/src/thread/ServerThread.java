/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.SettingsLoader;

/**
 *
 * @author NEDA
 */
public class ServerThread extends Thread{
    private boolean active;
    private ServerSocket ss;

    public ServerThread() {
        active = true;
    }
    
    
    @Override
    public void run() {
        try {
            int port = Integer.parseInt(SettingsLoader.getInstance().getProperty("port"));
            ss = new ServerSocket(port);
            while(active){
                Socket socket = ss.accept();
                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopServer() {
        try {
            active = false;
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
