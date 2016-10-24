package com.sgz.customer.sensor.poc.service.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.*;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
@XmlRootElement(name = "addCustomerSensorResponse")
public class AddCustomerSensorResponse {

    private String message;
    private Error error;

    @XmlElement(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @XmlElement(name = "error")
    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
