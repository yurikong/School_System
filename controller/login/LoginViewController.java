package controller.login;

import model.SchoolModel;
import view.LoginView;

public class LoginViewController {
	LoginView view;
	SchoolModel model;
	
	public LoginViewController(LoginView loginView, SchoolModel schlModel){
		this.view = loginView;
		this.model = schlModel;
	}
	public void init() {
		// Nothing to init in Login View!
	}
	public void update() {
		// Nothing to update in Login View!
	}
}
