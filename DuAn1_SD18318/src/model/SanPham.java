/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anh
 */
public class SanPham {
    private int idSp;
    private String maSp;
    private String tenSp;

    public SanPham() {
    }
    
    public SanPham(String maSp, String tenSp) {
        this.maSp = maSp;
        this.tenSp = tenSp;
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

    public int getIdSp() {
        return idSp;
    }

    public void setIdSp(int idSp) {
        this.idSp = idSp;
    }

    @Override
    public String toString() {
        return "SanPham{" + "idSp=" + idSp + ", maSp=" + maSp + ", tenSp=" + tenSp + '}';
    }

    

   
        
}
