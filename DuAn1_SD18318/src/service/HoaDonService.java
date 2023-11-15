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
                                 select * from [dbo].[HoaDon]
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
                hd.setGhiChu(rs.getString(16));
                hd.setTrangThai(rs.getBoolean(17));
                list.add(hd);
            }
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        return list;
    }
    
}
