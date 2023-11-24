/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.SanPham;

/**
 *
 * @author anh
 */
public interface SanPhamService {
    List<SanPham> getAll();
    SanPham getById(int id);
    List<SanPham> phanTrang(int page,int limit);
    int countSp();
    int getMaxPagesSp(int itemsPerPage);
    List<SanPham> search(String ma);
    int getSoLuongByID(int id);
    String addSP(SanPham sp);
    
}
