package com.work.dao;

import java.util.List;

import com.work.entity.Country;
import com.work.exception.DAOException;

public interface CountryDAO {
	public List<Country> getAll() throws DAOException;
	public List<Country> findByName(String name) throws DAOException;
	public void insert(Country country) throws DAOException;
	public void deleteByCode(String code) throws DAOException;
	public void update(Country country) throws DAOException;
}
