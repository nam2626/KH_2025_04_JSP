package controller;

public class KaKaoHandlerMapping {
	private static KaKaoHandlerMapping instance = new KaKaoHandlerMapping();

	private KaKaoHandlerMapping() {	}

	public static KaKaoHandlerMapping getInstance() {
		if(instance == null)
			instance = new KaKaoHandlerMapping();
		return instance;
	}

	public Controller createController(String command) {
		Controller controller = null;
		
		switch(command) {
			
		}
		
		return controller;
	}
	
	
	
}




