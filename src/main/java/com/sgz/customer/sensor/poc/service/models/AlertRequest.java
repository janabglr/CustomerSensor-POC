package com.sgz.customer.sensor.poc.service.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by janardhan.nellibanda on 10/12/2016.
 */
@XmlRootElement(name = "alertRequest")
public class AlertRequest {

    private String userName;
    private String tagId;
    private String highTemperature;
    private String lowTemperature;
    private String numberOfOccurencesHigh;
    private String numberOfOccurencesLow;

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
}
