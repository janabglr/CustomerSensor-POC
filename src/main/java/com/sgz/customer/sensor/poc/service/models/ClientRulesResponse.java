package com.sgz.customer.sensor.poc.service.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by janardhan.nellibanda on 10/4/2016.
 */
@XmlRootElement(name = "clientRulesResponse")
public class ClientRulesResponse {

    private String message;

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
