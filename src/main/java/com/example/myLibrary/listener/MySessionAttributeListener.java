package com.example.myLibrary.listener;

import com.example.myLibrary.model.User;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Date;

@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String id = event.getSession().getId();
        User atrValue = (User) event.getValue();
        System.out.println("user with " + atrValue.getEmail() + " email logged in at " +
                new Date() + "session id " + id);
    }
}
