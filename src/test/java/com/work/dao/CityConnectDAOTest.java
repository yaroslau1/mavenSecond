package com.work.dao;


import com.work.exception.DAOException;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class CityConnectDAOTest {
    CityConnectDAO cityConnectDAO;

    {
        try {
            cityConnectDAO = new CityConnectDAO("com/work/company/test.properties");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void close() {
    }

    @Test
    public void getAll() {
        try {
            assertEquals(2,cityConnectDAO.getAll().size());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByName() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void update() {
    }
}
