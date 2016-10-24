package com.sgz.customer.sensor.poc.service.models;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
@XmlRootElement(name = "CustomerSensorPayload")
public class CustomerSensorPayload {

    private CustomerSensorRequest productRequest;

    @XmlElement(name = "productRequest")
    public CustomerSensorRequest getProductRequest() {
        return productRequest;
    }

    public void setProductRequest(CustomerSensorRequest productRequest) {
        this.productRequest = productRequest;
    }
}
