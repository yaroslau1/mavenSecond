package com.work.company;

import com.work.dao.CityConnectDAO;
import com.work.dao.CountryConnectDAO;
import com.work.dao.UserConnectDAO;
import com.work.entity.User;
import com.work.exception.DAOException;

public class MainAppCompany {

	public static void main(String[] args) {
		long start;
		long end;
		start = System.currentTimeMillis();
		try (CityConnectDAO cityConnectDAO = new CityConnectDAO();
			 CountryConnectDAO countryConnectDAO = new CountryConnectDAO();
			 UserConnectDAO userConnectDAO = new UserConnectDAO()){
			//cityConnectDAO.math();
			//System.out.println( cityConnectDAO.getAll() );
			//System.out.println( cityConnectDAO.findByName("Minsk") );
			//System.out.println( cityConnectDAO.findByName("Brest") );
			//System.out.println( cityConnectDAO.findByName("Grodno") );
			
			//cityConnectDAO.addValues("Stry", "BLR", 1234);
			//System.out.println(cityConnectDAO.getAll());
			//System.out.println( countryConnectDAO.getAll() );
			//cityConnectDAO.deleteByID(4081);
			//cityConnectDAO.deleteByID(4089);
			//cityConnectDAO.deleteByID(4090);
			//cityConnectDAO.deleteByID(4091);
			//cityConnectDAO.updateById(4080);
			//System.out.println(cityConnectDAO.findByName("Stry"));

            //User user = new User("login", "pass", 0);
            //userConnectDAO.insert(user);
            System.out.println(userConnectDAO.getAll());
			
		} catch (DAOException e) {			
			e.printStackTrace();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
		end = System.currentTimeMillis();
		System.out.println(end - start + "Congratulation!!!!");
	}
}