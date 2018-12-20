package com.work.dao;


import com.work.entity.City;
import com.work.exception.DAOException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CityConnectDAOTest {
    private static CityConnectDAO cityConnectDAO;

    @BeforeClass
    public static void open(){
        try {
            cityConnectDAO = new CityConnectDAO("com/work/company/test.properties");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() {
        List<City> cityList = new ArrayList<>();
        try {
            cityList = cityConnectDAO.getAll();
            assertEquals(1,cityList.get(0).getId());
            assertEquals("Minsk",cityList.get(0).getName());
            assertEquals("BLR",cityList.get(0).getCountryCode());
            assertEquals(150000,cityList.get(0).getPopulation());
            assertEquals(2,cityList.get(1).getId());
            assertEquals("Brest",cityList.get(1).getName());
            assertEquals("BLR",cityList.get(1).getCountryCode());
            assertEquals(60000,cityList.get(1).getPopulation());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByName() {
        try {
            assertEquals(1, cityConnectDAO.findByName("Minsk").get(0).getId());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {
        City city = new City("Pinsk", 150000,"BLR");
        try {
            cityConnectDAO.insert(city);
            assertEquals(3, cityConnectDAO.getAll().size());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteById() {

    }

    @Test
    public void update() {
    }
}
