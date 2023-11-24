/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.SanPham;
import model.SanPhamChiTiet;

/**
 *
 * @author anh
 */
public interface SanPhamChiTietService {
    List<SanPhamChiTiet> getAll();
    List<SanPhamChiTiet> phanTrang(int page,int limit) ;
    int countSpct();
    int getMaxPages(int itemsPerPage);
    List<SanPhamChiTiet> search(String ma);
    SanPhamChiTiet get_By_ID(int id);
    List<SanPhamChiTiet> getAllByName(String name);
}
