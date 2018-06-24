package com.electronicwebshop.dal.impl;

import com.electronicwebshop.dal.ProizvodDal;
import com.electronicwebshop.model.Proizvod;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProizvodDalImpl implements ProizvodDal {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Proizvod> getProizvodList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Proizvod");
        List<Proizvod> proizvodList = query.list();

        session.flush();

        return proizvodList;
    }

    @Override
    public Proizvod getProizvodById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Proizvod proizvod = (Proizvod) session.get(Proizvod.class,id);
        session.flush();

        return proizvod;
    }

    @Override
    public void addProizvod(Proizvod proizvod) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(proizvod);
        session.flush();

    }

    @Override
    public void editProizvod(Proizvod proizvod) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(proizvod);
        session.flush();
    }

    @Override
    public void deleteProizvod(Proizvod proizvod) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(proizvod);
        session.flush();
    }
}
