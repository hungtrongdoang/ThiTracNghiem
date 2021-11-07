
package qlserver;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaSymbols;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static qlserver.Server1.user;


public class ThreadLuu extends Thread {

    private final Socket socket;
    int clientNo;
    String secretKey = "KETQUA";

    public ThreadLuu(Socket pSocket, int count) {
        this.socket = pSocket;
        clientNo = count;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String str = dis.readUTF();
           str = AES.decrypt(str, secretKey);
            String[] arrStr = str.split("///");
            if (true) {
                ConnectDth.getTHONGTINN(str);
                user.append("Kết quả thi:\n");
                user.append(str + "\n");
            }

            // String str = null;   
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
