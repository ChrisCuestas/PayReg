package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import finance.EventHandler;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Home {

	private EventHandler eventHandler;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Home() {
		this.eventHandler = new EventHandler();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblPayRegTitle = new JLabel("PayReg");
		springLayout.putConstraint(SpringLayout.NORTH, lblPayRegTitle, 37, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPayRegTitle, 244, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPayRegTitle, -222, SpringLayout.EAST, frame.getContentPane());
		lblPayRegTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPayRegTitle.setFont(new Font("Stencil", Font.BOLD, 21));
		frame.getContentPane().add(lblPayRegTitle);
		
		JLabel lblDef = new JLabel("Sistema de registro de aportes");
		springLayout.putConstraint(SpringLayout.NORTH, lblDef, 6, SpringLayout.SOUTH, lblPayRegTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblDef, 208, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblDef, -361, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDef, -187, SpringLayout.EAST, frame.getContentPane());
		lblDef.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(lblDef);
		
		JLabel lblAuthor = new JLabel("Author: Christian Camilo Cuestas");
		springLayout.putConstraint(SpringLayout.WEST, lblAuthor, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAuthor, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAuthor, 198, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblAuthor);
		
		JButton btnNewEvent = new JButton("Nuevo Evento");
		springLayout.putConstraint(SpringLayout.WEST, btnNewEvent, -147, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewEvent, -300, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewEvent, -34, SpringLayout.EAST, frame.getContentPane());
		btnNewEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		frame.getContentPane().add(btnNewEvent);
		
		JButton btnProperties = new JButton("Propiedades...");
		springLayout.putConstraint(SpringLayout.NORTH, btnProperties, 26, SpringLayout.SOUTH, btnNewEvent);
		springLayout.putConstraint(SpringLayout.WEST, btnProperties, 0, SpringLayout.WEST, btnNewEvent);
		springLayout.putConstraint(SpringLayout.EAST, btnProperties, 0, SpringLayout.EAST, btnNewEvent);
		frame.getContentPane().add(btnProperties);
		
		JList<Object> listOfEvents = new JList<Object>();
		listOfEvents.setBorder(new LineBorder(new Color(0, 0, 0)));
		listOfEvents.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, listOfEvents, -52, SpringLayout.NORTH, lblAuthor);
		springLayout.putConstraint(SpringLayout.WEST, listOfEvents, 31, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, listOfEvents, -285, SpringLayout.NORTH, lblAuthor);
		springLayout.putConstraint(SpringLayout.EAST, listOfEvents, 336, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(listOfEvents);
		
		JButton btnManageEvent = new JButton("Administrar...");
		springLayout.putConstraint(SpringLayout.NORTH, btnManageEvent, 23, SpringLayout.SOUTH, btnProperties);
		springLayout.putConstraint(SpringLayout.WEST, btnManageEvent, 0, SpringLayout.WEST, btnNewEvent);
		springLayout.putConstraint(SpringLayout.EAST, btnManageEvent, 0, SpringLayout.EAST, btnNewEvent);
		frame.getContentPane().add(btnManageEvent);
		
		JButton btnEliminar = new JButton("Eliminar...");
		springLayout.putConstraint(SpringLayout.NORTH, btnEliminar, 65, SpringLayout.SOUTH, btnManageEvent);
		springLayout.putConstraint(SpringLayout.WEST, btnEliminar, 0, SpringLayout.WEST, btnNewEvent);
		springLayout.putConstraint(SpringLayout.EAST, btnEliminar, 0, SpringLayout.EAST, btnNewEvent);
		frame.getContentPane().add(btnEliminar);
	}
}
