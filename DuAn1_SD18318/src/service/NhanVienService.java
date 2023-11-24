/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.sun.net.httpserver.Authenticator;
import java.util.List;
import model.NhanVien;
import java.sql.*;
import java.util.ArrayList;
import model.HoaDon;

/**
 *
 * @author ADMIN
 */
public class NhanVienService {

    public List<NhanVien> getAll() {
        String sql = """
                     SELECT [ID]
                           ,[MaNV]
                           ,[TenNV]
                           ,[NgaySinh]
                           ,[GioiTinh]
                           ,[DiaChi]
                           ,[SDT]
                           ,[Email]
                           ,[VaiTro]
                       FROM [dbo].[NhanVien]
                     """;
        try (Connection con = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<NhanVien> list = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setIdNV(rs.getInt(1));
                nv.setMaNV(rs.getString(2));
                nv.setTenNV(rs.getString(3));
                nv.setNgSinh(rs.getDate(4));
                nv.setGioiTinh(rs.getBoolean(5));
                nv.setDiaChi(rs.getString(6));
                nv.setSdt(rs.getString(7));
                nv.setEmail(rs.getString(8));
                nv.setVaiTro(rs.getBoolean(9));
                list.add(nv);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addNV(NhanVien nv) {
        int check = 0;
        String sql = """
                     INSERT INTO [dbo].[NhanVien]
                                ([MaNV]
                                ,[TenNV]
                                ,[NgaySinh]
                                ,[GioiTinh]
                                ,[DiaChi]
                                ,[SDT]
                                ,[Email]
                                ,[VaiTro])
                          VALUES
                                (?,?,?,?,?,?,?,?)
                     """;
        try (Connection con = SQLServerConnection.getConnection("DUAN1"); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getNgSinh());
            ps.setObject(4, nv.isGioiTinh());
            ps.setObject(5, nv.getDiaChi());
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.isVaiTro());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public NhanVien getById(int id) {
        List<NhanVien> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from NhanVien where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setIdNV(rs.getInt(1));
                nv.setMaNV(rs.getString(2));
                nv.setTenNV(rs.getString(3));
                nv.setNgSinh(rs.getDate(4));
                nv.setGioiTinh(rs.getBoolean(5));
                nv.setDiaChi(rs.getString(6));
                nv.setSdt(rs.getString(7));
                nv.setEmail(rs.getString(8));
                nv.setVaiTro(rs.getBoolean(9));
                listById.add(nv);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }

    public static void main(String[] args) {
        List<NhanVien> list = new NhanVienService().getAll();
        System.out.println(list);
    }

}
