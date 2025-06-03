package model.service;

import java.util.ArrayList;

import model.dao.EmployeeDAO;
import model.dto.EmployeeDTO;

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

	public ArrayList<EmployeeDTO> selectAll() {
		return dao.selectAll();
	}

	 public boolean insertEmployee(EmployeeDTO dto) {
	        int result = EmployeeDAO.getInstance().insert(dto);
	        return result > 0;
	    }

	
	
}
