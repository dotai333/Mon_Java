///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package edu.cntt.lab03;
//
//import dao.SinhVien;
//import dao.SinhVienDao;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Scanner;
//import java.util.Date;
//
///**
// *
// * @author PC_33
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int choice;
//        do {
//            menu();
//            choice = Integer.parseInt(sc.nextLine());
//            switch (choice) {
//                case 1:
//                    System.err.println("Hiển thị danh sách sinh viên");
//                    hienThiDanhSach();
//                    break;
//                
//                case 2:
//                    themSinhVien();
//                    break;
//                case 3: 
//                    capNhatSinhVien();
//                    break;
//                case 4: 
//                    xoaSinhVien();
//                    break;
//                case 5:
//                timSinhVienTheoMa();
//                break;
//                case 6: 
//                    timSinhVienTheoTen();
//                    break;
//                case 0:
//                    System.out.println("Kết thúc chương trình.");
//                    break;
//                default:
//                    System.out.println("Lựa chọn không hợp lệ");
//            }
//        }while (choice != 0);
//    }
//    
//    public static void menu(){
//        System.out.println();
//        System.out.println("=====================================");
//        System.out.println(" QUẢN LÝ SINH VIÊN ");
//        System.out.println("=====================================");
//        System.out.println("1. Hiển thị danh sách sinh viên");
//        System.out.println("2. Thêm Sinh Viên");
//        System.out.println("3. Cập nhật Sinh Viên");
//        System.out.println("4. Xóa Sinh Viên");
//        System.out.println("5. Tìm Sinh Viên theo mã");
//        System.out.println("6. Tìm Sinh Viên theo tên");
//        System.out.println("0. Thoát !!!");
//        System.out.println("=====================================");
//        System.out.println("Nhập lựa chọn: ");
//    }
//    
//    public static void hienThiDanhSach() throws SQLException {
//        SinhVienDao svDao = new SinhVienDao();
//        var ds = svDao.findAll();
//        System.out.println();
//        System.out.println("DANH SÁCH SINH VIÊN");
//        System.out.println("=====================================");
//        System.out.printf("%-10s %-20s %-12s %-6s %-20s %-10s%n",
//                "Mã SV", "Họ tên", "Ngày sinh", "GT", "Địa chỉ", "Khoa");
//        
//        for (SinhVien sv : ds){
//            System.out.println(sv);
//        }
//    }
//    
//    public static void themSinhVien(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("THÊM SINH VIÊN");
//        
//        System.out.print("Mã Sinh Viên: ");
//        String maSV = sc.nextLine();
//        
//        System.out.print("Ngày sinh (dd/MM/yyyy):  ");
//        String ngaySinhStr = sc.nextLine();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date ngaySinh = null;
//        
//        try {
//            ngaySinh = sdf.parse(ngaySinhStr);
//        } catch (ParseException ex) {
//            System.out.println("Kiểu không hợp lệ");
//        }
//        
//        System.out.print("Giới tính ( ");
//        String hoTen = sc.nextLine();
//        System.out.println("Họ tên: ");
//        String hoTen = sc.nextLine();
//        System.out.println("Họ tên: ");
//        String hoTen = sc.nextLine();
//        System.out.println("Họ tên: ");
//        String hoTen = sc.nextLine();
//    }
//        
//    
//}
