/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author anh
 */
public class SanPhamChiTiet {

    private int id;
    private int idSp;
    private int idNsx;
    private int idMs;
    private int idCl;
    private int idSize;
    private int idMu;
    private int idKd;
    private int idLop;
    private int idCtdc;
//    private String maSp;
//    private String tenSp;
//    private String tenMs;
//    private String tenCl;
//    private String tenSize;
//    private String tenMu;
//    private String tenKd;
//    private int soLop;
//    private String tenKhoaCai;
    private String moTa;
    private int soLuong;
    private float gia;
    private String nguoiTao;
    private String nguoiSua;
    private Date ngayTao;
    private Date ngaySua;
    private boolean trangThai;

    public SanPhamChiTiet() {
    }

   

    public SanPhamChiTiet(int id, int idSp, int idNsx, int idMs, int idCl, int idSize, int idMu, int idKd, int idLop, int idCtdc, String moTa, int soLuong, float gia, String nguoiTao, String nguoiSua, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.id = id;
        this.idSp = idSp;
        this.idNsx = idNsx;
        this.idMs = idMs;
        this.idCl = idCl;
        this.idSize = idSize;
        this.idMu = idMu;
        this.idKd = idKd;
        this.idLop = idLop;
        this.idCtdc = idCtdc;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.gia = gia;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSp() {
        return idSp;
    }

    public void setIdSp(int idSp) {
        this.idSp = idSp;
    }

    public int getIdNsx() {
        return idNsx;
    }

    public void setIdNsx(int idNsx) {
        this.idNsx = idNsx;
    }

    public int getIdMs() {
        return idMs;
    }

    public void setIdMs(int idMs) {
        this.idMs = idMs;
    }

    public int getIdCl() {
        return idCl;
    }

    public void setIdCl(int idCl) {
        this.idCl = idCl;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public int getIdMu() {
        return idMu;
    }

    public void setIdMu(int idMu) {
        this.idMu = idMu;
    }

    public int getIdKd() {
        return idKd;
    }

    public void setIdKd(int idKd) {
        this.idKd = idKd;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public int getIdCtdc() {
        return idCtdc;
    }

    public void setIdCtdc(int idCtdc) {
        this.idCtdc = idCtdc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
