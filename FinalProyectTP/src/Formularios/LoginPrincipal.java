package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;

import Hilo.Hilo;

import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class LoginPrincipal extends JFrame{

	private JPanel contentPane;
	private JButton Ingresar;
	private JButton btnSalir;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPrincipal frame = new LoginPrincipal();
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
	public LoginPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPrincipal.class.getResource("/pictures/books-icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 50, 432, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
	
		
		Ingresar = new JButton("Ingresar");
		Ingresar.setBackground(new Color(192, 192, 192));
		Ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ingresarAdmin();
			}
		});
		contentPane.setLayout(null);
		
		Ingresar.setBounds(230, 281, 85, 42);
		contentPane.add(Ingresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(192, 192, 192));
		btnSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent atg0){
				salir();
			}
		});
		btnSalir.setBounds(80, 281, 85, 42);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginPrincipal.class.getResource("/pictures/pexels-photo-264635.jpeg")));
		lblNewLabel.setBounds(0, 0, 416, 335);
		contentPane.add(lblNewLabel);
	}

		protected void salir() {
		System.exit(0);
		
	}

		protected void ingresarAdmin() {
			Login loginAdmin=new Login();
			loginAdmin.setVisible(true);
			this.dispose();	
		
	}
}
