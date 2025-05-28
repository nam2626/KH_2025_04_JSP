package dao;

import config.DBManager;

public class StudentDAO {
	private static StudentDAO instance = new StudentDAO();
	private DBManager manager;
	
	private StudentDAO() {
		manager = DBManager.getInstance();
	}

	public static StudentDAO getInstance() {
		if(instance == null)
			instance = new StudentDAO();
		return instance;
	}

	
	
	
}
