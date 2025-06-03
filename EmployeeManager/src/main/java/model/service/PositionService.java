package model.service;

import model.dao.PositionDAO;

public class PositionService {
	private static PositionService instance = new PositionService();
	private PositionDAO dao;	
	
	private PositionService() {
		dao = PositionDAO.getInstance();
	}

	public static PositionService getInstance() {
		if(instance == null)
			instance = new PositionService();
		return instance;
	}

	
	
}
