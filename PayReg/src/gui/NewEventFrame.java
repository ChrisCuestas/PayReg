package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import finance.EventHandler;

import javax.swing.JTextField;
import javax.swing.JButton;

public class NewEventFrame  {
	
	JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldCost;
	private JLabel lblCost;
	private JLabel lblName;
	private JButton btnNewEvent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
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

	/**
	 * Create the application.
	 */
	public NewEventFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 299, 123);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		lblName = new JLabel("Nombre:");
		springLayout.putConstraint(SpringLayout.WEST, lblName, 31, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblName, -31, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblName, 15, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(lblName);
		
		lblCost = new JLabel("Costo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCost, 5, SpringLayout.SOUTH, lblName);
		springLayout.putConstraint(SpringLayout.WEST, lblCost, 0, SpringLayout.WEST, lblName);
		springLayout.putConstraint(SpringLayout.EAST, lblCost, 0, SpringLayout.EAST, lblName);
		frame.getContentPane().add(lblCost);
		
		textFieldName = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textFieldName, 100, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textFieldName, 0, SpringLayout.NORTH, lblName);
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldName, 0, SpringLayout.SOUTH, lblName);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldCost = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textFieldCost, 100, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textFieldCost, 0, SpringLayout.NORTH, lblCost);
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldCost, 0, SpringLayout.SOUTH, lblCost);
		frame.getContentPane().add(textFieldCost);
		textFieldCost.setColumns(5);
		
		btnNewEvent = new JButton("Crear");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewEvent, 6, SpringLayout.SOUTH, lblCost);
		springLayout.putConstraint(SpringLayout.EAST, btnNewEvent, -10, SpringLayout.EAST, frame.getContentPane());
		btnNewEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = "Conv";
				int cost = Integer.parseInt("15");
				
				int id = eventHandler.addNewEvent(name, cost);
			}
		});
		
		frame.getContentPane().add(btnNewEvent);
	}

}
