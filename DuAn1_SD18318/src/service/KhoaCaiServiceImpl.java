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
import model.CachThucDongCua;
import model.KieuDang;

/**
 *
 * @author anh
 */
public class KhoaCaiServiceImpl implements KhoaCaiService{

    @Override
    public List<CachThucDongCua> getAll() {
        List<CachThucDongCua> listKhoaCai = new ArrayList<>();
        try {
            String database = "DUAN1";
            String sql = """
                                 SELECT [ID]
                                                 ,[MaCTDC]
                                                 ,[TenCTDC]
                                             FROM [dbo].[CachThucDongCua]
                                             order by id desc
                                 """;
            Connection con = SQLServerConnection.getConnection(database);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CachThucDongCua khoaCai = new CachThucDongCua();
                khoaCai.setMaCachThuc(rs.getString(2));
                khoaCai.setTenCachThuc(rs.getString(3));
                listKhoaCai.add(khoaCai);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listKhoaCai;
    }

    @Override
    public CachThucDongCua get_By_Id(int id) {
        List<CachThucDongCua> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from CachThucDongCua where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CachThucDongCua khoaCai = new CachThucDongCua();
                khoaCai.setMaCachThuc(rs.getString(2));
                khoaCai.setTenCachThuc(rs.getString(3));
                listById.add(khoaCai);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }

    @Override
    public List<CachThucDongCua> getCbbKhoaCai() {
        List<CachThucDongCua> list = new ArrayList<>();
        try {
            String sqlMs ="select TenCTDC from CachThucDongCua "
                    + "order by ID DESC";

            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sqlMs);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CachThucDongCua kc = new CachThucDongCua();
                kc.setTenCachThuc(rs.getString("TenCTDC"));
                list.add(kc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String addCTDC(CachThucDongCua ctdc) {
        List<CachThucDongCua> listCTDC = new ArrayList<>();
        try {
            String sql = """
                                 INSERT INTO [dbo].[CachThucDongCua]
                                                      ([MaCTDC]
                                                      ,[TenCTDC]
                                                      ,[TrangThai])
                                                VALUES
                                            (?,?,?)
                                 """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, ctdc.getMaCachThuc());
            ps.setObject(2, ctdc.getTenCachThuc());
            ps.setObject(3, ctdc.isTrangThai());
            if (ps.executeUpdate() < 1) {
                return "add that bai";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Add Thành Công";
    }
    
}
