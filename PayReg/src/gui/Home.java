package gui;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import finance.EventHandler;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Home extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private EventHandler eventHandler;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(
				new Runnable() {
					public void run() {
						try {
							Home home = new Home();
							home.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
													);
		
	}

	/**
	 * Create the application.
	 */
	public Home() {
		super("PayReg: Home");
		setPreferredSize(new Dimension(250, 330));
		setMinimumSize(new Dimension(250, 330));
		setMaximumSize(new Dimension(250, 330));
		setBounds(100, 100, 250, 330);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		JButton btnNewEvent = new JButton("Nuevo Evento");
		btnNewEvent.setBounds(45, 120, 160, 20);
		btnNewEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Home.super.getContentPane().setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NewEventFrame window = new NewEventFrame();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		contentPane.add(btnNewEvent);
		
		
		
		JButton btnManageEvent = new JButton("Administrar Evento...");
		btnManageEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnManageEvent.setBounds(45, 148, 160, 23);
		contentPane.add(btnManageEvent);
		
		JButton btnDeleteEvent = new JButton("Eliminar Evento...");
		btnDeleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDeleteEvent.setBounds(45, 220, 160, 20);
		contentPane.add(btnDeleteEvent);
		
		JLabel lblLogInUser = new JLabel("Sesión iniciada como:");
		lblLogInUser.setBounds(10, 11, 153, 14);
		contentPane.add(lblLogInUser);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(140, 11, 46, 14);
		contentPane.add(lblUser);
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ btnNewEvent, btnManageEvent, btnDeleteEvent}));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
