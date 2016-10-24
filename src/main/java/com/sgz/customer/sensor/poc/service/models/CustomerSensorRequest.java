package com.sgz.customer.sensor.poc.service.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
@XmlRootElement(name = "sensorInfoRequest")
public class CustomerSensorRequest {

    private SensorInfo sensorInfo;

    @XmlElement(name = "sensorInfo")

    public SensorInfo getSensorInfo() {
        return sensorInfo;
    }

    public void setSensorInfo(SensorInfo sensorInfo) {
        this.sensorInfo = sensorInfo;
    }
}
