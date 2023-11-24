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
import model.KieuMu;

/**
 *
 * @author anh
 */
public class MuServiceImpl implements MuService{

    @Override
    public List<KieuMu> getAll() {
        List<KieuMu> listKieuMu = new ArrayList<>();
        try {
            String database = "DUAN1";
            String sql = """
                                 SELECT [ID]
                                             ,[MaMu]
                                             ,[KieuMu]
                                             ,[TrangThai]
                                         FROM [dbo].[Mu]
                                        order by id desc
                                 """;
            Connection con = SQLServerConnection.getConnection(database);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KieuMu mu = new KieuMu();
                mu.setIdKieuMu(rs.getInt(1));
                mu.setMaKieuMu(rs.getString(2));
                mu.setTenKieuMu(rs.getString(3));
                mu.setTrangThaiKieuMu(rs.getBoolean(4));
                listKieuMu.add(mu);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SizeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKieuMu;
    }

  
    
    public static void main(String[] args) {
        MuServiceImpl sv = new MuServiceImpl();
        System.out.println(sv.get_By_Id(2).toString());
    }

    @Override
    public List<KieuMu> getCbbMu() {
        List<KieuMu> list = new ArrayList<>();
        try {
            String sqlSize = "select KieuMu from Mu "
                    + "order by ID DESC";
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sqlSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KieuMu mu = new KieuMu();
                mu.setTenKieuMu(rs.getString("KieuMu"));
                list.add(mu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public KieuMu get_By_Id(int id) {
        List<KieuMu> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from Mu where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KieuMu mu = new KieuMu();
                mu.setMaKieuMu(rs.getString("MaMu"));
                mu.setTenKieuMu(rs.getString("KieuMu"));
                mu.setTrangThaiKieuMu(rs.getBoolean(4));
                listById.add(mu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }

    @Override
    public String addMu(KieuMu mu) {
        List<KieuMu> listMu = new ArrayList<>();
        try {
            String sql = """
                                 INSERT INTO [dbo].[Mu]
                                                      ([MaMu]
                                                      ,[KieuMu]
                                                      ,[TrangThai])
                                                VALUES
                                            (?,?,?)
                                 """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, mu.getMaKieuMu());
            ps.setObject(2, mu.getTenKieuMu());
            ps.setObject(3, mu.isTrangThaiKieuMu());
            if (ps.executeUpdate() < 1) {
                return "add that bai";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Add Thành Công";
    }
}
