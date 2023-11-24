/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anh
 */
public class Size {
    private int idSize;
    private String maSize ;
    private String tenSize ;
    private boolean trangThaiSize;

    public Size() {
    }
    
    public Size(String tenSize) {
        this.tenSize = tenSize;
    }
    
    public Size(int idSize, String tenSize) {
        this.idSize = idSize;
        this.tenSize = tenSize;
    }
    
    public Size(String maSize, String tenSize, boolean trangThaiSize) {
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.trangThaiSize = trangThaiSize;
    }
    

    public Size(int idSize, String maSize, String tenSize, boolean trangThaiSize) {
        this.idSize = idSize;
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.trangThaiSize = trangThaiSize;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public boolean isTrangThaiSize() {
        return trangThaiSize;
    }

    public void setTrangThaiSize(boolean trangThaiSize) {
        this.trangThaiSize = trangThaiSize;
    }

    @Override
    public String toString() {
        return tenSize;
    }
    
}
