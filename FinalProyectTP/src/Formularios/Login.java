package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Clases.DbConnection;
import Hilo.Hilo;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private static JTextField txtAdmin;
	private static JPasswordField txtpasswordAdmin;
	public static JProgressBar progressBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/pictures/Document-write-icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 50, 832, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel labelLoginAdmin = new JLabel("");
		
		labelLoginAdmin.setBounds(199, 11, 356, 113);
		contentPane.add(labelLoginAdmin);
		
		txtAdmin = new JTextField();
		txtAdmin.setBackground(new Color(222, 184, 135));
		txtAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAdmin.setBounds(317, 333, 423, 47);
		contentPane.add(txtAdmin);
		txtAdmin.setColumns(10);
		
		txtpasswordAdmin = new JPasswordField();
		txtpasswordAdmin.setBackground(new Color(222, 184, 135));
		txtpasswordAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpasswordAdmin.setBounds(317, 403, 423, 47);
		contentPane.add(txtpasswordAdmin);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(222, 184, 135));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					ingresar();
				
			}
		});
		btnAceptar.setBounds(618, 472, 153, 37);
		contentPane.add(btnAceptar);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				cargar();
			}
		});
		progressBar.setBounds(76, 252, 710, 31);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/pictures/login.JPG")));
		lblNewLabel.setBounds(0, 0, 816, 522);
		contentPane.add(lblNewLabel);
		
		
	}

	protected void cargar() {
		if(progressBar.getValue()==100) {
			Menu login=new Menu();
			login.setVisible(true);
			this.dispose();	
		}
		
	}

	protected void ingresar() {
		
		try{
			if(txtAdmin.getText().length()>0 && txtpasswordAdmin.getPassword().length>0 ){
				
				if(checkUser(txtAdmin.getText(),txtpasswordAdmin.getPassword())){
					
					Hilo barra=new Hilo();	
					barra.start();
					
					
				}else{
					JOptionPane.showMessageDialog(null, "El nombre de usuario y/o contrasenia no son validos.");
                    JOptionPane.showMessageDialog(null, txtAdmin.getText()+" " +txtpasswordAdmin.getPassword() );
                    txtAdmin.setText("");    //limpiar campos
                    txtpasswordAdmin.setText("");        
                     
                    txtAdmin.requestFocusInWindow();
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe escribir nombre de usuario y contrasenia.\n" +"NO puede dejar ningun campo vacio");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}
	boolean checkUser(String User,char[] cs){
		try{
			DbConnection con=new DbConnection();//database
			String admin=Login.txtAdmin.getText();
			String contra=String.valueOf(Login.txtpasswordAdmin.getPassword());
			
			//int resultado=0;
			String SSQL="SELECT * FROM administrador WHERE nombre='"+admin+"' AND password='"+contra+"'";
			// Statement stmt=connection.createStatement();
			 Statement stmt=con.getConnection().createStatement();  
			 ResultSet rs=stmt.executeQuery(SSQL);
			   
			
	            if( rs.first() )        // si es valido el primer reg. hay una fila, tons el usuario y su pw existen
	                return true;        //usuario validado correctamente
	            else
	                return false; 
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
