/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.KieuDang;

/**
 *
 * @author anh
 */
public interface KieuDangService {
    List<KieuDang> getAll();
    KieuDang get_By_Id(int id);
    List<KieuDang> getCbbKd();
    String addKD(KieuDang kd); 
}
