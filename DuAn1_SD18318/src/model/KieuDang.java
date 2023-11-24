/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anh
 */
public class KieuDang {

    private int idKd;
    private String maKd;
    private String tenKd;
    private boolean trangThai;

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    public KieuDang() {
    }

    public KieuDang(String maKd, String tenKd, boolean trangThai) {
        this.maKd = maKd;
        this.tenKd = tenKd;
        this.trangThai = trangThai;
    }
    
    public KieuDang(int idKd, String maKd, String tenKd) {
        this.idKd = idKd;
        this.maKd = maKd;
        this.tenKd = tenKd;
    }

    public int getIdKd() {
        return idKd;
    }

    public void setIdKd(int idKd) {
        this.idKd = idKd;
    }

    public String getMaKd() {
        return maKd;
    }

    public void setMaKd(String maKd) {
        this.maKd = maKd;
    }

    public String getTenKd() {
        return tenKd;
    }

    public void setTenKd(String tenKd) {
        this.tenKd = tenKd;
    }

    @Override
    public String toString() {
        return tenKd;
    }
    
}
