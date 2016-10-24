package com.sgz.customer.sensor.poc.service;

import com.textmagic.sdk.RestClient;
import com.textmagic.sdk.RestException;
import com.textmagic.sdk.resource.instance.TMNewMessage;
import org.apache.commons.lang.StringUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

/**
 * Created by janardhan.nellibanda on 10/4/2016.
 */

public class SendSMSAndEmailAlerts {

    public static String sendEmailAlert(Map<String, Object> resultMap) {

        final String username = "testemail4poc@gmail.com";
        final String password = "test2016";
        final String toEmail = String.valueOf(resultMap.get("EmailId"));
        final String tagID = String.valueOf(resultMap.get("TagId"));
        final String ruleID = String.valueOf(resultMap.get("RuleId"));

        final String degrees = String.valueOf(resultMap.get("TopTemp"));
        final String numberOfOccurrence = String.valueOf(resultMap.get("numberOfOccurence"));
        final String boxID = String.valueOf(resultMap.get("TagId"));
        final String owner = String.valueOf(resultMap.get("tag_owner"));
        final String originator = String.valueOf(resultMap.get("tag_originator"));
        final String shipper = String.valueOf(resultMap.get("tag_shipper"));
        final String dateTime = String.valueOf(resultMap.get(""));

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        String alertMessage;
        try {

                Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("testemail4poc@gmail.com"));
            message.setContent("Content-Type", "text/html; charset=UTF-8");
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(String.valueOf(toEmail)));
            message.setSubject("Alert!! Tempurature Update");
           message.setText("Temp > "+degrees+" degrees \n" +
                    "Number of Occurrence "+numberOfOccurrence+"\n" +
                    "The Box ID = "+boxID+"\n" +
                    "Owner = '"+owner+"'\n" +
                    "Originator = '"+originator+"' \n" +
                    "Shipper = '"+shipper+"'\n" +
                    "Date Time = '"+dateTime+"' SensorData\n" +
                    "\n" +
                    "Please click <a href=\"http://localhost:8888/v1/customer/sensor/eventlog?tagID="+tagID+"&ruleID="+ruleID+">here</a>\" to confirm the Mail");


            Transport.send(message);

            alertMessage = "Email sent successfully";

        } catch (MessagingException e) {
            alertMessage = "Error Occurred While Sending Email Alert";
            e.printStackTrace();
        }

        return alertMessage;
    }

    public static String sendEmailAlert(String email, String tagID, String ruleID) {

        final String username = "testemail4poc@gmail.com";
        final String password = "test2016";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        String alertMessage;
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("testemail4poc@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(String.valueOf(email)));
            message.setSubject("Alert!! Tempurature Update");
            message.setText("Please click <a href=\"http://localhost:8888/v1/customer/sensor/eventlog?tagID="+tagID+"&ruleID="+ruleID+">here</a>\" to confirm the Mail");


            Transport.send(message);

            alertMessage = "Email sent successfully";

        } catch (MessagingException e) {
            alertMessage = "Error Occurred While Sending Email Alert";
            e.printStackTrace();
        }

        return alertMessage;
    }


    public static String sendSMSAlert(String phoneNumber) {
        RestClient client = new RestClient("mahabirsingh", "1ilWFmDVg8lfHFLkiVpJdZrKbuy93s");

        String message;
        TMNewMessage m = client.getResource(TMNewMessage.class);
        m.setText("Hello from TextMagic Java");
        m.setPhones(Collections.singletonList(phoneNumber));
        try {
            m.send();
            message = "SMS Alert Sent";
        } catch (final RestException e) {
            message = "Error Occurred While Sending SMS Alert";
            e.printStackTrace();

        }
        return message;
    }

    /*public static String sendEmailAndSMSAlert(String email, String phone, String tagId, String ruleID) {

        String emailAlertMessage = null;
        String smsAlertMessage = null;
        if (StringUtils.isNotBlank(email)) {
            emailAlertMessage = sendEmailAlert(email, Integer.parseInt(tagId), Integer.parseInt(ruleID));
        }

        if (StringUtils.isNotBlank(phone)) {
            smsAlertMessage = sendSMSAlert(phone);
        }

        return emailAlertMessage + smsAlertMessage;
    }*/

    public static String sendEmailAndSMSAlert(List<Map<String, Object>> list) {

        String emailAlertMessage = null;
        String smsAlertMessage = null;

        for (Map<String, Object> stringStringMap : list) {
            if (StringUtils.isNotBlank((String) stringStringMap.get("EmailId"))) {
                emailAlertMessage = sendEmailAlert(stringStringMap);
            }
        }

        /*if (StringUtils.isNotBlank(phone)) {
            smsAlertMessage = sendSMSAlert(phone);
        }*/

        return emailAlertMessage/* + smsAlertMessage*/;
    }
}