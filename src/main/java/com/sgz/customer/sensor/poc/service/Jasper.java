package com.sgz.customer.sensor.poc.service;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by janardhan.nellibanda on 10/14/2016.
 */
public class Jasper {

    public static void main(String[] args) {


        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customersensor", "root", "admin123*8");
            InputStream inputStream = new FileInputStream(new File(".jrxml"));
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            Map<String, String> map = new HashMap<String, String>();

            map.put("jasper report", "client rules report");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);

            //OutputStream outputStream = new FileOutputStream(new File("D://report.html"));
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "D://report.html");
        } catch (Exception e) {

        }
    }
}
