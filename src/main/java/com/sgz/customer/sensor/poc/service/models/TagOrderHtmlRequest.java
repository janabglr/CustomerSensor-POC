package com.sgz.customer.sensor.poc.service.models;

/**
 * Created by janardhan.nellibanda on 10/10/2016.
 */
public class TagOrderHtmlRequest {

    private String selectTag;
    private String bottomTemp;
    private String numberOfTimesBottom;
    private String topTemp;
    private String numberOfTimesTop;
    private String checkbox2;
    private String email;
    private String phone;


    public String getSelectTag() {
        return selectTag;
    }

    public void setSelectTag(String selectTag) {
        this.selectTag = selectTag;
    }

    public String getBottomTemp() {
        return bottomTemp;
    }

    public void setBottomTemp(String bottomTemp) {
        this.bottomTemp = bottomTemp;
    }

    public String getNumberOfTimesBottom() {
        return numberOfTimesBottom;
    }

    public void setNumberOfTimesBottom(String numberOfTimesBottom) {
        this.numberOfTimesBottom = numberOfTimesBottom;
    }

    public String getTopTemp() {
        return topTemp;
    }

    public void setTopTemp(String topTemp) {
        this.topTemp = topTemp;
    }

    public String getNumberOfTimesTop() {
        return numberOfTimesTop;
    }

    public void setNumberOfTimesTop(String numberOfTimesTop) {
        this.numberOfTimesTop = numberOfTimesTop;
    }

    public String getCheckbox2() {
        return checkbox2;
    }

    public void setCheckbox2(String checkbox2) {
        this.checkbox2 = checkbox2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
