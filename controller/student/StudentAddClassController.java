package controller.student;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import datatypes.Student;
import model.StudentModel;
import view.StudentView;

public class StudentAddClassController implements ActionListener {
	private StudentView view;
	private StudentModel model;
	private StudentViewController stdViewController;
	private Student student;
	
	public StudentAddClassController(StudentView view, StudentModel model, Student student){
		this.view = view;
		this.model = model;
		this.student = student;
	}
	public void actionPerformed(java.awt.event.ActionEvent e){
		int opt = JOptionPane.showConfirmDialog(null, "Confirm!");
		if(opt == JOptionPane.YES_OPTION) {
			int i 					= view.schlScheduleTable.getSelectedRow();
			int sessionID 			= (int) view.schlScheduleTable.getModel().getValueAt(i, 0);

			if(i != -1) {
				Object[] selectedRow 	= ((Vector) ((DefaultTableModel)view.schlScheduleTable.getModel()).getDataVector().elementAt(i)).toArray();

				// Add in DB:
				model.enrollSession(student.id(), sessionID);
				
				// Add in View:
				((DefaultTableModel)view.stdScheduleTable.getModel()).addRow(selectedRow);;
				
				// Update UI Data:
				this.stdViewController.update();
			}
			else JOptionPane.showMessageDialog(null, "You haven't selected a class to add");
		}
	}
	public void setStudentViewController(StudentViewController stdViewController) {
		this.stdViewController = stdViewController;
	}
}
