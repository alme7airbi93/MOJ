package com.mohammad.mojapplication.Objects;

import java.util.Date;

/**
 * Created by user on 11/1/2015.
 */
public class Party {

    private String partyID;
    private String fName;
    private String type;
    private String mobile;
    private String address;

    public Party(String partyID, String fName, String type, String mobile, String address) {
        this.partyID = partyID;
        this.fName = fName;
        this.type = type;
        this.mobile = mobile;
        this.address = address;
    }

    public String getPartyID() {
        return partyID;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
