package controller.admin;

import javax.swing.table.DefaultTableModel;

import datatypes.Admin;
import view.AdminView;

public class AdminViewController {
	AdminView 	view;
	Admin 		admin;
	public AdminViewController(AdminView view, Admin admin){
		this.view = view;
		this.admin = admin;
	}
	public void init() {
		updateSchoolTab();
	}
	public void updateSchoolTab() {
		System.out.print("");
		Object[][] testData = {
			{new Integer(3),"Trung", "Ba", "Nguyen"},
			{new Integer(12),"Yay", "J","Smith"},
			{new Integer(1412),"awe", "J","aetae"},
			{new Integer(512),"awt", "g","Smiath"},
			{new Integer(51),"t", "J","awe"}
		};
		String[] header  = new String[] {"ID", "First Name", "Midle Name", "Last Name"};	 // init
		view.adListTable.setModel(new DefaultTableModel(testData, header));
		view.schoolNameField.setText("Yoo1");
		view.schoolCurrentTermField.setText("Yoo2");
		view.schoolDescriptionField.setText("Yoo3");
//		Admin
		
	}
	public void updateAdminTab() {
		
	}
	public void updateEmployeeTab() {
		
	}
	public void updateStudenTab() {
		
	}
	public void updateCollegeTab() {
		
	}
	public void updateDepartmentTab() {
		
	}
	public void updateMajorTab() {
		
	}
	public void updateCourseTab() {
		
	}
	public void SessionTab() {
		
	}
}
