package com.staystrong.main;

import com.staystrong.config.TestSuperMaperClassCofig;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SsmMainClass {
    public static void main(String[] args) {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        String path= Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1);
        Tomcat tomcat=new Tomcat();
        tomcat.setPort(Integer.valueOf(System.getProperty("port","8081")));
        tomcat.addContext("/",path);
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.register(TestSuperMaperClassCofig.class);
        DispatcherServlet dispatcherServlet=new DispatcherServlet(context);
        Wrapper wrapper = tomcat.addServlet("/", "tanji", dispatcherServlet);
        wrapper.setLoadOnStartup(1);
        wrapper.addMapping("/*");
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
