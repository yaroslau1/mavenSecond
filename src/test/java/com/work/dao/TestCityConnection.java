package com.work.dao;

import com.work.exception.DAOException;

public class TestCityConnection {

    protected TestCityConnection(){
        try {
            CityConnectDAO cityConnectDAO = new CityConnectDAO("com/work/company/test.properties");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
