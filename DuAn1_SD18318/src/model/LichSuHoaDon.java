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
public class LichSuHoaDon {

    private int id;
    private int idHD;
    private java.sql.Date ngayDat;
    private float tongTien;
    private java.sql.Date ngayTao;
    private java.sql.Date ngaySua;
    private String nguoiTao;
    private String nguoiSua;
    private boolean trangThai;

    public LichSuHoaDon() {
    }

    public LichSuHoaDon(int id, int idHD, java.sql.Date ngayDat, float tongTien, java.sql.Date ngayTao, java.sql.Date ngaySua, String nguoiTao, String nguoiSua, boolean trangThai) {
        this.id = id;
        this.idHD = idHD;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public java.sql.Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(java.sql.Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
