/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.DangKy;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConection;

/**
 *
 * @author pcpv
 */
public class DangKyDAO {
    public List<DangKy> findAll() {
        List<DangKy> list = new ArrayList<>();
        String sql = "SELECT dk.MaSV, sv.HoTen, dk.MaMH, mh.TenMH, dk.NgayDangKy, dk.DiemQuaTrinh, dk.DiemThi, dk.DiemTongKet "
                   + "FROM DANGKY dk "
                   + "JOIN SINHVIEN sv ON dk.MaSV = sv.MaSV "
                   + "JOIN MONHOC mh ON dk.MaMH = mh.MaMH";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                list.add(new DangKy(
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("MaMH"),
                    rs.getString("TenMH"),
                    rs.getDate("NgayDangKy"),
                    rs.getDouble("DiemQuaTrinh"),
                    rs.getDouble("DiemThi"),
                    rs.getDouble("DiemTongKet")
                ));
            }
        } catch (Exception e) {
            System.out.println("Lỗi đọc danh sách đăng ký: " + e.getMessage());
        }
        return list;
    }

    // Kiểm tra trùng khóa chính (MaSV, MaMH)
    public boolean checkExisted(String maSV, String maMH) {
        String sql = "SELECT COUNT(*) FROM DANGKY WHERE MaSV = ? AND MaMH = ?";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSV);
            ps.setString(2, maMH);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            System.out.println("Lỗi kiểm tra đăng ký: " + e.getMessage());
        }
        return false;
    }

    // Thêm bản ghi đăng ký vào CSDL (Chỉ lưu MaSV, MaMH, ngày và điểm)
    public boolean insert(DangKy dk) {
        String sql = "INSERT INTO DANGKY(MaSV, MaMH, NgayDangKy, DiemQuaTrinh, DiemThi, DiemTongKet) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dk.getMaSV());
            ps.setString(2, dk.getMaMH());
            ps.setDate(3, new Date(dk.getNgayDangKy().getTime()));
            ps.setDouble(4, dk.getDiemQT());
            ps.setDouble(5, dk.getDiemThi());
            ps.setDouble(6, dk.getDiemTK());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi thêm đăng ký: " + e.getMessage());
        }
        return false;
    }

    // Cập nhật thông tin đăng ký
    public boolean update(DangKy dk) {
        String sql = "UPDATE DANGKY SET NgayDangKy = ?, DiemQuaTrinh = ?, DiemThi = ?, DiemTongKet = ? WHERE MaSV = ? AND MaMH = ?";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, new Date(dk.getNgayDangKy().getTime()));
            ps.setDouble(2, dk.getDiemQT());
            ps.setDouble(3, dk.getDiemThi());
            ps.setDouble(4, dk.getDiemTK());
            ps.setString(5, dk.getMaSV());
            ps.setString(6, dk.getMaMH());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi cập nhật đăng ký: " + e.getMessage());
        }
        return false;
    }

    // Xóa đăng ký
    public boolean delete(String maSV, String maMH) {
        String sql = "DELETE FROM DANGKY WHERE MaSV = ? AND MaMH = ?";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSV);
            ps.setString(2, maMH);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi xóa đăng ký: " + e.getMessage());
        }
        return false;
    }

    // Tìm kiếm theo MaSV, Họ tên SV hoặc Tên MH
    public List<DangKy> search(String keyword) {
        List<DangKy> list = new ArrayList<>();
        String sql = "SELECT dk.MaSV, sv.HoTen, dk.MaMH, mh.TenMH, dk.NgayDangKy, dk.DiemQuaTrinh, dk.DiemThi, dk.DiemTongKet "
                   + "FROM DANGKY dk "
                   + "JOIN SINHVIEN sv ON dk.MaSV = sv.MaSV "
                   + "JOIN MONHOC mh ON dk.MaMH = mh.MaMH "
                   + "WHERE dk.MaSV LIKE ? OR sv.HoTen LIKE ? OR mh.TenMH LIKE ?";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DangKy(
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("MaMH"),
                    rs.getString("TenMH"),
                    rs.getDate("NgayDangKy"),
                    rs.getDouble("DiemQuaTrinh"),
                    rs.getDouble("DiemThi"),
                    rs.getDouble("DiemTongKet")
                ));
            }
        } catch (Exception e) {
            System.out.println("Lỗi tìm kiếm đăng ký: " + e.getMessage());
        }
        return list;
    }
}
