package com.work.dao;

import java.util.List;

import com.work.entity.City;
import com.work.exсeption.DAOException;

public interface CityDAO {
	public List<City> getAll () throws DAOException;
	public List<City> findByName (String name) throws DAOException;
	public void insert (City city) throws DAOException;
	public void deleteById (int id) throws DAOException;
	public void update (City city) throws DAOException;
}
