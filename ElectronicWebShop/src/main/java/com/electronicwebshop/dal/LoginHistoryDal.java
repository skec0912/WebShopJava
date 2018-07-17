package com.electronicwebshop.dal;

import com.electronicwebshop.model.LoginHistory;

import java.util.List;

public interface LoginHistoryDal {
   List<LoginHistory> getAllHistories();
}
