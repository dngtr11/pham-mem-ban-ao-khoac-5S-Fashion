/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anh
 */
public class CachThucDongCua {
    private int idCachThuc;
    private String maCachThuc ;
    private String tenCachThuc ;
    private boolean trangThai;
    public CachThucDongCua() {
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    public CachThucDongCua(String maCachThuc, String tenCachThuc, boolean trangThai) {
        this.maCachThuc = maCachThuc;
        this.tenCachThuc = tenCachThuc;
        this.trangThai = trangThai;
    }
    
    public CachThucDongCua(int idCachThuc, String maCachThuc, String tenCachThuc) {
        this.idCachThuc = idCachThuc;
        this.maCachThuc = maCachThuc;
        this.tenCachThuc = tenCachThuc;
    }

    public int getIdCachThuc() {
        return idCachThuc;
    }

    public void setIdCachThuc(int idCachThuc) {
        this.idCachThuc = idCachThuc;
    }

    public String getMaCachThuc() {
        return maCachThuc;
    }

    public void setMaCachThuc(String maCachThuc) {
        this.maCachThuc = maCachThuc;
    }

    public String getTenCachThuc() {
        return tenCachThuc;
    }

    public void setTenCachThuc(String tenCachThuc) {
        this.tenCachThuc = tenCachThuc;
    }

    @Override
    public String toString() {
        return tenCachThuc;
    }
    
}
