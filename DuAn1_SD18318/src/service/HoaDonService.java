/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.HoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dung Tran
 */
public class HoaDonService {
   public List<HoaDon> getAll(){
        List<HoaDon> list = new ArrayList<>();
        try {
            String sql = """
                                 select * from HoaDon
                                 """;
            Connection c = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getInt(1));
                hd.setMaHD(rs.getString(2));
                hd.setIdKH(rs.getInt(3));
                hd.setIdNV(rs.getInt(4));
                hd.setIdGG(rs.getInt(5));
                hd.setTenNguoiNhan(rs.getString(6));
                hd.setSDT(rs.getString(7));
                hd.setTongTien(rs.getFloat(8));
                hd.setNgayDat(rs.getDate(9));
                hd.setNgayGiao(rs.getDate(10));
                hd.setNgayTao(rs.getDate(11));
                hd.setNgaySua(rs.getDate(12));
                hd.setNguoiTao(rs.getString(13));
                hd.setNguoiSua(rs.getString(14));
                hd.setPhiVanChuyen(rs.getFloat(15));
                hd.setHinhThuc(rs.getString(16));
                hd.setDiaChi(rs.getString(17));
                hd.setGhiChu(rs.getString(18));
                hd.setTrangThai(rs.getBoolean(19));
                list.add(hd);
            }
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        return list;
    }
    public List<HoaDon> paging(int page, int limit) {
        String sql = "select * from HoaDon ORDER BY MaHD "
                + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        
        try (Connection con = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,  (page - 1) * limit);
            ps.setInt(2,  limit);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getInt(1));
                hd.setMaHD(rs.getString(2));
                hd.setIdKH(rs.getInt(3));
                hd.setIdNV(rs.getInt(4));
                hd.setIdGG(rs.getInt(5));
                hd.setTenNguoiNhan(rs.getString(6));
                hd.setSDT(rs.getString(7));
                hd.setTongTien(rs.getFloat(8));
                hd.setNgayDat(rs.getDate(9));
                hd.setNgayGiao(rs.getDate(10));
                hd.setNgayTao(rs.getDate(11));
                hd.setNgaySua(rs.getDate(12));
                hd.setNguoiTao(rs.getString(13));
                hd.setNguoiSua(rs.getString(14));
                hd.setPhiVanChuyen(rs.getFloat(15));
                hd.setHinhThuc(rs.getString(16));
                hd.setDiaChi(rs.getString(17));
                hd.setGhiChu(rs.getString(18));
                hd.setTrangThai(rs.getBoolean(19));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HoaDon getById(int id) {
        List<HoaDon> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from HoaDon where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getInt(1));
                hd.setMaHD(rs.getString(2));
                hd.setIdKH(rs.getInt(3));
                hd.setIdNV(rs.getInt(4));
                hd.setIdGG(rs.getInt(5));
                hd.setTenNguoiNhan(rs.getString(6));
                hd.setSDT(rs.getString(7));
                hd.setTongTien(rs.getFloat(8));
                hd.setNgayDat(rs.getDate(9));
                hd.setNgayGiao(rs.getDate(10));
                hd.setNgayTao(rs.getDate(11));
                hd.setNgaySua(rs.getDate(12));
                hd.setNguoiTao(rs.getString(13));
                hd.setNguoiSua(rs.getString(14));
                hd.setPhiVanChuyen(rs.getFloat(15));
                hd.setHinhThuc(rs.getString(16));
                hd.setDiaChi(rs.getString(17));
                hd.setGhiChu(rs.getString(18));
                hd.setTrangThai(rs.getBoolean(19));
                listById.add(hd);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }
    public List<HoaDon> search(String ma){
        List<HoaDon> list = new ArrayList<>();
        String sql = """
                     select * 
                     from HoaDon hd
                     join NhanVien nv on nv.ID = hd.ID_NV
                     where MaHD like ? or MaNV like ?;
                     """;
         try (Connection con = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,"%"+ ma+"%");
            ps.setObject(2,"%"+ ma+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getInt(1));
                hd.setMaHD(rs.getString(2));
                hd.setIdKH(rs.getInt(3));
                hd.setIdNV(rs.getInt(4));
                hd.setIdGG(rs.getInt(5));
                hd.setTenNguoiNhan(rs.getString(6));
                hd.setSDT(rs.getString(7));
                hd.setTongTien(rs.getFloat(8));
                hd.setNgayDat(rs.getDate(9));
                hd.setNgayGiao(rs.getDate(10));
                hd.setNgayTao(rs.getDate(11));
                hd.setNgaySua(rs.getDate(12));
                hd.setNguoiTao(rs.getString(13));
                hd.setNguoiSua(rs.getString(14));
                hd.setPhiVanChuyen(rs.getFloat(15));
                hd.setHinhThuc(rs.getString(16));
                hd.setDiaChi(rs.getString(17));
                hd.setGhiChu(rs.getString(18));
                hd.setTrangThai(rs.getBoolean(19));
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<HoaDon> timTheoNgay(java.sql.Date ngayDat,java.sql.Date ngayGiao) {
    List<HoaDon> list = new ArrayList<>();
        String sql = """
                     SELECT * FROM HoaDon
                     WHERE NgayDat BETWEEN ? AND ?;
                     """;
         try (Connection con = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(ngayDat.getTime()));
            ps.setDate(2, new java.sql.Date(ngayGiao.getTime()));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getInt(1));
                hd.setMaHD(rs.getString(2));
                hd.setIdKH(rs.getInt(3));
                hd.setIdNV(rs.getInt(4));
                hd.setIdGG(rs.getInt(5));
                hd.setTenNguoiNhan(rs.getString(6));
                hd.setSDT(rs.getString(7));
                hd.setTongTien(rs.getFloat(8));
                hd.setNgayDat(rs.getDate(9));
                hd.setNgayGiao(rs.getDate(10));
                hd.setNgayTao(rs.getDate(11));
                hd.setNgaySua(rs.getDate(12));
                hd.setNguoiTao(rs.getString(13));
                hd.setNguoiSua(rs.getString(14));
                hd.setPhiVanChuyen(rs.getFloat(15));
                hd.setHinhThuc(rs.getString(16));
                hd.setDiaChi(rs.getString(17));
                hd.setGhiChu(rs.getString(18));
                hd.setTrangThai(rs.getBoolean(19));
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
}
    public int countHoaDon(){
        String sql = """
                     select count (*) from HoaDon
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
        int totalCount = countHoaDon();
        int maxPage = totalCount/itemsPerPage;
        if (totalCount%itemsPerPage!=0) {
            maxPage++;
        }return maxPage;
    }
}
