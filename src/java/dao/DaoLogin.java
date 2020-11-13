/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Beans.NewHibernateUtil;
import idao.IdaoLogin;
import java.io.Serializable;
import models.UsuariosLogin;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author adrian
 */
public class DaoLogin implements IdaoLogin<UsuariosLogin> {

    private SessionFactory factory;
    private Session session;
    private UsuariosLogin userone;

    public DaoLogin() {
        factory = NewHibernateUtil.getSessionFactory();
    }

    @Override
    public boolean insert(UsuariosLogin model) {
        session = factory.openSession();
        session.beginTransaction();
        session.save(model);
        Serializable save = session.save(model);
        session.getTransaction().commit();
        session.close();
        return save != null;
    }

    @Override
    public UsuariosLogin checarUsuario(UsuariosLogin model) {
        session = factory.openSession();
        session.beginTransaction();
        UsuariosLogin us = null;
        Query query = session.createQuery("from UsuariosLogin WHERE nombre = '" + model.getName() + "'AND password = '" + model.getPassword() + "'");
        if (!query.list().isEmpty()) {
            us = (UsuariosLogin) query.list().get(0);
        }
        return us;
    }

}
