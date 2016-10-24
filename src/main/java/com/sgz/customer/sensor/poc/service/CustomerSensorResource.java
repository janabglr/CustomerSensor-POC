package com.sgz.customer.sensor.poc.service;


import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.sgz.customer.sensor.poc.service.models.*;
import com.sgz.customer.sensor.poc.service.models.Error;
import com.sgz.customer.sensor.poc.service.services.CustomerSensorInfoDataAccessService;
import com.sun.jersey.spi.resource.Singleton;
import net.sf.jasperreports.engine.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.text.html.HTML;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
@Singleton
@Path("customer/sensor")
@Named
public class CustomerSensorResource {
    private static final ImmutableSet<String> REQUEST_QUERY_PARAMS = ImmutableSet.of("startTime", "stopTime");
    private final CustomerSensorInfoDataAccessService customerSensorInfoDataAccessService;

    @Inject
    public CustomerSensorResource(final CustomerSensorInfoDataAccessService customerSensorInfoDataAccessService) {
        this.customerSensorInfoDataAccessService = customerSensorInfoDataAccessService;
    }

    @GET
    @Path("getSensorInfo")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllTemperature(@QueryParam("startTime") String startTime,
                                      @QueryParam("stopTime") String stopTime,
                                      @Context final UriInfo uriInfo) {

        Response response = null;

        try {
            for (String paramName : uriInfo.getQueryParameters().keySet()) {
                if (!REQUEST_QUERY_PARAMS.contains(paramName)) {
                    throw new Exception(paramName + " is not a valid parameter");
                }
            }
            response = Response.status(Response.Status.OK).entity(customerSensorInfoDataAccessService.getCustomerSensorInfo(startTime, stopTime)).build();

        } catch (Exception e) {
            response = getErrorResponse(e);
        }

        return response;
    }

    @POST
    @Path("addSensorInfo")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addBooks(CustomerSensorRequest customerSensorRequest,
                             @QueryParam("limit") String limit) {

        Response response = null;

        try {

            response = Response.status(Response.Status.OK).entity(customerSensorInfoDataAccessService.addCustomerSensorInfo(customerSensorRequest)).build();
        } catch (Exception e) {
            response = getErrorResponse(e);

        }

        return response;
    }

    @POST
    @Path("clientrules")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response clientRules(ClientRules clientRules) {

        Response response = null;

        try {

            response = Response.status(Response.Status.OK).entity(customerSensorInfoDataAccessService.clientRules(clientRules)).build();
        } catch (Exception e) {
            response = getErrorResponse(e);

        }

        return response;
    }

    @POST
    @Path("createUser")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createUser(User user) {

        Response response = null;

        try {

            response = Response.status(Response.Status.OK).entity(customerSensorInfoDataAccessService.createUser(user)).build();
        } catch (Exception e) {
            response = getErrorResponse(e);

        }

        return response;
    }

    /*
    * Adds userName and tagDetails to database
    *
    * */

   @POST
    @Path("setTagOrder")
   @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response setTagOrder(TagOrder tagOrder) {

        Response response = null;

        try {
            response = Response.status(Response.Status.OK).entity(customerSensorInfoDataAccessService.tagOrder(tagOrder)).build();
        } catch (Exception e) {
            response = getErrorResponse(e);

        }

        return response;
    }

    @POST
    @Path("tagType")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response tagType(TagType tagType) {

        Response response = null;

        try {
            response = Response.status(Response.Status.OK).entity(customerSensorInfoDataAccessService.tagType(tagType)).build();
        } catch (Exception e) {
            response = getErrorResponse(e);

        }

        return response;
    }
     private Response getErrorResponse(Exception e) {
        Response response;
        AddCustomerSensorResponse productResponse = new AddCustomerSensorResponse();
        Error error = new Error();
        if (e.getMessage().contains("Duplicate entry ")){
            error.setMessage("ID already exists..");
        } else {
            error.setMessage(e.getMessage());
        }
        productResponse.setError(error);
        response = Response.status(Response.Status.BAD_REQUEST).entity(productResponse).build();
        return response;
    }


    @POST
    @Path("alert")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AlertResponse sendAlerts(AlertRequest alertRequest) {

        AlertResponse response = null;

        try {

            response = customerSensorInfoDataAccessService.sendAlerts(alertRequest);
        } catch (Exception e) {
            getErrorResponse(e);

        }

        return response;
    }

    @GET
    @Path("getreport")
    @Produces(MediaType.APPLICATION_JSON)
    public AlertReportResponse getReport() {

        AlertReportResponse response = null;

        try {

            response = customerSensorInfoDataAccessService.getalertreport();
        } catch (Exception e) {
            getErrorResponse(e);

        }

        return response;
    }

    @GET
    @Path("sensordata")
    @Produces(MediaType.APPLICATION_JSON)
    public AlertReportResponse sensorData() {

        AlertReportResponse response = null;

        try {

            response = customerSensorInfoDataAccessService.getalertreport();
        } catch (Exception e) {
            getErrorResponse(e);

        }

        return response;
    }


    @GET
    @Path("eventlog")
    @Produces(MediaType.TEXT_HTML)
    public String eventLog(@QueryParam("tagID") String tagID,
                                        @QueryParam("ruleID") String ruleID) {

        String response = null;

        try {

            response = customerSensorInfoDataAccessService.eventLog(tagID, ruleID);
        } catch (Exception e) {
            getErrorResponse(e);

        }

        return response;
    }

    @POST
    @Path("sensordata")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public SensorDataResponse sensorData(SensorData sensorData) {

        SensorDataResponse response = null;

        try {

            response = customerSensorInfoDataAccessService.sensorData(sensorData);
        } catch (Exception e) {
            getErrorResponse(e);

        }

        return response;
    }


    @GET
    @Path("pdf")
    @Produces("application/pdf")
    public Response outputPDF() {

        OutputStream output = null;

        try {
            File jrxmlFile = new File("C:\\Users\\m-takayashiki\\report2.jrxml");

            if(jrxmlFile.exists()) {

                //jrxml compile
                JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFile.getAbsolutePath());

                //some code emitted

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

                String filePath = "C:\\Users\\m-takayashiki\\MyAwesomeJasperReport25.pdf";
                output = new FileOutputStream(new File(filePath));
                JasperExportManager.exportReportToPdfStream(jasperPrint, output);


                // From here trying to ask user to download PDF

                Response.ResponseBuilder response = Response.ok((Object) filePath);

                response.header("Content-disposition",
                        "attachment; filename=MyAwesomeJasperReportDownload.pdf");

                return response.build();
            }
        }
        catch(Exception e) {
            System.out.println("-------------------- PDF exception ");
            System.out.println(e);
            return null;
        }
        finally {
            try {
                if(output != null) { output.close(); }
            }
            catch(Exception e) { System.out.println(e); }

        }
    }
}
