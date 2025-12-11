package org.idev.mybank;

import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.idev.mybank.web.TransactionServlet;


public class ApplicationLauncher {
    public static void main(String[] args) throws Exception {

        int serverPort;

        String portProperty = System.getProperty("server.port");
        if (portProperty != null) {
            serverPort = Integer.parseInt(portProperty);
        } else {
            serverPort = 8080;
        }

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(serverPort);
        tomcat.getConnector();

        Context ctx = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(ctx, "transactionServlet", new TransactionServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();

    }
}
