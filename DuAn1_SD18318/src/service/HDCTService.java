/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.HoaDonCT;
import java.sql.*;
import java.util.ArrayList;
import model.HoaDon;
import model.SanPham;

/**
 *
 * @author Dung Tran
 */
public class HDCTService {
   public List<HoaDonCT> getAll(){
        String sql = """
                     select * 
                     from HoaDonChiTiet hdct
                     join HoaDon hd on hd.ID = hdct.ID_HD
                     left join SanPhamChiTiet spct on spct.ID = hdct.ID_SPCT;
                     """;
        try(Connection c = SQLServerConnection.getConnection("DUAN1");
                PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonCT> list = new ArrayList<>();
            while (rs.next()) {                
                HoaDonCT ct = new HoaDonCT();
                ct.setId(rs.getInt(1));
                ct.setIdSPCT(rs.getInt(2));
                ct.setIdHD(rs.getInt(3));
                ct.setSoLuong(rs.getInt(4));
                ct.setGia(rs.getFloat(5));
                ct.setThanhTien(rs.getFloat(6));
                ct.setNguoiTao(rs.getString(7));
                ct.setNguoiSua(rs.getString(8));
                ct.setNgayTao(rs.getDate(9));
                ct.setNgaySua(rs.getDate(10));
                ct.setTrangThai(rs.getBoolean(11));
                list.add(ct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public HoaDonCT getById(int id) {
        List<HoaDonCT> listById = new ArrayList<>();
        try {
            String GET_BY_ID = """
                                       select * from HoaDonChiTiet where id = ?
                                       """;
            Connection con = SQLServerConnection.getConnection("DUAN1");
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT ct = new HoaDonCT();
                 ct.setId(rs.getInt(1));
                ct.setIdSPCT(rs.getInt(2));
                ct.setIdHD(rs.getInt(3));
                ct.setSoLuong(rs.getInt(4));
                ct.setGia(rs.getFloat(5));
                ct.setThanhTien(rs.getFloat(6));
                ct.setNguoiTao(rs.getString(7));
                ct.setNguoiSua(rs.getString(8));
                ct.setNgayTao(rs.getDate(9));
                ct.setNgaySua(rs.getDate(10));
                ct.setTrangThai(rs.getBoolean(11));
                listById.add(ct);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listById.get(0);
    }
    public List<HoaDonCT> getByKeyword(String MaHD){
        try{
        String sql = """
                     select  HoaDonChiTiet.id,SanPhamChiTiet.id ,
                     HoaDon.ID,
                     	SanPham.MaSP ,
                     	SanPham.TenSP ,
                     	NSX.TenNSX ,
                     	MauSac.TenMS ,
                     	CachThucDongCua.TenCTDC,
                     	ChatLieu.TenCL,
                     	KieuDang.TenKD,
                     	Lop.SoLop,
                     	Mu.KieuMu,
                     	Size.TenS,
                     	HoaDonChiTiet.gia,
                     	HoaDonChiTiet.SoLuong,
                     	HoaDonChiTiet.gia*HoaDonChiTiet.SoLuong as thanhTien
                     from SanPhamChiTiet
                     join SanPham on SanPham.ID = SanPhamChiTiet.ID_SP
                     join NSX on NSX.ID = SanPhamChiTiet.ID_NSX
                     join MauSac on MauSac.ID = SanPhamChiTiet.ID_MS
                     join CachThucDongCua on CachThucDongCua.ID = SanPhamChiTiet.ID_CTDC
                     join ChatLieu on ChatLieu.ID = SanPhamChiTiet.ID_CL
                     join KieuDang on KieuDang.ID = SanPhamChiTiet.ID_KD
                     join Lop on Lop.ID = SanPhamChiTiet.ID_Lop
                     join Mu on Mu.ID = SanPhamChiTiet.ID_Mu
                     join Size on Size.ID = SanPhamChiTiet.ID_Size
                     join HoaDonChiTiet on SanPhamChiTiet.ID = HoaDonChiTiet.ID_SPCT
                     join HoaDon on HoaDonChiTiet.ID_HD = HoaDon.ID
                     where HoaDon.MaHD = ?
                     """;
        Connection c = SQLServerConnection.getConnection("DUAN1");
                PreparedStatement ps = c.prepareStatement(sql) ;
            ps.setObject(1, MaHD);
            List<HoaDonCT> listHDCT = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                HoaDonCT ct = new HoaDonCT();
                ct.setId(rs.getInt(1));
                SanPham sp = new SanPham();
                
            }
            return listHDCT;
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
    
}
