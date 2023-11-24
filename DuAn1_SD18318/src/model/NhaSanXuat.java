/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anh
 */
public class NhaSanXuat {
    private int idNsx;
    private String maNsx ;
    private String tenNsx ;
    private String diaChiNsx ;
    private int sdtNsx;
    private boolean trangThaiNsx;

    public NhaSanXuat() {
    }

    public NhaSanXuat(int idNsx, String maNsx, String tenNsx, String diaChiNsx, int sdtNsx, boolean trangThaiNsx) {
        this.idNsx = idNsx;
        this.maNsx = maNsx;
        this.tenNsx = tenNsx;
        this.diaChiNsx = diaChiNsx;
        this.sdtNsx = sdtNsx;
        this.trangThaiNsx = trangThaiNsx;
    }

    public int getIdNsx() {
        return idNsx;
    }

    public void setIdNsx(int idNsx) {
        this.idNsx = idNsx;
    }

    public String getMaNsx() {
        return maNsx;
    }

    public void setMaNsx(String maNsx) {
        this.maNsx = maNsx;
    }

    public String getTenNsx() {
        return tenNsx;
    }

    public void setTenNsx(String tenNsx) {
        this.tenNsx = tenNsx;
    }

    public String getDiaChiNsx() {
        return diaChiNsx;
    }

    public void setDiaChiNsx(String diaChiNsx) {
        this.diaChiNsx = diaChiNsx;
    }

    public int getSdtNsx() {
        return sdtNsx;
    }

    public void setSdtNsx(int sdtNsx) {
        this.sdtNsx = sdtNsx;
    }

    public boolean isTrangThaiNsx() {
        return trangThaiNsx;
    }

    public void setTrangThaiNsx(boolean trangThaiNsx) {
        this.trangThaiNsx = trangThaiNsx;
    }
    
}
