package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import finance.EventHandler;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Home extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
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
		super("PAYREG");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 567, 494);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblPayRegTitle = new JLabel("PayReg");
		lblPayRegTitle.setBounds(244, 37, 85, 22);
		lblPayRegTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPayRegTitle.setFont(new Font("Stencil", Font.BOLD, 21));
		this.getContentPane().add(lblPayRegTitle);
		
		JLabel lblDef = new JLabel("Sistema de registro de aportes");
		lblDef.setBounds(208, 65, 156, 30);
		lblDef.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.getContentPane().add(lblDef);
		
		JLabel lblAuthor = new JLabel("Author: Christian Camilo Cuestas");
		lblAuthor.setBounds(10, 432, 188, 14);
		this.getContentPane().add(lblAuthor);
		
		JButton btnNewEvent = new JButton("Nuevo Evento");
		btnNewEvent.setBounds(404, 133, 113, 23);
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
		this.getContentPane().add(btnNewEvent);
		
		JButton btnProperties = new JButton("Propiedades...");
		btnProperties.setBounds(404, 182, 113, 23);
		this.getContentPane().add(btnProperties);
		
		JList<Object> listOfEvents = new JList<Object>();
		listOfEvents.setBounds(31, 380, 305, -233);
		listOfEvents.setBorder(new LineBorder(new Color(0, 0, 0)));
		listOfEvents.setBackground(Color.WHITE);
		this.getContentPane().add(listOfEvents);
		
		JButton btnManageEvent = new JButton("Administrar...");
		btnManageEvent.setBounds(404, 228, 113, 23);
		this.getContentPane().add(btnManageEvent);
		
		JButton btnEliminar = new JButton("Eliminar...");
		btnEliminar.setBounds(404, 316, 113, 23);
		this.getContentPane().add(btnEliminar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
