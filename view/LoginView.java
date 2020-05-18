package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.login.LoginUserController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class LoginView extends JFrame {
	private JPanel 			contentPane;
	private JButton 		btnReset;
	private JButton 		btnLogin;
	
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmExit;
	private JMenu mnAbout;
	private JMenuItem mntmInfo;
	
	// Public Fields (For controllers):
	public JTextField 		idField;
	public JPasswordField 	passwordField;
	
	
	public JTextField getjText() {
		return this.idField;
	}
	
	/**
	 * Create the frame.
	 */
	public LoginView() {
		// Init view Component:
		initComponents();
		createEvents();
		
		// Show:
		this.setVisible(true);
	}
	// Controllers:
	public void addLoginUserController(LoginUserController loginUserController) { btnLogin.addActionListener(loginUserController);}
	
	
	private void createEvents() {
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idField.setText("");
				passwordField.setText("");
			}
		});
		// Menu bar handler
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(opt == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		// Event "enter" button
		JRootPane rootPane = SwingUtilities.getRootPane(btnLogin); 
		rootPane.setDefaultButton(btnLogin);
	}
	
	
	private void initComponents() {
		// Menu Bar:
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmExit = new JMenuItem("Exit");

		mnFile.add(mntmExit);
		
		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		mntmInfo = new JMenuItem("Info");
		mnAbout.add(mntmInfo);
		
		// Default JFrame Setting:
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// UserName Filed:
		JLabel lblID = new JLabel("ID: ");
		
		idField = new JTextField();
		idField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		
		// Password Filed:
		passwordField = new JPasswordField();
		
		btnLogin = new JButton("Login");
		btnReset = new JButton("Reset");

		// UI Positioning:
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(2))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(18))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(3)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(passwordField, Alignment.LEADING, 261, 261, 261)
						.addComponent(idField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(193)
							.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(224))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(181)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblID, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(194))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
