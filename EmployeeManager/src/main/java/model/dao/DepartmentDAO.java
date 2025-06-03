package model.dao;

import config.DBManager;

public class DepartmentDAO {
	private static DepartmentDAO instance = new DepartmentDAO();
	private DBManager manager;
	
	private DepartmentDAO() {
		manager = DBManager.getInstance();
	}

	public static DepartmentDAO getInstance() {
		if(instance == null)
			instance = new DepartmentDAO();
		return instance;
	}

	
}
