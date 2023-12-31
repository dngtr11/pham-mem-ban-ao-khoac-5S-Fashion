/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anh
 */
public class MauSac {
    private int idMauSac;
    private String maMauSac;
    private String tenMauSac ;
    private boolean trangThaiMauSac;

    public MauSac() {
    }

    public MauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }
    
    public MauSac(int idMauSac, String maMauSac, String tenMauSac, boolean trangThaiMauSac) {
        this.idMauSac = idMauSac;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.trangThaiMauSac = trangThaiMauSac;
    }

    public int getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(int idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public boolean isTrangThaiMauSac() {
        return trangThaiMauSac;
    }

    public void setTrangThaiMauSac(boolean trangThaiMauSac) {
        this.trangThaiMauSac = trangThaiMauSac;
    }

    @Override
    public String toString() {
        return tenMauSac;
    }

    public MauSac(String maMauSac, String tenMauSac, boolean trangThaiMauSac) {
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.trangThaiMauSac = trangThaiMauSac;
    }
    
}
