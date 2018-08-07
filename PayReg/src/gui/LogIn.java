package gui;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class LogIn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		super("PayReg: LogIn");
		setPreferredSize(new Dimension(250, 330));
		setMinimumSize(new Dimension(250, 330));
		setMaximumSize(new Dimension(250, 330));
		setBounds(100, 100, 250, 330);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
		}
	
	private void initialize() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayRegTitle = new JLabel("PayReg");
		lblPayRegTitle.setBounds(82, 40, 86, 20);
		lblPayRegTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPayRegTitle.setFont(new Font("Stencil", Font.BOLD, 21));
		contentPane.add(lblPayRegTitle);
		
		JLabel lblDef = new JLabel("Sistema de registro de aportes");
		lblDef.setBounds(30, 65, 190, 14);
		lblDef.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblDef);
		
		JLabel lblAuthor = new JLabel("Author: Christian Camilo Cuestas");
		lblAuthor.setBounds(10, 280, 224, 14);
		contentPane.add(lblAuthor);
		
		JLabel lblCredentials = new JLabel("Credentials:");
		lblCredentials.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCredentials.setBounds(16, 103, 94, 26);
		contentPane.add(lblCredentials);
		
		userNameField = new JTextField();
		userNameField.setBounds(101, 140, 110, 20);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(45, 143, 46, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(23, 185, 68, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(101, 182, 110, 20);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(74, 239, 89, 23);
		contentPane.add(btnLogIn);
		
		
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{userNameField, passwordField, btnLogIn}));
	}
}
