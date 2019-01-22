package com.work.dao;

import com.work.entity.User;
import com.work.exception.DAOException;

import java.util.List;

public interface UserDAO {
    public List<User> getAll () throws DAOException;
    public List<User> findByName (String name) throws DAOException;
    public void insert (User user) throws DAOException;
    public void delete (User user) throws DAOException;
    public void update (User user) throws DAOException;
}
