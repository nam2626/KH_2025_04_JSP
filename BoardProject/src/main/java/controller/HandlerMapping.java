package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {	}

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}

	public Controller createController(String command) {
		Controller controller = null;
		
		switch(command) {
		case "boardMain":
			controller = new BoardMainController();
			break;
		case "boardWriteView":
			controller = new BoardWriteViewController();
			break;
		case "loginView":
			controller = new LoginViewController();
			break;
		case "login":
			controller = new LoginController();
			break;
		case "boardWrite":
			controller = new BoardWriteController();
			break;
		case "boardView":
			controller = new BoardViewController();
			break;
		case "fileDown":
			controller = new BoardFileDownController();
			break;
		case "boardCommentInsert":
			controller = new BoardCommentWriteController();
			break;
		case "boardLike":
			controller = new BoardLikeController();
			break;
		}
		
		return controller;
	}
	
	
	
}




