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
		case "loginView":
			controller = new LoginViewController();
			break;
		case "login":
			controller = new LoginController();
			break;
		}
		
		return controller;
	}
	
	
	
}




