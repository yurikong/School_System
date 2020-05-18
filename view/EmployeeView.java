package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.employee.SchoolTermController;
import controller.LoginController;
import controller.employee.EmployeeTermController;

public class EmployeeView extends JFrame {
	private JPanel 		contentPane;
	private JTabbedPane tabbedPane;		
	private GroupLayout gl_contentPane;	
	private JButton 	btnLogout;
	
	/*########### Employee Tab: ###########*/
	public JTextField 	fullnameField;		// <Fields>
	public JTextField 	idField;			//
	public JTextField 	salaryField;		//
	public JTable 		empScheduleTable; 	// <Tables>:
	public String[] 	empScheduleTableHeader;//
	public JComboBox 	empTermDropdown;	// <Dropdown>:	
	public TreeMap<String, Object[][]> 	empScheduleByTerm;	// Table Data
	
	/*########### Schedule Tab: ###########*/
	public JTable 		schlScheduleTable;	// <Tables>:
	public String[]		schlScheduleTableHeader;
	public JComboBox  	schlTermDropdown;	// <Dropdown>:	
	public TreeMap<String, Object[][]> 	schlScheduleByTerm;	// Table Data
	public JTextField 	titleField;
	
	public EmployeeView() {
		initData();
		initComponents();
		createEvents();
		this.setVisible(true);
	}
	public void initData() {
		empScheduleByTerm 	= new TreeMap<String, Object[][]>();	// Table Data
	}
	
	// Employee Controllers:
	public void addEmployeeTermController(EmployeeTermController empTermController) 	{ empTermDropdown.addActionListener(empTermController); }
	// Schedule Controllers:
	public void addSchoolTermController(SchoolTermController schoolTermController) 		{ schlTermDropdown.addActionListener(schoolTermController); }
	
	
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
	// Employee Tab:
		// print current CourseID to the field
		empScheduleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel tModel = empScheduleTable.getModel();
				int i = empScheduleTable.getSelectedRow();
				// dropField.setText( tModel.getValueAt(i, 0).toString());
			}
		});
	// ScheduleTab:
		schlScheduleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel tModel = schlScheduleTable.getModel();
				int i = schlScheduleTable.getSelectedRow();
				// addField.setText( tModel.getValueAt(i, 0).toString());
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
		
		//+EmployeeTabPanel Component:
		employeeTabComponent();
		
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
	
	public void employeeTabComponent() {
		JPanel adminTab = new JPanel();
		tabbedPane.addTab("Employee", null, adminTab, null);
	
		JPanel schedulePanel = new JPanel();
		schedulePanel.setBorder(new TitledBorder(null, "Weekly Schedule", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel adminInfoPanel = new JPanel();
		adminInfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_adminTab = new GroupLayout(adminTab);
		gl_adminTab.setHorizontalGroup(
			gl_adminTab.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_adminTab.createSequentialGroup()
					.addContainerGap()
					.addComponent(adminInfoPanel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(schedulePanel, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_adminTab.setVerticalGroup(
			gl_adminTab.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_adminTab.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_adminTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_adminTab.createSequentialGroup()
							.addComponent(schedulePanel, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_adminTab.createSequentialGroup()
							.addComponent(adminInfoPanel, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addGap(292))))
		);
		
		JLabel lblTerms = new JLabel("Term: ");
		lblTerms.setBounds(16, 30, 32, 14);
		
		// ######################### ComboBox ######################### 
		empTermDropdown = new JComboBox();
		
		empTermDropdown.setBounds(52, 27, 92, 20);
		//stdTermDropdown.setModel(new DefaultComboBoxModel(new String[] {"Fall 2019", "Spring 2020"}));	// static

		schedulePanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(16, 65, 498, 396);
		schedulePanel.add(scrollPane);
		
		
		// ######################### JTable #########################		
		//Init table
		empScheduleTableHeader  = new String[] {"CRN", "Course Name", "Room", "Time"};	 // init
		empScheduleTable = new JTable( new DefaultTableModel(new Object[][] {}, empScheduleTableHeader) ){
				public boolean isCellEditable(int row, int column) {
				return false; 
			}
		};

		scrollPane.setViewportView(empScheduleTable);
		
		// ######################### Drop Panel #########################
		schedulePanel.add(lblTerms);
		schedulePanel.add(empTermDropdown);
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblId = new JLabel("ID:");
		
		JLabel lblTuition = new JLabel("Salary:  ");
		
		fullnameField = new JTextField();
		fullnameField.setColumns(10);
		fullnameField.setEditable(false);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setEditable(false);

		
		salaryField = new JTextField();
		salaryField.setColumns(10);
		salaryField.setEditable(false);
		
		JLabel lblTitle = new JLabel("Title:  ");
		
		titleField = new JTextField();
		titleField.setEditable(false);
		titleField.setColumns(10);

		GroupLayout gl_adminInfoPanel = new GroupLayout(adminInfoPanel);
		gl_adminInfoPanel.setHorizontalGroup(
			gl_adminInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminInfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_adminInfoPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_adminInfoPanel.createSequentialGroup()
							.addGroup(gl_adminInfoPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblId))
							.addGap(25)
							.addGroup(gl_adminInfoPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(idField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(fullnameField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_adminInfoPanel.createSequentialGroup()
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(titleField))
						.addGroup(gl_adminInfoPanel.createSequentialGroup()
							.addComponent(lblTuition)
							.addGap(18)
							.addComponent(salaryField, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_adminInfoPanel.setVerticalGroup(
			gl_adminInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminInfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_adminInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(fullnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_adminInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addGap(21)
					.addGroup(gl_adminInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(titleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_adminInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTuition)
						.addComponent(salaryField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		adminInfoPanel.setLayout(gl_adminInfoPanel);
		adminTab.setLayout(gl_adminTab);
	}
	
	public void scheduleTabComponent() {
		JPanel scheduleTab = new JPanel();
		tabbedPane.addTab("Schedule", null, scheduleTab, null);
		
		JPanel schlScheldulePanel = new JPanel();
		
		
		// ######################### Combobox #########################			
		schlTermDropdown = new JComboBox();
		schlTermDropdown.setModel(new DefaultComboBoxModel(new String[] {"Fall 2019", "Spring 2020"}));

		
		
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
		schlScheduleTableHeader  = new String[] {"CRN", "Course Name", "Room", "Time", "Intructor", "Preq"};	 // init
		schlScheduleTable = new JTable( new DefaultTableModel(new Object[][] {}, schlScheduleTableHeader) ){
				public boolean isCellEditable(int row, int column) {
				return false; 
			}
		};
		
		scrollPane_1.setViewportView(schlScheduleTable);
		scheduleTab.setLayout(gl_scheduleTab);
	}
}
