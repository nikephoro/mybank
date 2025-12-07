package org.idev.mybank;

import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.idev.mybank.web.TransactionServlet;


public class ApplicationLauncher {
    public static void main(String[] args) throws Exception {
        String systemPort = System.getProperty("server.port", "8080");
        int port = Integer.parseInt(systemPort);

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.getConnector();

        Context context = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(context, "TransactionServlet", new TransactionServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();

    }
}
