package controller.student;

import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.table.DefaultTableModel;

import model.StudentModel;
import view.StudentView;

public class StudentTermController implements ActionListener {
	private StudentView view;
	private StudentModel model;
	
	public StudentTermController(StudentView view, StudentModel model){
		this.view = view;
		this.model = model;
	}
	public void actionPerformed(java.awt.event.ActionEvent e){
		String selected = (String) view.stdTermDropdown.getSelectedItem();
//		System.out.println( view.stdScheduleByTerm.values() );
		
//		TreeMap<String, Object[][]> test = view.stdScheduleByTerm;
//
//		for (Entry<String, Object[][]> entry : test.entrySet()) {
//		     System.out.println("Key: " + entry.getKey() + ". Length: " + entry.getValue().length);
//		}
		Object [][] currentTable = view.stdScheduleByTerm.get( selected ); 	// data already filled (inited by StudentUpdateViewController)
		view.stdScheduleTable.setModel( new DefaultTableModel(currentTable, view.stdScheduleTableHeader) );	// construct tables
	}
}
