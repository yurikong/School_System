package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AdminView;

public class ControllerTemplate implements ActionListener  {
	private AdminView view;
	public ControllerTemplate(AdminView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
