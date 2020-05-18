package controller.login;

import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.EmployeeController;
import controller.StudentController;
import datatypes.Employee;
import datatypes.Student;
import datatypes.User;
import model.StudentModel;
import model.UserModel;
import view.LoginView;

public class LoginUserController implements ActionListener { 
	LoginView view;
	UserModel model;
	// Model here!
	// LoginController(jFrame,Model){
	public LoginUserController(LoginView loginView, UserModel usrModel) {
		this.view = loginView;
		this.model = usrModel;
	}

	public void actionPerformed(java.awt.event.ActionEvent e){
		String ids = view.idField.getText();	//ID String
		String pw  = view.passwordField.getText();

		boolean error = false;
		error = validateID(ids) || validatePW(pw);
		
		if(error == true) {
			JOptionPane.showMessageDialog(null, "The username or password is invalid", "Error", JOptionPane.ERROR_MESSAGE);
		}else  {
			int id 		= Integer.parseInt(ids);
			Object user = model.login(id, pw);
			
			if( user == null ) {
				JOptionPane.showMessageDialog(null, "The username or password is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				view.dispose();
				//if(user.getClass().equals(Student))
				if(user instanceof Student) {
					//System.out.print("aweawe");
					Student student = (Student)user;
					StudentController std  = new StudentController(student);
					std.init();
				}
				// @If Employee:
				if(user instanceof Employee) {
					Employee employee = (Employee)user;
					EmployeeController emp = new EmployeeController(employee);
					emp.init();
				}
				// @If Admin:
			}
		}
	}
	public Boolean validateID(String ids) {
		Boolean isError = false;
		if(!isNumeric(ids)) isError	= true;
		if(ids.isEmpty()) 	isError = true;
		return isError;
	}
	public Boolean validatePW(String pw) {
		Boolean isError = false;
		if(pw.isEmpty()) isError 	= true;
		return isError;
	}
	public static boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
}
