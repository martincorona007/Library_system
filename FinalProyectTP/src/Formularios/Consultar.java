package Formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.mysql.jdbc.Statement;

import Clases.DbConnection;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class Consultar extends JFrame {
DefaultTableModel columns;
Statement st;
private JPanel contentPane;
	private JRadioButton RBbarra;
	private JRadioButton RBbtnNombre;
	public static JTable tableData;
	
	
	private static DbConnection BD;
	String atributo="id_libro";
	private JButton btnBuscar;
	private JTextField textBuscar;
	private JLabel lblConsultarPor;
	private final JLabel lblNewLabel = new JLabel("New label");
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultar frame = new Consultar();
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
	
	void llenar(String value) {
		try {
			DbConnection con=new DbConnection();
			String [] titulos= {"Id Libro","Codigo Barra","Nombre Libro","Editorial","Autor","Precio","ISBN","Encuader","N° Paginas","Material_apoyo","Edición","Idioma","Ejemplares","Fecha"};
			columns=new DefaultTableModel(null,titulos);
			st=(Statement) con.getConnection().createStatement();
			String datos[]=new String[14];//files to save in the table
			
			String query="";
			if(value.equals("")) {
				query="SElECT * FROM libros ";
			}else {
				query="SElECT * FROM libros WHERE "+atributo+"='"+value+"'";
			}
			
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				datos[0]=rs.getString(1);//data table 1
				datos[1]=rs.getString(2);//********
				datos[2]=rs.getString(3);///******
				datos[3]=rs.getString(4);//*******
				datos[4]=rs.getString(5);
				datos[5]=rs.getString(6);
				datos[6]=rs.getString(7);
				datos[7]=rs.getString(8);
				datos[8]=rs.getString(9);
				datos[9]=rs.getString(10);
				datos[10]=rs.getString(11);
				datos[11]=rs.getString(12);
				datos[12]=rs.getString(13);
				datos[13]=rs.getString(14);
				columns.addRow(datos);
			}
			tableData.setModel(columns);
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}
	public Consultar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Consultar.class.getResource("/pictures/books-icon.png")));
		setTitle("Consultar");
		BD=new DbConnection();//insttance
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1168, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] list={" ","Codigo de barras","Nombre",};
		
		ButtonGroup grupo = new ButtonGroup();//join the radiobuttons
		RBbarra = new JRadioButton("Codigo de barra");
		RBbarra.setBackground(new Color(210, 180, 140));
		RBbarra.setBounds(116, 7, 109, 23);
		contentPane.add(RBbarra);
		
		RBbtnNombre = new JRadioButton("Nombre");
		RBbtnNombre.setBackground(new Color(210, 180, 140));
		RBbtnNombre.setBounds(227, 7, 79, 23);
		contentPane.add(RBbtnNombre);
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(210, 180, 140));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				grupo.add(RBbarra);
				grupo.add(RBbtnNombre);
				if(RBbarra.isSelected()) {atributo="codigo_barra";llenar(textBuscar.getText());}
				else if(RBbtnNombre.isSelected()) {atributo="nombre_libro";llenar(textBuscar.getText());
				}else {
					JOptionPane.showMessageDialog(null,"No se ha seleccionado ninguna opción ");
				}
			
			}
		});
		btnBuscar.setBounds(311, 36, 89, 23);
		contentPane.add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 1113, 295);
		contentPane.add(scrollPane);
		
		tableData = new JTable();
		scrollPane.setViewportView(tableData);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(10, 37, 281, 20);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);
		
		JButton btnMostrarTodosLos = new JButton("Mostrar todos los datos");
		btnMostrarTodosLos.setBackground(new Color(210, 180, 140));
		btnMostrarTodosLos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenar("");
			}
		});
		btnMostrarTodosLos.setBounds(407, 36, 228, 23);
		contentPane.add(btnMostrarTodosLos);
		
		lblConsultarPor = new JLabel("Consultar por:");
		lblConsultarPor.setForeground(new Color(255, 255, 255));
		lblConsultarPor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConsultarPor.setBounds(10, 11, 100, 14);
		contentPane.add(lblConsultarPor);
		lblNewLabel.setIcon(new ImageIcon(Consultar.class.getResource("/pictures/background.jpg")));
		lblNewLabel.setBounds(0, -19, 415, 322);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Consultar.class.getResource("/pictures/background.jpg")));
		lblNewLabel_1.setBounds(0, 407, 417, -114);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Consultar.class.getResource("/pictures/background.jpg")));
		label.setBounds(392, 0, 491, 268);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Consultar.class.getResource("/pictures/background.jpg")));
		label_1.setBounds(882, 0, 270, 268);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Consultar.class.getResource("/pictures/background.jpg")));
		label_2.setBounds(882, 135, 270, 268);
		contentPane.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Consultar.class.getResource("/pictures/background.jpg")));
		label_3.setBounds(392, 135, 491, 268);
		contentPane.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Consultar.class.getResource("/pictures/background.jpg")));
		label_4.setBounds(0, 135, 491, 268);
		contentPane.add(label_4);
		
		
		this.setLocationRelativeTo(null);
		llenar("");
		
		
		}
}
