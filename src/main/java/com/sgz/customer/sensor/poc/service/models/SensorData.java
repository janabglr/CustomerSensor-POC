package com.sgz.customer.sensor.poc.service.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by janardhan.nellibanda on 10/4/2016.
 */
@XmlRootElement(name = "sensorData")
public class SensorData {

    private String sensorTimeStamp;
    private String tagID;
    private String sensorTemp;
    private String reviewed;
    private String tagType;
    private String metadata;

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public String getSensorTimeStamp() {
        return sensorTimeStamp;
    }

    public void setSensorTimeStamp(String sensorTimeStamp) {
        this.sensorTimeStamp = sensorTimeStamp;
    }

    public String getTagID() {
        return tagID;
    }

    public void setTagID(String tagID) {
        this.tagID = tagID;
    }

    public String getSensorTemp() {
        return sensorTemp;
    }

    public void setSensorTemp(String sensorTemp) {
        this.sensorTemp = sensorTemp;
    }

    public String getReviewed() {
        return reviewed;
    }

    public void setReviewed(String reviewed) {
        this.reviewed = reviewed;
    }
}
