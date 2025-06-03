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
		case "main":
			controller = new MainController();
			break;
		case "insertEmployeeView":
			controller = new InsertEmployeeViewController();
			break;
		case "insertEmployee":
			controller = new InsertEmployeeController();
			break;
		case "posList":
			controller = new PositionListController();
			break;
		case "deptList":
		    controller = new DepartmentListController();
		    break;		    
		case "posInsertView":
			controller = new PositionInsertViewController();
			break;
		case "posInsert":
			controller = new PositionInsertController();
			break;
		case "deptInsertView":
			controller = new DepartmentInsertViewController();
			break;
		case "deptInsert":
			controller = new DepartmentInsertController();
			break;
		}
		
		return controller;
	}
	
	
	
}




