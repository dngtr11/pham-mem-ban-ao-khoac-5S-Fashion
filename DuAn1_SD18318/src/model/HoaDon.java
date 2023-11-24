/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Dung Tran
 */
public class HoaDon {
    private int id;
    private String maHD;
    private int idKH;
    private int idNV;
    private int idGG;
    private String tenNguoiNhan;
    private String SDT ;
    private float tongTien;
    private java.sql.Date ngayDat;
    private java.sql.Date ngayGiao;
    private java.sql.Date ngayTao;
    private java.sql.Date ngaySua;
    private String nguoiTao;
    private String nguoiSua;
    private float phiVanChuyen;
    private String hinhThuc ;
    private String diaChi ;
    private String ghiChu;
    private boolean trangThai;

    public HoaDon() {
    }

    public HoaDon(int id, String maHD, int idKH, int idNV, int idGG, String tenNguoiNhan, String SDT, float tongTien, java.sql.Date ngayDat, java.sql.Date ngayGiao, java.sql.Date ngayTao, java.sql.Date ngaySua, String nguoiTao, String nguoiSua, float phiVanChuyen, String hinhThuc, String diaChi, String ghiChu, boolean trangThai) {
        this.id = id;
        this.maHD = maHD;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idGG = idGG;
        this.tenNguoiNhan = tenNguoiNhan;
        this.SDT = SDT;
        this.tongTien = tongTien;
        this.ngayDat = ngayDat;
        this.ngayGiao = ngayGiao;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.phiVanChuyen = phiVanChuyen;
        this.hinhThuc = hinhThuc;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public int getIdGG() {
        return idGG;
    }

    public void setIdGG(int idGG) {
        this.idGG = idGG;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public java.sql.Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(java.sql.Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public java.sql.Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(java.sql.Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public java.sql.Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(java.sql.Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public java.sql.Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(java.sql.Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(String nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public float getPhiVanChuyen() {
        return phiVanChuyen;
    }

    public void setPhiVanChuyen(float phiVanChuyen) {
        this.phiVanChuyen = phiVanChuyen;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    
}
