package com.electronicwebshop.dal.impl;

import com.electronicwebshop.dal.LoginHistoryDal;
import com.electronicwebshop.model.LoginHistory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class LoginHistoryDalImpl implements LoginHistoryDal {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<LoginHistory>  getAllHistories() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from LoginHistory");
        List<LoginHistory> loginHistoryList = query.list();

        return loginHistoryList;
    }
}
