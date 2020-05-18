package controller.admin.school;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SchoolModel;
import view.AdminView;

public class SuperAdminSetSchoolController implements ActionListener  {
	private AdminView view;
	private SchoolModel schlModel;
	public SuperAdminSetSchoolController(AdminView view, SchoolModel schlModel) {
		this.view = view;
		this.schlModel = schlModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
