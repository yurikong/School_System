package main;

import controller.AppController;
import driver.Preload;

public class AppRunner {

	public static void main(String[] args) {
		Preload preload = new Preload();
		preload.load();
		
		AppController baseApp = new AppController();
		baseApp.start();
	}
}
