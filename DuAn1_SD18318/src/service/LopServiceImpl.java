/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.KieuDang;
import model.LopAo;

/**
 *
 * @author anh
 */
public class LopServiceImpl implements LopService{

    @Override
    public List<LopAo> getAll() {
        List<LopAo> listLopAo = new ArrayList<>();
        try {
            String database = "DUAN1";
            String sql = """
                                 SELECT [ID]
                                                 ,[MaL]
                                                 ,[SoLop]
                                             FROM [dbo].[Lop]
                                             order by id desc
                                 """;
            Connection con = SQLServerConnection.getConnection(database);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LopAo lop = new LopAo();
                lop.setMaLop(rs.getString(2));
                lop.setSoLop(rs.getInt(3));
                listLopAo.add(lop);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listLopAo;
    }

    @Override
    public LopAo get_By_Id(int id) {
        List<LopAo> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from Lop where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LopAo lop = new LopAo();
                lop.setMaLop(rs.getString(2));
                lop.setSoLop(rs.getInt(3));
                listById.add(lop);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }

    @Override
    public String addLop(LopAo lop) {
        List<LopAo> listLop = new ArrayList<>();
        try {
            String sql = """
                                 INSERT INTO [dbo].[Lop]
                                                       ([MaL]
                                                       ,[SoLop]
                                                       ,[TrangThai])
                                      VALUES
                                            (?,?,?)
                                 """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, lop.getMaLop());
            ps.setObject(2, lop.getSoLop());
            ps.setObject(3, lop.isTrangThai());
            if (ps.executeUpdate() < 1) {
                return "add that bai";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Add Thành Công";
    }

    @Override
    public List<LopAo> getCbbLop() {
        List<LopAo> list = new ArrayList<>();
        try {
            String sqlMs = "select SoLop from Lop "
                    + "order by ID DESC";
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sqlMs);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LopAo lop = new LopAo();
                lop.setSoLop(rs.getInt("SoLop"));
                list.add(lop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
