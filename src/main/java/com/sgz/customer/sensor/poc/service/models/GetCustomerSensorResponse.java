package com.sgz.customer.sensor.poc.service.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
@XmlRootElement(name = "getCustomerSensorResponse")
public class GetCustomerSensorResponse {

    private List<SensorInfo> sensorInfo;
    private String message;


    @XmlElement(name = "sensorInfo")
    @XmlElementWrapper(name = "sensorInfos")
    public List<SensorInfo> getSensorInfo() {
        return sensorInfo;
    }

    public void setSensorInfo(List<SensorInfo> sensorInfo) {
        this.sensorInfo = sensorInfo;
    }

    @XmlElement(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
