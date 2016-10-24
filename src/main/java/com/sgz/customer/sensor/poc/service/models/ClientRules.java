package com.sgz.customer.sensor.poc.service.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by janardhan.nellibanda on 10/4/2016.
 */
@XmlRootElement(name = "clientRules")
public class ClientRules implements Serializable{

    private String userName;
    private String tagID;
    private int topTemp;
    private int bottomTemp;
    private int numberOfTimesTop;
    private int numberOfTimesBottom;
    private String email;
    private String phone;
    private String ruleID;

    public String getRuleID() {
        return ruleID;
    }

    public void setRuleID(String ruleID) {
        this.ruleID = ruleID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTagID() {
        return tagID;
    }

    public void setTagID(String tagID) {
        this.tagID = tagID;
    }

    public int getTopTemp() {
        return topTemp;
    }

    public void setTopTemp(int topTemp) {
        this.topTemp = topTemp;
    }

    public int getBottomTemp() {
        return bottomTemp;
    }

    public void setBottomTemp(int bottomTemp) {
        this.bottomTemp = bottomTemp;
    }

    public int getNumberOfTimesTop() {
        return numberOfTimesTop;
    }

    public void setNumberOfTimesTop(int numberOfTimesTop) {
        this.numberOfTimesTop = numberOfTimesTop;
    }

    public int getNumberOfTimesBottom() {
        return numberOfTimesBottom;
    }

    public void setNumberOfTimesBottom(int numberOfTimesBottom) {
        this.numberOfTimesBottom = numberOfTimesBottom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
