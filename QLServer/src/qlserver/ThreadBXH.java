
package qlserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static qlserver.Server1.user;


public class ThreadBXH extends Thread {

    private final Socket socket;
    int clientNo;
    String secretKey = "RANK";

    public ThreadBXH(Socket pSocket, int count) {
        this.socket = pSocket;
        clientNo = count;
    }

    @Override
    public void run() {
        try {

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            if (true) {
                String tr = ConnectDth.getAllSV();
                tr = AES.encrypt(tr, secretKey);
                dos.writeUTF(tr);
                dos.flush();
            }

            // String str = null;   
            dos.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
