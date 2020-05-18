package controller.employee;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import datatypes.Employee;
import model.EmployeeModel;
import model.SchoolModel;
import view.EmployeeView;

public class EmployeeViewController {
	private EmployeeView view;
	private EmployeeModel empModel;
	private SchoolModel schlModel;
	private Employee employee;
	
	public EmployeeViewController(EmployeeView view, EmployeeModel empModel, SchoolModel schlModel, Employee employee){
		this.view = view;
		this.empModel = empModel;
		this.employee = employee;
		this.schlModel = schlModel;
	}
	
	public void init() {
		String empFullName 	= getEmployeeFullName();
		String empID		= Integer.toString( employee.id());
		String empTitle		= employee.title();
		String empSalary	= Integer.toString( employee.salary() );
		TreeMap<String, Object[][]> empTermData  	= empModel.getEmployeeScheduleByTermConverted(employee.id());
		TreeMap<String, Object[][]> schlTermData 	= schlModel.getSessionScheduleByTermConverted();
		DefaultComboBoxModel stdComboBoxMoDel 		= new DefaultComboBoxModel(stdTermList(empTermData));	// set Combobox items
		DefaultComboBoxModel schlComboBoxMoDel 		= new DefaultComboBoxModel(schlTermList(schlTermData));	// set Combobox items


	// (Employee Tab)
		// Init fields with EMPLOYEE-TAB
		view.idField.setText		( empID );
		view.fullnameField.setText	( empFullName );
		view.titleField.setText		( empTitle );
		
		// Init emp ComboBox
		view.empTermDropdown.setModel(stdComboBoxMoDel);
		
		// Init emp Schedule data
		view.empScheduleByTerm 		= empTermData;			// Dont really nead it here but need for dropdown selection after init
		
		// Constructing Table with selected option:
		Object [][] curTermData = view.empScheduleByTerm.get( view.empTermDropdown.getSelectedItem() ); 	// get selected term in ComboBox
		view.empScheduleTable.setModel( new DefaultTableModel(curTermData, view.empScheduleTableHeader) );	// construct tables
		
	// (Schedule Tab)
		
		// Init schl schedule ComboBox		
		view.schlTermDropdown.setModel(schlComboBoxMoDel);
		
		// Init schl Schedule data
		view.schlScheduleByTerm 	= schlTermData;		// Dont really nead it here but need for dropdown selection after init
		
		// Constructing Table with selected option:
		Object [][] currentTable2 	= view.schlScheduleByTerm.get( view.schlTermDropdown.getSelectedItem() ); 			// get selected term in ComboBox
		view.schlScheduleTable.setModel( new DefaultTableModel(currentTable2, view.schlScheduleTableHeader) );	// construct tables
	}	
	public String getEmployeeFullName() {
		return employee.firstname() + " " + employee.middlename() +  " " + employee.lastname();
	}
	
	public String[] stdTermList(TreeMap<String, Object[][]> stdTermData) {
		Set<String> keys = stdTermData.keySet();
		return keys.toArray(new String[keys.size()]);
	}
	public String[] schlTermList(TreeMap<String, Object[][]> schlTermData) {
		Set<String> keys = schlTermData.keySet();
		return keys.toArray(new String[keys.size()]);
	}
}
