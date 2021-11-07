package clientthitn;

import java.io.DataInputStream;
import java.io.IOException;

public class DataStream extends Thread {

    private boolean run;
    private DataInputStream dis;
    private clientchat client;
    String secretKey = "CHAT";

    public DataStream(clientchat client, DataInputStream dis) {
        run = true;
        this.client = client;
        this.dis = dis;
        this.start();
    }

    public void run() {
        String msg1, msg2;
        while (run) {
            try {
                msg1 = dis.readUTF();
                msg1 = AES.decrypt(msg1, secretKey);
                msg2 = dis.readUTF();
                msg2 = AES.decrypt(msg2, secretKey);
                client.getMSG(msg1, msg2);
            } catch (IOException e) {
                System.out.println("Đã rời khỏi phòng chờ");
                stopThread();
            }
        }
        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopThread() {
        this.run = false;
    }
}
