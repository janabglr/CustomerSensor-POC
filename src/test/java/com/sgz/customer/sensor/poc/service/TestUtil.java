package com.sgz.customer.sensor.poc.service;

import com.sgz.customer.sensor.poc.service.models.CustomerSensorRequest;

/**
 * Created by janardhan.nellibanda on 9/26/2016.
 */
public class TestUtil {

    public static CustomerSensorRequest getProductRequest() {

        CustomerSensorRequest productRequest = new CustomerSensorRequest();
       /* productRequest.setProductId("123");
        productRequest.setProductName("Name");
        productRequest.setTemperature("22");*/
        return productRequest;
    }
}
