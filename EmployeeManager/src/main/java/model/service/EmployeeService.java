package model.service;

import model.dao.EmployeeDAO;

public class EmployeeService {
	private static EmployeeService instance = new EmployeeService();
	private EmployeeDAO dao;	
	
	private EmployeeService() {
		dao = EmployeeDAO.getInstance();
	}

	public static EmployeeService getInstance() {
		if(instance == null)
			instance = new EmployeeService();
		return instance;
	}

	
	
}
