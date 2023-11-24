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
 *
 */
public class KhachHangService {

    public List<KhachHang> getAll() {
        String sql = """
                     select * from KhachHang
                     """;
        try ( Connection c = SQLServerConnection.getConnection("DUAN1");  PreparedStatement ps = c.prepareStatement(sql)) {
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
                kh.setTrangThai(rs.getBoolean(13));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhachHang> paging(int page, int limit) {
        String sql = """
                      SELECT *
                         
                            FROM [dbo].[KhachHang] ORDER BY ID
                     """ + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try ( Connection con = SQLServerConnection.getConnection("DUAN1");  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, (page - 1) * limit);
            ps.setInt(2, limit);
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

    public Integer addKH(KhachHang kh) {
        Integer row = null;
        String sql = """
                     INSERT INTO KhachHang
                                (MaKH,HoTen,GioiTinh,NgaySinh,SDT,Email,DiaChi)
                          VALUES
                                (?,?,?,?,?,?,?)
                     """;
        try (
                 Connection con = SQLServerConnection.getConnection("DUAN1");  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh.getMaKH());
            ps.setObject(2, kh.getTenKH());
            ps.setObject(3, kh.isGioiTinh());
            ps.setObject(4, kh.getNgaySinh());
            ps.setObject(5, kh.getSdt());
            ps.setObject(6, kh.getEmail());
            ps.setObject(7, kh.getDiaChi());

            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer update(KhachHang kh) {
        Integer row = null;
        String sql = "update KhachHang\n"
                + "set  HoTen =?,GioiTinh=?,NgaySinh=?,SDT=?,Email=?,DiaChi=?\n"
                + "where MaKH =?";
        Connection con = SQLServerConnection.getConnection("DUAN1");
        try {
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setObject(7, kh.getMaKH());
            pstm.setObject(1, kh.getTenKH());
            pstm.setObject(2, kh.isGioiTinh());
            pstm.setObject(3, kh.getNgaySinh());
            pstm.setObject(4, kh.getSdt());
            pstm.setObject(5, kh.getEmail());
            pstm.setObject(6, kh.getDiaChi());

            row = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public boolean delete(String maKH) {
        Integer row = 0;
        String sql = "delete from KhachHang where MaKH=?";
        Connection con = SQLServerConnection.getConnection("DUAN1");
        try {
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, maKH);

            row = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return row>0;
    }
    public int countSp() {
        Connection cn = SQLServerConnection.getConnection("DUAN1");
        String sql = "select count(*) from SanPham";
        int count = 0;
        try {

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getMaxPagesSp(int itemsPerPage) {
        int totalCount = countSp();
        int maxPages = totalCount / itemsPerPage;
        if (totalCount % itemsPerPage != 0) {
            maxPages++;
        }
        return maxPages;
    }
}
