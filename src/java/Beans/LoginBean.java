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
import dao.DaoLogin;
import models.UsuariosLogin;
import models.usuarios;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {
    private UsuariosLogin u;
    private DaoLogin Dao;
    
    
    
    public LoginBean() {
        u = new UsuariosLogin();
        Dao = new DaoLogin();
    }

    public void insertDatos() {
        Dao.insert(u);
        u = new UsuariosLogin();
    }

   public UsuariosLogin getU() {
        return u;
    }

    public void setU(UsuariosLogin u) {
        this.u = u;
    }

    public DaoLogin getDao() {
        return Dao;
    }

    public void setDao(DaoLogin Dao) {
        this.Dao = Dao;
    }
   
    public String checarUsuario() {
        UsuariosLogin usu;
        String r = "";
        System.out.println(u.getPassword());
        usu = Dao.checarUsuario(u);
        if(usu!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("UsuariosLogin", usu);
            r = "List";
        } else {
            r = "index";
        }
    return r;
}
}

