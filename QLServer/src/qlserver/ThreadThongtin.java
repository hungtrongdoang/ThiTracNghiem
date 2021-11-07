package qlserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.Arrays;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import qlserver.AES;

import static qlserver.Server1.user;

public class ThreadThongtin extends Thread {

    private final Socket socket;

    public ThreadThongtin(Socket pSocket, int count) {
        this.socket = pSocket;
        int clientNo = count;
    }

    @Override
    public void run() {

        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String secretKey = "THONGTIN";
            String str = dis.readUTF();
            str = AES.decrypt(str, secretKey);
            String[] arrStr = str.split("///");
            String s1 = arrStr[1];

            boolean str1 = ConnectDth.getIdMASV(s1);
            if (str1 == true) {
                String string1 = "Fail";
                string1 = AES.encrypt(string1, secretKey);
                dos.writeUTF(string1);
            } else {
                String string2 = "Success";
               string2 = AES.encrypt(string2, secretKey);
                dos.writeUTF(string2);
                user.append(str + "\n");
            }

            dis.close();
            dos.close();
            socket.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
