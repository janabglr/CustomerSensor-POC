package com.sgz.customer.sensor.poc.service.services;

import com.sgz.customer.sensor.poc.service.SendSMSAndEmailAlerts;
import com.sgz.customer.sensor.poc.service.models.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by janardhan.nellibanda on 10/3/2016.
 */
public class CustomerSensorInfoDataAccessService {

    public AddCustomerSensorResponse addCustomerSensorInfo(final CustomerSensorRequest customerSensorRequest) throws Exception {
        AddCustomerSensorResponse addCustomerSensorResponse = null;
        try {
            String sqlInsert = "INSERT INTO SensorInfo (tagID,tagTypeID,unit,algo,upper,lower,timeinterval,delay,points,start,stop,mfr,time,data, tagOriginator, tagOwner, tagShipper)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        int update = getJdbcTemplate().update(sqlInsert,
                customerSensorRequest.getSensorInfo().getId(),
                customerSensorRequest.getSensorInfo().getTagTypeID(),
                customerSensorRequest.getSensorInfo().getUnit(),
                customerSensorRequest.getSensorInfo().getAlgo(),
                customerSensorRequest.getSensorInfo().getUpper(),
                customerSensorRequest.getSensorInfo().getLower(),
                customerSensorRequest.getSensorInfo().getInterval(),
                customerSensorRequest.getSensorInfo().getDelay(),
                customerSensorRequest.getSensorInfo().getPoints(),
                customerSensorRequest.getSensorInfo().getStart(),
                customerSensorRequest.getSensorInfo().getStop(),
                customerSensorRequest.getSensorInfo().getMfr(),
                customerSensorRequest.getSensorInfo().getTime(),
                customerSensorRequest.getSensorInfo().getData(),
                customerSensorRequest.getSensorInfo().getTagOriginator(),
                customerSensorRequest.getSensorInfo().getTagOwner(),
                customerSensorRequest.getSensorInfo().getTagShipper()
                );

        /*String query = "INSERT into sensordata (id, changetime, sensordatatime) VALUES (?, ?, ?) ";
        jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {

            public void setValues(java.sql.PreparedStatement ps, int i) throws SQLException {
                SensorData customer = customerSensorRequest.getSensorInfo().getSensorData().get(i);
                ps.setInt(1, Integer.parseInt(customerSensorRequest.getSensorInfo().getId()));
                ps.setShort(2, Short.parseShort(customer.getChangeTime()));
                ps.setString(3, customer.getSensorDataTime());

            }

            public int getBatchSize() {
                return customerSensorRequest.getSensorInfo().getSensorData().size();
            }

        });*/
        addCustomerSensorResponse = new AddCustomerSensorResponse();
        if (update == 1) {
            addCustomerSensorResponse.setMessage("Successfully added sensor info into database..");
        } else {
            addCustomerSensorResponse.setMessage("No rows added to database..");
        }
        } catch (Exception e) {
           throw new Exception("ID already Exists..");
        }
        return addCustomerSensorResponse;
    }

    public GetCustomerSensorResponse getCustomerSensorInfo(String startTime, String stopTime) {
        GetCustomerSensorResponse getCustomerSensorResponse = new GetCustomerSensorResponse();
        String sqlSelect = "SELECT * FROM sensorinfo WHERE start = '"+startTime+"' AND stop = '"+stopTime+"'";
        final List<SensorData> sensorDatas = new ArrayList<SensorData>();
        List<SensorInfo> listContact = getJdbcTemplate().query(sqlSelect, new RowMapper<SensorInfo>() {

            public SensorInfo mapRow(ResultSet result, int rowNum) throws SQLException {
                SensorInfo sensorInfo = new SensorInfo();
                sensorInfo.setId(result.getString("tagId"));
                sensorInfo.setTagTypeID(result.getString("tagTypeID"));
                sensorInfo.setUnit(result.getString("unit"));
                sensorInfo.setAlgo(result.getString("algo"));
                sensorInfo.setUpper(result.getString("upper"));
                sensorInfo.setLower(result.getString("lower"));
                sensorInfo.setInterval(result.getString("timeinterval"));
                sensorInfo.setDelay(result.getString("delay"));
                sensorInfo.setPoints(result.getString("points"));
                sensorInfo.setStart(result.getString("start"));
                sensorInfo.setStop(result.getString("stop"));
                sensorInfo.setMfr(result.getString("mfr"));
                sensorInfo.setTime(result.getString("time"));
                sensorInfo.setData(result.getString("data"));
                /*SensorData sensorData = new SensorData();
                sensorData.setChangeTime(result.getString("changeTime"));
                sensorData.setSensorDataTime("sensorDataTime");
                sensorDatas.add(sensorData);
                sensorInfo.setSensorData(sensorDatas);*/

                return sensorInfo;
            }

        });

        //TODO need to check java sending mail
        /*for (SensorInfo sensorInfo : listContact) {
            if (Integer.parseInt(sensorInfo.getUpper()) > 40 || Integer.parseInt(sensorInfo.getLower()) < 20) {
                String to = "jana.bglr@gmail.com";//change accordingly
                String from = "jana.bglr3@gmail.com";//change accordingly
                String host = "localhost";//or IP address

                //Get the session object
                Properties properties = System.getProperties();
                properties.setProperty("mail.smtp.host", host);
                Session session = Session.getDefaultInstance(properties);

                //compose the message
                try{
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from));
                    message.addRecipient(MimeMessage.RecipientType.TO,new InternetAddress(to));
                    message.setSubject("Ping");
                    message.setText("Hello, this is example of sending email  ");

                    // Send message
                    Transport.send(message);
                    System.out.println("message sent successfully....");
                    getCustomerSensorResponse.setMessage("Mail has sent successfully..");

                } catch (AddressException e) {
                    e.printStackTrace();
                } catch (javax.mail.MessagingException e) {
                    e.printStackTrace();
                }
            }
        }*/


        List<SensorInfo> sensorInfos = new ArrayList<SensorInfo>();
        sensorInfos.addAll(listContact);
        getCustomerSensorResponse.setSensorInfo(sensorInfos);
        return getCustomerSensorResponse;
    }

    public ClientRulesResponse clientRules(final ClientRules clientRules) throws Exception {
        ClientRulesResponse clientRulesResponse = null;
        try {
            String sqlInsert = "INSERT INTO ClientRules (tagId, topTemp, bottomTemp, numberOfTopTemp, numberOfBottomTemp, emailID, phoneNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
            int update = getJdbcTemplate().update(sqlInsert,
                    clientRules.getTagID(),
                    clientRules.getTopTemp(),
                    clientRules.getBottomTemp(),
                    clientRules.getNumberOfTimesTop(),
                    clientRules.getNumberOfTimesBottom(),
                    clientRules.getEmail(),
                    clientRules.getPhone()
            );

            clientRulesResponse = new ClientRulesResponse();
            if (update == 1) {
                clientRulesResponse.setMessage("Successfully added client rules into database..");
            } else {
                clientRulesResponse.setMessage("No rows added to database..");
            }
        }  catch (Exception e) {
            throw new Exception();
        }
        return clientRulesResponse;
    }

    public String createUser(User user) {
        String message = null;

        try {
            String sqlInsert = "INSERT INTO user (username, password) VALUES (?, ?)";
            int update = getJdbcTemplate().update(sqlInsert, user.getUserName(), user.getPassword());
            if (update == 1) {
                message = "Created user successfully..";
            } else {
                message = "No rows added to database..";
            }
        }  catch (Exception e) {
            return "Issue with userName/password";
        }
        return message;
    }

    public String tagOrder(TagOrder tagOrder) {

        String message = null;
        try {

            String query = "INSERT INTO tagorder (username, tagID, tagTypeID) VALUES (?, ?, ?)";
            int update = getJdbcTemplate().update(query, tagOrder.getUserName(), tagOrder.getTagId(), tagOrder.getTagTypeID());

            if (update == 1) {
                message = "Created tagOrder successfully..";
            } else {
                message = "No rows added to database..";
            }

        } catch (Exception e) {
            message = e.getLocalizedMessage();
            e.printStackTrace();
        }

        return message;
    }

    public String tagType(TagType tagType) {

        String message = null;
        try {

            String query = "INSERT INTO tagType (tagTypeID, typeName) VALUES (?, ?)";
            int update = getJdbcTemplate().update(query, tagType.getTagTypeID(), tagType.getTypeName());

            if (update == 1) {
                message = "Created tagType successfully..";
            } else {
                message = "No rows added to database..";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }
   /* public String setTagOrderHtmlData(TagOrderHtmlRequest tagOrderHtmlRequest) {

        List<TagOrder> tagOrders = new ArrayList<TagOrder>();

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        String message = null;
        try {
            dataSource.setDriver(new com.mysql.jdbc.Driver());

            dataSource.setUrl("jdbc:mysql://localhost:3306/customersensor");
            dataSource.setUsername("root");
            dataSource.setPassword("admin123*8");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            String sqlInsert = "INSERT INTO clientrules (tagId, topTemp, bottomTemp, numberOfTimesTop, numberOfTimesBottom, email, phone)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            int update = jdbcTemplate.update(sqlInsert,
                    tagOrderHtmlRequest.getSelectTag(),
                    tagOrderHtmlRequest.getTopTemp(),
                    tagOrderHtmlRequest.getBottomTemp(),
                    tagOrderHtmlRequest.getNumberOfTimesTop(),
                    tagOrderHtmlRequest.getNumberOfTimesBottom(),
                    //tagOrderHtmlRequest.getCheckbox2(),
                    tagOrderHtmlRequest.getEmail(),
                    tagOrderHtmlRequest.getPhone()

            );

            if (update == 1) {
                return "<html> " + "<title>" + "Alert Configuration" + "</title>"
                        + "<body><h1>" + "Updated successfully" + "</body></h1>" + "</html> ";
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }

        return "<html> " + "<title>" + "Alert Configuration" + "</title>"
                + "<body><h1>" + "Exception occurred while adding to database" + "</body></h1>" + "</html> ";
    }*/

    public AlertResponse sendAlerts(AlertRequest alertRequest){
        AlertResponse alertResponse = new AlertResponse();

        try {
            String sqlSelect = "SELECT DISTINCT * from clientrules WHERE username='"+alertRequest.getUserName()+"' " +
                    "AND tagId='"+alertRequest.getTagId()+"' AND topTemp='"+alertRequest.getHighTemperature()+"' " +
                    "AND bottomTemp='"+alertRequest.getLowTemperature()+"' AND numberOfTopTemp='"+alertRequest.getNumberOfOccurencesHigh()+"' " +
                    "AND numberOfBottomTemp='"+alertRequest.getNumberOfOccurencesLow()+"'";
            List<AlertResponse> alertResponses = getJdbcTemplate().query(sqlSelect, new RowMapper<AlertResponse>() {

                public AlertResponse mapRow(ResultSet result, int rowNum) throws SQLException {
                    AlertResponse alertRows = new AlertResponse();
                    alertRows.setUserName(result.getString("username"));
                    alertRows.setTagId(result.getString("tagId"));
                    alertRows.setHighTemperature(result.getString("topTemp"));
                    alertRows.setLowTemperature(result.getString("bottomTemp"));
                    alertRows.setNumberOfOccurencesHigh(result.getString("numberOfTopTemp"));
                    alertRows.setNumberOfOccurencesLow(result.getString("numberOfBottomTemp"));
                    alertRows.setEmail(result.getString("emailId"));
                    alertRows.setPhone(result.getString("phoneNumber"));
                    alertRows.setRuleID(result.getString("ruleID"));
                    return alertRows;
                }

            });

            if (CollectionUtils.isNotEmpty(alertResponses)) {
                for (AlertResponse alertResp : alertResponses) {
                    String message = SendSMSAndEmailAlerts.sendEmailAlert(alertResp.getEmail(), alertResp.getTagId(), alertResp.getRuleID());
                    alertResponse.setMessage(message);
                    /*String deleteStatement = "DELETE from clientrules WHERE username='"+alertResp.getUserName()+"' " +
                            "AND tagId='"+alertResp.getTagId()+"' AND topTemp='"+alertResp.getHighTemperature()+"' " +
                            "AND bottomTemp='"+alertResp.getLowTemperature()+"' AND numberOfTimesTop='"+alertResp.getNumberOfOccurencesHigh()+"' " +
                            "AND numberOfTimesBottom='"+alertResp.getNumberOfOccurencesLow()+"'" +
                            "AND email='"+alertResp.getEmail()+"'" + "AND phone='"+alertResp.getPhone()+"'";
                    int update = jdbcTemplate.update(deleteStatement);
                    if (update != 1) {
                        alertResponse.setMessage("Error occurred while deleting row in database");
                    }*/
                }
            } else {
                alertResponse.setMessage("No Rows Found");
            }

            } catch (Exception e1) {
            e1.printStackTrace();
        }
        return alertResponse;

    }


    public AlertReportResponse getalertreport(){
        AlertReportResponse alertResponses = null;
        try {
            String sqlSelect = "SELECT * from clientrules";
            List<AlertResponse> alertResponse = getJdbcTemplate().query(sqlSelect, new RowMapper<AlertResponse>() {

                public AlertResponse mapRow(ResultSet result, int rowNum) throws SQLException {
                    AlertResponse alertRows = new AlertResponse();
                    alertRows.setUserName(result.getString("username"));
                    alertRows.setTagId(result.getString("tagId"));
                    alertRows.setHighTemperature(result.getString("topTemp"));
                    alertRows.setLowTemperature(result.getString("bottomTemp"));
                    alertRows.setNumberOfOccurencesHigh(result.getString("numberOfTopTemp"));
                    alertRows.setNumberOfOccurencesLow(result.getString("numberOfBottomTemp"));
                    alertRows.setEmail(result.getString("emailId"));
                    alertRows.setPhone(result.getString("phoneNumber"));
                    return alertRows;
                }

            });
            alertResponses = new AlertReportResponse();
            alertResponses.setAlertResponse(alertResponse);


        } catch (Exception e1) {
            e1.printStackTrace();

        }


        return alertResponses;

    }


    public AlertReportResponse sensorData(){
        AlertReportResponse alertResponses = null;
        try {
            String sqlSelect = "SELECT * from clientrules";
            List<AlertResponse> alertResponse = getJdbcTemplate().query(sqlSelect, new RowMapper<AlertResponse>() {

                public AlertResponse mapRow(ResultSet result, int rowNum) throws SQLException {
                    AlertResponse alertRows = new AlertResponse();
                    alertRows.setUserName(result.getString("username"));
                    alertRows.setTagId(result.getString("tagId"));
                    alertRows.setHighTemperature(result.getString("topTemp"));
                    alertRows.setLowTemperature(result.getString("bottomTemp"));
                    alertRows.setNumberOfOccurencesHigh(result.getString("numberOfTopTemp"));
                    alertRows.setNumberOfOccurencesLow(result.getString("numberOfBottomTemp"));
                    alertRows.setEmail(result.getString("emailId"));
                    alertRows.setPhone(result.getString("phoneNumber"));
                    return alertRows;
                }

            });
            alertResponses = new AlertReportResponse();
            alertResponses.setAlertResponse(alertResponse);


        } catch (Exception e1) {
            e1.printStackTrace();

        }


        return alertResponses;

    }


    public String eventLog(String tagID, String ruleID) {

        try {
            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            dataSource.setDriver(new com.mysql.jdbc.Driver());

            dataSource.setUrl("jdbc:mysql://localhost:3306/customersensor");
            dataSource.setUsername("root");
            dataSource.setPassword("admin123*8");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            String sqlInsert = "INSERT INTO EventLog (tagID, ruleID, confirmation) VALUES (?, ?, ?)";
            int update = jdbcTemplate.update(sqlInsert, tagID, ruleID, "YES");

            int update1 = jdbcTemplate.update("UPDATE sensordata SET reviewed=? WHERE tagId=?", "YES", tagID);

            if (update != 0 && update1 != 0) {
                return "<html> " + "<title>" + "Alert Configuration" + "</title>"
                        + "<body><h1>" + "Thanks for the confirmation" + "</body></h1>" + "</html> ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "<html> " + "<title>" + "Alert Configuration" + "</title>"
                + "<body><h1>" + "Exception occurred while adding to data into EventLog" + "</body></h1>" + "</html> ";


    }

    public SensorDataResponse sensorData(SensorData sensorData) {

        SensorDataResponse sensorDataResponse = new SensorDataResponse();
        try {
            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            dataSource.setDriver(new com.mysql.jdbc.Driver());

            dataSource.setUrl("jdbc:mysql://localhost:3306/customersensor");
            dataSource.setUsername("root");
            dataSource.setPassword("admin123*8");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            String sqlInsert = "INSERT INTO SensorData (tagID, sensorTemp, tagType, sensorTimeStamp, reviewed, metadata) VALUES (?, ?, ?, ?, ?, ?)";
            int update = jdbcTemplate.update(sqlInsert, sensorData.getTagID(), sensorData.getSensorTemp(), sensorData.getTagType(),
                    sensorData.getSensorTimeStamp(), "NO", sensorData.getMetadata());



            if (update == 1) {
                List<Map<String, Object>> storedProcedureResult = callStoredProcedure(sensorData);
                if (CollectionUtils.isNotEmpty(storedProcedureResult)) {
                    sensorDataResponse.setMessage(SendSMSAndEmailAlerts.sendEmailAndSMSAlert(storedProcedureResult));
                } else {
                    sensorDataResponse.setMessage("Please check the details and try again.");
                }
            } else {
                sensorDataResponse.setMessage("Error Occurred while inserting into database");
            }
        } catch (Exception e) {
            sensorDataResponse.setMessage(e.getLocalizedMessage());
            e.printStackTrace();
        }

        return sensorDataResponse;

    }


    private static List<Map<String, Object>> callStoredProcedure(SensorData sensorData) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                .withProcedureName("email_sending_query");
        Map<String, Object> inParamMap = new HashMap<String, Object>();

        inParamMap.put("tagId", sensorData.getTagID());
        inParamMap.put("TagTypeId", sensorData.getTagType());
        inParamMap.put("SensorTemp", sensorData.getSensorTemp());
        inParamMap.put("MetaData", sensorData.getMetadata());
        SqlParameterSource in = new MapSqlParameterSource(inParamMap);
        Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
        System.out.println(simpleJdbcCallResult.get("#result-set-3"));
        List<Map<String, Object>> list = (List<Map<String, Object>>) simpleJdbcCallResult.get("#result-set-3");
        return list;
    }


    private static JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = null;

        try {
            final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            dataSource.setDriver(new com.mysql.jdbc.Driver());
            dataSource.setUrl("jdbc:mysql://localhost:3306/customersensor");
            dataSource.setUsername("root");
            dataSource.setPassword("admin123*8");
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jdbcTemplate;
    }

}
