/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlserver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.apache.xmlbeans.XmlFactoryHook;

public class Server1 extends javax.swing.JFrame {

    /**
     * Creates new form Server1
     */
    public static Server1 svServer1 = new Server1();
    public JButton closeButton;
    public static Hashtable<String, ThreadPhongcho> listUser;
    private static ServerSocket server;

    public Server1() {
        initComponents();
//        user.setLineWrap(true);
        setResizable(false);
        user.setEditable(false);

        setSize(435, 560);
    }

    public static void Setthongtin() {

        try {
            final ServerSocket ss = new ServerSocket(12345);
            user.append("Server Lấy Thông Tin đã mở!\n");
            Thread th = new Thread() {
                int core = 0;

                public void run() {
                    try {
                        while (true) {
                            core++;
                            Socket socket = ss.accept();
                            ThreadThongtin t = new ThreadThongtin(socket, core);
                            t.start();

                        }
                    } catch (Exception e) {
                        user.append("Error: " + e.getMessage() + "\n");
                        e.printStackTrace();
                    }
                }

            };
            th.start();

        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
        // return core;
    }

    public static void Luuthongtin() {

        try {

            final ServerSocket ss = new ServerSocket(54321);
            user.append("Server Lưu Thông Tin đã mở!\n");
            Thread th = new Thread() {
                int count = 0;

                public void run() {
                    try {
                        while (true) {
                            count++;
                            Socket socket = ss.accept();
                            ThreadLuu t = new ThreadLuu(socket, count);
                            t.start();

                        }

                    } catch (Exception e) {
                        user.append("Error: " + e.getMessage() + "\n");
                        e.printStackTrace();
                    }

                }
            };
            th.start();

        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void BXH() {

        try {

            final ServerSocket ss = new ServerSocket(65432);
            user.append("Server Bảng Xếp Hạng đã mở!\n");
            Thread th = new Thread() {
                int count = 0;

                public void run() {
                    try {
                        while (true) {
                            count++;
                            Socket socket = ss.accept();
                            ThreadBXH t = new ThreadBXH(socket, count);
                            t.start();

                        }

                    } catch (Exception e) {
                        user.append("Error: " + e.getMessage() + "\n");
                        e.printStackTrace();
                    }

                }
            };
            th.start();

        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void PhongCho() {
        try {
            server = new ServerSocket(2107);
            user.append("Server Phòng Chờ đã mở\n");
            Thread t = new Thread() {   
                public void run() {
                    try {
                        listUser = new Hashtable<String, ThreadPhongcho>();
                        
                        while (true) {                          
                            Socket client = server.accept();
                            new ThreadPhongcho(svServer1, client);

                        }
                    } catch (IOException ex) {
                        user.append("Không thể khởi động máy chủ\n");
                    }
                }

            };
            t.start();
        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sendAll(String from, String msg) {
        Enumeration e = listUser.keys();
        String name = null;
        while (e.hasMoreElements()) {
            name = (String) e.nextElement();     
            if (name.compareTo(from) != 0) {
                listUser.get(name).sendMSG("3", msg);
            }
        }
    }

    public void sendAllUpdate(String from) {
        Enumeration e = listUser.keys();
        String name = null;
        while (e.hasMoreElements()) {
            name = (String) e.nextElement();
            //System.out.println(name);
            if (name.compareTo(from) != 0) {
                listUser.get(name).sendMSG("4", getAllName());
            }
        }
    }

    public String getAllName() {
        Enumeration e = listUser.keys();
        String name = "";
        while (e.hasMoreElements()) {
            name += (String) e.nextElement() + "\n";
        }
        return name;
    }

    public static void ThiTracNghiem() {
        try {

            final ServerSocket ss = new ServerSocket(13334);
            user.append("Server Thi Trắc Nghiệm đã mở!\n");
            Thread th = new Thread() {
                int count = 0;

                public void run() {
                    try {
                        while (true) {
                            count++;
                            Socket socket = ss.accept();
                            ThreadThi t = new ThreadThi(socket, count);
                            t.start();
                            
                        }
                    } catch (Exception e) {
                        user.append("Error: " + e.getMessage() + "\n");
                        e.printStackTrace();
                    }
                }
            };
            th.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //  return core;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOpenServer = new javax.swing.JButton();
        btnCloseServer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user = new javax.swing.JTextArea();
        txtport = new javax.swing.JTextField();
        btnQL = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        btnOpenServer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnOpenServer.setText("Mở Server");
        btnOpenServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenServerActionPerformed(evt);
            }
        });
        getContentPane().add(btnOpenServer);
        btnOpenServer.setBounds(20, 40, 100, 30);

        btnCloseServer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCloseServer.setText("Đóng Server");
        btnCloseServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseServerActionPerformed(evt);
            }
        });
        getContentPane().add(btnCloseServer);
        btnCloseServer.setBounds(300, 40, 110, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trạng thái Server:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 130, 102, 14);

        user.setColumns(20);
        user.setRows(5);
        jScrollPane1.setViewportView(user);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 150, 390, 363);
        getContentPane().add(txtport);
        txtport.setBounds(130, 40, 160, 30);

        btnQL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQL.setText("Quản Lý Dữ Liệu");
        btnQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLActionPerformed(evt);
            }
        });
        getContentPane().add(btnQL);
        btnQL.setBounds(20, 90, 390, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlserver/maxresdefault.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 430, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenServerActionPerformed
        // TODO add your handling code here:

        if (txtport.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP VÀO Ô TRỐNG ĐỂ MỞ PORT!", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            int PORT = Integer.parseInt(txtport.getText());
            if (PORT < 0 || PORT > 65535) {
                JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP PORT TỪ 0 - 65535!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    btnQL.setEnabled(false);
                    user.append("Server chính đã mở.\n");
                    final ServerSocket ss = new ServerSocket(PORT);
                    user.append("Server bắt đầu phục vụ ở " + PORT + "\n");
                    JOptionPane.showMessageDialog(null, " MỞ SERVER THÀNH CÔNG VỚI PORT: " + PORT, "Information", JOptionPane.INFORMATION_MESSAGE);
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    this.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            try {
                                //gởi tin nhắn tới tất cả client
                                server.close();
                                System.exit(0);
                            } catch (IOException e1) {
                                JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    Thread th = new Thread() {
                        public void run() {
                            try {
                                while (true) {
                                    Socket socket = ss.accept();
                                    ThreadFirst tf = new ThreadFirst(socket);
                                    tf.start();
                                    user.append("Có 1 kết nối đến\n");
                                   
                                    
                                }

                            } catch (Exception e) {
                                user.append("Error: " + e.getMessage() + "\n");
                                e.printStackTrace();
                            }

                        }
                    };
                    th.start();
                    Setthongtin();
                    PhongCho();
                    BXH();
                    ThiTracNghiem();
                    Luuthongtin();

                } catch (IOException ex) {
                    Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
                    user.append("Không thể khởi động máy chủ\n");
                }
            }
        }


    }//GEN-LAST:event_btnOpenServerActionPerformed

    private void btnCloseServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseServerActionPerformed
        JFrame Frame = new JFrame("Close");
        if (JOptionPane.showConfirmDialog(Frame, "BẠN CÓ CHẮC CHẮN MUỐNG ĐÓNG SERVER KHÔNG", "Exit",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (server == null) {
                System.exit(0);
            } else {
                try {

                    server.close();
                    System.exit(0);
                } catch (IOException ex) {
                    Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseServerActionPerformed

    private void btnQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        QLData ql = new QLData();
        ql.setVisible(true);
    }//GEN-LAST:event_btnQLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server1().setVisible(true);
            }

        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseServer;
    private javax.swing.JButton btnOpenServer;
    private javax.swing.JButton btnQL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtport;
    public static javax.swing.JTextArea user;
    // End of variables declaration//GEN-END:variables
}
