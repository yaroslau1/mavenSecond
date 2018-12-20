package com.work.dao;


import com.work.entity.City;
import com.work.exception.DAOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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

    @AfterClass
    public static void close(){
        try {
            cityConnectDAO.close();
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() {
        List<City> cityList;
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
        List<City> cityList;
        try {
            cityList = cityConnectDAO.findByName("Minsk");
            assertEquals(1, cityList.get(0).getId());
            assertEquals("Minsk",cityList.get(0).getName());
            assertEquals("BLR",cityList.get(0).getCountryCode());
            assertEquals(150000,cityList.get(0).getPopulation());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {
        City city = new City(3,"Pinsk", 150000,"BLR");
        List<City> cityList;
        try {
            cityConnectDAO.insert(city);
            cityList = cityConnectDAO.findByName("Pinsk");
            assertEquals(3, cityList.get(0).getId());
            assertEquals("Pinsk",cityList.get(0).getName());
            assertEquals("BLR",cityList.get(0).getCountryCode());
            assertEquals(150000,cityList.get(0).getPopulation());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteById() {
        List<City> cityList;
        try {
            cityConnectDAO.deleteById(2);
            cityList = cityConnectDAO.findByName("Brest");
            assertEquals(true, cityList.isEmpty());
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void update() {
        List<City> cityList;
        City city = new City(2, "Pinsk", 150000,"BLR");
        try {
            cityConnectDAO.update(city);
            cityList = cityConnectDAO.getAll();
            assertEquals(2,cityList.get(1).getId());
            assertEquals("Pinsk",cityList.get(1).getName());
            assertEquals("BLR",cityList.get(1).getCountryCode());
            assertEquals(150000,cityList.get(1).getPopulation());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
