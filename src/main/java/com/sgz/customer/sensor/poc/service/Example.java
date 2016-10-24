package com.sgz.customer.sensor.poc.service;

/**
 * Created by janardhan.nellibanda on 10/13/2016.
 */
import com.textmagic.sdk.RestClient;
import com.textmagic.sdk.RestException;
import com.textmagic.sdk.resource.instance.*;
import java.util.Arrays;
import java.util.Collections;

public class Example{
    public static void main(String[] args) throws RestException {
        //pwd mahabir123
        RestClient client = new RestClient("mahabirsingh", "1ilWFmDVg8lfHFLkiVpJdZrKbuy93s");

        TMNewMessage m = client.getResource(TMNewMessage.class);
        m.setText("Hello from TextMagic Java");
        m.setPhones(Collections.singletonList("+918197332722"));
        try {
            m.send();
        } catch (final RestException e) {
            System.out.println(e.getErrors());
            throw new RuntimeException(e);
        }
        System.out.println(m.getId());
    }
}
