package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import controller.admin.admin.SuperAdminRemoveAdminController;
import controller.admin.admin.SuperAdminSetAdminController;
import controller.admin.employee.AdminAddEmployeeSessionController;
import controller.admin.school.SuperAdminSetSchoolController;
import controller.student.StudentAddClassController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminView extends JFrame{
	
	private JPanel 		contentPane;
	private JTabbedPane tabbedPane;
	private JButton 	btnLogout;
	
	/*########### School Tab: ###########*/
	public JPanel schoolTab;
	public JButton schoolSaveButton;
	public JTextField schoolNameField;
	public JTextField schoolCurrentTermField;
	public JTextField schoolDescriptionField;
	
/*########### Admin Tab: ###########*/
	public JTable adListTable;
	public JScrollPane scrollPane;
	public JPanel adminTab;
	public JPanel adminInfo;
	public JTextField adminFirstNameField;
	public JTextField adminMiddleNameField;
	public JTextField adminLastNamefield;
	public JTextField adminIDField;
	public JButton adminSaveButton;
	public JRadioButton adminAddRadioButton;
	public JRadioButton adminEditRadioButton;
	public ButtonGroup adminRBG;
		/****Remove****/
	public JPanel removeAdmin;
	public JTextField adminRemoveIDField;
	public JButton adminRemoveButton;
		/****AdminList****/
	public JPanel adminListPane;
	
/*########### Employee Tab: ###########*/
	public JPanel employeeContentPane;
	public JTabbedPane adminTabbedPane;
	/****Profile****/
	public JPanel adminProfile;	
		/****Employee****/
	public JRadioButton radioButton;
	public JRadioButton radioButton_1;
	public JPanel employeInfo;
	public JLabel empNameLB;
	public JLabel empIDLB;
	public JTextField empProfileFirstNameField;
	public JTextField empProfileMiddleNameField;
	public JLabel empMiddleNameLB;
	public JTextField empProfielLastNameField;
	public JLabel emp;
	public JTextField empProfileIDField;
	public JButton empProfileSaveBtn;
		/****Remove****/
	public JPanel removeEmployee;
	public JButton empRemoveButton;
	public JLabel empRIDLB;
	public JTextField empProfileRmIDField;
		/****EmployeeList****/
	public JPanel employeeList;
	public JScrollPane empScrollPanel;		

	/****Assign****/
	public JPanel adminAssign;
	public JButton empAssignButton;
	public JTextField empAssignNameField;
	public JLabel selectEmpName1;
		/****AssignList****/
	public JPanel sessionSchedulePane;
	public JScrollPane empAssignSessionScrollPanel;
	
	/****Unassigns****/
	public JPanel adminUnAssign;
	public JButton empUnassignButton;
	public JTextField empUnassignNameField;
	public JLabel selectEmpName2;
		/****UnassignList****/
	public JPanel empSchedulePane;
	public JScrollPane empUnassignScrollPanel;

/*########### Student Tab: ###########*/
	public JPanel studentTab;
		/****Student****/
	public JPanel stdInfo;
	public JLabel stdFirstNameLB;
	public JLabel stdIDLB;
	public JTextField stdFirstNameField;
	public JTextField stdMiddleNameField;
	public JTextField stdLastNameField;
	public JLabel lblMiddle;
	public JLabel lblLast_1;
	public JTextField stdIDField;
	public JRadioButton stdAddRadioButton;
	public JRadioButton stdEditRadioButton;
	public ButtonGroup stdRBG;
	public JButton stdSaveButton;
		/****Remove****/
	public JPanel removeStd;
	public JButton stdRemoveButton;
	public JLabel removeStdIDLB;
	public JTextField stdRemoveIDField;
		/****StudentList****/
	public JPanel stdList;
	public JScrollPane stdScrollPanel; 
	
/*########### College Tab: ###########*/
	public JPanel collegeTab;
		/****College****/
	public JPanel collegeInfo;
	public JLabel collegeNameLB;
	public JLabel collegeDeanLB;
	public JTextField collegeNameField;
	public JTextField collegeDeanField;
	public JButton collegeSaveButton;
	public JRadioButton collegeAddRadioButton;
	public JRadioButton collegeEditRadioButton;
	public ButtonGroup collegeRBG;
		/****Remove****/
	public JPanel collegeRemovePane;
	public JButton collegeRemoveButton;
	public JLabel collegeRMLB;
	public JTextField collegeRemoveField;
		/****College List****/
	public JPanel collegeList;
	public JScrollPane collegeScrollPanel;
	
/*########### Department Tab: ###########*/
	public JPanel departmentTab;
		/****Department****/
	public JPanel dpInfo;
	public JLabel dpNameLB;
	public JLabel dpCharLB;
	public JTextField departmentNameField;
	public JTextField departmentChairField;
	public JComboBox departmentCollegeComboBox;
	public JButton departmentSaveButton;
	public JRadioButton departmentAddRadioButton;
	public JRadioButton departmentEditRadioButton;
	public ButtonGroup dpRBG;
		/****Remove****/
	public JPanel dpRemove;
	public JButton departmentRemoveButton;
	public JLabel dpRMLB;
	public JTextField departmentRemoveDepartmentField;
		/****Department List****/
	public JPanel dpList;
	public JScrollPane departmentScrollPanel;

/*########### Major Tab: ###########*/
	public JPanel majorTab;
		/****Major****/
	public JPanel majorInfo;
	public JTextField majorDepartmentComboBox;
	public JButton majorSaveButton;
	public JRadioButton majorAddRadioButton;
	public JRadioButton majorEditRadioButton;
	public ButtonGroup majorRBG;
	public JComboBox majorDpCB;
		/****Remove****/
	public JPanel majorRemove;
	public JButton majorRemoveButton;
	public JLabel majorRmDpLb;
	public JTextField majorRemoveDepartmentField;
		/****Major List****/
	public JPanel majorList;
	public JScrollPane majorScrollPanel;

	/*########### Course Tab: ###########*/
	public JPanel courseContentPane;
	public JTabbedPane courseTabbedPane;
	/****Course****/
	public JPanel coursePanel;
		/****CourseInfo****/
	public JPanel courseInfo;
	public JLabel courseIdLB;
	public JLabel courseNameLB;
	public JTextField courseIDField;
	public JTextField courseNameField;
	public JButton courseSaveButton;
	public JRadioButton courseAddRadioButton;
	public JRadioButton courseEditRadioButton;
	public ButtonGroup courseRBG;
	public JLabel courseMjLB;
	public JComboBox courseMajorComboBox;
	public JTextField coursePrereqField;
		/****Remove****/
	public JPanel courseRemove;
	public JButton courseRemoveButton;
	public JLabel courseRmLB;
	public JTextField courseRemoveCourseField;
		/****CourseList****/
	public JPanel courseList;
	public JScrollPane courseScrollPanel;
	/****Pre-req****/
	public JPanel preqPanel;
		/****pre-req Info****/
	public JPanel prereqInfo;
	public JLabel prereqSCLB;
	public JLabel prereqLB;
	public JTextField prereqSelectCourseField;
	public JTextField prereqField;
		/****Add****/
	public JPanel prereqAdd;
	public JLabel prereqAddCLB;
	public JTextField prereqAddCourseField;
	public JButton prereqAddButton;
		/****Remove****/
	public JPanel prereqRemove;
	public JLabel prereqRmLB;
	public JTextField prereqRemoveCourseField;
	public JButton prereqRemoveButton;
		/****List****/
	public JPanel prereqList;
	public JScrollPane prereqScrollPanel;

	
	/*########### Session Tab: ###########*/
	
	public AdminView() {
		//initDate();
		initComponents();
		createEvents();
		this.setVisible(true);
	}
	
	/*
	public void initData() {
		
	}*/
	
	/*########### Call Controller: ###########*/
		//School
	public void addSetSchoolInfoController		( SuperAdminSetSchoolController controller ) 	{ schoolSaveButton.addActionListener(controller); } 
		//Admin
	public void addSetAdminController			( SuperAdminSetAdminController controller ) 		{ adminSaveButton.addActionListener(controller);}
	public void addRemoveAdminController 		( SuperAdminRemoveAdminController controller ) 		{ adminRemoveButton.addActionListener(controller);}
		//Employee
	public void addAddEmployeeSessionController	( AdminAddEmployeeSessionController controller ) 	{ empAssignButton.addActionListener(controller); }

		//Student
		//College
		//Department
		//Major
		//Course
		//Session
	
	/*########### Call Handler: ###########*/
	public void createEvents() {
	//Logout
		JFrame _this = this;
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_this.dispose();
				LoginController login = new LoginController();
				login.init();
			}
		});
		
	//School
	//Admin
		adListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adminEditRadioButton.setSelected(true);
				
				TableModel tModel = adListTable.getModel();
				int i = adListTable.getSelectedRow();
				adminIDField.setText		(tModel.getValueAt(i, 0).toString());
				adminFirstNameField.setText	(tModel.getValueAt(i, 1).toString());
				adminMiddleNameField.setText(tModel.getValueAt(i, 2).toString());
				adminLastNamefield.setText	(tModel.getValueAt(i, 3).toString());

			}
		});
		// Add Option Selected
		adminAddRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adListTable.getSelectionModel().clearSelection();
				adminIDField.setText		("");
				adminFirstNameField.setText	("");
				adminMiddleNameField.setText("");
				adminLastNamefield.setText	("");
			}
		});
		// Edit Option Selected
		adminEditRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	//Employee
	
	//Student
	
	//College	
		
	//Department
	
	//Major
		
	//Course
	
	//Session
	
	}
	
	public void initComponents(){
		//-Jframe Windows:
		jframeComponent();
		
		//-Menu Component:
		menuComponent();
		
		//-Tab Component:
		tabComponent();
		
		//+schoolTabPanel Component:
		schoolTabComponent();
		
		//+adminTabPanel Component:
		adminTabComponent();
		
		//+employeeTabPanel Component:
		employeeTabComponent();
		
		//+studentTabPanel Component:
		studentTabComponent();
		
		//+CollegeTabPanel Component:
		collegeTabComponent();
		
		//+departmentTabPanel Component:
		departmentTabComponent();
		
		//+majorTabPanel Component:
		majorTabComponent();
		
		//+courseTabPanel Component:
		courseTabComponent();
		
		//+sessionTabPanel Component:
		sessionTabComponent();
		
	}
	
	public void jframeComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
	
	public void tabComponent() {
		contentPane.setLayout(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 775, 527);
		contentPane.add(tabbedPane);
	}
	
	/*########### School Tab: ###########*/
	public void schoolTabComponent() {
		schoolTab = new JPanel();
		tabbedPane.addTab("School", null, schoolTab, null);
		
		JLabel lblSchoolName = new JLabel("School Name :");
		lblSchoolName.setBounds(199, 175, 90, 14);
		
		JLabel lblCurrentTerm = new JLabel("Current Term :");
		lblCurrentTerm.setBounds(199, 220, 108, 14);
		
		schoolNameField = new JTextField();
		schoolNameField.setBounds(316, 172, 167, 20);
		schoolNameField.setColumns(10);
		
		schoolTab.setLayout(null);
		schoolTab.add(lblSchoolName);
		schoolTab.add(lblCurrentTerm);
		schoolTab.add(schoolNameField);
		
		JLabel lblSchoolDescription = new JLabel("School Description :");
		lblSchoolDescription.setBounds(199, 269, 117, 14);
		schoolTab.add(lblSchoolDescription);
		
		schoolDescriptionField = new JTextField();
		schoolDescriptionField.setColumns(10);
		schoolDescriptionField.setBounds(316, 266, 167, 20);
		schoolTab.add(schoolDescriptionField);
		
		schoolCurrentTermField = new JTextField();
		schoolCurrentTermField.setColumns(10);
		schoolCurrentTermField.setBounds(316, 217, 167, 20);
		schoolTab.add(schoolCurrentTermField);
		
		schoolSaveButton = new JButton("Save");
	
		schoolSaveButton.setBounds(376, 364, 117, 29);
		schoolTab.add(schoolSaveButton);
	}
	
	/*########### Admin Tab: ###########*/
	public void adminTabComponent() {
		adminTab = new JPanel();
		tabbedPane.addTab("Admin", null, adminTab, null);
		adminTab.setLayout(null);
		
		/****************Admin*****************/
		adminInfo = new JPanel();
		adminInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Admin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		adminInfo.setBounds(10, 40, 210, 185);
		adminTab.add(adminInfo);
		
		JLabel lblFirstname = new JLabel("FirstName:");
		lblFirstname.setBounds(16, 30, 32, 14);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setBounds(16, 115, 46, 14);
		
		adminFirstNameField = new JTextField();
		adminFirstNameField.setBounds(64, 27, 127, 20);
		adminFirstNameField.setColumns(10);
		
		adminIDField = new JTextField();
		adminIDField.setBounds(64, 112, 127, 20);
		adminIDField.setEditable(false);
		adminIDField.setColumns(10);
		
		adminInfo.setLayout(null);
		adminInfo.add(lblFirstname);
		adminInfo.add(label_1);
		adminInfo.add(adminFirstNameField);
		adminInfo.add(adminIDField);
		
		adminSaveButton = new JButton("Save");
		adminSaveButton.setBounds(133, 143, 71, 23);
		adminInfo.add(adminSaveButton);
		
		adminAddRadioButton = new JRadioButton("Add");

		adminAddRadioButton.setBounds(6, 141, 57, 23);
		adminInfo.add(adminAddRadioButton);
		
		adminEditRadioButton = new JRadioButton("Edit");

		adminEditRadioButton.setBounds(73, 141, 57, 23);
		adminInfo.add(adminEditRadioButton);
		
		//Group Button method
		adminRBG = new ButtonGroup();
		adminAddRadioButton.setSelected(true);
		adminRBG.add(adminAddRadioButton);
		adminRBG.add(adminEditRadioButton);
		
		JLabel lblNewLabel = new JLabel("Middle :");
		lblNewLabel.setBounds(16, 56, 61, 16);
		adminInfo.add(lblNewLabel);
		
		JLabel lblLast = new JLabel("Last :");
		lblLast.setBounds(16, 84, 61, 16);
		adminInfo.add(lblLast);
		
		adminMiddleNameField = new JTextField();
		adminMiddleNameField.setColumns(10);
		adminMiddleNameField.setBounds(64, 59, 127, 20);
		adminInfo.add(adminMiddleNameField);
		
		adminLastNamefield = new JTextField();
		adminLastNamefield.setColumns(10);
		adminLastNamefield.setBounds(64, 84, 127, 20);
		adminInfo.add(adminLastNamefield);
		
		/****************Remove*****************/
		removeAdmin = new JPanel();
		removeAdmin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Remove", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		removeAdmin.setBounds(10, 292, 210, 120);
		adminTab.add(removeAdmin);
		
		adminRemoveButton = new JButton("Remove");
		adminRemoveButton.setBounds(115, 79, 71, 23);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(16, 51, 25, 14);
		
		adminRemoveIDField = new JTextField();
		adminRemoveIDField.setBounds(68, 48, 118, 20);
		adminRemoveIDField.setEditable(false);
		adminRemoveIDField.setColumns(10);
		
		removeAdmin.setLayout(null);
		removeAdmin.add(adminRemoveButton);
		removeAdmin.add(lblId);
		removeAdmin.add(adminRemoveIDField);
		
		/****************Admin List*****************/
		adminListPane = new JPanel();
		adminListPane.setBorder(new TitledBorder(null, "Admin List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		adminListPane.setBounds(230, 11, 519, 477);
		adminTab.add(adminListPane);
		adminListPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 26, 482, 430);
		adminListPane.add(scrollPane);
		
		adListTable = new JTable(){
			public boolean isCellEditable(int row, int column) {
				return false; 
			}
		};

		scrollPane.setViewportView(adListTable);
	}
	
	/*########### Employee Tab: ###########*/
	public void employeeTabComponent() {
		employeeContentPane = new JPanel();
		tabbedPane.addTab("Employee", null, employeeContentPane, null);
		employeeContentPane.setLayout(null);
		
		adminTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		adminTabbedPane.setBounds(10, 11, 749, 478);
		employeeContentPane.add(adminTabbedPane);
		
		/****************Profile*****************/
		adminProfile = new JPanel();
		adminTabbedPane.addTab("Profiles", null, adminProfile, null);
		adminProfile.setLayout(null);
		
		employeInfo = new JPanel();
		employeInfo.setLayout(null);
		employeInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		employeInfo.setBounds(10, 40, 210, 185);
		adminProfile.add(employeInfo);
		
		empNameLB = new JLabel("First :");
		empNameLB.setBounds(16, 30, 32, 14);
		employeInfo.add(empNameLB);
		
		empIDLB = new JLabel("ID:");
		empIDLB.setBounds(16, 113, 15, 14);
		employeInfo.add(empIDLB);
		
		empProfileFirstNameField = new JTextField();
		empProfileFirstNameField.setEditable(false);
		empProfileFirstNameField.setColumns(10);
		empProfileFirstNameField.setBounds(64, 27, 127, 20);
		employeInfo.add(empProfileFirstNameField);
		
		empProfileIDField = new JTextField();
		empProfileIDField.setEditable(false);
		empProfileIDField.setColumns(10);
		empProfileIDField.setBounds(64, 110, 127, 20);
		employeInfo.add(empProfileIDField);
		
		empProfileSaveBtn = new JButton("Save");
		empProfileSaveBtn.setBounds(133, 144, 71, 23);
		employeInfo.add(empProfileSaveBtn);
		
		empProfileMiddleNameField = new JTextField();
		empProfileMiddleNameField.setEditable(false);
		empProfileMiddleNameField.setColumns(10);
		empProfileMiddleNameField.setBounds(64, 56, 127, 20);
		employeInfo.add(empProfileMiddleNameField);
		
		empMiddleNameLB = new JLabel("Middle :");
		empMiddleNameLB.setBounds(16, 59, 32, 14);
		employeInfo.add(empMiddleNameLB);
		
		empProfielLastNameField = new JTextField();
		empProfielLastNameField.setEditable(false);
		empProfielLastNameField.setColumns(10);
		empProfielLastNameField.setBounds(64, 85, 127, 20);
		employeInfo.add(empProfielLastNameField);
		
		emp = new JLabel("Last :");
		emp.setBounds(16, 88, 32, 14);
		employeInfo.add(emp);
		
		radioButton = new JRadioButton("Add");
		radioButton.setSelected(true);
		radioButton.setBounds(6, 142, 57, 23);
		employeInfo.add(radioButton);
		
		radioButton_1 = new JRadioButton("Edit");
		radioButton_1.setBounds(73, 142, 57, 23);
		employeInfo.add(radioButton_1);
		
		removeEmployee = new JPanel();
		removeEmployee.setLayout(null);
		removeEmployee.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Remove", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		removeEmployee.setBounds(10, 256, 210, 120);
		adminProfile.add(removeEmployee);
		
		empRemoveButton = new JButton("Remove");
		empRemoveButton.setBounds(115, 79, 71, 23);
		removeEmployee.add(empRemoveButton);
		
		empRIDLB = new JLabel("ID:");
		empRIDLB.setBounds(16, 51, 25, 14);
		removeEmployee.add(empRIDLB);
		
		empProfileRmIDField = new JTextField();
		empProfileRmIDField.setEditable(false);
		empProfileRmIDField.setColumns(10);
		empProfileRmIDField.setBounds(68, 48, 118, 20);
		removeEmployee.add(empProfileRmIDField);
		
		employeeList = new JPanel();
		employeeList.setLayout(null);
		employeeList.setBorder(new TitledBorder(null, "Employee List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		employeeList.setBounds(225, 0, 519, 450);
		adminProfile.add(employeeList);
		
		empScrollPanel = new JScrollPane();
		empScrollPanel.setBounds(10, 21, 499, 418);
		employeeList.add(empScrollPanel);
		
		/****************Assign*****************/
		adminAssign = new JPanel();
		adminTabbedPane.addTab("Assigns", null, adminAssign, null);
		adminAssign.setLayout(null);
		
		sessionSchedulePane = new JPanel();
		sessionSchedulePane.setLayout(null);
		sessionSchedulePane.setBorder(new TitledBorder(null, "Session Schedule", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sessionSchedulePane.setBounds(204, 11, 530, 428);
		adminAssign.add(sessionSchedulePane);
		
		empAssignSessionScrollPanel = new JScrollPane();
		empAssignSessionScrollPanel.setBounds(16, 25, 498, 392);
		sessionSchedulePane.add(empAssignSessionScrollPanel);
		
		empAssignButton = new JButton("Assign");
		empAssignButton.setBounds(101, 401, 71, 23);
		adminAssign.add(empAssignButton);
		
		empAssignNameField = new JTextField();
		empAssignNameField.setEditable(false);
		empAssignNameField.setColumns(10);
		empAssignNameField.setBounds(58, 94, 127, 20);
		adminAssign.add(empAssignNameField);
		
		selectEmpName1 = new JLabel("Name:");
		selectEmpName1.setBounds(10, 97, 32, 14);
		adminAssign.add(selectEmpName1);
		
		/****************Unassign*****************/
		adminUnAssign = new JPanel();
		adminTabbedPane.addTab("Unassigns", null, adminUnAssign, null);
		adminUnAssign.setLayout(null);
		
		empSchedulePane = new JPanel();
		empSchedulePane.setLayout(null);
		empSchedulePane.setBorder(new TitledBorder(null, "Session Schedule", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		empSchedulePane.setBounds(204, 11, 530, 428);
		adminUnAssign.add(empSchedulePane);
		
		empUnassignScrollPanel = new JScrollPane();
		empUnassignScrollPanel.setBounds(16, 25, 498, 392);
		empSchedulePane.add(empUnassignScrollPanel);
		
		empUnassignNameField = new JTextField();
		empUnassignNameField.setEditable(false);
		empUnassignNameField.setColumns(10);
		empUnassignNameField.setBounds(58, 94, 127, 20);
		adminUnAssign.add(empUnassignNameField);
		
		selectEmpName2 = new JLabel("Name:");
		selectEmpName2.setBounds(10, 97, 32, 14);
		adminUnAssign.add(selectEmpName2);
		
		empUnassignButton = new JButton("Unassign");
		empUnassignButton.setBounds(86, 399, 99, 23);
		adminUnAssign.add(empUnassignButton);
	}
	
	/*########### Student Tab: ###########*/
	public void studentTabComponent() {
		studentTab = new JPanel();
		tabbedPane.addTab("Student", null, studentTab, null);
		studentTab.setLayout(null);
		
		/****************Student*****************/
		stdInfo = new JPanel();
		stdInfo.setLayout(null);
		stdInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Student", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		stdInfo.setBounds(10, 40, 210, 185);
		studentTab.add(stdInfo);
		
		stdFirstNameLB = new JLabel("First :");
		stdFirstNameLB.setBounds(16, 30, 32, 14);
		stdInfo.add(stdFirstNameLB);
		
		stdIDLB = new JLabel("ID:");
		stdIDLB.setBounds(16, 117, 15, 14);
		stdInfo.add(stdIDLB);
		
		stdFirstNameField = new JTextField();
		stdFirstNameField.setEditable(false);
		stdFirstNameField.setColumns(10);
		stdFirstNameField.setBounds(64, 27, 127, 20);
		stdInfo.add(stdFirstNameField);
		
		stdIDField = new JTextField();
		stdIDField.setEditable(false);
		stdIDField.setColumns(10);
		stdIDField.setBounds(64, 114, 127, 20);
		stdInfo.add(stdIDField);
		
		stdSaveButton = new JButton("Save");
		stdSaveButton.setBounds(120, 146, 71, 23);
		stdInfo.add(stdSaveButton);
		
		stdAddRadioButton = new JRadioButton("Add");
		stdAddRadioButton.setBounds(6, 144, 51, 23);
		stdInfo.add(stdAddRadioButton);
		
		stdEditRadioButton = new JRadioButton("Edit");
		stdEditRadioButton.setBounds(64, 144, 51, 23);
		stdInfo.add(stdEditRadioButton);
	
		//Group Button method
		stdRBG = new ButtonGroup();
		stdAddRadioButton.setSelected(true);
		stdRBG.add(stdAddRadioButton);
		stdRBG.add(stdEditRadioButton);
		
		stdMiddleNameField = new JTextField();
		stdMiddleNameField.setEditable(false);
		stdMiddleNameField.setColumns(10);
		stdMiddleNameField.setBounds(64, 55, 127, 20);
		stdInfo.add(stdMiddleNameField);
		
		stdLastNameField = new JTextField();
		stdLastNameField.setEditable(false);
		stdLastNameField.setColumns(10);
		stdLastNameField.setBounds(64, 82, 127, 20);
		stdInfo.add(stdLastNameField);
		
		lblMiddle = new JLabel("Middle :");
		lblMiddle.setBounds(16, 56, 32, 14);
		stdInfo.add(lblMiddle);
		
		lblLast_1 = new JLabel("Last :");
		lblLast_1.setBounds(16, 85, 32, 14);
		stdInfo.add(lblLast_1);
		
		/****************Remove*****************/
		removeStd = new JPanel();
		removeStd.setLayout(null);
		removeStd.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Remove", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		removeStd.setBounds(10, 292, 210, 120);
		studentTab.add(removeStd);
		
		stdRemoveButton = new JButton("Remove");
		stdRemoveButton.setBounds(115, 79, 71, 23);
		removeStd.add(stdRemoveButton);
		
		removeStdIDLB = new JLabel("ID:");
		removeStdIDLB.setBounds(16, 51, 25, 14);
		removeStd.add(removeStdIDLB);
		
		stdRemoveIDField = new JTextField();
		stdRemoveIDField.setEditable(false);
		stdRemoveIDField.setColumns(10);
		stdRemoveIDField.setBounds(68, 48, 118, 20);
		removeStd.add(stdRemoveIDField);
		
		/****************Student List*****************/
		stdList = new JPanel();
		stdList.setLayout(null);
		stdList.setBorder(new TitledBorder(null, "Student List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		stdList.setBounds(230, 11, 519, 477);
		studentTab.add(stdList);
		
		stdScrollPanel = new JScrollPane();
		stdScrollPanel.setBounds(10, 21, 499, 445);
		stdList.add(stdScrollPanel);;
	}
	
	/*########### College Tab: ###########*/
	public void collegeTabComponent() {
		collegeTab = new JPanel();
		tabbedPane.addTab("College", null, collegeTab, null);
		collegeTab.setLayout(null);
		
		/****************College*****************/
		collegeInfo = new JPanel();
		collegeInfo.setLayout(null);
		collegeInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "College", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		collegeInfo.setBounds(10, 40, 210, 145);
		collegeTab.add(collegeInfo);
		
		collegeNameLB = new JLabel("Name :");
		collegeNameLB.setBounds(16, 30, 38, 14);
		collegeInfo.add(collegeNameLB);
		
		collegeDeanLB = new JLabel("Dean :");
		collegeDeanLB.setBounds(16, 68, 38, 14);
		collegeInfo.add(collegeDeanLB);
		
		collegeNameField = new JTextField();
		collegeNameField.setEditable(false);
		collegeNameField.setColumns(10);
		collegeNameField.setBounds(64, 27, 127, 20);
		collegeInfo.add(collegeNameField);
		
		collegeDeanField = new JTextField();
		collegeDeanField.setEditable(false);
		collegeDeanField.setColumns(10);
		collegeDeanField.setBounds(64, 65, 127, 20);
		collegeInfo.add(collegeDeanField);
		
		collegeSaveButton = new JButton("Save");
		collegeSaveButton.setBounds(120, 104, 71, 23);
		collegeInfo.add(collegeSaveButton);
		
		collegeAddRadioButton = new JRadioButton("Add");
		collegeAddRadioButton.setBounds(10, 104, 51, 23);
		collegeInfo.add(collegeAddRadioButton);
		
		collegeEditRadioButton = new JRadioButton("Edit");
		collegeEditRadioButton.setBounds(63, 104, 51, 23);
		collegeInfo.add(collegeEditRadioButton);
		
		//Group Button method
		collegeRBG = new ButtonGroup();
		collegeAddRadioButton.setSelected(true);
		collegeRBG.add(collegeAddRadioButton);
		collegeRBG.add(collegeEditRadioButton);
		
		/****************Remove*****************/
		collegeRemovePane = new JPanel();
		collegeRemovePane.setLayout(null);
		collegeRemovePane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Remove", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		collegeRemovePane.setBounds(10, 292, 210, 120);
		collegeTab.add(collegeRemovePane);
		
		collegeRemoveButton = new JButton("Remove");
		collegeRemoveButton.setBounds(115, 79, 71, 23);
		collegeRemovePane.add(collegeRemoveButton);
		
		collegeRMLB = new JLabel("College :");
		collegeRMLB.setBounds(16, 51, 44, 14);
		collegeRemovePane.add(collegeRMLB);
		
		collegeRemoveField = new JTextField();
		collegeRemoveField.setEditable(false);
		collegeRemoveField.setColumns(10);
		collegeRemoveField.setBounds(68, 48, 118, 20);
		collegeRemovePane.add(collegeRemoveField);
		
		/****************College List*****************/
		collegeList = new JPanel();
		collegeList.setLayout(null);
		collegeList.setBorder(new TitledBorder(null, "College List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		collegeList.setBounds(230, 11, 519, 477);
		collegeTab.add(collegeList);
		
		collegeScrollPanel = new JScrollPane();
		collegeScrollPanel.setBounds(10, 21, 499, 445);
		collegeList.add(collegeScrollPanel);
	}
	
	/*########### Department Tab: ###########*/
	public void departmentTabComponent() {
		departmentTab = new JPanel();
		tabbedPane.addTab("Department", null, departmentTab, null);
		departmentTab.setLayout(null);
		
		/****************Department*****************/
		dpInfo = new JPanel();
		dpInfo.setLayout(null);
		dpInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "College", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		dpInfo.setBounds(10, 40, 210, 178);
		departmentTab.add(dpInfo);
		
		dpNameLB = new JLabel("Name :");
		dpNameLB.setBounds(16, 30, 38, 14);
		dpInfo.add(dpNameLB);
		
		dpCharLB = new JLabel("Chair :");
		dpCharLB.setBounds(16, 68, 38, 14);
		dpInfo.add(dpCharLB);
		
		departmentNameField = new JTextField();
		departmentNameField.setEditable(false);
		departmentNameField.setColumns(10);
		departmentNameField.setBounds(64, 27, 127, 20);
		dpInfo.add(departmentNameField);
		
		departmentChairField = new JTextField();
		departmentChairField.setEditable(false);
		departmentChairField.setColumns(10);
		departmentChairField.setBounds(64, 65, 127, 20);
		dpInfo.add(departmentChairField);
		
		departmentSaveButton = new JButton("Save");
		departmentSaveButton.setBounds(126, 148, 71, 23);
		dpInfo.add(departmentSaveButton);
		
		departmentAddRadioButton = new JRadioButton("Add");
		departmentAddRadioButton.setBounds(16, 148, 51, 23);
		dpInfo.add(departmentAddRadioButton);
		
		departmentEditRadioButton = new JRadioButton("Edit");
		departmentEditRadioButton.setBounds(69, 148, 51, 23);
		dpInfo.add(departmentEditRadioButton);
		
		//Group Button method
		dpRBG = new ButtonGroup();
		departmentAddRadioButton.setSelected(true);
		dpRBG.add(departmentAddRadioButton);
		dpRBG.add(departmentEditRadioButton);
		
		JLabel dpCollegeLB = new JLabel("College : ");
		dpCollegeLB.setBounds(16, 106, 51, 14);
		dpInfo.add(dpCollegeLB);
		
		departmentCollegeComboBox = new JComboBox();
		departmentCollegeComboBox.setBounds(64, 102, 127, 22);
		dpInfo.add(departmentCollegeComboBox);
		
		/****************Remove*****************/
		dpRemove = new JPanel();
		dpRemove.setLayout(null);
		dpRemove.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Remove", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		dpRemove.setBounds(10, 292, 210, 138);
		departmentTab.add(dpRemove);
		
		departmentRemoveButton = new JButton("Remove");
		departmentRemoveButton.setBounds(115, 95, 71, 23);
		dpRemove.add(departmentRemoveButton);
		
		dpRMLB = new JLabel("Department :");
		dpRMLB.setBounds(24, 39, 79, 14);
		dpRemove.add(dpRMLB);
		
		departmentRemoveDepartmentField = new JTextField();
		departmentRemoveDepartmentField.setEditable(false);
		departmentRemoveDepartmentField.setColumns(10);
		departmentRemoveDepartmentField.setBounds(68, 64, 118, 20);
		dpRemove.add(departmentRemoveDepartmentField);
		
		/****************Department List*****************/
		dpList = new JPanel();
		dpList.setLayout(null);
		dpList.setBorder(new TitledBorder(null, "Department List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dpList.setBounds(230, 11, 519, 477);
		departmentTab.add(dpList);
		
		departmentScrollPanel = new JScrollPane();
		departmentScrollPanel.setBounds(10, 21, 499, 445);
		dpList.add(departmentScrollPanel);;
	}
	
	/*########### Major Tab: ###########*/
	public void majorTabComponent() {
		majorTab = new JPanel();
		tabbedPane.addTab("Major", null, majorTab, null);
		majorTab.setLayout(null);
		
		/****************Major*****************/
		majorInfo = new JPanel();
		majorInfo.setLayout(null);
		majorInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Major", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		majorInfo.setBounds(10, 40, 210, 207);
		majorTab.add(majorInfo);
		
		JLabel majorNameLB = new JLabel("Name :");
		majorNameLB.setBounds(16, 30, 38, 14);
		majorInfo.add(majorNameLB);
		
		JLabel majorDpLB = new JLabel("Department :");
		majorDpLB.setBounds(16, 88, 76, 14);
		majorInfo.add(majorDpLB);
		
		majorDepartmentComboBox = new JTextField();
		majorDepartmentComboBox.setEditable(false);
		majorDepartmentComboBox.setColumns(10);
		majorDepartmentComboBox.setBounds(64, 54, 127, 20);
		majorInfo.add(majorDepartmentComboBox);
		
		majorSaveButton = new JButton("Save");
		majorSaveButton.setBounds(126, 152, 71, 23);
		majorInfo.add(majorSaveButton);
		
		majorAddRadioButton = new JRadioButton("Add");
		majorAddRadioButton.setSelected(true);
		majorAddRadioButton.setBounds(16, 152, 51, 23);
		majorInfo.add(majorAddRadioButton);
		
		majorEditRadioButton = new JRadioButton("Edit");
		majorEditRadioButton.setBounds(69, 152, 51, 23);
		majorInfo.add(majorEditRadioButton);
		
		//Group Button method
		majorRBG = new ButtonGroup();
		majorAddRadioButton.setSelected(true);
		majorRBG.add(majorAddRadioButton);
		majorRBG.add(majorEditRadioButton);
		
		majorDpCB = new JComboBox();
		majorDpCB.setBounds(64, 113, 127, 22);
		majorInfo.add(majorDpCB);
		
		/****************Remove*****************/
		majorRemove = new JPanel();
		majorRemove.setLayout(null);
		majorRemove.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Remove", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		majorRemove.setBounds(10, 313, 210, 138);
		majorTab.add(majorRemove);
		
		majorRemoveButton = new JButton("Remove");
		majorRemoveButton.setBounds(115, 95, 71, 23);
		majorRemove.add(majorRemoveButton);
		
		majorRmDpLb = new JLabel("Department :");
		majorRmDpLb.setBounds(24, 39, 79, 14);
		majorRemove.add(majorRmDpLb);
		
		majorRemoveDepartmentField = new JTextField();
		majorRemoveDepartmentField.setEditable(false);
		majorRemoveDepartmentField.setColumns(10);
		majorRemoveDepartmentField.setBounds(68, 64, 118, 20);
		majorRemove.add(majorRemoveDepartmentField);
		
		/****************Major List*****************/
		majorList = new JPanel();
		majorList.setLayout(null);
		majorList.setBorder(new TitledBorder(null, "Major List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		majorList.setBounds(230, 11, 519, 477);
		majorTab.add(majorList);
		
		majorScrollPanel = new JScrollPane();
		majorScrollPanel.setBounds(10, 21, 499, 445);
		majorList.add(majorScrollPanel);;
	}
	
	/*########### Course Tab: ###########*/
	public void courseTabComponent() {
		courseContentPane = new JPanel();
		
		tabbedPane.addTab("Course", null, courseContentPane, null);
		courseContentPane.setLayout(null);
		
		courseTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		courseTabbedPane.setBounds(10, 11, 749, 478);
		courseContentPane.add(courseTabbedPane);
		
	/****************Course Tab*****************/
		coursePanel = new JPanel();
		courseTabbedPane.addTab("Course", null, coursePanel, null);
		coursePanel.setLayout(null);
		
		/****************Course Info*****************/
		courseInfo = new JPanel();
		courseInfo.setLayout(null);
		courseInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Course", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		courseInfo.setBounds(10, 31, 210, 234);
		coursePanel.add(courseInfo);
		
		courseIdLB = new JLabel("ID :");
		courseIdLB.setBounds(16, 30, 38, 14);
		courseInfo.add(courseIdLB);
		
		courseNameLB = new JLabel("Name :");
		courseNameLB.setBounds(16, 68, 38, 14);
		courseInfo.add(courseNameLB);
		
		courseIDField = new JTextField();
		courseIDField.setEditable(false);
		courseIDField.setColumns(10);
		courseIDField.setBounds(64, 27, 127, 20);
		courseInfo.add(courseIDField);
		
		courseNameField = new JTextField();
		courseNameField.setEditable(false);
		courseNameField.setColumns(10);
		courseNameField.setBounds(64, 65, 127, 20);
		courseInfo.add(courseNameField);
		
		courseSaveButton = new JButton("Save");
		courseSaveButton.setBounds(126, 184, 71, 23);
		courseInfo.add(courseSaveButton);
		
		courseAddRadioButton = new JRadioButton("Add");
		courseAddRadioButton.setSelected(true);
		courseAddRadioButton.setBounds(16, 184, 51, 23);
		courseInfo.add(courseAddRadioButton);
		
		courseEditRadioButton = new JRadioButton("Edit");
		courseEditRadioButton.setBounds(69, 184, 51, 23);
		courseInfo.add(courseEditRadioButton);

		//Group Button method
		courseRBG = new ButtonGroup();
		courseAddRadioButton.setSelected(true);
		courseRBG.add(courseAddRadioButton);
		courseRBG.add(courseEditRadioButton);
		
		courseMjLB = new JLabel("Major : ");
		courseMjLB.setBounds(16, 144, 51, 14);
		courseInfo.add(courseMjLB);
		
		courseMajorComboBox = new JComboBox();
		courseMajorComboBox.setBounds(64, 140, 127, 22);
		courseInfo.add(courseMajorComboBox);
		
		JLabel prerepLb = new JLabel("Pre-req :");
		prerepLb.setBounds(16, 105, 51, 14);
		courseInfo.add(prerepLb);
		
		coursePrereqField = new JTextField();
		coursePrereqField.setEditable(false);
		coursePrereqField.setColumns(10);
		coursePrereqField.setBounds(64, 105, 127, 20);
		courseInfo.add(coursePrereqField);
		
		/****************Remove*****************/
		courseRemove = new JPanel();
		courseRemove.setLayout(null);
		courseRemove.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Remove", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		courseRemove.setBounds(10, 285, 210, 138);
		coursePanel.add(courseRemove);
		
		courseRemoveButton = new JButton("Remove");
		courseRemoveButton.setBounds(115, 95, 71, 23);
		courseRemove.add(courseRemoveButton);
		
		courseRmLB = new JLabel("Course :");
		courseRmLB.setBounds(24, 39, 79, 14);
		courseRemove.add(courseRmLB);
		
		courseRemoveCourseField = new JTextField();
		courseRemoveCourseField.setEditable(false);
		courseRemoveCourseField.setColumns(10);
		courseRemoveCourseField.setBounds(68, 64, 118, 20);
		courseRemove.add(courseRemoveCourseField);
		
		/****************Course List*****************/
		courseList = new JPanel();
		courseList.setLayout(null);
		courseList.setBorder(new TitledBorder(null, "Course List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		courseList.setBounds(225, 0, 519, 450);
		coursePanel.add(courseList);
		
		courseScrollPanel = new JScrollPane();
		courseScrollPanel.setBounds(10, 21, 499, 418);
		courseList.add(courseScrollPanel);
		
	/****************Pre-req Tab*****************/
		preqPanel = new JPanel();
		courseTabbedPane.addTab("Pre-req", null, preqPanel, null);
		preqPanel.setLayout(null);
		
		/****************Pre-req Info*****************/
		prereqInfo = new JPanel();
		prereqInfo.setLayout(null);
		prereqInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		prereqInfo.setBounds(10, 31, 210, 162);
		preqPanel.add(prereqInfo);
		
		prereqSCLB = new JLabel("Selected Course :");
		prereqSCLB.setBounds(16, 30, 86, 14);
		prereqInfo.add(prereqSCLB);
		
		prereqLB = new JLabel("Pre-required :");
		prereqLB.setBounds(16, 96, 86, 14);
		prereqInfo.add(prereqLB);
		
		prereqSelectCourseField = new JTextField();
		prereqSelectCourseField.setEditable(false);
		prereqSelectCourseField.setColumns(10);
		prereqSelectCourseField.setBounds(64, 55, 127, 20);
		prereqInfo.add(prereqSelectCourseField);
		
		prereqField = new JTextField();
		prereqField.setEditable(false);
		prereqField.setColumns(10);
		prereqField.setBounds(64, 117, 127, 20);
		prereqInfo.add(prereqField);
		
		/****************Pre-req Add*****************/
		prereqAdd = new JPanel();
		prereqAdd.setLayout(null);
		prereqAdd.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		prereqAdd.setBounds(10, 196, 210, 120);
		preqPanel.add(prereqAdd);
		
		prereqAddCLB = new JLabel("Course :");
		prereqAddCLB.setBounds(16, 51, 44, 14);
		prereqAdd.add(prereqAddCLB);
		
		prereqAddCourseField = new JTextField();
		prereqAddCourseField.setEditable(false);
		prereqAddCourseField.setColumns(10);
		prereqAddCourseField.setBounds(68, 48, 118, 20);
		prereqAdd.add(prereqAddCourseField);
		
		prereqAddButton = new JButton("Add");
		prereqAddButton.setBounds(68, 80, 117, 29);
		prereqAdd.add(prereqAddButton);
		
		/****************Pre-req Remove*****************/
		prereqRemove = new JPanel();
		prereqRemove.setLayout(null);
		prereqRemove.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Remove", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		prereqRemove.setBounds(10, 319, 210, 120);
		preqPanel.add(prereqRemove);
		
		prereqRmLB = new JLabel("Course :");
		prereqRmLB.setBounds(16, 51, 44, 14);
		prereqRemove.add(prereqRmLB);
		
		prereqRemoveCourseField = new JTextField();
		prereqRemoveCourseField.setEditable(false);
		prereqRemoveCourseField.setColumns(10);
		prereqRemoveCourseField.setBounds(68, 48, 118, 20);
		prereqRemove.add(prereqRemoveCourseField);
		
		prereqRemoveButton = new JButton("Remove");
		prereqRemoveButton.setBounds(68, 80, 117, 29);
		prereqRemove.add(prereqRemoveButton);
		
		/****************Pre-req Course List*****************/
		prereqList = new JPanel();
		prereqList.setLayout(null);
		prereqList.setBorder(new TitledBorder(null, "P.Course List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		prereqList.setBounds(225, 0, 519, 450);
		preqPanel.add(prereqList);
		
		prereqScrollPanel = new JScrollPane();
		prereqScrollPanel.setBounds(10, 21, 499, 418);
		prereqList.add(prereqScrollPanel);;
	}
	
	/*########### Session Tab: ###########*/
	public void sessionTabComponent() {
		JPanel sessionTab = new JPanel();
		tabbedPane.addTab("Session", null, sessionTab, null);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
