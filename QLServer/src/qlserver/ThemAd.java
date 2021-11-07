/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import static qlserver.ConnectDth.getSqlConnection;

/**
 *
 * @author longp
 */
public class ThemAd extends javax.swing.JFrame {

    ConnectDth dbconn = new ConnectDth();
    Connection dbConnection = null;

    public ThemAd() {
        initComponents();
         this.setLocationRelativeTo(null);
        setResizable(false);
        setSize(375, 245);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        btnThem = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        txtpassword1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Thêm tài khoản");
        getContentPane().setLayout(null);
        getContentPane().add(txtusername);
        txtusername.setBounds(140, 20, 201, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USERNAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 20, 102, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 102, 30);
        getContentPane().add(txtpassword);
        txtpassword.setBounds(140, 60, 201, 30);

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThemMouseExited(evt);
            }
        });
        btnThem.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnThemMouseMoved(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem);
        btnThem.setBounds(50, 160, 100, 30);

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThoat.setText("THOÁT");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoat);
        btnThoat.setBounds(240, 160, 94, 30);

        txtpassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassword1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtpassword1);
        txtpassword1.setBounds(140, 100, 201, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CONFIRM");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 100, 102, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlserver/maxresdefault.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(4, 0, 370, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemMouseExited

    private void btnThemMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemMouseMoved

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        dbConnection = dbconn.getSqlConnection();
        Connection conn = getSqlConnection();
        if (txtusername.getText().equals("") || txtpassword.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "VUI LÒNG ĐIỀN VÀO USERNAME VÀ PASSWORD!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            MessageDigest md, md2;
            try {
                String username = txtusername.getText();
                String password = new String(txtpassword.getPassword());
                String confirm = new String(txtpassword1.getPassword());
                md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] digest = md.digest();
                String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
                md2 = MessageDigest.getInstance("MD5");
                md2.update(confirm.getBytes());
                byte[] digestconfirm = md2.digest();
                String myHashConfirm = DatatypeConverter.printHexBinary(digestconfirm).toUpperCase();
                if (myHashConfirm.equals(myHash)) {
                    String str = "insert into taikhoan values('" + username + "','" + myHash + "')";
                    PreparedStatement ptsm = conn.prepareStatement(str);
                    int rs = ptsm.executeUpdate();
                    if (rs != 0) {
                        JOptionPane.showMessageDialog(null, "ĐĂNG KÍ THÀNH CÔNG", "Information", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "ĐĂNG KÝ THẤT BẠI", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP ĐÚNG MẬT KHẨU XÁC THỰC!", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (NoSuchAlgorithmException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "TÀI KHOẢN ĐÃ TỒN TẠI", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtpassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassword1ActionPerformed

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
            java.util.logging.Logger.getLogger(ThemAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemAd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemAd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JPasswordField txtpassword1;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}