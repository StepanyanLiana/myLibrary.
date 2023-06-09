package com.example.myLibrary.listener;

import com.example.myLibrary.model.User;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Date;

@WebListener
public class UserEventListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String id = event.getSession().getId();
        String name = event.getName();
        User atrValue = (User) event.getValue();
        if (name.equalsIgnoreCase("user")) {
            System.out.println("user with " + atrValue.getEmail() + " email logged in at " +
                    new Date() + "session id " + id);
        }
    }
}