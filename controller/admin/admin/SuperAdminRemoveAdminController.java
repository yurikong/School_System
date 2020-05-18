package controller.admin.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.AdminModel;
import view.AdminView;

public class SuperAdminRemoveAdminController implements ActionListener  {
	private AdminView view;
	private AdminModel adModel;
	public SuperAdminRemoveAdminController(AdminView view, AdminModel adModel) {
		this.view = view;
		this.adModel = adModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
