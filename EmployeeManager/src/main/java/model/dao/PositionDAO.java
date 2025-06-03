package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import model.dto.PositionDTO;

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

	public ArrayList<PositionDTO> selectAll() {
        ArrayList<PositionDTO> list = new ArrayList<PositionDTO>();
        String sql = "select * from position";
        try (PreparedStatement pstmt = manager.getInstance().getConnection().prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String posNo = rs.getString("pno");
                    String posName = rs.getString("pname");
                    list.add(new PositionDTO(posNo, posName));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	public int insert(PositionDTO dto) {
		 int result = 0;
		    String sql = "INSERT INTO position (pno, pname) VALUES (?, ?)";
		    try (PreparedStatement pstmt = manager.getInstance().getConnection().prepareStatement(sql)) {
		        pstmt.setString(1, dto.getPosNo());
		        pstmt.setString(2, dto.getPosName());
		        result = pstmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return result;
	}
}
