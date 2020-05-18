package controller.student;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import datatypes.Student;
import model.StudentModel;
import view.StudentView;

public class StudentDropClassController implements ActionListener {
	private StudentView view;
	private StudentModel model;
	private Student student;
	private StudentViewController stdViewController;
	
	public StudentDropClassController(StudentView view, StudentModel model, Student student){
		this.view = view;
		this.model = model;
		this.student = student;
	}
	public void actionPerformed(java.awt.event.ActionEvent e){
		// WRONG! remove according input! not selection!
		int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Drop This Course?");
		if(opt == JOptionPane.YES_OPTION) {
			int i 			= view.stdScheduleTable.getSelectedRow();
			int sessionID 	= (int) view.stdScheduleTable.getModel().getValueAt(i, 0);

			if(i != -1) {
				// Remove in DB:
				model.dropSession(student.id(), sessionID);
				
				// Remove in View:
				((DefaultTableModel)view.stdScheduleTable.getModel()).removeRow(i);
				
				// Update UI Data:
				this.stdViewController.update();

			}
			else JOptionPane.showMessageDialog(null, "You haven't selected a class to drop");
		}
	}
	public void setStudentViewController(StudentViewController stdViewController) {
		this.stdViewController = stdViewController;
	}
}
