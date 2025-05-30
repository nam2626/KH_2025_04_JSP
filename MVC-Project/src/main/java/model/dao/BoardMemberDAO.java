package model.dao;

import config.DBManager;

public class BoardMemberDAO {
	private static BoardMemberDAO instance = new BoardMemberDAO();
	private DBManager manager;
	
	private BoardMemberDAO() {
		manager = DBManager.getInstance();
	}

	public static BoardMemberDAO getInstance() {
		if(instance == null)
			instance = new BoardMemberDAO();
		return instance;
	}

	
	
}
