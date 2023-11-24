/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.SanPham;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author anh
 */
public class SanPhamServiceImpl implements SanPhamService{

    @Override
    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();
        try {
            String database = "DUAN1";
            
            String sql = """
                                 SELECT [ID]
                                       ,[MaSP]
                                       ,[TenSP]
                                   FROM [dbo].[SanPham]
                                 """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSp(rs.getInt(1));
                sp.setMaSp(rs.getString(2));
                sp.setTenSp(rs.getString(3));
                list.add(sp);
            }
        } catch (SQLException e) {
            
        }
        return list;
    }

    @Override
    public SanPham getById(int id) {
        List<SanPham> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from SanPham where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSp(rs.getInt(1));
                sp.setMaSp(rs.getString(2));
                sp.setTenSp(rs.getString(3));
                listById.add(sp);
                
            } 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (!listById.isEmpty()) {
            return listById.get(0);
        }
        return null;
    }

    @Override
    public List<SanPham> phanTrang(int page, int limit) {
        String sql = "SELECT * FROM [dbo].[SanPham] ORDER BY id "
                + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        /*
         * limit: 2
         * OFFSET: số bản ghi bỏ qua
         * page 1: 1-2 -> bỏ qua 0
         * page 2: 3-4 -> bỏ qua 2 = (2-1) * 2
         * page 3: 5-6 -> bỏ qua 4 = (3-1) * 2
         * page 4: 7-8 -> bỏ qua 6 = (4-1) * 2
         */
        try (Connection con = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,  (page - 1) * limit);
            ps.setInt(2,  limit);
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSp(rs.getInt(1));
                sp.setMaSp(rs.getString(2));
                sp.setTenSp(rs.getString(3));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
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

    @Override
    public int getMaxPagesSp(int itemsPerPage) {
        int totalCount = countSp();
        int maxPages = totalCount / itemsPerPage;
        if (totalCount % itemsPerPage != 0) {
            maxPages++;
        }
        return maxPages;
    }

    @Override
    public List<SanPham> search(String ma) {
        List<SanPham> list = new ArrayList<>();
        try {
            String sqlSearch = """
                                        SELECT  sp.ID, MaSP,TenSP,sum(SoLuong) as 'SL'
                                            FROM SanPhamChiTiet spct join SanPham sp on spct.ID_SP = sp.ID
                                            where MaSP like ? or TenSP like ?
                                            Group by sp.ID, MaSP,TenSP
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sqlSearch);
            ps.setObject(1, "%"+ma+"%");
            ps.setObject(2, "%"+ma+"%");
            int sl=0;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getString(1));
                sp.setMaSp(rs.getString(2));
                sp.setTenSp(rs.getString(3));
                sl=rs.getInt("SL");
                list.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int getSoLuongByID(int id) {
        
        try {
            String database = "DUAN1";
            
            String sql = """
                                 SELECT  sp.ID, MaSP,TenSP,sum(SoLuong) as 'SL'
                                            FROM SanPhamChiTiet spct join SanPham sp on spct.ID_SP = sp.ID
                                        	where sp.ID = ?
                                        	Group by sp.ID, MaSP,TenSP
                                 """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            int sl=0;
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                sl=rs.getInt("SL");
                System.out.println(sl);
            }
            
            return sl;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public String addSP(SanPham sp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
   
}
