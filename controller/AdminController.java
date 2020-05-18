package controller;

import controller.admin.AdminViewController;
import controller.admin.admin.SuperAdminRemoveAdminController;
import controller.admin.admin.SuperAdminSetAdminController;
import controller.admin.school.SuperAdminSetSchoolController;
import datatypes.Admin;
import driver.Preload;
import model.AdminModel;
import model.EmployeeModel;
import model.SchoolModel;
import model.StudentModel;
import model.SuperAdminModel;
import model.UserModel;
import view.AdminView;
import view.StudentView;

public class AdminController {
	private AdminView 	view;
	private Admin 		admin;
	
	private SchoolModel 	schlModel;
	private StudentModel 	stdModel;
	private AdminModel 		adModel;
	private EmployeeModel 	empModel;
	private SuperAdminModel sAdModel;
	private UserModel 		userModel;

	
	public AdminController(Admin admin){
		this.admin  	= admin;

		this.view 		= new AdminView();
		this.schlModel  = new SchoolModel();
		this.stdModel 	= new StudentModel();
		this.adModel	= new AdminModel();
		this.empModel	= new EmployeeModel();
		this.stdModel	= new StudentModel();
		this.sAdModel	= new SuperAdminModel();
		this.userModel	= new UserModel();
	}
	public void init() {
	// Special Controller:
		AdminViewController adViewController	= new AdminViewController(view, admin);
		adViewController.init();
 
	// Controllers:
		//School:
		SuperAdminSetSchoolController sAdSetSchoolController = new SuperAdminSetSchoolController(view, schlModel);
		view.addSetSchoolInfoController(sAdSetSchoolController);
		
		//Admin:
		SuperAdminRemoveAdminController sAdRemoveAdminController = new SuperAdminRemoveAdminController(view, adModel);
		view.addRemoveAdminController(sAdRemoveAdminController);
		
		SuperAdminSetAdminController sAdSetAdminController = new SuperAdminSetAdminController(view, sAdModel);
		view.addSetAdminController(sAdSetAdminController);
		
		
	}
	public static void main(String[] args) {
		AdminController ctrl = new AdminController(new Admin(1,"trung","nguyen","ba"));
		ctrl.init();
	}
}
