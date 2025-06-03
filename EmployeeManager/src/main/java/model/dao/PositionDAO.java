package model.dao;

import config.DBManager;

public class PositionDAO {
	private static PositionDAO instance = new PositionDAO();
	private DBManager manager;
	
	private PositionDAO() {
		manager = DBManager.getInstance();
	}

	public static PositionDAO getInstance() {
		if(instance == null)
			instance = new PositionDAO();
		return instance;
	}

	
}
