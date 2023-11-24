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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MauSac;
import model.Size;

/**
 *
 * @author anh
 */
public class MauSacServiceIml implements MauSacService{

    @Override
    public List<MauSac> getAll() {
        List<MauSac> listMauSac = new ArrayList<>();
        try {
            String database = "DUAN1";
            String sql = """
                                 SELECT [ID]
                                         ,[MaMS]
                                         ,[TenMS]
                                         ,[TrangThai]
                                     FROM [dbo].[MauSac]
                                      order by id desc
                                 """;
            Connection con = SQLServerConnection.getConnection(database);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setMaMauSac(rs.getString(2));
                ms.setTenMauSac(rs.getString(3));
                ms.setTrangThaiMauSac(rs.getBoolean(4));
                listMauSac.add(ms);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SizeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMauSac;
    }

    @Override
    public MauSac get_By_Id(int id) {
        List<MauSac> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from MauSac where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setMaMauSac(rs.getString(2));
                ms.setTenMauSac(rs.getString(3));
                ms.setTrangThaiMauSac(rs.getBoolean(4));
                listById.add(ms);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }

    @Override
    public String addMs(MauSac ms) {
        List<MauSac> listS = new ArrayList<>();
        try {
            String sql = """
                                 INSERT INTO [dbo].[MauSac]
                                                 ([MaMS]
                                                 ,[TenMS]
                                                 ,[TrangThai])
                                           VALUES
                                            (?,?,?)
                                 """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, ms.getMaMauSac());
            ps.setObject(2,ms.getTenMauSac());
            ps.setObject(3, ms.isTrangThaiMauSac());
            if (ps.executeUpdate() < 1) {
                return "add that bai";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Add Thành Công";
    }

    @Override
    public List<MauSac> getCbbMs() {
        List<MauSac> list = new ArrayList<>();
        try {
            String sqlMs = "select TenMs from MauSac "
                    + "order by ID DESC";
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sqlMs);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setTenMauSac(rs.getString("TenMS"));
                list.add(ms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
}
