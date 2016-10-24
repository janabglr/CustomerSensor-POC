package com.sgz.customer.sensor.poc.service.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by janardhan.nellibanda on 10/4/2016.
 */
@XmlRootElement(name = "tagOrder")
public class TagOrder implements Serializable{

    private String userName;
    private String tagId;
    private String tagTypeID;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagTypeID() {
        return tagTypeID;
    }

    public void setTagTypeID(String tagTypeID) {
        this.tagTypeID = tagTypeID;
    }
}
