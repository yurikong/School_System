package controller;

import model.SchoolModel;
import model.StudentModel;
import view.StudentView;

import java.awt.EventQueue;

import javax.swing.UIManager;

import controller.student.SchoolTermController;
import controller.student.StudentAddClassController;
import controller.student.StudentDropClassController;
import controller.student.StudentTermController;
import controller.student.StudentViewController;
import datatypes.Student;

public class StudentController {
	private StudentView 	view;
	private StudentModel 	stdModel;
	private SchoolModel		schlModel;
	private Student 		student;
	
	public StudentController(Student student){
		this.view 		= new StudentView();
		this.stdModel 	= new StudentModel();
		this.schlModel	= new SchoolModel();
		
		this.student = student;
	}
	public void init() {
	// Special Controller:
		StudentViewController viewController				= new StudentViewController(view, stdModel, schlModel, student);
		viewController.init();
	// Controllers:
		// Student Add Class
		StudentAddClassController addClassController 		= new StudentAddClassController(view, stdModel, student);
		view.addAddClassController(addClassController);
		addClassController.setStudentViewController(viewController);
		// Student Drop Class
		StudentDropClassController dropClassController 		= new StudentDropClassController(view, stdModel, student);
		view.addDropClassController(dropClassController);
		dropClassController.setStudentViewController(viewController);
		
		// Student Select Student Term
		StudentTermController studentTermController 		= new StudentTermController(view, stdModel);
		view.addStudentTermController(studentTermController);
		
		// Student Select School Term
		SchoolTermController schoolTermController 			= new SchoolTermController(view, stdModel);
		view.addSchoolTermController(schoolTermController);
		
	}
}


