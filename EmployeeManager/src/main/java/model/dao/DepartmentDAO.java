package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import model.dto.DepartmentDTO;

public class DepartmentDAO {
	private static DepartmentDAO instance = new DepartmentDAO();
	private DBManager manager;
	
	private DepartmentDAO() {
		manager = DBManager.getInstance();
	}

	public static DepartmentDAO getInstance() {
		if(instance == null)
			instance = new DepartmentDAO();
		return instance;
	}

	 public ArrayList<DepartmentDTO> selectAll() {
	        ArrayList<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
	        String sql = "select * from department";
	        try (PreparedStatement pstmt = manager.getInstance().getConnection().prepareStatement(sql)) {
	            try (ResultSet rs = pstmt.executeQuery()) {
	                while (rs.next()) {
	                    String deptNo = rs.getString("dno");
	                    String deptName = rs.getString("dname");
	                    list.add(new DepartmentDTO(deptNo, deptName));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	
}
