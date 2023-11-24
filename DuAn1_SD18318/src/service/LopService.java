/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.LopAo;

/**
 *
 * @author anh
 */
public interface LopService {
    List<LopAo> getAll();
    String addLop(LopAo lop);
    LopAo get_By_Id(int id);
    List<LopAo> getCbbLop();
}
