/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SuaThongTinSV extends javax.swing.JFrame {

    /**
     * Creates new form Them
     */
    ConnectDth dbconn = new ConnectDth();
    Connection dbConnection = null;
    DefaultTableModel Model;

    public SuaThongTinSV() {
        initComponents();     
        setResizable(false);
        setSize(735, 480);
        txtMasv.setEditable(false);
        txtNgay.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton3 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtHoTen = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        txtNgay = new javax.swing.JTextField();
        txtMasv = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sửa Thông Tin Sinh Viên");
        getContentPane().setLayout(null);

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtHoTen);
        txtHoTen.setBounds(70, 130, 280, 30);

        txtsdt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtsdt);
        txtsdt.setBounds(70, 200, 280, 30);

        txtDiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtDiem);
        txtDiem.setBounds(430, 130, 280, 30);

        txtNgay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtNgay);
        txtNgay.setBounds(430, 200, 280, 30);

        txtMasv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMasv.setMinimumSize(new java.awt.Dimension(10, 25));
        txtMasv.setName(""); // NOI18N
        txtMasv.setPreferredSize(new java.awt.Dimension(10, 25));
        getContentPane().add(txtMasv);
        txtMasv.setBounds(70, 70, 280, 30);

        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-edit-30.png"))); // NOI18N
        btnLuu.setText("Sửa");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        getContentPane().add(btnLuu);
        btnLuu.setBounds(605, 20, 100, 40);

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-exit-30.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoat);
        btnThoat.setBounds(23, 13, 110, 39);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Mã SV:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 70, 60, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nội dung:");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(23, 50, 68, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Họ Tên:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 130, 60, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Điểm:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(360, 130, 60, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ngày Thi:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(350, 200, 70, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("SĐT:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 200, 60, 30);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jTabbedPane1.addTab("Quản Lý Sinh Viên", jScrollPane3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 250, 700, 190);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlserver/maxresdefault.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(-6, 0, 760, 460);

        getAccessibleContext().setAccessibleName("Quản Lý Sinh Viên");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        dbConnection = dbconn.getSqlConnection();
        if (txtMasv.getText().equals("") || txtHoTen.getText().equals("") || txtsdt.getText().equals("") || txtDiem.getText().equals("") || txtNgay.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "VUI LÒNG ĐIỀN ĐẦY ĐỦ THÔNG TIN! ", "Message Dialog", JOptionPane.WARNING_MESSAGE);
        } else {
          
              String masv = txtMasv.getText();
                String hoten = txtHoTen.getText();
                float diem = Float.parseFloat(txtDiem.getText());
                String sdt = txtsdt.getText();
                String ngaythi = txtNgay.getText();

                String update = "UPDATE SINHVIEN SET HOTEN = N'" + hoten + "', SODIENTHOAI = '" + sdt + "', DIEM = '" + diem + "', NGAYTHI = '" + ngaythi + "' WHERE MASV = '" + masv + "' ";
                try {

                    PreparedStatement pst = dbConnection.prepareStatement(update);
                    int rs = pst.executeUpdate();
                    if (rs != 0) {
                        JOptionPane.showMessageDialog(null, "SỬA THÀNH CÔNG THÔNG TIN SINH VIÊN", "Information", JOptionPane.INFORMATION_MESSAGE);
                        clearAllInputField();
                        LoadData();
                       
                    } else {

                        JOptionPane.showMessageDialog(null, "SỬA THẤT BẠI", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "SỬA THẤT BẠI", "Error", JOptionPane.ERROR_MESSAGE);

                }      
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        LoadData();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if (jTable2.getSelectedRow() >= 0) {
            txtMasv.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 0) + "");
            txtHoTen.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 1) + "");
            txtsdt.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 2) + "");
            txtDiem.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 3) + "");
            txtNgay.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 4) + "");
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void LoadData() {
        Model = (DefaultTableModel) jTable2.getModel();
        Model.setRowCount(0);
        dbConnection = dbconn.getSqlConnection();
        String qlsv = "SELECT * FROM SINHVIEN";
        try {
            PreparedStatement pst = dbConnection.prepareStatement(qlsv);
            ResultSet rs = pst.executeQuery();
            jTable2.removeAll();
            String[] arr = {"MSSV", "Họ Tên", "Số Điện Thoại", "Điểm", "Ngày Thi"};
            Model = new DefaultTableModel(arr, 0);
            while (rs.next()) {

                Vector vec = new Vector();
                vec.add(rs.getString("MASV"));
                vec.add(rs.getString("HOTEN"));
                vec.add(rs.getString("SODIENTHOAI"));
                vec.add(rs.getFloat("DIEM"));
                vec.add(rs.getString("NGAYTHI"));
                Model.addRow(vec);
            }

            jTable2.setModel(Model);
        } catch (SQLException ex) {
            Logger.getLogger(QLData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(SuaThongTinSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaThongTinSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaThongTinSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaThongTinSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuaThongTinSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMasv;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables

    private void clearAllInputField() {
        txtMasv.setText("");
        txtHoTen.setText("");
        txtDiem.setText("");
        txtsdt.setText("");
        txtNgay.setText("");

    }
}
