package com.sgz.customer.sensor.poc.service.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by janardhan.nellibanda on 10/4/2016.
 */
@XmlRootElement(name = "user")
public class User implements Serializable{

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
