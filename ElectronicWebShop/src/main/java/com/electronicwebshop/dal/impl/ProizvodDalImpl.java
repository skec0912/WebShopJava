package com.electronicwebshop.dal.impl;

import com.electronicwebshop.dal.ProizvodDal;
import com.electronicwebshop.model.Proizvod;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProizvodDalImpl implements ProizvodDal {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProizvod(Proizvod proizvod) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(proizvod);
        session.flush();
    }

    public void editProizvod(Proizvod proizvod) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(proizvod);
        session.flush();
    }

    public Proizvod getProizvodById(String proizvodId) {
        Session session = sessionFactory.getCurrentSession();
        Proizvod proizvod = (Proizvod) session.get(Proizvod.class, proizvodId);
        session.flush();

        return proizvod;
    }

    public List<Proizvod> getAllProizvod() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Proizvod");
        List<Proizvod> proizvodi = query.list();
        session.flush();

        return proizvodi;
    }

    public void deleteProizvod(String id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProizvodById(id));
        session.flush();
    }
}
