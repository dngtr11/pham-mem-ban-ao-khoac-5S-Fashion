/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Size;

/**
 *
 * @author anh
 */
public interface SizeService {
    List<Size> getAll();
    String AddSize(Size s);
    String xoaSize(Size s);
    String suaSize(String maCu,Size s);
    Size get_By_Id(int id);
    List<Size> getSize();
}
