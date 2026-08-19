/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC_33
 */
public class DBConection {

    private static final String URL
            = "jdbc:sqlserver://localhost;databaseName=QLGiaoVu;encrypt=true;trustServerCertificate=true;"
            + "databaseName=QLGiaoVu;"
            + "encrypt=true;"
            + "trustServerCertificate=true";

// Tài khoản đăng nhập SQL Server
    private static final String USER = "sa";
// Mật khẩu SQL Server
    private static final String PASSWORD = "123456";
    public static Connection getConnection() {
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
