package model.dao;

import config.DBManager;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private DBManager manager;
	
	private EmployeeDAO() {
		manager = DBManager.getInstance();
	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	
}
