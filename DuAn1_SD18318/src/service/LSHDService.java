/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.LichSuHoaDon;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Dung Tran
 */
public class LSHDService {

    public List<LichSuHoaDon> getAll() {
        String sql = """
                    SELECT *
                    FROM LichSuHoaDon lshd
                    JOIN HoaDon hd ON hd.ID = lshd.ID_HD
                    LEFT JOIN NhanVien nv ON nv.ID = hd.ID_NV;
                     """;
        try (Connection c = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<LichSuHoaDon> list = new ArrayList<>();
            while (rs.next()) {
                LichSuHoaDon ls = new LichSuHoaDon();
                ls.setId(rs.getInt(1));
                ls.setIdHD(rs.getInt(2));
                ls.setNgayDat(rs.getDate(3));
                ls.setTongTien(rs.getFloat(4));
                ls.setNgayTao(rs.getDate(5));
                ls.setNgaySua(rs.getDate(6));
                ls.setNguoiTao(rs.getString(7));
                ls.setNguoiSua(rs.getString(8));
                ls.setTrangThai(rs.getBoolean(9));
                list.add(ls);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<LichSuHoaDon> paging(int page, int limit) {
        String sql = "select *  from LichSuHoaDon ORDER BY id "
                + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try (Connection con = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, (page - 1) * limit);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            List<LichSuHoaDon> list = new ArrayList<>();
            while (rs.next()) {
                LichSuHoaDon ls = new LichSuHoaDon();
                ls.setId(rs.getInt(1));
                ls.setIdHD(rs.getInt(2));
                ls.setNgayDat(rs.getDate(3));
                ls.setTongTien(rs.getFloat(4));
                ls.setNgayTao(rs.getDate(5));
                ls.setNgaySua(rs.getDate(6));
                ls.setNguoiTao(rs.getString(7));
                ls.setNguoiSua(rs.getString(8));
                ls.setTrangThai(rs.getBoolean(9));
                list.add(ls);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<LichSuHoaDon> timTheoNgay(java.sql.Date ngayDat) {
    List<LichSuHoaDon> list = new ArrayList<>();
        String sql = """
                     SELECT * FROM LichSuHoaDon
                     WHERE NgayDat BETWEEN ? AND ?;
                     """;
         try (Connection con = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(ngayDat.getTime()));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichSuHoaDon ls = new LichSuHoaDon();
                ls.setId(rs.getInt(1));
                ls.setIdHD(rs.getInt(2));
                ls.setNgayDat(rs.getDate(3));
                ls.setTongTien(rs.getFloat(4));
                ls.setNgayTao(rs.getDate(5));
                ls.setNgaySua(rs.getDate(6));
                ls.setNguoiTao(rs.getString(7));
                ls.setNguoiSua(rs.getString(8));
                ls.setTrangThai(rs.getBoolean(9));
                list.add(ls);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
}
    public List<LichSuHoaDon> search(String ma){
        List<LichSuHoaDon> list = new ArrayList<>();
        String sql = """
                     select 
                     * from LichSuHoaDon lshd
                     join HoaDon hd on hd.ID = lshd.ID_HD
                     where MaHD like ? or TenNguoiNhan like ?
                     """;
         try (Connection con = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,"%"+ ma+"%");
            ps.setObject(2,"%"+ ma+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichSuHoaDon ls = new LichSuHoaDon();
                ls.setId(rs.getInt(1));
                ls.setIdHD(rs.getInt(2));
                ls.setNgayDat(rs.getDate(3));
                ls.setTongTien(rs.getFloat(4));
                ls.setNgayTao(rs.getDate(5));
                ls.setNgaySua(rs.getDate(6));
                ls.setNguoiTao(rs.getString(7));
                ls.setNguoiSua(rs.getString(8));
                ls.setTrangThai(rs.getBoolean(9));
                list.add(ls);            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public LichSuHoaDon getById(int id) {
        List<LichSuHoaDon> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from LichSuHoaDon where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichSuHoaDon ls = new LichSuHoaDon();
                ls.setId(rs.getInt(1));
                ls.setIdHD(rs.getInt(2));
                ls.setNgayDat(rs.getDate(3));
                ls.setTongTien(rs.getFloat(4));
                ls.setNgayTao(rs.getDate(5));
                ls.setNgaySua(rs.getDate(6));
                ls.setNguoiTao(rs.getString(7));
                ls.setNguoiSua(rs.getString(8));
                ls.setTrangThai(rs.getBoolean(9));
                listById.add(ls);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }
    public int countLSHD(){
        String sql = """
                     select count (*) from LichSuHoaDon
                     """;
        int count = 0;
        Connection c = SQLServerConnection.getConnection("DUAN1");
        try {
            PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            count=rs.getInt(1);
        }
        return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public int getMaxPage(int itemsPerPage){
        int totalCount = countLSHD();
        int maxPage = totalCount/itemsPerPage;
        if (totalCount%itemsPerPage!=0) {
            maxPage++;
        }return maxPage;
    }
}
