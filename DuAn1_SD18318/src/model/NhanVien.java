/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVien {

    private int idNV;
    private String maNV;
    private String tenNV;
    private Date ngSinh;
    private boolean gioiTinh;
    private String diaChi;
    private String sdt;
    private String email;
    private boolean vaiTro;

    public NhanVien() {
    }

    public NhanVien(int idNV, String maNV, String tenNV, Date ngSinh, boolean gioiTinh, String diaChi, String sdt, String email, boolean vaiTro) {
        this.idNV = idNV;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngSinh = ngSinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.vaiTro = vaiTro;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgSinh() {
        return ngSinh;
    }

    public void setNgSinh(Date ngSinh) {
        this.ngSinh = ngSinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "idNV=" + idNV + ", maNV=" + maNV + ", tenNV=" + tenNV + ", ngSinh=" + ngSinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", email=" + email + ", vaiTro=" + vaiTro + '}';
    }

}
