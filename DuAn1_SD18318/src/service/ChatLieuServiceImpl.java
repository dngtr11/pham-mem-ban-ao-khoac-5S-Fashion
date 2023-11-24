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
import model.ChatLieu;
import model.MauSac;

/**
 *
 * @author anh
 */
public class ChatLieuServiceImpl implements ChatLieuService{

    @Override
    public List<ChatLieu> getAll() {
        List<ChatLieu> listChatLieu = new ArrayList<>();
        try {
            String database = "DUAN1";
            String sql = """
                                 SELECT [ID]
                                           ,[MaCL]
                                           ,[TenCL]
                                           ,[TrangThai]
                                       FROM [dbo].[ChatLieu]
                                       order by id desc
                                 """;
            Connection con = SQLServerConnection.getConnection(database);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                cl.setMaChatLieu(rs.getString(2));
                cl.setTenChatLieu(rs.getString(3));
                cl.setTrangThai(rs.getBoolean(4));
                listChatLieu.add(cl);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SizeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listChatLieu;
    }

    @Override
    public ChatLieu get_By_Id(int id) {
        List<ChatLieu> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from ChatLieu where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                cl.setMaChatLieu(rs.getString(2));
                cl.setTenChatLieu(rs.getString(3));
                cl.setTrangThai(rs.getBoolean(4));
                listById.add(cl);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }

    @Override
    public String addCl(ChatLieu cl) {
        List<ChatLieu> listCl = new ArrayList<>();
        try {
            String sql = """
                                 INSERT INTO [dbo].[ChatLieu]
                                                 ([MaCL]
                                                 ,[TenCL]
                                                 ,[TrangThai])
                                           VALUES
                                            (?,?,?)
                                 """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, cl.getMaChatLieu());
            ps.setObject(2, cl.getTenChatLieu());
            ps.setObject(3, cl.isTrangThai());
            if (ps.executeUpdate() < 1) {
                return "add that bai";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Add Thành Công";
    }

    @Override
    public List<ChatLieu> getCbbChatLieu() {
        List<ChatLieu> list = new ArrayList<>();
        try {
            String sqlMs = "select TenCL from ChatLieu "
                    + "order by ID DESC";
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(sqlMs);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                cl.setTenChatLieu(rs.getString("TenCL"));
                list.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
}
