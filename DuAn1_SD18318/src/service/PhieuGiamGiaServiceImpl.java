/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PhieuGiamGia;

/**
 *
 * @author dell
 */
public class PhieuGiamGiaServiceImpl implements PhieuGiamGiaService{

    @Override
    public List<PhieuGiamGia> getAll() {
        List<PhieuGiamGia> list = new ArrayList<>();
        try {
            String database = "DUAN1";
            
            String sql = """
                            SELECT [ID]
                                         ,[MaGG]
                                         ,[HinhThucGG]
                                         ,[GiaTri]
                                         ,[NgayBD]
                                         ,[NgayKT]
                                         ,[NguoiTao]
                                         ,[NguoiSua]
                                         ,[TrangThai]
                                     FROM [dbo].[PhieuGiamGia]
                                 """;
            Connection con = SQLServerConnection.getConnection(database);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuGiamGia gg = new PhieuGiamGia();
                gg.setIdGg(rs.getString(1));
                gg.setMaGg(rs.getString(2));
                gg.setHinhThuc(rs.getString(3));
                gg.setGiaTri(rs.getInt(4));
                gg.setNgayBd(rs.getDate(5));
                gg.setNgayKt(rs.getDate(6));
                gg.setNguoiTao(rs.getString(7));
                gg.setNguoiSua(rs.getString(8));
                gg.setTrangThai(rs.getBoolean(9));
                list.add(gg);
            }
        } catch (SQLException e) {
            
        }
        return list;
    }
    
}
