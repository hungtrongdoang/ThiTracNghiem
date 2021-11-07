package qlserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import static qlserver.Server1.user;


public class ThreadThi extends Thread {

    int clientNo;
    public static String tr;
    private final Socket socket;

    public ThreadThi(Socket pSocket, int counter) {
        this.socket = pSocket;
        clientNo = counter;
    }

    public void run() {
        try {

            int core = 0;
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            if (true) {
                tr = ConnectDth.getAllCauHoi();
                user.append("Toàn bộ câu hỏi:\n" + tr + "\n");
                String SECRET_KEY = "stackjava.com.if";         
                String encrypted = AES.encrypt(tr, SECRET_KEY);
                System.out.println(tr);
                System.out.println("mã hóa: "+encrypted);
                
                dos.writeUTF(encrypted);
                dos.flush();

            }
            dis.close();
            dos.close();
            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(ThreadThi.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
}
