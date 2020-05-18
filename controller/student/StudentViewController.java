package controller.student;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import datatypes.Session;
import datatypes.Student;
import model.SchoolModel;
import model.StudentModel;
import view.StudentView;

public class StudentViewController {
	private StudentView view;
	private StudentModel stdModel;
	private SchoolModel schlModel;
	private Student student;
	
	public StudentViewController(StudentView view, StudentModel stdModel, SchoolModel schlModel, Student student){
		this.view = view;
		this.stdModel = stdModel;
		this.student = student;
		this.schlModel = schlModel;
	}
	
	public void init() {
		String stdFullName 	= getStudentFullName();
		String stdID		= Integer.toString( student.id());
		String stdTuition	= student.tuitionStatus();
		TreeMap<String, Object[][]> stdTermData  	= stdModel.getStudentScheduleByTermConverted(student.id());
		TreeMap<String, Object[][]> schlTermData 	= schlModel.getSessionScheduleByTermConverted();
		DefaultComboBoxModel stdComboBoxMoDel 		= new DefaultComboBoxModel(stdTermList(stdTermData));	// set Combobox items
		DefaultComboBoxModel schlComboBoxMoDel 		= new DefaultComboBoxModel(schlTermList(schlTermData));	// set Combobox items

		TreeMap<String, Object[][]> test = schlTermData;
		for (Entry<String, Object[][]> entry : test.entrySet()) {
		     System.out.println("Key: " + entry.getKey() + ". Length: " + entry.getValue().length);
		}
		
	// (Student Tab)
		// Init fields with STUDENT-TAB
		view.idField.setText		( stdID );
		view.fullnameField.setText	( stdFullName );
		view.tuitionField.setText	( stdTuition );
		
		// Init std ComboBox
		view.stdTermDropdown.setModel(stdComboBoxMoDel);
		
		// Init std Schedule data
		view.stdScheduleByTerm 	= stdTermData;			// Dont really nead it here but need for dropdown selection after init
		
		// Constructing Table with selected option:
		Object [][] curTermData = view.stdScheduleByTerm.get( view.stdTermDropdown.getSelectedItem() ); 	// get selected term in ComboBox
		view.stdScheduleTable.setModel( new DefaultTableModel(curTermData, view.stdScheduleTableHeader) );	// construct tables
		
	// (Schedule Tab)
		
		// Init schl schedule ComboBox		
		view.schlTermDropdown.setModel(schlComboBoxMoDel);
		
		// Init schl Schedule data
		view.schlScheduleByTerm 	= schlTermData;		// Dont really nead it here but need for dropdown selection after init
		
		// Constructing Table with selected option:
		Object [][] currentTable2 	= view.schlScheduleByTerm.get( view.schlTermDropdown.getSelectedItem() ); 			// get selected term in ComboBox
//		System.out.println(currentTable2[0][0]);
//		System.out.println(currentTable2[0][1]);
//		System.out.println(currentTable2[0][2]);
//		System.out.println(currentTable2[0][3]);
//		System.out.println(currentTable2[0][4]);
//		System.out.println(currentTable2[0][5]);

		view.schlScheduleTable.setModel( new DefaultTableModel(currentTable2, view.schlScheduleTableHeader) );	// construct tables
	}	
	public void update() {
		init();
	}
	public String getStudentFullName() {
		return student.firstname() + " " + student.middlename() +  " " + student.lastname();
	}
	
//	public TreeMap<String, Object[][]> dataConvertion() {	
//
//	    TreeMap<String, Object[][]> converted = new TreeMap<String, Object[][]>();
//
//		Object[][] data1 = {
//				{new Integer(3),"xxx", "Vivian 301", "MW 9:30-11:40", "ABC XYZ"},
//				{new Integer(12),"ENGL 317", "Engineer 123", "TTh 9:30-11:40", "ABC XYZ"},
//				{new Integer(1412),"CECS 277", "HP 103", "TTh 9:30-11:40", "ABC XYZ"},
//				{new Integer(512),"CECS 225", "DC 101", "TTh 9:30-11:40", "ABC XYZ"},
//				{new Integer(51),"MUSC 100", "CC 201", "TTh 9:30-11:40", "ABC XYZ"}
//			};
//		Object[][] data2 = {
//				{new Integer(3),"yyy", "Vivian 301", "MW 9:30-11:40", "ABC XYZ"},
//				{new Integer(12),"ENGL 317", "Engineer 123", "TTh 9:30-11:40", "ABC XYZ"},
//				{new Integer(1412),"CECS 277", "HP 103", "TTh 9:30-11:40", "ABC XYZ"},
//				{new Integer(512),"CECS 225", "DC 101", "TTh 9:30-11:40", "ABC XYZ"},
//				{new Integer(51),"MUSC 100", "CC 201", "TTh 9:30-11:40", "ABC XYZ"}
//			};
//		Object[][] data3 = {
//				{new Integer(3),"zzz", "Vivian 301", "MW 9:30-11:40", "ABC XYZ"},
//				{new Integer(12),"ENGL 317", "Engineer 123", "TTh 9:30-11:40", "ABC XYZ"},
//				{new Integer(1412),"CECS 277", "HP 103", "TTh 9:30-11:40", "ABC XYZ"},
//				{new Integer(512),"CECS 225", "DC 101", "TTh 9:30-11:40", "ABC XYZ"},
//				{new Integer(51),"MUSC 100", "CC 201", "TTh 9:30-11:40", "ABC XYZ"}
//			};
//		converted.put("Fall 2019", data1);
//		converted.put("Spring 2020", data2);
//		converted.put("Hello 2011", data3);
//		return converted;
//	}
	
	public String[] stdTermList(TreeMap<String, Object[][]> stdTermData) {
		Set<String> keys = stdTermData.keySet();
		return keys.toArray(new String[keys.size()]);
	}
	public String[] schlTermList(TreeMap<String, Object[][]> schlTermData) {
		Set<String> keys = schlTermData.keySet();
		return keys.toArray(new String[keys.size()]);
	}
}
