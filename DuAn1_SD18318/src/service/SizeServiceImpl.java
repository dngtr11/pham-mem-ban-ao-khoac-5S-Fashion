
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Size;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anh
 */
public class SizeServiceImpl implements SizeService {

    @Override
    public List<Size> getAll() {
        List<Size> listSize = new ArrayList<>();
        try {
            String database = "DUAN1";
            String sql = """
                                 SELECT [ID]
                                       ,[MaS]
                                       ,[TenS]
                                       ,[TrangThai]
                                   FROM [dbo].[Size]
                                   order by id desc
                                 """;
            Connection con = SQLServerConnection.getConnection(database);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Size s = new Size();
                s.setMaSize(rs.getString(2));
                s.setTenSize(rs.getString(3));
                s.setTrangThaiSize(rs.getBoolean(4));
                listSize.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSize;
    }

    @Override
    public Size get_By_Id(int id) {
        List<Size> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from Size where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Size s = new Size();
                s.setMaSize(rs.getString(2));
                s.setTenSize(rs.getString(3));
                s.setTrangThaiSize(rs.getBoolean(4));
                listById.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }

    @Override
    public String AddSize(Size s) {
        List<Size> listS = new ArrayList<>();
        try {
            String sql = """
                                 INSERT INTO [dbo].[Size]
                                            ([MaS]
                                            ,[TenS]
                                            ,[TrangThai])
                                      VALUES
                                            (?,?,?)
                                 """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, s.getMaSize());
            ps.setObject(2, s.getTenSize());
            ps.setObject(3, s.isTrangThaiSize());
            if (ps.executeUpdate() < 1) {
                return "add that bai";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Add Thành Công";
    }

    @Override
    public String xoaSize(Size s) {
        String sqlDelete = """
                           DELETE FROM [dbo].[Size]
                                             WHERE id = ?
                           """;
        try ( Connection conNect = SQLServerConnection.getConnection("DUAN1");  PreparedStatement ps = conNect.prepareStatement(sqlDelete)) {
            ps.setObject(1, s.getIdSize());
            if (ps.executeUpdate() < 1) {
                return "xoa that bai";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "chuong trinh co loi";
        }
        return "xoa thanh cong";
    }

    @Override
    public String suaSize(String maCu, Size s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Size> getSize() {
        List<Size> list = new ArrayList<>();
        try {
            String sqlSize = "select TenS from Size "
                    + "order by ID DESC";
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sqlSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Size s = new Size();
                s.setTenSize(rs.getString("TenS"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
