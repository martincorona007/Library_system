package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import Clases.DbConnection;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Eliminar extends JFrame {

	private JPanel contentPane;
	private JTextField textDelete;
	private static DbConnection BD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eliminar frame = new Eliminar();
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
	public Eliminar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Eliminar.class.getResource("/pictures/books-icon.png")));
		BD=new DbConnection();//insttance
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 200, 342, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Numero de Folio:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(21, 11, 144, 45);
		contentPane.add(lblNewLabel);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(189, 183, 107));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Statement stmt = (Statement) BD.getConnection().createStatement();
					//Statement stmt2 = (Statement) BD.getConnection().createStatement();
					stmt.execute("DELETE FROM libros WHERE id_libro="+textDelete.getText());
					//stmt2.execute("INSERT INTO libros_vendidos WHERE id_librovendido="+textDelete.getText());
					
					JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente");
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"No ha eliminado correctamente");
					e.printStackTrace();
				}
				 
			}
		});
		
		btnAceptar.setBounds(198, 81, 110, 45);
		contentPane.add(btnAceptar);
		
		textDelete = new JTextField();
		textDelete.setBounds(127, 11, 184, 45);
		contentPane.add(textDelete);
		textDelete.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Eliminar.class.getResource("/pictures/background.jpg")));
		lblNewLabel_1.setBounds(0, 0, 326, 150);
		contentPane.add(lblNewLabel_1);
	}
	protected void dispo(){
		Menu k=new Menu();
		k.setVisible(true);
		this.dispose();
	}
}
