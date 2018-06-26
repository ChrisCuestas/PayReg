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
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblName = new JLabel("Nombre:");
		lblName.setBounds(31, 15, 221, 14);
		frame.getContentPane().add(lblName);
		
		lblCost = new JLabel("Costo:");
		lblCost.setBounds(31, 34, 221, 14);
		frame.getContentPane().add(lblCost);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(100, 15, 86, 14);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldCost = new JTextField();
		textFieldCost.setBounds(100, 34, 46, 14);
		frame.getContentPane().add(textFieldCost);
		textFieldCost.setColumns(5);
		
		btnNewEvent = new JButton("Crear");
		btnNewEvent.setBounds(214, 54, 59, 23);
		btnNewEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//String name = "Conv";
				//int cost = Integer.parseInt("15");
				
				//int id = eventHandler.addNewEvent(name, cost);
			}
		});
		
		frame.getContentPane().add(btnNewEvent);
	}

}
