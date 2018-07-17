package com.electronicwebshop.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Entity
public class LoginHistory implements Serializable {


    private static final long serialVersionUID = 5175007745266196390L;

    public int getLoginHistoryId() {
        return loginHistoryId;
    }

    public void setLoginHistoryId(int loginHistoryId) {
        this.loginHistoryId = loginHistoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Id
    @GeneratedValue
    private int loginHistoryId;

    String name;

    Date date;

    String ip;

}
