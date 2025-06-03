package model.service;

import java.util.List;

import model.dao.DepartmentDAO;
import model.dto.DepartmentDTO;

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

	public List<DepartmentDTO> getAllDepartments() {
		return dao.selectAll();
	}

	public boolean insertDepartment(DepartmentDTO dto) {
		int result = DepartmentDAO.getInstance().insert(dto);
        return result > 0;
	}

	
	
}
