package com.mohammad.mojapplication.Objects;

import java.util.Date;
import java.util.UUID;

/**
 * Created by user on 11/1/2015.
 */
public class Service {

    private String userID;
    private String type;
    private String serviceID;
    private Date date;
    private String serviceStatus;

    public Service(String userID, String type, String serviceID, Date date,String serviceStatus) {
        this.userID = userID;
        this.type = type;
        this.serviceID = serviceID;
        this.date = date;
        this.serviceStatus = serviceStatus;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
}
