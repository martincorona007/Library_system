package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class AboutSoftware extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutSoftware frame = new AboutSoftware();
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
	public AboutSoftware() {
		setTitle("Acerca del Software");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AboutSoftware.class.getResource("/pictures/books-icon.png")));

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSoftwareCreatedBy = new JLabel("Software created by :");
		lblSoftwareCreatedBy.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSoftwareCreatedBy.setBounds(67, 0, 249, 46);
		contentPane.add(lblSoftwareCreatedBy);
		
		JLabel lblAcuaCutioLuis = new JLabel("Acu\u00F1a Cuti\u00F1o Luis Eduardo");
		lblAcuaCutioLuis.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAcuaCutioLuis.setBounds(41, 115, 226, 31);
		contentPane.add(lblAcuaCutioLuis);
		
		JLabel lblCoronaLomeliMartin = new JLabel("Corona Lomeli Martin");
		lblCoronaLomeliMartin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCoronaLomeliMartin.setBounds(78, 156, 200, 31);
		contentPane.add(lblCoronaLomeliMartin);
		
		JLabel lblNewLabel = new JLabel("Delgadillo Sandoval Gilberto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(31, 209, 236, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AboutSoftware.class.getResource("/pictures/pexels-photo-768125.jpeg")));
		lblNewLabel_1.setBounds(0, 0, 434, 262);
		contentPane.add(lblNewLabel_1);
		this.setLocationRelativeTo(null);
	}
}
