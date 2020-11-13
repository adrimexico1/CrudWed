/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author adrian
 */
import dao.DaoUsuarios;
import idao.Idao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import models.usuarios;

@ManagedBean(name = "userBean")
@RequestScoped
public class UsuariosBean {

    private usuarios user;
    private List<usuarios> userRecords;
    private Idao miDao;
    private int id;

    public UsuariosBean() {
        user = new usuarios();
        userRecords = new ArrayList();
        miDao = new DaoUsuarios();
        userRecords = miDao.readRecords();
    }

    public void sendUser() {
        miDao.insertRecord(user);
    }

    public usuarios getUser() {
        return user;
    }

    public List<usuarios> getUserRecords() {
        return userRecords;
    }

    public void setUserRecords(List<usuarios> userRecords) {
        this.userRecords = userRecords;
    }

    public Idao getMiDao() {
        return miDao;
    }

    public void setMiDao(Idao miDao) {
        this.miDao = miDao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void sendData() {
        miDao.insertRecord(user);
    }

    public void delete() {
        System.out.println("trying");
        miDao.deleteRecord(id);
    }

    public void update() {
        System.out.println("updating");
        miDao.updateRecord(user, id);
    }

}
