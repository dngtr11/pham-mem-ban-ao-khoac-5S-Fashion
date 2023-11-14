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
                sp.setMaSp(rs.getString(1));
                sp.setMaSp(rs.getString(2));
                sp.setTenSp(rs.getString(3));
                list.add(sp);
            }
        } catch (SQLException e) {
            
        }
        return list;
    }
    
}
