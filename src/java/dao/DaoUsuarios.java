/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Beans.NewHibernateUtil;
import idao.Idao;
import java.util.List;
import models.usuarios;
import java.io.Serializable;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author adrian
 */
public class DaoUsuarios implements Idao<usuarios, Integer> {

    private SessionFactory factory;
    private Session session;
    private usuarios userRecord;
    private List<usuarios> userRecords;

    public DaoUsuarios() {
        factory = NewHibernateUtil.getSessionFactory();
    }

    @Override
    public boolean insertRecord(usuarios model) {
        session = factory.openSession();
        session.beginTransaction();
        Serializable save = session.save(model);
        session.getTransaction().commit();
        session.close();
        return save != null;
    }

    @Override
    public boolean deleteRecord(Integer idModel) {
        session = factory.openSession();
        session.beginTransaction();
        session.delete(new usuarios(idModel));
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateRecord(usuarios model, Integer idModel) {
        session = factory.openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public usuarios ReadOneRecord(Integer idModel) {
        session = factory.openSession();
        session.beginTransaction();
        usuarios user = (usuarios) session.get(usuarios.class, idModel);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public List<usuarios> readRecords() {
        session = factory.openSession();
        Query query = session.createQuery("from usuarios");
        List list = query.list();
        session.close();
        return list;
    }

}
