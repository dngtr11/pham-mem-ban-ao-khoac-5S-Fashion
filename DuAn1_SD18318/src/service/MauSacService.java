/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.MauSac;

/**
 *
 * @author anh
 */
public interface MauSacService {
    List<MauSac> getAll();
    String addMs(MauSac ms );
    MauSac get_By_Id(int id);
    List<MauSac> getCbbMs();
}
