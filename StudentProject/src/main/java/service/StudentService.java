package service;

import java.util.ArrayList;

import dao.StudentDAO;
import dto.StudentDTO;

public class StudentService {
	private static StudentService instance = new StudentService();
	private StudentDAO dao;
	private StudentService() {
		dao = StudentDAO.getInstance();
	}

	public static StudentService getInstance() {
		if(instance == null)
			instance = new StudentService();
		return instance;
	}

	public ArrayList<StudentDTO> selectAllStudent() {
		return dao.selectAllStudent();
	}

}


