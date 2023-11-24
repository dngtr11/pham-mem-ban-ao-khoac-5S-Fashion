/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.ChatLieu;

/**
 *
 * @author anh
 */
public interface ChatLieuService {
    List<ChatLieu> getAll();
    String addCl(ChatLieu cl);
    ChatLieu get_By_Id(int id);
    List<ChatLieu> getCbbChatLieu();
}
