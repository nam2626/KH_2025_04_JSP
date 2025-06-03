package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import model.dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private DBManager manager;
	
	private EmployeeDAO() {
		manager = DBManager.getInstance();
	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	public ArrayList<EmployeeDTO> selectAll() {
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		
		String sql = "select * from employee";
				
		try(PreparedStatement pstmt = 
				manager.getInstance().getConnection().prepareStatement(sql)){
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					String empNo = rs.getString("eno");
					String empName = rs.getString("ename");
					String deptNo = rs.getString("dno");
					String posNo = rs.getString("pno");
					int salary = rs.getInt("salary");
					String hireDate = rs.getString("hiredate");
					
					list.add(new EmployeeDTO(empNo, empName, deptNo, posNo, salary, hireDate));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
}







