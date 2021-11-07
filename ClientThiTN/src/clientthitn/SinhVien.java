/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientthitn;

public class SinhVien {

    private int sinhvien;
    private String HoTen, SDT, NgayThi;
    private Float Diem;
    private String MaSV;

    public SinhVien() {
    }

    public SinhVien(String MaSV, String HoTen, String SDT, float Diem, String NgayThi) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.Diem = Diem;
        this.NgayThi = NgayThi;

    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMASV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Float getDiem() {
        return Diem;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }

    public String getNgayThi() {
        return NgayThi;
    }

    public void setNgayThi(String NgayThi) {
        this.NgayThi = NgayThi;
    }
}
