package qlserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static qlserver.Server1.user;

public class ThreadPhongcho extends Thread {

    public Socket client;
    public Server1 server;
    private String nickName;
    private DataOutputStream dos;
    private DataInputStream dis;
    private boolean run;
    String secretKey = "CHAT";

    public ThreadPhongcho(Server1 server, Socket client) {
        try {
            this.server = server;
            this.client = client;
            dos = new DataOutputStream(client.getOutputStream());
            dis = new DataInputStream(client.getInputStream());
            
            run = true;
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        // xữ lý đăng nhập
        String msg = null;
        try {
            user.append("Phòng chờ:\n");
            while (run) {
                nickName = getMSG();
                if (nickName.compareTo("0") == 0) {
                    logout();
                } else {
                    if (checkNick(nickName)) {
                        sendMSG("0");
                    } else {
             
                        user.append(nickName + " đã kết nối vào phòng chờ\n");    
                        server.sendAll(nickName, nickName + " đã vào room với anh em\n");
                        server.listUser.put(nickName, this);
                        server.sendAllUpdate(nickName);
                        sendMSG("1");
                        diplayAllUser();
                        while (run) {
                            int stt = Integer.parseInt(getMSG());
                            switch (stt) {
                                case 0:
                                    run = false;
                                    server.listUser.remove(this.nickName);
                                    exit();
                                    break;
                                case 1:
                                    msg = getMSG();
                                    server.sendAll(nickName, nickName + " : " + msg);
                                    break;
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {

        }

    }

    private void logout() {
        try {
            dos.close();
            dis.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exit() {
        try {
            server.sendAllUpdate(nickName);
            dos.close();
            dis.close();
            client.close();
            user.append(nickName + " đã thoát\n");
            System.out.println(nickName + " đã thoát\n");
            server.sendAll(nickName, nickName + " đã thoát\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkNick(String nick) {
        return server.listUser.containsKey(nick);
    }

    private void sendMSG(String data) {
        try {
            data = AES.encrypt(data, secretKey);
            dos.writeUTF(data);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMSG(String msg1, String msg2) {
        sendMSG(msg1);
        sendMSG(msg2);
    }

    private String getMSG() {
        String data = null;
        try {
            data = dis.readUTF();
            data = AES.decrypt(data, secretKey);
        } catch (IOException e) {

        }
        return data;
    }

    private void diplayAllUser() {
        String name = server.getAllName();
        sendMSG("4");
        sendMSG(name);
    }
    
}
