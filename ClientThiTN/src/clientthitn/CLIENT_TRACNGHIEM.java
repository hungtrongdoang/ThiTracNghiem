/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientthitn;

import clientthitn.KETQUA;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLEngineResult;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public final class CLIENT_TRACNGHIEM extends javax.swing.JFrame {

    JFrame f = new JFrame();
    private JFrame mainFrame;
    JFileChooser c = new JFileChooser();
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    int soCau = 0;
    ButtonGroup G = new ButtonGroup();
    String strkq;
    String anw;
    JButton jbnt = new JButton("click");
    private Iterable<CauHoi> listCH;
    private static int timer = 30;
    int current = -1;
    int dem = 0;
    boolean checkinput = false;
    int cauHientai = -1;
    ArrayList<CauHoi> listCauhoi = null;
    String anwClient = "";
    ArrayList<String> cauChon = null;
    ArrayList<String> ketqua = null;
    String secretKey = "THI";

    /**
     * Creates new form CLIENT_TRACNGHIEM
     */
    public CLIENT_TRACNGHIEM() throws InterruptedException, IOException {
        initComponents();

       
        setResizable(false);
        setSize(755, 560);
        this.setLocationRelativeTo(null);
        G.add(jrbA);
        G.add(jrbB);
        G.add(jrbC);
        G.add(jrbD);

        listCauhoi = new ArrayList();
        cauChon = new ArrayList();
        ketqua = new ArrayList<>();
        ThiTracNghiem();
        cauHoiKeTiep();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String time = " Timer : " + timer;
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 21));

        if (timer > 0) {
            g.drawString(time, 10, 100);

        } else {
            g.drawString("Times up ", 10, 100);

            timer = 30;
            try {
                try {
                    cauHoiKeTiep();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            if (timer < 0) {
                current++;
                timer = 30;
            }
        }
    }

    private void tinhSoCauDung() throws IOException, InterruptedException {
        int cau = 0;
        int dem = 0;
        for (int i = 0; i < soCau; i++) {

            dem++;
            String dapan = listCauhoi.get(i).getDapAn();
            String chon = cauChon.get(i);
            System.out.println(dem + " SS Đáp án: " + dapan + " -- D/A của bạn: " + chon);
            strkq = dem + " Đáp án đúng " + dapan + " -- D/A của bạn: --" + chon;
            ketqua.add(strkq);
            if (chon.equals(dapan)) {
                System.out.println("Đúng");
                cau++;
            } else {
                System.out.println("Sai");
            }
        }

        DapAn.diem = cau;

    }

    private void cauHoiKeTiep() throws IOException, InterruptedException {
        current++;
        timer = 30;

        if (current > 0) {
            if (jrbA.isSelected()) {
                cauChon.add("A");
                anwClient += dem + "///";
                anwClient += anw + "///";
                System.out.println("A");
            } else if (jrbB.isSelected()) {
                cauChon.add("B");
                System.out.println("B");
                anwClient += dem + "///";
                anwClient += anw + "///";
            } else if (jrbC.isSelected()) {
                cauChon.add("C");
                System.out.println("C");
                anwClient += dem + "///";
                anwClient += anw + "///";
            } else if (jrbD.isSelected()) {
                cauChon.add("D");
                System.out.println("D");
                anwClient += dem + "///";
                anwClient += anw + "///";
            } else {
                cauChon.add("E");
                System.out.println("E");
            }
        }

        if (current < soCau) {
            dem++;
            CauHoi ch = listCauhoi.get(current);
            System.out.println(dem + ": " + ch.getNoiDung());
            txtCauhoi.setText(dem + ": " + ch.getNoiDung());
            System.out.println("A. " + ch.getCauA());
            jrbA.setText(ch.getCauA());
            System.out.println("B. " + ch.getCauB());
            jrbB.setText(ch.getCauB());
            System.out.println("C. " + ch.getCauC());
            jrbC.setText(ch.getCauC());
            System.out.println("D. " + ch.getCauD());
            jrbD.setText(ch.getCauD());

            if (dem == 10) {
                btnNopbai.setText("HOÀN THÀNH");
            }
        } else {

            JOptionPane.showMessageDialog(null, "BẠN ĐÃ HOÀN THÀNH BÀI!", "Information", JOptionPane.INFORMATION_MESSAGE);
            tinhSoCauDung();
            this.setVisible(false);
            KETQUA KQ = new KETQUA();
            KQ.setVisible(true);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCauhoi = new javax.swing.JLabel();
        jrbA = new javax.swing.JRadioButton();
        jrbB = new javax.swing.JRadioButton();
        jrbC = new javax.swing.JRadioButton();
        jrbD = new javax.swing.JRadioButton();
        btnNopbai = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phòng Thi");
        getContentPane().setLayout(null);

        txtCauhoi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCauhoi.setForeground(new java.awt.Color(255, 255, 255));
        txtCauhoi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCauhoi.setText("CÂU 1 : mạng man được sử dụng trong phạm vi:");
        getContentPane().add(txtCauhoi);
        txtCauhoi.setBounds(0, 210, 750, 140);

        jrbA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jrbA.setForeground(new java.awt.Color(255, 0, 0));
        jrbA.setText("QUỐC GIA");
        jrbA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAActionPerformed(evt);
            }
        });
        getContentPane().add(jrbA);
        jrbA.setBounds(70, 370, 250, 50);

        jrbB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jrbB.setForeground(new java.awt.Color(51, 204, 0));
        jrbB.setText("LỤC ĐỊA");
        jrbB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBActionPerformed(evt);
            }
        });
        getContentPane().add(jrbB);
        jrbB.setBounds(430, 370, 240, 50);

        jrbC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jrbC.setForeground(new java.awt.Color(0, 51, 153));
        jrbC.setText("KHU PHỐ");
        jrbC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCActionPerformed(evt);
            }
        });
        getContentPane().add(jrbC);
        jrbC.setBounds(70, 460, 250, 50);

        jrbD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jrbD.setForeground(new java.awt.Color(255, 102, 0));
        jrbD.setText("THÀNH PHỐ");
        jrbD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDActionPerformed(evt);
            }
        });
        getContentPane().add(jrbD);
        jrbD.setBounds(430, 460, 240, 50);

        btnNopbai.setBackground(new java.awt.Color(153, 153, 255));
        btnNopbai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNopbai.setText("TIẾP THEO");
        btnNopbai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNopbaiActionPerformed(evt);
            }
        });
        getContentPane().add(btnNopbai);
        btnNopbai.setBounds(591, 180, 130, 41);

        jLabel1.setFont(new java.awt.Font("Stencil Std", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUIZ GAME!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 60, 470, 100);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clientthitn/background.PNG"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 750, 530);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     public void ThiTracNghiem() {
        try {
            String SECRET_KEY = "stackjava.com.if";

            socket = new Socket(thongtinsv.ServerIP, 13334);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            CauHoi CH = new CauHoi();
            String strAES = dis.readUTF();

            String strTN = AES.decrypt(strAES, SECRET_KEY);
            System.out.println(strAES);
            System.out.println(strTN);
            String[] arrStr = strAES.split("///");
            List<CauHoi> listCH = new ArrayList<CauHoi>();

            int i = 0;
            int dem = 0;
            for (i = 0; i < arrStr.length;) {
                if (dem < 11) {
                    CH = new CauHoi();
                    CH.setCauhoi(Integer.parseInt(arrStr[i]));
                    CH.setTrinhDo(arrStr[i + 1]);
                    CH.setNoiDung(arrStr[i + 2]);
                    CH.setCauA(arrStr[i + 3]);
                    CH.setCauB(arrStr[i + 4]);
                    CH.setCauC(arrStr[i + 5]);
                    CH.setCauD(arrStr[i + 6]);
                    CH.setDapAn(arrStr[i + 7]);
                    listCauhoi.add(CH);
                    i = i + 8;
                }
                dem++;
            }
            dem = 0;
            String anwClient = "";
            soCau = listCauhoi.size();
            //  CauHoi ch ;
            dem++;

            while (checkinput) {

                if (anw.equals("A") || anw.equals("B") || anw.equals("C") || anw.equals("D")) {
                    anwClient += dem + "///";
                    anwClient += anw + "///";
                    checkinput = false;
                } else {
                    System.out.println("NHẬP SAI VUI LÒNG NHẬP LẠI!");
                    JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP 1 VÀO MỘT ĐÁP ẤN TRƯỚC KHI TRẢ LỚI!", "Message", JOptionPane.WARNING_MESSAGE);
                }
            }
            dos.writeUTF(anwClient);

            String answer = dis.readUTF();
            System.out.println(answer);

            // Thread.sleep(3000);
            socket.close();
        } catch (IOException ex) {
            ex.getStackTrace();

        } 
    }
    private void btnNopbaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNopbaiActionPerformed

        try {

            cauHoiKeTiep();
        } catch (IOException ex) {
            Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnNopbaiActionPerformed

    private void jrbAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAActionPerformed

    }//GEN-LAST:event_jrbAActionPerformed

    private void jrbBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbBActionPerformed

    private void jrbCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbCActionPerformed

    private void jrbDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbDActionPerformed

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
            java.util.logging.Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    new CLIENT_TRACNGHIEM().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNopbai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jrbA;
    private javax.swing.JRadioButton jrbB;
    private javax.swing.JRadioButton jrbC;
    private javax.swing.JRadioButton jrbD;
    private javax.swing.JLabel txtCauhoi;
    // End of variables declaration//GEN-END:variables
}
