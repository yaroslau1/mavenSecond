package com.work.dao;

import com.work.entity.User;
import com.work.exception.DAOException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class UserConnectDAO implements UserDAO, AutoCloseable {

    private Connection connection;
    private PreparedStatement getAll = null;
    private PreparedStatement insert;
    private PreparedStatement delete = null;
    private PreparedStatement update = null;

    public UserConnectDAO() throws DAOException{
        Properties property = new Properties();
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream reader = classLoader.getResourceAsStream("com/work/company/properties.properties");
        try {
            property.load(reader);
            String driverName = property.getProperty("driver");
            String url = property.getProperty("url");
            String user = property.getProperty("user");
            String pass = property.getProperty("pass");
            reader.close();
            Class.forName(driverName).newInstance();
            connection = DriverManager.getConnection(url, user, pass);
            getAll = connection.prepareStatement("SELECT Name, Password, Age FROM user");
            insert = connection.prepareStatement("INSERT INTO user (Name, Password, Age) VALUES (?, ?, ?)");
            delete = connection.prepareStatement("DELETE FROM user WHERE Name = ?");
            update = connection.prepareStatement("UPDATE user SET Password = ?, Age = ? WHERE Name = ?");
        } catch (IOException e) {
            throw new DAOException("Error in constructor with file opening", e);
        } catch (InstantiationException e) {
            throw new DAOException("Error in constructor: object Class not found", e);
        } catch (IllegalAccessException e) {
            throw new DAOException("Error in constructor with access to DB", e);
        } catch (ClassNotFoundException e) {
            throw new DAOException("Error in constructor with ClassPath", e);
        } catch (SQLException e) {
            throw new DAOException("Error in constructor with SQLQuery", e);
        }
    }

    @Override
    public List<User> getAll() throws DAOException {
        List<User> listUsers = new LinkedList<>();
        try (ResultSet resultSet = getAll.executeQuery()){
            while(resultSet.next()){
                User user = new User();
                String age = resultSet.getString("Age");
                String name = resultSet.getString("Name");
                String pass = resultSet.getString("Password");
                user.setName(name);
                user.setPass(pass);
                user.setAge(Integer.parseInt(age));
                listUsers.add(user);
            }
            return listUsers;
        } catch (SQLException e) {
            throw new DAOException("Error in getAll user method", e);
        }
    }

    @Override
    public List<User> findByName(String name) throws DAOException {
        List<User> listUsers = new LinkedList<>();
        try (ResultSet resultSet = getAll.executeQuery()){
            while(resultSet.next()){
                User user = new User();
                String nameForSearch = resultSet.getString("Name");
                if (nameForSearch.equals(name)) {
                    String age = resultSet.getString("Age");
                    String pass = resultSet.getString("Password");
                    user.setName(name);
                    user.setAge(Integer.parseInt(age));
                    user.setPass(pass);
                    listUsers.add(user);
                }
            }
            return listUsers;
        } catch (SQLException e) {
            throw new DAOException("Error in findByName user method", e);
        }
    }

    @Override
    public void insert(User user) throws DAOException {
        try {
            insert.setString(1, user.getName());
            insert.setString(2, user.getPass());
            insert.setInt(3, user.getAge());
            insert.execute();
        } catch (SQLException e) {
            throw new DAOException("error in add user", e);
        }
    }

    @Override
    public void delete(User user) throws DAOException {
        try {
            delete.setString(1, user.getName());
            delete.execute();
        } catch (SQLException e) {
            throw new DAOException("error in delete user", e);
        }
    }

    @Override
    public void update(User user) throws DAOException {
        try {
            update.setString(1, user.getPass());
            update.setInt(2, user.getAge());
            update.setString(3, user.getName());
            update.execute();
        } catch (SQLException e) {
            throw new DAOException("error in update user", e);
        }
    }

    @Override
    public void close() throws Exception {
        SQLException exception = new SQLException("Some errors with closing");
        if(getAll != null){
            try {
                getAll.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if(delete != null){
            try {
                delete.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if(update != null){
            try {
                update.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if(insert != null){
            try {
                insert.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (exception.getSuppressed().length > 0) {
            throw new DAOException("errors with closing PrepereStatement in city dao", exception);
        }
    }
}
