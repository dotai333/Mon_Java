/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edu.cntt.lab02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author PC_33
 */
public class Main {

// Chuỗi kết nối SQL Server
    private static final String URL
            = "jdbc:sqlserver://PC-33\\SQLEXPRESS01:1433;"
            + "databaseName=QLGiaoVu;"
            + "encrypt=true;"
            + "trustServerCertificate=true";

// Tài khoản đăng nhập SQL Server
    private static final String USER = "sa";
// Mật khẩu SQL Server
    private static final String PASSWORD = "123456";

    
    
    public static void main(String[] args) {
        Connection conn = null;
try {
conn = DriverManager.getConnection(URL, USER, PASSWORD);
System.out.println("Kết nối SQL Server thành công.");
} catch (SQLException e) {
System.out.println("Không thể kết nối SQL Server!");
System.out.println(e.getMessage());
}
return conn;
    }

}
