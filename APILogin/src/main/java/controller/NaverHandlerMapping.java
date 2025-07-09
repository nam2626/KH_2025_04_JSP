package controller;

public class NaverHandlerMapping {
	private static NaverHandlerMapping instance = new NaverHandlerMapping();

	private NaverHandlerMapping() {	}

	public static NaverHandlerMapping getInstance() {
		if(instance == null)
			instance = new NaverHandlerMapping();
		return instance;
	}

	public Controller createController(String command) {
		Controller controller = null;
		
		switch(command) {
		case "loginView":
			controller = new NaverLoginViewController();
			break;
		case "callback":
			controller = new NaverLoginController();
			break;
		case "profile":
			controller = new NaverProfileController();
			break;
		case "refresh":
			controller = new NaverRefreshController();
			break;
		case "delete":
			controller = new NaverDeleteController();
			break;
		case "logout":
			controller = new NaverLogoutController();
			break;
		}
		
		return controller;
	}
	
	
	
}




