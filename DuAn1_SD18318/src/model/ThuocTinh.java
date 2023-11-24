/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anh
 */
public class ThuocTinh {
    private int idSp ;
    private String maSp ;
    private String tenSp ;
    private int soLuongSpct ;

    public ThuocTinh() {
    }

    public ThuocTinh(String maSp, String tenSp, int soLuongSpct) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuongSpct = soLuongSpct;
    }

    public ThuocTinh(int idSp, String maSp, String tenSp, int soLuongSpct) {
        this.idSp = idSp;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuongSpct = soLuongSpct;
    }

    public int getIdSp() {
        return idSp;
    }

    public void setIdSp(int idSp) {
        this.idSp = idSp;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuongSpct() {
        return soLuongSpct;
    }

    public void setSoLuongSpct(int soLuongSpct) {
        this.soLuongSpct = soLuongSpct;
    }

    @Override
    public String toString() {
        return "ThuocTinh{" + "idSp=" + idSp + ", maSp=" + maSp + ", tenSp=" + tenSp + ", soLuongSpct=" + soLuongSpct + '}';
    }
    
}
