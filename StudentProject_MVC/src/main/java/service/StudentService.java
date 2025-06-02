package service;

import java.util.ArrayList;

import dao.StudentDAO;
import dto.MajorDTO;
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

	public int deleteStudent(String sno) {
		if(sno == null)
			return 0;
		return dao.deleteStudent(sno);
	}

	public ArrayList<MajorDTO> selectAllMajor() {
		return dao.selectAllMajor();
	}

	public int insertStudent(StudentDTO dto) {
		return dao.insertStudent(dto);
	}

	public StudentDTO selectStudent(String sno) {
		return dao.selectStudent(sno);
	}

	public int updateStudent(StudentDTO dto) {
		return dao.updateStudent(dto);
	}

	public ArrayList<StudentDTO> selectStudentList(String search) {
		return dao.selectStudentList(search);
	}

}


