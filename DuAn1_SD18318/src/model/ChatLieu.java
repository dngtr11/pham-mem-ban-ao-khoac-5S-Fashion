/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anh
 */
public class ChatLieu {
    private int idChatLieu;
    private String maChatLieu ;
    private String tenChatLieu ;
    private boolean trangThaiChatLieu;

    public ChatLieu() {
    }

    public ChatLieu(String maChatLieu, String tenChatLieu, boolean trangThaiChatLieu) {
        this.maChatLieu = maChatLieu;
        this.tenChatLieu = tenChatLieu;
        this.trangThaiChatLieu = trangThaiChatLieu;
    }
    
    public ChatLieu(int idChatLieu, String maChatLieu, String tenChatLieu, boolean trangThai) {
        this.idChatLieu = idChatLieu;
        this.maChatLieu = maChatLieu;
        this.tenChatLieu = tenChatLieu;
        this.trangThaiChatLieu = trangThai;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public boolean isTrangThai() {
        return trangThaiChatLieu;
    }

    public void setTrangThai(boolean trangThaiChatLieu) {
        this.trangThaiChatLieu = trangThaiChatLieu;
    }

    @Override
    public String toString() {
        return tenChatLieu;
    }
    
    
}
