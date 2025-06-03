package model.service;

import model.dao.DepartmentDAO;

public class DepartmentService {
	private static DepartmentService instance = new DepartmentService();
	private DepartmentDAO dao;	
	
	private DepartmentService() {
		dao = DepartmentDAO.getInstance();
	}

	public static DepartmentService getInstance() {
		if(instance == null)
			instance = new DepartmentService();
		return instance;
	}

	
	
}
