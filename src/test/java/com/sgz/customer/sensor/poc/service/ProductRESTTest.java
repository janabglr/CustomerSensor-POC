package com.sgz.customer.sensor.poc.service;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;
import com.sun.jersey.test.framework.spi.container.grizzly2.web.GrizzlyWebTestContainerFactory;
import org.junit.After;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created with IntelliJ IDEA.
 * User: Janardhan
 */
public class ProductRESTTest extends JerseyTest {

    @Override
    protected AppDescriptor configure() {

        return new WebAppDescriptor.Builder(
                "com.rfid.products.poc.service").contextPath("/")
                .contextParam("contextConfigLocation", "classpath:spring/resources/customer-sensor-poc.xml")
                .initParam("com.sun.jersey.config.property.packages", "com.rfid.products.poc.service; org.codehaus.jackson.jaxrs")
                .contextParam("contextClass", "MockableContext")
                .servletClass(SpringServlet.class)
                .contextListenerClass(ContextLoaderListener.class)
                .requestListenerClass(RequestContextListener.class)
                .build();
    }

    @Override
    protected int getPort(final int defaultPort) {

        ServerSocket server = null;
        int port = -1;
        try {
            server = new ServerSocket(0);
            port = server.getLocalPort();
        } catch (IOException e) {
           // LOGGER.error("exception", e);
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    //LOGGER.error("exception", e);
                }
            }
        }
        if ((port != -1) || (defaultPort == 0)) {
            return port;
        }
        return getPort(0);
    }

    @After
    public void cleanMockContext() throws Exception {
        MockableContext.cleanup();
    }

    @Override
    public TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();
    }

}
