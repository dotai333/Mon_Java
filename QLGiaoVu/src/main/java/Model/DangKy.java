/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author pcpv
 */
public class DangKy {
    private String maSV;
    private String hoTen;
    private String maMH;
    private String tenMH;
    private Date ngayDangKy;
    private double diemQT;
    private double diemThi;
    private double diemTK;

    public DangKy() {}

    public DangKy(String maSV, String hoTen, String maMH, String tenMH, Date ngayDangKy, double diemQT, double diemThi, double diemTK) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.ngayDangKy = ngayDangKy;
        this.diemQT = diemQT;
        this.diemThi = diemThi;
        this.diemTK = diemTK;
    }

    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getMaMH() { return maMH; }
    public void setMaMH(String maMH) { this.maMH = maMH; }
    public String getTenMH() { return tenMH; }
    public void setTenMH(String tenMH) { this.tenMH = tenMH; }
    public Date getNgayDangKy() { return ngayDangKy; }
    public void setNgayDangKy(Date ngayDangKy) { this.ngayDangKy = ngayDangKy; }
    public double getDiemQT() { return diemQT; }
    public void setDiemQT(double diemQT) { this.diemQT = diemQT; }
    public double getDiemThi() { return diemThi; }
    public void setDiemThi(double diemThi) { this.diemThi = diemThi; }
    public double getDiemTK() { return diemTK; }
    public void setDiemTK(double diemTK) { this.diemTK = diemTK; }
}
