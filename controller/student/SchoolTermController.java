package controller.student;

import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import model.StudentModel;
import view.StudentView;

public class SchoolTermController implements ActionListener {
	private StudentView view;
	private StudentModel model;
	
	public SchoolTermController(StudentView view, StudentModel model){
		this.view = view;
		this.model = model;
	}
	public void actionPerformed(java.awt.event.ActionEvent e){
		String selected = (String) view.schlTermDropdown.getSelectedItem();
		Object [][] currentTable = view.schlScheduleByTerm.get( selected ); 	// data already filled (inited by StudentUpdateViewController)
		view.schlScheduleTable.setModel( new DefaultTableModel(currentTable, view.schlScheduleTableHeader) );	// construct tables
	}
}
