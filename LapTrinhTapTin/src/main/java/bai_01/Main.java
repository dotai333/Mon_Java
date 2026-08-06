/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bai_01;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author PC_33
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<SinhVien> dsSinhVien = new ArrayList();
        dsSinhVien.add(new SinhVien ("SV01", "Trần Minh Thông", 8.5));
        dsSinhVien.add(new SinhVien ("SV02", "Lê Thị Thương", 7.0));
        dsSinhVien.add(new SinhVien ("SV03", "Nguyễn Văn Cường", 8.0));
        dsSinhVien.add(new SinhVien ("SV04", "Trần Văn An", 9.5));
        dsSinhVien.add(new SinhVien ("SV05", "Nguyễn Văn Mạnh", 4.5));
        dsSinhVien.add(new SinhVien ("SV06", "Trần Thị Tâm", 6.5));

        //Xuất ra màn hình Console
        System.out.println("==========DANH SACH SINH VIEN==========");
        for (SinhVien sv : dsSinhVien)
        {
            System.err.println(sv.getMaSV() + ";" + sv.getHoTen() + ";" + sv.getDiemTB());
        }
        
        //Xuất ra tập tin SinhVien.txt
        
        try {
            FileWriter fw = new FileWriter("sinhvien.txt");
            for (SinhVien sv: dsSinhVien)
            {
                fw.write(sv.getMaSV() + ";" + sv.getHoTen() + ";" + sv.getDiemTB() + "\n"); 
            }
            fw.close();
            System.out.println("Ghi danh sach sinh vien ra tap tin sinhvien.txt thanh cong");       
        } catch (Exception ex) {
            System.out.println("Ghi sinh vien that bai");
            System.out.println("Loi:" + ex.toString());
        }
    }
}
