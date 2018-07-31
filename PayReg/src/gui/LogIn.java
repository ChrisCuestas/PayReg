package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Dimension;

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
		setType(Type.UTILITY);
		setTitle("PayReg: LogIn");
		setForeground(new Color(250, 250, 210));
		setBackground(new Color(0, 255, 127));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 258, 270);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCredentials = new JLabel("Credentials:");
		lblCredentials.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCredentials.setBounds(22, 59, 94, 26);
		contentPane.add(lblCredentials);
		
		userNameField = new JTextField();
		userNameField.setBounds(114, 104, 110, 20);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(58, 107, 46, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(36, 149, 68, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(114, 146, 110, 20);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(87, 203, 89, 23);
		contentPane.add(btnLogIn);
		
		JLabel lblPayreg = new JLabel("PayReg");
		lblPayreg.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblPayreg.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayreg.setBounds(22, 11, 68, 33);
		contentPane.add(lblPayreg);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{userNameField, passwordField, btnLogIn}));
	}
}
