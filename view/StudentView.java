package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.LoginController;
import controller.student.SchoolTermController;
import controller.student.StudentAddClassController;
import controller.student.StudentDropClassController;
import controller.student.StudentTermController;
import controller.student.StudentViewController;
import datatypes.User;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TreeMap;

public class StudentView extends JFrame {

	private JPanel 		contentPane;
	private JTabbedPane tabbedPane;		
	private GroupLayout gl_contentPane;	
	private JButton 	btnLogout;
	
	/*########### Student Tab: ###########*/
	public JTextField 	fullnameField;		// <Fields>
	public JTextField 	idField;			//
	public JTextField 	tuitionField;		//
	public JTextField 	addField;			//
	public JTextField 	dropField;			//
	private JButton 	btnAdd;				// <Buttons>:			
	private JButton 	btnDrop;			//
	public JTable 		stdScheduleTable; 	// <Tables>:
	public String[] 	stdScheduleTableHeader;//
	public JComboBox 	stdTermDropdown;	// <Dropdown>:	
	public TreeMap<String, Object[][]> 	stdScheduleByTerm;	// Table Data
	
	/*########### Schedule Tab: ###########*/
	public JTable 		schlScheduleTable;	// <Tables>:
	public String[]		schlScheduleTableHeader;
	public JComboBox  	schlTermDropdown;	// <Dropdown>:	
	public TreeMap<String, Object[][]> 	schlScheduleByTerm;	// Table Data
	

	public StudentView() {
		initData();
		initComponents();
		createEvents();
		//createControllers();
		this.setVisible(true);
	}
	public void initData() {
		stdScheduleByTerm 	= new TreeMap<String, Object[][]>();	// Table Data
	}
	
	// Student Controllers:
	public void addAddClassController(StudentAddClassController addClassController) 	{btnAdd.addActionListener(addClassController);}
	public void addDropClassController(StudentDropClassController dropClassController) 	{btnDrop.addActionListener(dropClassController);}
	public void addStudentTermController(StudentTermController studentTermController) 	{stdTermDropdown.addActionListener(studentTermController);}
	// Schedule Controllers:
	public void addSchoolTermController(SchoolTermController schoolTermController) 		{schlTermDropdown.addActionListener(schoolTermController);}
	
	
	public void createEvents() {
	// Logout
		JFrame _this = this;
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_this.dispose();
				LoginController login = new LoginController();
				login.init();
			}
		});	
	// StudentTab:
		// print current CourseID to the field
		stdScheduleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel tModel = stdScheduleTable.getModel();
				int i = stdScheduleTable.getSelectedRow();
				dropField.setText( tModel.getValueAt(i, 0).toString());

			}
		});
	// ScheduleTab:
		schlScheduleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel tModel = schlScheduleTable.getModel();
				int i = schlScheduleTable.getSelectedRow();
				addField.setText( tModel.getValueAt(i, 0).toString());
			}
		});
	}

	public void initComponents(){
		//-Jframe Windows:
		jframeComponent();
		
		//-Menu Component:
		menuComponent();
		
		//-Tab Component:
		tabComponent();
		
		//+StudentTabPanel Component:
		studentTabComponent();
		
		//+ScheduleTabPanel Component:
		scheduleTabComponent();
	}
	
	public void menuComponent() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmInfo = new JMenuItem("Info");
		mnAbout.add(mntmInfo);
		
		JPanel panel = new JPanel();
		menuBar.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnLogout = new JButton("Logout");
		
		panel.add(btnLogout, BorderLayout.EAST);
		
		// Menu bar handler
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(opt == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}
	
	public void jframeComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

	public void tabComponent() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 775, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void studentTabComponent() {
		JPanel studentTab = new JPanel();
		tabbedPane.addTab("Student", null, studentTab, null);
	
		JPanel schedulePanel = new JPanel();
		schedulePanel.setBorder(new TitledBorder(null, "Weekly Schedule", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel addClassPanel = new JPanel();
		addClassPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Class", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel dropClassPanel = new JPanel();
		dropClassPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Drop Class", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel studentInfoPanel = new JPanel();
		studentInfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Student Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_studentTab = new GroupLayout(studentTab);
		
		
		gl_studentTab.setHorizontalGroup(
			gl_studentTab.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_studentTab.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_studentTab.createParallelGroup(Alignment.LEADING)
						.addComponent(studentInfoPanel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addComponent(dropClassPanel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addComponent(addClassPanel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(schedulePanel, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_studentTab.setVerticalGroup(
			gl_studentTab.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_studentTab.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_studentTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_studentTab.createSequentialGroup()
							.addComponent(studentInfoPanel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(addClassPanel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(dropClassPanel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addComponent(schedulePanel, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblTerms = new JLabel("Term: ");
		lblTerms.setBounds(16, 30, 32, 14);
		
		// ######################### ComboBox ######################### 
		stdTermDropdown = new JComboBox();
		
		stdTermDropdown.setBounds(52, 27, 92, 20);
		//stdTermDropdown.setModel(new DefaultComboBoxModel(new String[] {"Fall 2019", "Spring 2020"}));	// static

		schedulePanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(16, 65, 498, 396);
		schedulePanel.add(scrollPane);
		
		
		// ######################### JTable #########################		
		//Init table
		stdScheduleTableHeader  = new String[] {"CRN", "Course Name", "Room", "Time", "Intructor"};	 // init
		stdScheduleTable = new JTable( new DefaultTableModel(new Object[][] {}, stdScheduleTableHeader) ){
			public boolean isCellEditable(int row, int column) {
				return false; 
			}
		};

		scrollPane.setViewportView(stdScheduleTable);
		
		// ######################### Drop Panel #########################
		schedulePanel.add(lblTerms);
		schedulePanel.add(stdTermDropdown);
		JLabel label = new JLabel("CRN:");
		
		dropField = new JTextField();
		dropField.setColumns(10);
		dropField.setEditable(false);
		
		// Drop Item in Table########################:
		btnDrop = new JButton("Drop");
		
		GroupLayout gl_dropClassPanel = new GroupLayout(dropClassPanel);
		gl_dropClassPanel.setHorizontalGroup(
			gl_dropClassPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropClassPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dropClassPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDrop)
						.addGroup(gl_dropClassPanel.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(dropField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_dropClassPanel.setVerticalGroup(
			gl_dropClassPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dropClassPanel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_dropClassPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(dropField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDrop)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		dropClassPanel.setLayout(gl_dropClassPanel);
		
		JLabel lblNewLabel = new JLabel("CRN:");
		
		addField = new JTextField();
		addField.setColumns(10);
		addField.setEditable(false);
		
		btnAdd = new JButton("Add");

		GroupLayout gl_addClassPanel = new GroupLayout(addClassPanel);
		gl_addClassPanel.setHorizontalGroup(
			gl_addClassPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_addClassPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_addClassPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAdd)
						.addGroup(Alignment.LEADING, gl_addClassPanel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
							.addComponent(addField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addGap(18))
		);
		gl_addClassPanel.setVerticalGroup(
			gl_addClassPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addClassPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_addClassPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(addField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAdd)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		addClassPanel.setLayout(gl_addClassPanel);
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblId = new JLabel("ID:");
		
		JLabel lblTuition = new JLabel("Tuition:  ");
		
		fullnameField = new JTextField();
		fullnameField.setColumns(10);
		fullnameField.setEditable(false);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setEditable(false);

		
		tuitionField = new JTextField();
		tuitionField.setColumns(10);
		tuitionField.setEditable(false);

		GroupLayout gl_studentInfoPanel = new GroupLayout(studentInfoPanel);
		gl_studentInfoPanel.setHorizontalGroup(
			gl_studentInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_studentInfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_studentInfoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblId)
						.addComponent(lblTuition))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_studentInfoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(tuitionField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(fullnameField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_studentInfoPanel.setVerticalGroup(
			gl_studentInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_studentInfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_studentInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(fullnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_studentInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addGroup(gl_studentInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tuitionField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTuition))
					.addContainerGap())
		);
		studentInfoPanel.setLayout(gl_studentInfoPanel);
		studentTab.setLayout(gl_studentTab);
	}
	
	public void scheduleTabComponent() {
		JPanel scheduleTab = new JPanel();
		tabbedPane.addTab("Schedule", null, scheduleTab, null);
		
		JPanel schlScheldulePanel = new JPanel();
		
		
		// ######################### Combobox #########################			
		schlTermDropdown = new JComboBox();
		//schlTermDropdown.setModel(new DefaultComboBoxModel(new String[] {"Fall 2019", "Spring 2020"}));
	
		JLabel label_1 = new JLabel("Term: ");
		GroupLayout gl_scheduleTab = new GroupLayout(scheduleTab);
		gl_scheduleTab.setHorizontalGroup(
			gl_scheduleTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_scheduleTab.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_scheduleTab.createParallelGroup(Alignment.LEADING)
						.addComponent(schlScheldulePanel, GroupLayout.PREFERRED_SIZE, 745, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_scheduleTab.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(schlTermDropdown, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_scheduleTab.setVerticalGroup(
			gl_scheduleTab.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_scheduleTab.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(gl_scheduleTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_scheduleTab.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(schlTermDropdown, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(schlScheldulePanel, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		schlScheldulePanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 725, 411);
		schlScheldulePanel.add(scrollPane_1);
		
		
		// ######################### JTable #########################		
		//Init table
		schlScheduleTableHeader  	= new String[] {"CRN", "Course Name", "Room", "Time", "Intructor", "Preq"};	 // init
		schlScheduleTable 			= new JTable( new DefaultTableModel(new Object[][] {}, schlScheduleTableHeader) ){
			public boolean isCellEditable(int row, int column) {
				return false; 
			}
		};
		
						
//		// All Classes Schedule
//		String[] columnNames_1 = {
//				"CRN",
//				"Course Name",
//                "Room",
//                "Time",
//                "Intructor",
//                "Preq"};
//
//		Object[][] data_1 = {
//			{new Integer(39),"CECS 343", "Vivian 301", "MW 9:30-11:40", "ABC XYZ", "CECS 227"},
//			{new Integer(412),"ENGL 317", "Engineer 123", "TTh 9:30-11:40", "ABC XYZ", "ENGL 99"},
//			{new Integer(112),"CECS 277", "HP 103", "TTh 9:30-11:40", "ABC XYZ", "CECS 100, CECS 90"},
//			{new Integer(152),"CECS 225", "DC 101", "TTh 9:30-11:40", "ABC XYZ", "CECS 100"},
//			{new Integer(523),"MUSC 100", "CC 201", "TTh 9:30-11:40", "ABC XYZ", "MUSC 90"}
//		};
//		DefaultTableModel model_1 = new DefaultTableModel(data_1, columnNames_1);
//		schlScheduleTable = new JTable( model_1 ){
//				public boolean isCellEditable(int row, int column) {
//				return false; 
//			}
//		};
		
		
		scrollPane_1.setViewportView(schlScheduleTable);
		scheduleTab.setLayout(gl_scheduleTab);
	}

}
