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

	public int insert(EmployeeDTO dto) {
		 int result = 0;
	        String sql = "INSERT INTO employee (eno, ename, dno, pno, salary, hiredate) VALUES (?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement pstmt = manager.getInstance().getConnection().prepareStatement(sql)) {
	            pstmt.setString(1, dto.getEmpNo());
	            pstmt.setString(2, dto.getEmpName());
	            pstmt.setString(3, dto.getDeptNo());
	            pstmt.setString(4, dto.getPosNo());
	            pstmt.setInt(5, dto.getSalary());
	            pstmt.setString(6, dto.getHireDate());
	            result = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	}

	
}







