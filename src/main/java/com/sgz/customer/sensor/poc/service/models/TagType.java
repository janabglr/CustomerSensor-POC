package com.sgz.customer.sensor.poc.service.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by janardhan.nellibanda on 10/17/2016.
 */
@XmlRootElement(name = "tagType")
public class TagType {

    private String tagTypeID;
    private String TypeName;

    public String getTagTypeID() {
        return tagTypeID;
    }

    public void setTagTypeID(String tagTypeID) {
        this.tagTypeID = tagTypeID;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }
}
