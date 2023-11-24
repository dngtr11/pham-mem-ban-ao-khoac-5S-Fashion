/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.SanPhamChiTiet;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham;

/**
 *
 * @author anh
 */
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {

    @Override
    public List<SanPhamChiTiet> getAll() {
        List<SanPhamChiTiet> listSpct = new ArrayList<>();
        try {
            String database = "DUAN1";
            String sql = """
                                    SELECT [ID]
                                              ,[ID_SP]
                                              ,[ID_NSX]
                                              ,[ID_MS]
                                              ,[ID_CL]
                                              ,[ID_Size]
                                              ,[ID_Mu]
                                              ,[ID_KD]
                                              ,[ID_Lop]
                                              ,[ID_CTDC]
                                              ,[MoTa]
                                              ,[SoLuong]
                                              ,[Gia]
                                              ,[NguoiTao]
                                              ,[NguoiSua]
                                              ,[NgayTao]
                                              ,[NgaySua]
                                              ,[TrangThai]
                                          FROM [dbo].[SanPhamChiTiet]
                                 """;
            Connection con = SQLServerConnection.getConnection(database);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setMoTa(rs.getString(11));
                spct.setGia(rs.getFloat(13));
                spct.setSoLuong(rs.getInt(12));
                spct.setTrangThai(rs.getBoolean(18));
                spct.setId(rs.getInt(1));
                spct.setIdSp(rs.getInt(2));
                spct.setIdNsx(rs.getInt(3));
                spct.setIdMs(rs.getInt(4));
                spct.setIdCl(rs.getInt(5));
                spct.setIdSize(rs.getInt(6));
                spct.setIdMs(rs.getInt(7));
                spct.setIdKd(rs.getInt(8));
                spct.setIdLop(rs.getInt(9));
                spct.setIdCtdc(rs.getInt(10));
                spct.setNguoiTao(rs.getString(14));
                spct.setNguoiSua(rs.getString(15));
                spct.setNgayTao(rs.getDate(16));
                spct.setNgaySua(rs.getDate(17));
                listSpct.add(spct);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listSpct;
    }

    @Override
    public List<SanPhamChiTiet> phanTrang(int page, int limit) {
        String sql = "SELECT * FROM [dbo].[SanPhamChiTiet] ORDER BY id "
                + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        /*
         * limit: 2
         * OFFSET: số bản ghi bỏ qua
         * page 1: 1-2 -> bỏ qua 0
         * page 2: 3-4 -> bỏ qua 2 = (2-1) * 2
         * page 3: 5-6 -> bỏ qua 4 = (3-1) * 2
         * page 4: 7-8 -> bỏ qua 6 = (4-1) * 2
         */
        try ( Connection con = SQLServerConnection.getConnection("DUAN1");  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, (page - 1) * limit);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            List<SanPhamChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setMoTa(rs.getString(11));
                spct.setGia(rs.getFloat(13));
                spct.setSoLuong(rs.getInt(12));
                spct.setTrangThai(rs.getBoolean(18));
                spct.setId(rs.getInt(1));
                spct.setIdSp(rs.getInt(2));
                spct.setIdNsx(rs.getInt(3));
                spct.setIdMs(rs.getInt(4));
                spct.setIdCl(rs.getInt(5));
                spct.setIdSize(rs.getInt(6));
                spct.setIdMs(rs.getInt(7));
                spct.setIdKd(rs.getInt(8));
                spct.setIdLop(rs.getInt(9));
                spct.setIdCtdc(rs.getInt(10));
                spct.setNguoiTao(rs.getString(14));
                spct.setNguoiSua(rs.getString(15));
                spct.setNgayTao(rs.getDate(16));
                spct.setNgaySua(rs.getDate(17));
                list.add(spct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int countSpct() {
        Connection cn = SQLServerConnection.getConnection("DUAN1");
        String sql = "select count(*) from SanPhamChiTiet";
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

    @Override
    public int getMaxPages(int itemsPerPage) {
        int totalCount = countSpct();
        int maxPages = totalCount / itemsPerPage;
        if (totalCount % itemsPerPage != 0) {
            maxPages++;
        }
        return maxPages;
    }

    @Override
    public List<SanPhamChiTiet> search(String ma) {
        List<SanPhamChiTiet> list = new ArrayList<>();
        try {
            String sqlSearch = """
                                          select *
                                              from SanPhamChiTiet join SanPham on SanPhamChiTiet.ID_SP = SanPham.ID
                                              where MaSP like ? or TenSP like ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sqlSearch);
            ps.setObject(1, "%" + ma + "%");
            ps.setObject(2, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setMoTa(rs.getString(11));
                spct.setGia(rs.getFloat(13));
                spct.setSoLuong(rs.getInt(12));
                spct.setTrangThai(rs.getBoolean(18));
                spct.setId(rs.getInt(1));
                spct.setIdSp(rs.getInt(2));
                spct.setIdNsx(rs.getInt(3));
                spct.setIdMs(rs.getInt(4));
                spct.setIdCl(rs.getInt(5));
                spct.setIdSize(rs.getInt(6));
                spct.setIdMs(rs.getInt(7));
                spct.setIdKd(rs.getInt(8));
                spct.setIdLop(rs.getInt(9));
                spct.setIdCtdc(rs.getInt(10));
                spct.setNguoiTao(rs.getString(14));
                spct.setNguoiSua(rs.getString(15));
                spct.setNgayTao(rs.getDate(16));
                spct.setNgaySua(rs.getDate(17));
                list.add(spct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamChiTietServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public SanPhamChiTiet get_By_ID(int id) {
        List<SanPhamChiTiet> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from SanPhamChiTiet where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setMoTa(rs.getString(11));
                spct.setGia(rs.getFloat(13));
                spct.setSoLuong(rs.getInt(12));
                spct.setTrangThai(rs.getBoolean(18));
                spct.setId(rs.getInt(1));
                spct.setIdSp(rs.getInt(2));
                spct.setIdNsx(rs.getInt(3));
                spct.setIdMs(rs.getInt(4));
                spct.setIdCl(rs.getInt(5));
                spct.setIdSize(rs.getInt(6));
                spct.setIdMs(rs.getInt(7));
                spct.setIdKd(rs.getInt(8));
                spct.setIdLop(rs.getInt(9));
                spct.setIdCtdc(rs.getInt(10));
                spct.setNguoiTao(rs.getString(14));
                spct.setNguoiSua(rs.getString(15));
                spct.setNgayTao(rs.getDate(16));
                spct.setNgaySua(rs.getDate(17));
                listById.add(spct);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }

    @Override
    public List<SanPhamChiTiet> getAllByName(String name) {
        List<SanPhamChiTiet> list = new ArrayList<>();
        try {
            String sqlSearch = """
                            select *
                                   from SanPhamChiTiet join SanPham on SanPhamChiTiet.ID_SP = SanPham.ID
                                   where SanPham.TenSP = ?
                                           
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sqlSearch);
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setMoTa(rs.getString(11));
                spct.setGia(rs.getFloat(13));
                spct.setSoLuong(rs.getInt(12));
                spct.setTrangThai(rs.getBoolean(18));
                spct.setId(rs.getInt(1));
                spct.setIdSp(rs.getInt(2));
                spct.setIdNsx(rs.getInt(3));
                spct.setIdMs(rs.getInt(4));
                spct.setIdCl(rs.getInt(5));
                spct.setIdSize(rs.getInt(6));
                spct.setIdMs(rs.getInt(7));
                spct.setIdKd(rs.getInt(8));
                spct.setIdLop(rs.getInt(9));
                spct.setIdCtdc(rs.getInt(10));
                spct.setNguoiTao(rs.getString(14));
                spct.setNguoiSua(rs.getString(15));
                spct.setNgayTao(rs.getDate(16));
                spct.setNgaySua(rs.getDate(17));
                list.add(spct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
