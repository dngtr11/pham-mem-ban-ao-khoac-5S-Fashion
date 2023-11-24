/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.CachThucDongCua;

/**
 *
 * @author anh
 */
public interface KhoaCaiService {
    List<CachThucDongCua> getAll();
    CachThucDongCua get_By_Id(int id);
    List<CachThucDongCua> getCbbKhoaCai();
    String addCTDC(CachThucDongCua ctdc);
}
