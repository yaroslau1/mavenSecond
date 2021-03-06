package com.work.listeners;

import com.work.dao.CityConnectDAO;
import com.work.dao.UserConnectDAO;
import com.work.exception.DAOException;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent sessionEvent) {
        System.out.println("Session Created:: ID="+sessionEvent.getSession().getId());
        sessionEvent.getSession().setAttribute("name", "Session");
        try {
            CityConnectDAO cityConnectDAO = new CityConnectDAO();
            UserConnectDAO userConnectDAO = new UserConnectDAO();
            sessionEvent.getSession().setAttribute("cityConnectDB", cityConnectDAO);
            sessionEvent.getSession().setAttribute("userConnectDB", userConnectDAO);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        System.out.println("Session Destroyed:: ID="+sessionEvent.getSession().getId());
        try {
            CityConnectDAO cityConnectDAO = (CityConnectDAO) sessionEvent.getSession().getAttribute("cityConnectDAO");
            UserConnectDAO userConnectDAO = (UserConnectDAO) sessionEvent.getSession().getAttribute("userConnectDAO");
            cityConnectDAO.close();
            userConnectDAO.close();
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
