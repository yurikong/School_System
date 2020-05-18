package controller;

import controller.LoginController;
import view.LoginView;

public class AppController {
	public AppController() {
		// pass model here?
	}
	
	public void start() {
		LoginController login = new LoginController();
		login.init();
	}
}
