/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import idao.Idao;
import java.util.List;
import models.usuarios;

/**
 *
 * @author adrian
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Idao miDao = new DaoUsuarios();
        List<usuarios> users = miDao.readRecords();
        
        for (usuarios user: users){
            System.out.println(user.toString());
        }
    }
    
}
