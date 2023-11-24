/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anh
 */
public class KieuMu {
    private int idKieuMu;
    private String maKieuMu ;
    private String tenKieuMu;
    private boolean trangThaiKieuMu;

    public int getIdKieuMu() {
        return idKieuMu;
    }
    
    public void setIdKieuMu(int idKieuMu) {
        this.idKieuMu = idKieuMu;
    }

    public String getMaKieuMu() {
        return maKieuMu;
    }

    public void setMaKieuMu(String maKieuMu) {
        this.maKieuMu = maKieuMu;
    }

    public String getTenKieuMu() {
        return tenKieuMu;
    }

    public void setTenKieuMu(String tenKieuMu) {
        this.tenKieuMu = tenKieuMu;
    }

    public boolean isTrangThaiKieuMu() {
        return trangThaiKieuMu;
    }

    public void setTrangThaiKieuMu(boolean trangThaiKieuMu) {
        this.trangThaiKieuMu = trangThaiKieuMu;
    }

    public KieuMu() {
    }

    public KieuMu(String maKieuMu, String tenKieuMu, boolean trangThaiKieuMu) {
        this.maKieuMu = maKieuMu;
        this.tenKieuMu = tenKieuMu;
        this.trangThaiKieuMu = trangThaiKieuMu;
    }

    @Override
    public String toString() {
        return tenKieuMu;
    }
    
}
