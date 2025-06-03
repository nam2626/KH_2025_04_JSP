package model.service;

import java.util.List;

import model.dao.PositionDAO;
import model.dto.PositionDTO;

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

	public List<PositionDTO> getAllPositions() {
		return dao.selectAll();
	}

	
	
}
