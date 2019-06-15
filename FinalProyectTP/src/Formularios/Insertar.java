package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import Clases.DbConnection;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Insertar extends JFrame {

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
	private JDateChooser dateChooserDate;
	private JComboBox comboBoxEncuader;
	
	private JTextField textFieldCode;
	private JLabel lblNewLabel;
	private final JLabel lblNewLabel_1 = new JLabel("");
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertar frame = new Insertar();
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
	public Insertar() {
		setTitle("Insertar Libro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Insertar.class.getResource("/pictures/books-icon.png")));
		BD=new DbConnection();//insttance
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNombreDelLibro = new JLabel("Nombre del libro:");
		lblNombreDelLibro.setForeground(Color.WHITE);
		lblNombreDelLibro.setBackground(new Color(255, 255, 255));
		lblNombreDelLibro.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombreDelLibro.setBounds(10, 33, 169, 20);
		contentPane.add(lblNombreDelLibro);
		
		textNombre = new JTextField();
		textNombre.setBackground(new Color(210, 180, 140));
		textNombre.setBounds(189, 33, 259, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setForeground(new Color(255, 255, 255));
		lblEditorial.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEditorial.setBounds(10, 64, 150, 14);
		contentPane.add(lblEditorial);
		
		textEditorial = new JTextField();
		textEditorial.setBackground(new Color(210, 180, 140));
		textEditorial.setBounds(189, 64, 259, 20);
		contentPane.add(textEditorial);
		textEditorial.setColumns(10);
		
		JLabel lblNEjemplares = new JLabel("N\u00B0 Ejemplares:");
		lblNEjemplares.setForeground(Color.WHITE);
		lblNEjemplares.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNEjemplares.setBounds(10, 313, 195, 14);
		contentPane.add(lblNEjemplares);
		String[] listEjemplares={" ","1","2","3","4","5","6","7","8","9","10"};
		comboBoxEjemplares = new JComboBox(listEjemplares);
		comboBoxEjemplares.setBackground(new Color(210, 180, 140));
		comboBoxEjemplares.setBounds(189, 313, 259, 20);
		contentPane.add(comboBoxEjemplares);
		
		JLabel lblNombreDelAutor = new JLabel("Nombre del Autor:");
		lblNombreDelAutor.setForeground(Color.WHITE);
		lblNombreDelAutor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombreDelAutor.setBounds(10, 95, 179, 14);
		contentPane.add(lblNombreDelAutor);
		
		textAutor = new JTextField();
		textAutor.setBackground(new Color(210, 180, 140));
		textAutor.setBounds(189, 95, 259, 20);
		contentPane.add(textAutor);
		textAutor.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecio.setBounds(10, 344, 150, 14);
		contentPane.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setBackground(new Color(210, 180, 140));
		textPrecio.setBounds(189, 344, 259, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(210, 180, 140));
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	
					String query="INSERT INTO libros(codigo_barra,nombre_libro,editorial,autor,precio,ISBN,ecuadernacion,N_Paginas,Materialesdeapoyo,edicion,ideoma,ejemplares_libro,date) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement statement=(PreparedStatement) BD.getConnection().prepareStatement(query);
					//PreparedStatement statement = (PreparedStatement) BD.getConnection().prepareStatement(query);
					//InsertToDataBase(txtFolio_ID.getText(),textPropietario.getText(),textCP.getText(),textLFDExpedicion.getText(),textKeyVehicular.getText(),textRecaudadora.getText(),textPlacas.getText(),textMarca.getText(),textLSubmarca.getText(),textVersion.getText(),textModelo.getText(),textColor_1.getText(),textColor_2.getText(),textSerie.getText(),textMotor.getText(),textNRPVDOC_REG.getText(),comboBoxMov.getSelectedItem().toString(),comboBoxProce.getSelectedItem().toString(),comboBoxCombus.getSelectedItem().toString(),comboxBoxServi.getSelectedItem().toString(),comboBoxUso.getSelectedItem().toString(),comboBoxClase.getSelectedItem().toString(),comboBoxTipo.getSelectedItem().toString(),comboBoxCilindros.getSelectedItem().toString(),comboBoxPuerta.getSelectedItem().toString(),textPasajKG.getText());
				
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
				SimpleDateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd"); 
				String date=dFormat.format(dateChooserDate.getDate());
				
				statement.setString(13,date);
				
				statement.executeUpdate();
				BD.desconectar();
				
				JOptionPane.showMessageDialog(null,"Datos almacenados correctamente");
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
		//		SimpleDateFormat dFormat1=new SimpleDateFormat("yyyy-MM-dd"); 
		//		String date1=dFormat.format(dateChooserDate.setDateFormatString(""));
			
				
				
				
					/*Statement stmt=BD.getConnection().createStatement();
				String query="";
					stmt.executeUpdate(query);
					*/
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Datos almacenados incorrectamente /o campo no llenado");
					e.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(413, 409, 116, 29);
		contentPane.add(btnAceptar);
		
		textISBN = new JTextField();
		textISBN.setBackground(new Color(210, 180, 140));
		textISBN.setBounds(189, 126, 259, 20);
		contentPane.add(textISBN);
		textISBN.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setForeground(Color.WHITE);
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIsbn.setBounds(10, 126, 102, 14);
		contentPane.add(lblIsbn);
		
		JLabel lblEncuadernacin = new JLabel("Encuadernaci\u00F3n:");
		lblEncuadernacin.setForeground(Color.WHITE);
		lblEncuadernacin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEncuadernacin.setBounds(10, 157, 169, 14);
		contentPane.add(lblEncuadernacin);
		String[] listMaterial={" ","Si","No"};
		comboBoxMateriales = new JComboBox(listMaterial);
		comboBoxMateriales.setBackground(new Color(210, 180, 140));
		comboBoxMateriales.setBounds(189, 213, 259, 20);
		contentPane.add(comboBoxMateriales);
		
		JLabel lblMaterialesDeApoyo = new JLabel("Materiales de apoyo:");
		lblMaterialesDeApoyo.setForeground(Color.WHITE);
		lblMaterialesDeApoyo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMaterialesDeApoyo.setBounds(-1, 210, 190, 20);
		contentPane.add(lblMaterialesDeApoyo);
		String[] edition={" ","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
		comboBoxEdition = new JComboBox(edition);
		comboBoxEdition.setBackground(new Color(210, 180, 140));
		comboBoxEdition.setBounds(189, 244, 259, 20);
		contentPane.add(comboBoxEdition);
		
		JLabel lblEdicin = new JLabel("Edici\u00F2n:");
		lblEdicin.setForeground(Color.WHITE);
		lblEdicin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEdicin.setBounds(10, 244, 134, 14);
		contentPane.add(lblEdicin);
		
		textIdeoma = new JTextField();
		textIdeoma.setBackground(new Color(210, 180, 140));
		textIdeoma.setBounds(189, 275, 259, 20);
		contentPane.add(textIdeoma);
		textIdeoma.setColumns(10);
		
		JLabel lblIdeoma = new JLabel("Idioma:");
		lblIdeoma.setForeground(Color.WHITE);
		lblIdeoma.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIdeoma.setBounds(10, 278, 134, 14);
		contentPane.add(lblIdeoma);
		
		JLabel lblNPaginas = new JLabel("N\u00B0 Paginas:");
		lblNPaginas.setForeground(Color.WHITE);
		lblNPaginas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNPaginas.setBounds(10, 188, 150, 14);
		contentPane.add(lblNPaginas);
		
		dateChooserDate = new JDateChooser();
		dateChooserDate.setBackground(new Color(210, 180, 140));
		dateChooserDate.setBounds(189, 8, 259, 20);
		contentPane.add(dateChooserDate);
		
		JLabel LabelDate = new JLabel("Fecha:");
		LabelDate.setForeground(Color.WHITE);
		LabelDate.setFont(new Font("Tahoma", Font.BOLD, 17));
		LabelDate.setBounds(10, 8, 91, 20);
		contentPane.add(LabelDate);
		
		textFieldpages = new JTextField();
		textFieldpages.setBackground(new Color(210, 180, 140));
		textFieldpages.setBounds(189, 182, 259, 20);
		contentPane.add(textFieldpages);
		textFieldpages.setColumns(10);
		
		String[] list={" ","Rustica","No","Otr(a)"};
		comboBoxEncuader = new JComboBox(list);
		comboBoxEncuader.setBackground(new Color(210, 180, 140));
		comboBoxEncuader.setBounds(189, 157, 259, 20);
		contentPane.add(comboBoxEncuader);
		
		JLabel lblCodigoDeBarras = new JLabel("Codigo de Barras:");
		lblCodigoDeBarras.setForeground(Color.WHITE);
		lblCodigoDeBarras.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCodigoDeBarras.setBounds(10, 375, 169, 20);
		contentPane.add(lblCodigoDeBarras);
		
		textFieldCode = new JTextField();
		textFieldCode.setBackground(new Color(210, 180, 140));
		textFieldCode.setBounds(189, 375, 259, 20);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Insertar.class.getResource("/pictures/background.jpg")));
		lblNewLabel.setBounds(575, 0, -354, 358);
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setIcon(new ImageIcon(Insertar.class.getResource("/pictures/background.jpg")));
		lblNewLabel_1.setBounds(279, 188, 284, 262);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Insertar.class.getResource("/pictures/background.jpg")));
		label.setBounds(0, 200, 312, 250);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Insertar.class.getResource("/pictures/background.jpg")));
		label_1.setBounds(281, 0, 284, 262);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBackground(new Color(210, 180, 140));
		label_2.setIcon(new ImageIcon(Insertar.class.getResource("/pictures/background.jpg")));
		label_2.setBounds(-1, 0, 284, 262);
		contentPane.add(label_2);
	}
}
