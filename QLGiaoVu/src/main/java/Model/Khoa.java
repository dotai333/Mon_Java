/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Objects;


/**
 *
 * @author PC_33
 */
public class Khoa {
    private String maKhoa;
    private String tenKhoa;

    public Khoa() {
    }  

    public Khoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }   
    
    public Khoa(String maKhoa, String tenKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    @Override
    public String toString() {
        return  maKhoa + " - " + tenKhoa ;
    }  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Khoa other = (Khoa) obj;
        return Objects.equals(this.maKhoa, other.maKhoa);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.maKhoa);
        hash = 41 * hash + Objects.hashCode(this.tenKhoa);
        return hash;
    }

}
