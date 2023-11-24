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
import model.KieuDang;
import model.KieuMu;

/**
 *
 * @author anh
 */
public class KieuDangServiceImpl implements KieuDangService {

    @Override
    public List<KieuDang> getAll() {
        List<KieuDang> listKieuDang = new ArrayList<>();
        try {
            String database = "DUAN1";
            String sql = """
                                 SELECT [ID]
                                               ,[MaKD]
                                               ,[TenKD]
                                           FROM [dbo].[KieuDang]
                                           order by id desc
                                 """;
            Connection con = SQLServerConnection.getConnection(database);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KieuDang kd = new KieuDang();
                kd.setMaKd(rs.getString(2));
                kd.setTenKd(rs.getString(3));
                listKieuDang.add(kd);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listKieuDang;
    }

    @Override
    public KieuDang get_By_Id(int id) {
        List<KieuDang> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from KieuDang where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KieuDang kd = new KieuDang();
                kd.setMaKd(rs.getString(2));
                kd.setTenKd(rs.getString(3));
                listById.add(kd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }

    @Override
    public List<KieuDang> getCbbKd() {
        List<KieuDang> list = new ArrayList<>();
        try {
            String sqlMs = "select TenKD from KieuDang "
                    + "order by ID DESC";
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sqlMs);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KieuDang kd = new KieuDang();
                kd.setTenKd(rs.getString("TenKD"));
                list.add(kd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String addKD(KieuDang kd) {
        List<KieuDang> listKD = new ArrayList<>();
        try {
            String sql = """
                                 INSERT INTO [dbo].[KieuDang]
                                                 ([MaKD]
                                                 ,[TenKD]
                                                 ,[TrangThai])
                                           VALUES
                                            (?,?,?)
                                 """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, kd.getMaKd());
            ps.setObject(2, kd.getTenKd());
            ps.setObject(3, kd.isTrangThai());
            if (ps.executeUpdate() < 1) {
                return "add that bai";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Add Thành Công";
    }

}
