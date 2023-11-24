/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anh
 */
public class LopAo {
    private int idLop ;
    private String maLop ;
    private int soLop;
    private boolean trangThai;

    public LopAo(int idLop, String maLop, int soLop, boolean trangThai) {
        this.idLop = idLop;
        this.maLop = maLop;
        this.soLop = soLop;
        this.trangThai = trangThai;
    }
    
    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    public LopAo() {
    }

    public LopAo(String maLop, int soLop, boolean trangThai) {
        this.maLop = maLop;
        this.soLop = soLop;
        this.trangThai = trangThai;
    }

    

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public int getSoLop() {
        return soLop;
    }

    public void setSoLop(int soLop) {
        this.soLop = soLop;
    }

    @Override
    public String toString() {
        return soLop+"";
    }
    
}
