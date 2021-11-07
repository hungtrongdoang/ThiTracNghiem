
package qlserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlserver.Server1;
import static qlserver.Server1.Setthongtin;


public class ThreadFirst extends Thread {

    private final Socket socket;

    public ThreadFirst(Socket pSocket) {
        this.socket = pSocket;
    }

    
    @Override
    public void run() {
        
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                 
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
