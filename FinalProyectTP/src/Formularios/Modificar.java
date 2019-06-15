package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;

import Clases.DbConnection;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class Modificar extends JFrame {
	
private JPanel contentPane;
	
	private JTextField textNombre;
	private JTextField textEditorial;
	private JTextField textAutor;
	private JTextField textPrecio;
	private static DbConnection BD;
	private JTextField textISBN;
	private JTextField textIdeoma;
	private JDateChooser date;
	private JTextField textFieldpages;
	private JComboBox comboBoxMateriales;
	private JComboBox comboBoxEjemplares;
	private JComboBox comboBoxEdition;
	private JComboBox comboBoxEncuader;
	
	private JTextField textFieldCode;
	private JTextField textConuslt;
	String atributo="id_libro";
	PreparedStatement ps;
    ResultSet rs;
    private JTextField textFieldFecha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar frame = new Modificar();
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
	/*
	void llenar(String value) {
		try {
			DbConnection con=new DbConnection();
			String [] titulos= {"Id Libro","Nombre libro","Editorial","Autor","Precio","ISBN","Encuadernación","N° Paginas","Materiales de apoyo","Edición","Ideoma","Ejemplares","date"};
			columns=new DefaultTableModel(null,titulos);
			st=(Statement) con.getConnection().createStatement();
			String datos[]=new String[13];//files to save in the table
			
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
				columns.addRow(datos);
			}
			tableData.setModel(columns);
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}*/
	public Modificar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modificar.class.getResource("/pictures/books-icon.png")));
		BD=new DbConnection();//insttance
		setTitle("Actualizar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNombreDelLibro = new JLabel("Nombre del libro:");
		lblNombreDelLibro.setForeground(new Color(255, 255, 255));
		lblNombreDelLibro.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombreDelLibro.setBounds(10, 97, 169, 20);
		contentPane.add(lblNombreDelLibro);
		
		textNombre = new JTextField();
		textNombre.setBackground(new Color(222, 184, 135));
		textNombre.setBounds(189, 100, 259, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setForeground(new Color(255, 255, 255));
		lblEditorial.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEditorial.setBounds(10, 128, 150, 14);
		contentPane.add(lblEditorial);
		
		textEditorial = new JTextField();
		textEditorial.setBackground(new Color(210, 180, 140));
		textEditorial.setBounds(189, 128, 259, 20);
		contentPane.add(textEditorial);
		textEditorial.setColumns(10);
		
		JLabel lblNEjemplares = new JLabel("N\u00B0 Ejemplares:");
		lblNEjemplares.setForeground(new Color(255, 255, 255));
		lblNEjemplares.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNEjemplares.setBounds(10, 388, 195, 14);
		contentPane.add(lblNEjemplares);
		String[] listEjemplares={" ","1","2","3","4","5","6","7","8","9","10"};
		comboBoxEjemplares = new JComboBox(listEjemplares);
		comboBoxEjemplares.setBackground(new Color(210, 180, 140));
		comboBoxEjemplares.setBounds(189, 377, 259, 20);
		contentPane.add(comboBoxEjemplares);
		
		JLabel lblNombreDelAutor = new JLabel("Nombre del Autor:");
		lblNombreDelAutor.setForeground(new Color(255, 255, 255));
		lblNombreDelAutor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombreDelAutor.setBounds(10, 153, 179, 14);
		contentPane.add(lblNombreDelAutor);
		
		textAutor = new JTextField();
		textAutor.setBackground(new Color(210, 180, 140));
		textAutor.setBounds(189, 153, 259, 20);
		contentPane.add(textAutor);
		textAutor.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(new Color(255, 255, 255));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecio.setBounds(10, 413, 150, 14);
		contentPane.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setBackground(new Color(210, 180, 140));
		textPrecio.setBounds(189, 413, 259, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JButton btnAceptar = new JButton("Actualizar");
		btnAceptar.setBackground(new Color(210, 180, 140));
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	
				//	String query="UPDATE libros SET codigo_barra=?,nombre_libro=?,editorial=?,autor=?,precio=?,ISBN=?,ecuadernacion=?,N_Paginas=?,Materialesdeapoyo=?,edicion=?,ideoma=?,ejemplares_libro=?,date=? WHERE id_libro=?";
				//PreparedStatement statement=(PreparedStatement) BD.getConnection().prepareStatement(query);
					//PreparedStatement statement = (PreparedStatement) BD.getConnection().prepareStatement(query);
					//InsertToDataBase(txtFolio_ID.getText(),textPropietario.getText(),textCP.getText(),textLFDExpedicion.getText(),textKeyVehicular.getText(),textRecaudadora.getText(),textPlacas.getText(),textMarca.getText(),textLSubmarca.getText(),textVersion.getText(),textModelo.getText(),textColor_1.getText(),textColor_2.getText(),textSerie.getText(),textMotor.getText(),textNRPVDOC_REG.getText(),comboBoxMov.getSelectedItem().toString(),comboBoxProce.getSelectedItem().toString(),comboBoxCombus.getSelectedItem().toString(),comboxBoxServi.getSelectedItem().toString(),comboBoxUso.getSelectedItem().toString(),comboBoxClase.getSelectedItem().toString(),comboBoxTipo.getSelectedItem().toString(),comboBoxCilindros.getSelectedItem().toString(),comboBoxPuerta.getSelectedItem().toString(),textPasajKG.getText());
				 
		            java.sql.PreparedStatement statement = BD.getConnection().prepareStatement("UPDATE libros SET codigo_barra=?,nombre_libro=?,editorial=?,autor=?,precio=?,ISBN=?,ecuadernacion=?,N_Paginas=?,Materialesdeapoyo=?,edicion=?,ideoma=?,ejemplares_libro=?,date=? WHERE id_libro='"+textConuslt.getText()+"'");
		           
				statement.setString(1,textFieldCode.getText());	
				statement.setString(2,textNombre.getText());
				statement.setString(3,textEditorial.getText());
				statement.setString(4,textAutor.getText());
				statement.setInt(5, Integer.parseInt(textPrecio.getText()));
				statement.setString(6,textISBN.getText());
				statement.setString(7,comboBoxEncuader.getSelectedItem().toString());
				statement.setString(8,textFieldpages.getText());
				statement.setString(9,comboBoxMateriales.getSelectedItem().toString());
				statement.setInt(10,Integer.parseInt(comboBoxEdition.getSelectedItem().toString()));
				statement.setString(11,textIdeoma.getText());
				statement.setInt(12,Integer.parseInt(comboBoxEjemplares.getSelectedItem().toString()));
				statement.setString(13,textFieldFecha.getText());
				
				statement.executeUpdate();
				BD.desconectar();
				
				JOptionPane.showMessageDialog(null,"Datos correctamente Actualizados");
				textFieldCode.setText("");	
				textNombre.setText("");
				textEditorial.setText("");
				textAutor.setText("");
				textPrecio.setText("");
				textISBN.setText("");
				comboBoxEncuader.setSelectedIndex(0);
				textFieldpages.setText("");
				comboBoxMateriales.setSelectedIndex(0);
				comboBoxEdition.setSelectedIndex(0);
				textIdeoma.setText("");
				comboBoxEjemplares.setSelectedIndex(0);
				textFieldFecha.setText("");
				textConuslt.setText("");
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Datos Incorrectamente Actualizados /o campo no llenado");
					e.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(419, 475, 116, 29);
		contentPane.add(btnAceptar);
		
		textISBN = new JTextField();
		textISBN.setBackground(new Color(210, 180, 140));
		textISBN.setBounds(189, 184, 259, 20);
		contentPane.add(textISBN);
		textISBN.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setForeground(new Color(255, 255, 255));
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIsbn.setBounds(10, 184, 102, 14);
		contentPane.add(lblIsbn);
		
		JLabel lblEncuadernacin = new JLabel("Encuadernaci\u00F3n:");
		lblEncuadernacin.setForeground(new Color(255, 255, 255));
		lblEncuadernacin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEncuadernacin.setBounds(10, 215, 169, 14);
		contentPane.add(lblEncuadernacin);
		String[] listMaterial={" ","Si","No"};
		comboBoxMateriales = new JComboBox(listMaterial);
		comboBoxMateriales.setBackground(new Color(210, 180, 140));
		comboBoxMateriales.setBounds(189, 282, 259, 20);
		contentPane.add(comboBoxMateriales);
		
		JLabel lblMaterialesDeApoyo = new JLabel("Materiales de apoyo:");
		lblMaterialesDeApoyo.setForeground(new Color(255, 255, 255));
		lblMaterialesDeApoyo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMaterialesDeApoyo.setBounds(-1, 279, 190, 20);
		contentPane.add(lblMaterialesDeApoyo);
		String[] edition={" ","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
		comboBoxEdition = new JComboBox(edition);
		comboBoxEdition.setBackground(new Color(210, 180, 140));
		comboBoxEdition.setBounds(189, 317, 259, 20);
		contentPane.add(comboBoxEdition);
		
		JLabel lblEdicin = new JLabel("Edici\u00F2n:");
		lblEdicin.setForeground(new Color(255, 255, 255));
		lblEdicin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEdicin.setBounds(10, 317, 134, 14);
		contentPane.add(lblEdicin);
		
		textIdeoma = new JTextField();
		textIdeoma.setBackground(new Color(210, 180, 140));
		textIdeoma.setBounds(189, 346, 259, 20);
		contentPane.add(textIdeoma);
		textIdeoma.setColumns(10);
		
		JLabel lblIdeoma = new JLabel("Ideoma:");
		lblIdeoma.setForeground(new Color(255, 255, 255));
		lblIdeoma.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIdeoma.setBounds(10, 354, 134, 14);
		contentPane.add(lblIdeoma);
		
		JLabel lblNPaginas = new JLabel("N\u00AA Paginas:");
		lblNPaginas.setForeground(new Color(255, 255, 255));
		lblNPaginas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNPaginas.setBounds(10, 251, 150, 14);
		contentPane.add(lblNPaginas);
		
		JLabel LabelDate = new JLabel("Fecha:");
		LabelDate.setForeground(new Color(255, 255, 255));
		LabelDate.setFont(new Font("Tahoma", Font.BOLD, 17));
		LabelDate.setBounds(10, 71, 91, 20);
		contentPane.add(LabelDate);
		
		textFieldpages = new JTextField();
		textFieldpages.setBackground(new Color(210, 180, 140));
		textFieldpages.setBounds(189, 251, 259, 20);
		contentPane.add(textFieldpages);
		textFieldpages.setColumns(10);
		
		String[] list={" ","Rsutica","No","Otr(a)"};
		comboBoxEncuader = new JComboBox(list);
		comboBoxEncuader.setBackground(new Color(210, 180, 140));
		comboBoxEncuader.setBounds(189, 215, 259, 20);
		contentPane.add(comboBoxEncuader);
		
		JLabel lblCodigoDeBarras = new JLabel("Codigo de Barras:");
		lblCodigoDeBarras.setForeground(new Color(255, 255, 255));
		lblCodigoDeBarras.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCodigoDeBarras.setBounds(10, 445, 169, 20);
		contentPane.add(lblCodigoDeBarras);
		
		textFieldCode = new JTextField();
		textFieldCode.setBackground(new Color(210, 180, 140));
		textFieldCode.setBounds(189, 444, 259, 20);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		ButtonGroup grupo = new ButtonGroup();
		///agregarComo();
		JLabel lblConsultarPor = new JLabel("Consultar:");
		lblConsultarPor.setForeground(new Color(255, 255, 255));
		lblConsultarPor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblConsultarPor.setBounds(10, 41, 134, 19);
		contentPane.add(lblConsultarPor);
		
		textConuslt = new JTextField();
		textConuslt.setBackground(new Color(210, 180, 140));
		textConuslt.setBounds(186, 37, 262, 20);
		contentPane.add(textConuslt);
		textConuslt.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(210, 180, 140));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {	
					 Statement stmt=(Statement) BD.getConnection().createStatement();
					 ResultSet registro=stmt.executeQuery("SELECT codigo_barra,nombre_libro,editorial,autor,precio,ISBN,ecuadernacion,N_Paginas,Materialesdeapoyo,edicion,ideoma,ejemplares_libro,date FROM libros WHERE id_libro='"+textConuslt.getText()+"'");
					if(registro.next()==true){
						
						
						textFieldCode.setText(registro.getString("codigo_barra"));	
						textNombre.setText(registro.getString("nombre_libro"));
						textEditorial.setText(registro.getString("editorial"));
						textAutor.setText(registro.getString("autor"));
						textPrecio.setText(registro.getString("precio"));
						textISBN.setText(registro.getString("ISBN"));
						comboBoxEncuader.setSelectedItem(registro.getString("ecuadernacion"));
						textFieldpages.setText(registro.getString("N_paginas"));
						comboBoxMateriales.setSelectedItem(registro.getString("Materialesdeapoyo"));
						comboBoxEdition.setSelectedItem(registro.getString("edicion"));
						textIdeoma.setText(registro.getString("ideoma"));
						comboBoxEjemplares.setSelectedItem(registro.getString("ejemplares_libro"));
				
						textFieldFecha.setText(registro.getString("date"));
						//registro.setString(13,date);
						
					}else{
						JOptionPane.showMessageDialog(null,"NO existe el Folio ingresado");
						
					}
					
					
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Datos almacenados Incorrectamente /o campo no llenado");
						e1.printStackTrace();
					}		
			}			
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBuscar.setBounds(464, 33, 89, 23);
		contentPane.add(btnBuscar);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBackground(new Color(210, 180, 140));
		textFieldFecha.setBounds(189, 74, 259, 20);
		contentPane.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Modificar.class.getResource("/pictures/background.jpg")));
		lblNewLabel.setBounds(-1, 0, 449, 300);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Modificar.class.getResource("/pictures/background.jpg")));
		label.setBounds(111, 0, 449, 300);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Modificar.class.getResource("/pictures/background.jpg")));
		label_1.setBounds(-1, 240, 449, 300);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Modificar.class.getResource("/pictures/background.jpg")));
		label_2.setBounds(111, 240, 449, 300);
		contentPane.add(label_2);
	
	
	
	}
}