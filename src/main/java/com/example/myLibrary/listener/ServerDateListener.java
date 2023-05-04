package com.example.myLibrary.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener
public class ServerDateListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("server started at " + new Date());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("server stopped at " + new Date());
    }
}
