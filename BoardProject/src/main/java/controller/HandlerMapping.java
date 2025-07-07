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
		}
		
		return controller;
	}
	
	
	
}




