package com.sgz.customer.sensor.poc.service.models;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.security.Timestamp;
import java.util.List;

/**
 * Created by janardhan.nellibanda on 10/3/2016.
 */
public class SensorInfo implements Serializable {

    private String id;
    private String tagTypeID;
    private String unit;
    private String algo;
    private String upper;
    private String lower;
    private String interval;
    private String delay;
    private String points;
    private String start;
    private String stop;
    private String mfr;
    private String time;
    private String data;
    private String tagOriginator;
    private String tagOwner;
    private String tagShipper;

    public String getTagOriginator() {
        return tagOriginator;
    }

    public void setTagOriginator(String tagOriginator) {
        this.tagOriginator = tagOriginator;
    }

    public String getTagOwner() {
        return tagOwner;
    }

    public void setTagOwner(String tagOwner) {
        this.tagOwner = tagOwner;
    }

    public String getTagShipper() {
        return tagShipper;
    }

    public void setTagShipper(String tagShipper) {
        this.tagShipper = tagShipper;
    }

    //private List<SensorData> sensorData;

    /*@XmlElementWrapper(name = "sensorDataAtTimeChange")
    @XmlElement(name = "sensorData")
    public List<SensorData> getSensorData() {
        return sensorData;
    }

    public void setSensorData(List<SensorData> sensorData) {
        this.sensorData = sensorData;
    }
*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagTypeID() {
        return tagTypeID;
    }

    public void setTagTypeID(String tagTypeID) {
        this.tagTypeID = tagTypeID;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAlgo() {
        return algo;
    }

    public void setAlgo(String algo) {
        this.algo = algo;
    }

    public String getUpper() {
        return upper;
    }

    public void setUpper(String upper) {
        this.upper = upper;
    }

    public String getLower() {
        return lower;
    }

    public void setLower(String lower) {
        this.lower = lower;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}