package controller;

import controller.login.LoginViewController;
import controller.login.LoginUserController;
import model.SchoolModel;
import model.StudentModel;
import model.UserModel;
import view.LoginView;

public class LoginController {
	private LoginView view;
	private UserModel usrModel;
	private SchoolModel schlModel;
	public LoginController(){
		this.view 		= new LoginView();
		this.usrModel 	= new UserModel();
		this.schlModel  = new SchoolModel();
	}
	public void init() {
		  // Special Controller:
		  LoginViewController loginViewController	= new LoginViewController(view, schlModel);
		  loginViewController.init();
		  
		  // Controllers:
		  LoginUserController loginUserController 	= new LoginUserController(view, usrModel);
		  view.addLoginUserController(loginUserController);
	}
}
