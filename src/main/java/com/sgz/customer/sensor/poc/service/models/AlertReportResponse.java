package com.sgz.customer.sensor.poc.service.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by janardhan.nellibanda on 10/13/2016.
 */
public class AlertReportResponse {

    @XmlElementWrapper(name = "alertResponses")
    @XmlElement(name = "alertResponse")
    private List<AlertResponse> alertResponse;

    public List<AlertResponse> getAlertResponse() {
        return alertResponse;
    }

    public void setAlertResponse(List<AlertResponse> alertResponse) {
        this.alertResponse = alertResponse;
    }
}
