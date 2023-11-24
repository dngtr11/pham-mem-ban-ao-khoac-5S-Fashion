/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.KhachHang;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Dung Tran
 */
public class KhachHangService {

    public List<KhachHang> getAll() {
        String sql = """
                     select * from KhachHang
                     """;
        try (Connection c = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt(1));
                kh.setMaKH(rs.getString(2));
                kh.setTenKH(rs.getString(3));
                kh.setGioiTinh(rs.getBoolean(4));
                kh.setNgaySinh(rs.getDate(5));
                kh.setSdt(rs.getString(6));
                kh.setEmail(rs.getString(7));
                kh.setDiaChi(rs.getString(8));
                kh.setNgayTao(rs.getDate(9));
                kh.setNgaySua(rs.getDate(10));
                kh.setNguoiTao(rs.getString(11));
                kh.setNguoiSua(rs.getString(12));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhachHang getByID(int id) {
        String Get_By_ID = """
                     select * from KhachHang where id = ?
                     """;
        List<KhachHang> listByID = new ArrayList<>();
        try (Connection c = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = c.prepareStatement(Get_By_ID)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt(1));
                kh.setMaKH(rs.getString(2));
                kh.setTenKH(rs.getString(3));
                kh.setGioiTinh(rs.getBoolean(4));
                kh.setNgaySinh(rs.getDate(5));
                kh.setSdt(rs.getString(6));
                kh.setEmail(rs.getString(7));
                kh.setDiaChi(rs.getString(8));
                kh.setNgayTao(rs.getDate(9));
                kh.setNgaySua(rs.getDate(10));
                kh.setNguoiTao(rs.getString(11));
                kh.setNguoiSua(rs.getString(12));
                listByID.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listByID.get(0);
    }
}
