/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.MonHoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConection;

/**
 *
 * @author pcpv
 */
public class MonHocDAO {
    public List<MonHoc> findAll() {
        List<MonHoc> list = new ArrayList<>();
        String sql = "SELECT * FROM MonHoc";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new MonHoc(rs.getString("MaMH"), rs.getString("TenMH"), rs.getInt("SoTinChi")));
            }
        } catch (Exception e) {
            System.err.println("Lỗi lấy danh sách môn học: " + e.getMessage());
        }
        return list;
    }

    public boolean insert(MonHoc mh) {
        String sql = "INSERT INTO MonHoc(MaMH, TenMH, SoTinChi) VALUES(?, ?, ?)";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mh.getMaMH());
            ps.setString(2, mh.getTenMH());
            ps.setInt(3, mh.getSoTinChi());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi thêm môn học: " + e.getMessage());
        }
        return false;
    }

    public boolean update(String maCu, String maMoi, String tenMoi, int soTinChi) {
        String sql = "UPDATE MonHoc SET MaMH = ?, TenMH = ?, SoTinChi = ? WHERE MaMH = ?";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maMoi);
            ps.setString(2, tenMoi);
            ps.setInt(3, soTinChi);
            ps.setString(4, maCu);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi cập nhật môn học: " + e.getMessage());
        }
        return false;
    }

    // Kiểm tra môn học đã được sinh viên đăng ký hay chưa
    public boolean isMonHocDaDangKy(String maMH) {
        String sql = "SELECT COUNT(*) FROM DangKy WHERE MaMH = ?";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maMH);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            System.err.println("Lỗi kiểm tra đăng ký: " + e.getMessage());
        }
        return false;
    }

    public boolean delete(String maMH) {
        String sql = "DELETE FROM MonHoc WHERE MaMH = ?";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maMH);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Lỗi xóa môn học: " + e.getMessage());
        }
        return false;
    }

    public List<MonHoc> searchMonHoc(String keyword) {
        List<MonHoc> list = new ArrayList<>();
        String sql = "SELECT * FROM MonHoc WHERE MaMH LIKE ? OR TenMH LIKE ?";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MonHoc(rs.getString("MaMH"), rs.getString("TenMH"), rs.getInt("SoTinChi")));
            }
        } catch (Exception e) {
            System.err.println("Lỗi tìm kiếm môn học: " + e.getMessage());
        }
        return list;
    }
}
