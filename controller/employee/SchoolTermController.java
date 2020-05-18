package controller.employee;

import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import model.EmployeeModel;
import view.EmployeeView;

public class SchoolTermController implements ActionListener {
	private EmployeeView view;
	private EmployeeModel model;
	
	public SchoolTermController(EmployeeView view, EmployeeModel model){
		this.view = view;
		this.model = model;
	}
	public void actionPerformed(java.awt.event.ActionEvent e){
		String selected = (String) view.schlTermDropdown.getSelectedItem();
		Object [][] currentTable = view.schlScheduleByTerm.get( selected ); 	// data already filled (inited by StudentUpdateViewController)
		view.schlScheduleTable.setModel( new DefaultTableModel(currentTable, view.schlScheduleTableHeader) );	// construct tables
	}
}
