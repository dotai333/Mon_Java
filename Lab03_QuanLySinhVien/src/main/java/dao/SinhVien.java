/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dao;

import java.util.Date;

/**
 *
 * @author PC_33
 */
public class SinhVien {

    private String maSV;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private String maKhoa;

    public SinhVien(String maSV) {
        this.maSV = maSV;
    }

    public SinhVien(String maSV, String hoTen, Date NgaySinh, boolean gioiTinh, String diaChi, String maKhoa) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = NgaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.maKhoa = maKhoa;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.ngaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
    
   @Override
   public String toString() {
   return String.format("%-10s %-20s %-12s %-6s %-20s %-10s%n",
           maSV, hoTen, ngaySinh, gioiTinh ? "Nam" : "Nữ", diaChi, maKhoa);
   }
}
