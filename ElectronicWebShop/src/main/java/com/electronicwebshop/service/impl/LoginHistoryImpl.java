package com.electronicwebshop.service.impl;

import com.electronicwebshop.dal.LoginHistoryDal;
import com.electronicwebshop.model.LoginHistory;
import com.electronicwebshop.service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginHistoryImpl implements LoginHistoryService {
    @Autowired
    private LoginHistoryDal loginHistoryDal;


    @Override
    public List<LoginHistory> getAllHistories() {
        return loginHistoryDal.getAllHistories();
    }
}
