package com.sgz.customer.sensor.poc.service.models;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by janardhan.nellibanda on 10/12/2016.
 */
@XmlRootElement(name = "alertResponse")
public class AlertResponse{

    
    private String userName;

    private String tagId;

    private String highTemperature;

    private String lowTemperature;

    private String numberOfOccurencesHigh;

    private String numberOfOccurencesLow;

    private String email;

    private String phone;

    private String message;

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

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getHighTemperature() {
        return highTemperature;
    }

    public void setHighTemperature(String highTemperature) {
        this.highTemperature = highTemperature;
    }

    public String getLowTemperature() {
        return lowTemperature;
    }

    public void setLowTemperature(String lowTemperature) {
        this.lowTemperature = lowTemperature;
    }

    public String getNumberOfOccurencesHigh() {
        return numberOfOccurencesHigh;
    }

    public void setNumberOfOccurencesHigh(String numberOfOccurencesHigh) {
        this.numberOfOccurencesHigh = numberOfOccurencesHigh;
    }

    public String getNumberOfOccurencesLow() {
        return numberOfOccurencesLow;
    }

    public void setNumberOfOccurencesLow(String numberOfOccurencesLow) {
        this.numberOfOccurencesLow = numberOfOccurencesLow;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
