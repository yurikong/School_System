package controller;

import controller.employee.EmployeeTermController;
import controller.employee.EmployeeViewController;
import controller.employee.SchoolTermController;
import datatypes.Employee;
import model.EmployeeModel;
import model.SchoolModel;
import view.EmployeeView;

public class EmployeeController {
	private EmployeeView 	view;
	private EmployeeModel 	empModel;
	private SchoolModel		schlModel;
	private Employee 		employee;
	
	public EmployeeController(Employee employee){
		this.view 		= new EmployeeView();
		this.empModel 	= new EmployeeModel();
		this.schlModel	= new SchoolModel();
		this.employee   = employee;
	}
	public void init() {
	// Special Controller:
		EmployeeViewController viewController= new EmployeeViewController(view, empModel, schlModel, employee);
		viewController.init();
	// Controllers:

		// Student Select Student Term
		EmployeeTermController empTermController 			= new EmployeeTermController(view, empModel);
		view.addEmployeeTermController(empTermController);
		
		// Student Select School Term
		SchoolTermController schoolTermController 			= new SchoolTermController(view, empModel);
		view.addSchoolTermController(schoolTermController);
		
	}
}
