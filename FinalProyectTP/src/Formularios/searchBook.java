package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import Formularios.Ventas;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;
import Formularios.Ventas;
import Clases.DbConnection;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class searchBook extends JFrame {

	private JPanel contentPane;
		DefaultTableModel columns;
		Statement st;
		private JRadioButton RBbarra;
		private JRadioButton RBbtnNombre;
		public static JTable tableData2;
		
		///
		DefaultTableModel m;
		public static double total;//total
	
		double sub_total;//sub_subtotal
		double igv;//porciento
		private javax.swing.JDialog jDialog1;
		///NEW
		private static DbConnection BD;
		String atributo="id_libro";
		private JButton btnBuscar;
		private JTextField textBuscar;
		private JScrollPane scrollPane11SEARCH;
		private JTextField textFieldCantidad;
		private JButton btnAgregar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchBook frame = new searchBook();
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
	public searchBook() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(searchBook.class.getResource("/pictures/books-icon.png")));
		jDialog1 = new javax.swing.JDialog();
        

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		//
        total=0;
		sub_total=0.0;
		igv=0.0;
		initComponents();
		///////////
		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(644)
					.addComponent(btnBuscar)
					.addContainerGap(493, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(27)
					.addComponent(btnBuscar)
					.addContainerGap(370, Short.MAX_VALUE))
		);
        getContentPane().setLayout(layout);
	}
	
	void initComponents() {
		///////////////////////////////////////////////////
		setTitle("Productos");
		BD=new DbConnection();//insttance
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1228, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		//////////////////////////////////////////////////Window
		ButtonGroup grupo = new ButtonGroup();//join the radiobuttons
		RBbarra = new JRadioButton("Codigo de barra");
		RBbarra.setBackground(new Color(210, 180, 140));
		RBbarra.setBounds(116, 7, 109, 23);
		contentPane.add(RBbarra);
		
		RBbtnNombre = new JRadioButton("Nombre");
		RBbtnNombre.setBackground(new Color(210, 180, 140));
		RBbtnNombre.setBounds(227, 7, 73, 23);
		contentPane.add(RBbtnNombre);
		
		
		btnBuscar = new JButton("Buscar");
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
		btnBuscar.setBounds(312, 24, 89, 23);
		contentPane.add(btnBuscar);
		
		scrollPane11SEARCH = new JScrollPane();
		scrollPane11SEARCH.setEnabled(false);
		scrollPane11SEARCH.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane11SEARCH.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane11SEARCH.setBounds(10, 68, 1184, 295);
		contentPane.add(scrollPane11SEARCH);
		
		tableData2 = new JTable();
		scrollPane11SEARCH.setViewportView(tableData2);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(10, 37, 281, 20);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);
		
		JButton btnMostrarTodosLos = new JButton("Mostrar todos los datos");
		btnMostrarTodosLos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenar("");
			}
		});
		btnMostrarTodosLos.setBounds(408, 24, 156, 23);
		contentPane.add(btnMostrarTodosLos);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCantidad.setBounds(21, 391, 89, 27);
		contentPane.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(116, 391, 184, 27);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
	//
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fsel=tableData2.getSelectedRow();
				try {
					String codigo,descripcion,precio,cant,importe,Editorial,autor;
					double calcula=0.0,x=0.0,igvs=0.0;
					int canti=0;
					if(fsel==-1) {
						JOptionPane.showMessageDialog(null,"Debe seleccionar un producto","Advertencia",JOptionPane.WARNING_MESSAGE);
					}else {
						//String datos[]=new String[6];
						m=(DefaultTableModel) tableData2.getModel();
						codigo=tableData2.getValueAt(fsel, 0).toString();
						descripcion=tableData2.getValueAt(fsel, 1).toString();
						Editorial=tableData2.getValueAt(fsel, 2).toString();
						autor=tableData2.getValueAt(fsel, 3).toString();
						precio=tableData2.getValueAt(fsel, 4).toString();
						cant=textFieldCantidad.getText();
						//Calculus
						x=(Double.parseDouble(precio)*Integer.parseInt(cant));
						importe=String.valueOf(x);
						
						
						m=(DefaultTableModel)Ventas.tableData.getModel();
						String filaelements[]= {codigo,descripcion,Editorial,autor,cant,precio};
						m.addRow(filaelements);
						calcula=(Double.parseDouble(precio));
						total=total+x;
						//Ventas k=new Ventas();
						Ventas.textTotalPrecio.setText(""+total);
						//k.textTotalPrecio.setText(" "+total);
						
					}
					JOptionPane.showMessageDialog(null,"Producto agregado");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No ha seleccionado un producto", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAgregar.setBounds(327, 396, 89, 23);
		contentPane.add(btnAgregar);
		
		
		this.setLocationRelativeTo(null);
		llenar("");
		
		
	}
	void llenar(String value) {
		try {
			DbConnection con=new DbConnection();
			String [] titulos= {"codigo_barra","Nombre libro","Editorial","Autor","Precio","Ejemplares"};
			columns=new DefaultTableModel(null,titulos);
			st=(Statement) con.getConnection().createStatement();
			String datos[]=new String[13];//files to save in the table
			
			String query="";
			if(value.equals("")) {
				query="SElECT codigo_barra,nombre_libro,editorial,autor,precio,ejemplares_libro FROM libros ";
			}else {
				query="SElECT codigo_barra,nombre_libro,editorial,autor,precio,ejemplares_libro FROM libros WHERE "+atributo+"='"+value+"'";
			}
			
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				datos[0]=rs.getString(1);//data table 1
				datos[1]=rs.getString(2);//********
				datos[2]=rs.getString(3);///******
				datos[3]=rs.getString(4);//*******
				datos[4]=rs.getString(5);
				datos[5]=rs.getString(6);
				
				columns.addRow(datos);
			}
			tableData2.setModel(columns);
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}
	String comparar(int cod){
        String cant="";
        try {
            Statement st = (Statement) BD.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT codigo_barra,nombre_libro,editorial,autor,precio FROM libros WHERE id_libro='"+cod+"'");
            while(rs.next())
            {
                cant=rs.getString(5);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cant;
        
    }
}
