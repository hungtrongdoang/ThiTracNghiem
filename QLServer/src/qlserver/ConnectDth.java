/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlserver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author dell
 */
public class ConnectDth {

    public static int getCountUser(String str) {
        int count = 0;
        Connection conn = getSqlConnection();
        String sql = "select count(*) from SINHVIEN where MASV='" + str + "'";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDth.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public static String getIdMaSV(String str) {
        String idMaSv = "";
        Connection conn = getSqlConnection();
        String sql = "select * from SINHVIEN where UserName='" + str + "'";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            if (rs.next()) {
                idMaSv = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDth.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idMaSv;
    }

    public static boolean getIdMASV(String str) {
        Connection conn = getSqlConnection();
        String sql = "select * from SINHVIEN where MASV Like'" + str + "'";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDth.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    

    public static String getAllCauHoi() {

        List<CauHoi> listCH = new ArrayList<CauHoi>();
        int[] socau = new int[1000];
        Arrays.fill(socau, 0);
        Connection conn = getSqlConnection();
        String sql = "select * from BODE";
        Random rand = new Random();
        int dem = 0;
        int count = getMACH();
        while (dem < 10) {
            int k = rand.nextInt(count);
            if (socau[k] != 1) {
                socau[k] = 1;
                dem++;
            }
        }
        dem = -1;
        String str = "";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next()) {
                dem++;
                if (socau[dem] > 0) {
                    str += rs.getString("CAUHOI");
                    str += "///";
                    str += rs.getString("TRINHDO");
                    str += "///";
                    str += rs.getString("NOIDUNG");
                    str += "///";
                    str += rs.getString("A");
                    str += "///";
                    str += rs.getString("B");
                    str += "///";
                    str += rs.getString("C");
                    str += "///";
                    str += rs.getString("D");
                    str += "///";
                    str += rs.getString("DAP_AN");
                    str += "///";
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDth.class.getName()).log(Level.SEVERE, null, ex);
        }

        return str;
    }

    public static String getAllSV() {
        Connection conn = getSqlConnection();
        String sql = "select * from SINHVIEN ORDER BY DIEM DESC";
        String str = "";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next()) {
                str += rs.getString("MASV");
                str += "///";
                str += rs.getString("HOTEN");
                str += "///";
                str += rs.getString("SODIENTHOAI");
                str += "///";
                str += rs.getString("DIEM");
                str += "///";
                str += rs.getString("NGAYTHI");
                str += "///";

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDth.class.getName()).log(Level.SEVERE, null, ex);
        }

        return str;
    }

    public static boolean getTHONGTINN(String str) {
        boolean check = false;
        Connection conn = getSqlConnection();
        String[] arrStr = str.split("///");
        System.out.println(arrStr[0] + arrStr[1] + arrStr[2] + arrStr[3] + arrStr[4]);
        String sql = "insert into SINHVIEN(MASV,HOTEN,SODIENTHOAI,DIEM,NGAYTHI) values ('" + arrStr[1] + "',N'" + arrStr[0] + "','" + arrStr[2] + "','" + arrStr[3] + "','" + arrStr[4] + "')";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ptsm.executeUpdate();
            if (conn != null) {
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDth.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

//    public static void insertData(String masv, int core) {
//
//        Connection conn = getSqlConnection();
//        String time;
//        java.util.Date now = new java.util.Date();
//        String idMasv = getIdMaSV(masv);
//        int count = getCountUser(idMasv) + 1;
//        time = now.toString();
//        String sql = "insert into SINHVIEN(MASV,DIEM) values ('" + idMasv + "'+'" + core + "')";
//        System.out.println(sql);
//        try {
//            PreparedStatement ptsm = conn.prepareStatement(sql);
//            ptsm.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectDth.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
 
    public static int getMACH() {
        Connection conn = getSqlConnection();
        int count = 0;
        int cauhoi = 0;
        String qlbd = "SELECT * FROM BODE \n";
        try {
            PreparedStatement ptsm = conn.prepareStatement(qlbd);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (Exception e) {
        }
        if (count == 0) {
            return cauhoi;
        } else {
            String sql = "SELECT * FROM BODE \n"
                    + "WHERE CAUHOI not in (SELECT TOP (SELECT COUNT(1)-1 \n"
                    + "                             FROM BODE) \n"
                    + "                        CAUHOI \n"
                    + "                 FROM BODE)";

            try {
                PreparedStatement ptsm = conn.prepareStatement(sql);
                ResultSet rs = ptsm.executeQuery();
                while (rs.next()) {
                    cauhoi = rs.getInt("CAUHOI");
                }
            } catch (Exception e) {
            }
        }
        return cauhoi;
    }
    
    public static Connection getSqlConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=KIEMTRALTM;user=hoangdung;password=123 ";
            Connection conn = DriverManager.getConnection(dbURL);
            System.out.println("Success");
            return conn;
        } catch (SQLException e) {
            System.out.println("login fail");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        // System.out.println(getConnect(loc));

    }

}
