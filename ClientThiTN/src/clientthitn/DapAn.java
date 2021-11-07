/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientthitn;


public class DapAn {
     public static int dapancuaban;
      public static int diem;
       public static int dapan;
    String DapAnCuaBan ;
    int Diem;
    String Dapan;

    public DapAn(String DapAnCuaBan, int Diem, String Dapan) {
        this.DapAnCuaBan = DapAnCuaBan;
        this.Diem = Diem;
        this.Dapan = Dapan;
    }
    public DapAn(){
        
    }

    public String getDapan() {
        return Dapan;
    }

    public void setDapan(String Dapan) {
        this.Dapan = Dapan;
    }

    public DapAn(String Dapan) {
        this.Dapan = Dapan;
    }

    public String getDapAnCuaBan() {
        return DapAnCuaBan;
    }

    public void setDapAnCuaBan(String DapAnCuaBan) {
        this.DapAnCuaBan = DapAnCuaBan;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int Diem) {
        this.Diem = Diem;
    }

    public DapAn(String DapAnCuaBan, int Diem) {
        this.DapAnCuaBan = DapAnCuaBan;
        this.Diem = Diem;
    }
}
