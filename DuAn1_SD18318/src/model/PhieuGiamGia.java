/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
/**
 *
 * @author dell
 */
public class PhieuGiamGia {
    private String idGg;
    private String maGg;
    private String hinhThuc;
    private int giaTri;
    private Date ngayBd;
    private Date ngayKt;
    private String nguoiTao;
    private String nguoiSua;
    private boolean trangThai;

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(String idGg, String maGg, String hinhThuc, int giaTri, Date ngayBd, Date ngayKt, String nguoiTao, String nguoiSua, boolean trangThai) {
        this.idGg = idGg;
        this.maGg = maGg;
        this.hinhThuc = hinhThuc;
        this.giaTri = giaTri;
        this.ngayBd = ngayBd;
        this.ngayKt = ngayKt;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.trangThai = trangThai;
    }

    public String getIdGg() {
        return idGg;
    }

    public void setIdGg(String idGg) {
        this.idGg = idGg;
    }

    public String getMaGg() {
        return maGg;
    }

    public void setMaGg(String maGg) {
        this.maGg = maGg;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public Date getNgayBd() {
        return ngayBd;
    }

    public void setNgayBd(Date ngayBd) {
        this.ngayBd = ngayBd;
    }

    public Date getNgayKt() {
        return ngayKt;
    }

    public void setNgayKt(Date ngayKt) {
        this.ngayKt = ngayKt;
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

    @Override
    public String toString() {
        return "PhieuGiamGia{" + "idGg=" + idGg + ", maGg=" + maGg + ", hinhThuc=" + hinhThuc + ", giaTri=" + giaTri + ", ngayBd=" + ngayBd + ", ngayKt=" + ngayKt + ", nguoiTao=" + nguoiTao + ", nguoiSua=" + nguoiSua + ", trangThai=" + trangThai + '}';
    }
    
    
    
}
