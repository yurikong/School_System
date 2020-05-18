package controller.employee;

import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import model.EmployeeModel;
import view.EmployeeView;

public class EmployeeTermController implements ActionListener {
	private EmployeeView  view;
	private EmployeeModel model;
	
	public EmployeeTermController(EmployeeView view, EmployeeModel model){
		this.view = view;
		this.model = model;
	}
	public void actionPerformed(java.awt.event.ActionEvent e){
		String selected = (String) view.empTermDropdown.getSelectedItem();
		Object [][] currentTable = view.empScheduleByTerm.get( selected ); 	// data already filled (inited by StudentUpdateViewController)
		view.empScheduleTable.setModel( new DefaultTableModel(currentTable, view.empScheduleTableHeader) );	// construct tables
	}
}
