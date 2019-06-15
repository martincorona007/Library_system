package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.DbConnection;
import Clases.GenerarNumero;
import Clases.OperacionesVenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Ventas extends JFrame {
	DefaultTableModel columns;
	Statement st;
	private JPanel contentPane;
	private static JTextField textFactura;
	private JDateChooser dateChooserDAte;
	public static JTextField textTotalPrecio;
	private JButton btnBuscarArticulo;
	DefaultTableModel m;
	String atributo="id_libro";
	public static JTable tableData;
	private JScrollPane scrollPane;
	private static DbConnection BD;
	DbConnection cn =new  DbConnection();
	Connection con=cn.getConnection();
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
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
	public Ventas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventas.class.getResource("/pictures/books-icon.png")));
		initComponents();
		numeros();
		//llenar("");
		
	}
	
	/*void llenar(String value) {
		try {
			DbConnection con=new DbConnection();
			String [] titulos= {"codigo_barra","Nombre libro","Editorial","Autor","Precio"};
			columns=new DefaultTableModel(null,titulos);
			st=(Statement) con.getConnection().createStatement();
			String datos[]=new String[13];
			
			String query="";
			if(value.equals("")) {
				query="SElECT codigo_barra,nombre_libro,editorial,autor,precio FROM libros ";
			}else {
				query="SElECT codigo_barra,nombre_libro,editorial,autor,precio FROM libros WHERE "+atributo+"='"+value+"'";
			}
			delete and just leave name book and price
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
			
				datos[0]=rs.getString(1);data table 1
				datos[1]=rs.getString(2);
				datos[2]=rs.getString(3);
				datos[3]=rs.getString(4);
				datos[4]=rs.getString(5);
				
			
				columns.addRow(datos);
			}
			tableData.setModel(columns);
		} catch (Exception e) {
			
		e.printStackTrace();
		}
	}
	*/
	
	void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 694);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ButtonGroup grupo = new ButtonGroup();//join the radiobuttons
		
		JLabel lblNFactura = new JLabel("N\u00B0 Factura:");
		lblNFactura.setForeground(new Color(255, 255, 255));
		lblNFactura.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNFactura.setBounds(10, 48, 163, 43);
		contentPane.add(lblNFactura);
		
		textFactura = new JTextField();
		textFactura.setBackground(new Color(210, 180, 140));
		textFactura.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 30));
		textFactura.setBounds(137, 52, 156, 34);
		contentPane.add(textFactura);
		textFactura.setColumns(10);
		this.setLocationRelativeTo(null);
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(new Color(245, 245, 245));
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFecha.setBounds(303, 48, 113, 43);
		contentPane.add(lblFecha);
		
		dateChooserDAte = new JDateChooser();
		dateChooserDAte.setBackground(new Color(210, 180, 140));
		dateChooserDAte.setBounds(380, 48, 163, 34);
		contentPane.add(dateChooserDAte);
		
		JLabel lblTotalPrecio = new JLabel("Total Precio:");
		lblTotalPrecio.setForeground(new Color(255, 255, 255));
		lblTotalPrecio.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblTotalPrecio.setEnabled(true);
		lblTotalPrecio.setBounds(442, 482, 138, 34);
		contentPane.add(lblTotalPrecio);
		
		textTotalPrecio = new JTextField();
		textTotalPrecio.setBackground(new Color(210, 180, 140));
		textTotalPrecio.setBounds(573, 485, 163, 34);
		contentPane.add(textTotalPrecio);
		textTotalPrecio.setColumns(10);
		
		btnBuscarArticulo = new JButton("Buscar ");
		btnBuscarArticulo.setBackground(new Color(210, 180, 140));
		btnBuscarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goToSearchBook();
			/*	grupo.add(RBbarra);
				grupo.add(RBbtnNombre);
				if(RBbarra.isSelected()) {atributo="codigo_barra";llenar(textBuscar.getText());}
				else if(RBbtnNombre.isSelected()) {atributo="nombre_libro";llenar(textBuscar.getText());
				}else {
					JOptionPane.showMessageDialog(null,"No se ha seleccionado ninguna opción ");
				}*/
				
			}
		});
		btnBuscarArticulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarArticulo.setBounds(538, 135, 198, 34);
		contentPane.add(btnBuscarArticulo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 253, 683, 198);
		contentPane.add(scrollPane);
		
		tableData = new JTable();
		tableData.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"codigo_barra","Nombre libro","Editorial","Autor","cantidad","Precio"
			}
		));
		scrollPane.setViewportView(tableData);
		
		JLabel lblBuscarEnEl = new JLabel("Buscar en el almacen de libros");
		lblBuscarEnEl.setForeground(new Color(245, 245, 245));
		lblBuscarEnEl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBuscarEnEl.setBounds(269, 138, 259, 26);
		contentPane.add(lblBuscarEnEl);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBackground(new Color(210, 180, 140));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double total=0.0,precio=0.0,change=0.0,precioactual=0.0;
				int fsel,resp,fil;
				try {
					fsel=tableData.getSelectedRow();
					if(fsel==-1) {
						JOptionPane.showMessageDialog(null,"Debe seleccionar el producto para eliminar", "Advertencia",JOptionPane.WARNING_MESSAGE);
					}else {
						resp=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar el producto","Eliminar",JOptionPane.YES_NO_OPTION);
						if(resp==JOptionPane.YES_OPTION) {
							change=Double.parseDouble(tableData.getValueAt(fsel, 5).toString());
							precioactual=Double.parseDouble(textTotalPrecio.getText())-change;
							total=precioactual;
							textTotalPrecio.setText(""+total);
							m=(DefaultTableModel)tableData.getModel();
							//fil=(int)m.getValueAt(fsel,0);
							m.removeRow(fsel);
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"No se realizo correctamente la eliminacion del producto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(538, 180, 198, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Comprar");
		btnNewButton_1.setBackground(new Color(210, 180, 140));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String code="",cant="",price="",totales="";
				int fact1=0;
				if(tableData.getRowCount()>0) {
					for(int i=0;i<tableData.getRowCount();i++) {
						//statement.setInt(1, Integer.parseInt(textFactura.getText()));
					code=(String) tableData.getValueAt(i, 0);
					cant= (String) tableData.getValueAt(i,4 );
					price=(String) tableData.getValueAt(i,5 );
					
					System.out.println("code: "+code+" cant "+cant+" price "+price);
				}
					try {
						String query="INSERT INTO venta(id_venta,codigo_barralibro,cantidad,precio,fecha_venta,precio_total) values(?,?,?,?,?,?)";
						java.sql.PreparedStatement statement=con.prepareStatement(query);
					//just need keep the data on venta and that's it.
						
						SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy"); 
						String date=dFormat.format(dateChooserDAte.getDate());
						 fact1=Integer.parseInt(textFactura.getText());
						totales=textTotalPrecio.getText();
						statement.setInt(1, fact1);
						statement.setString(2, code);
						statement.setInt(3, Integer.parseInt(cant));
						statement.setString(4,price);
						statement.setString(5,date);
						statement.setString(6,totales);
						statement.executeUpdate();
						
						
						JOptionPane.showMessageDialog(null,"Compra exitosa!!!");
					} catch (Exception e2) {
						e2.printStackTrace();
						System.out.println("yo");
						//e2.getMessage();
					}
				}else {
					JOptionPane.showMessageDialog(null,"la tabla de producto esta vacia");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(573, 573, 163, 34);
		contentPane.add(btnNewButton_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Ventas.class.getResource("/pictures/background.jpg")));
		label.setBounds(1, 352, 415, 316);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Ventas.class.getResource("/pictures/background.jpg")));
		label_1.setBounds(1, 48, 415, 316);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Ventas.class.getResource("/pictures/background.jpg")));
		label_2.setBounds(1, -122, 415, 316);
		contentPane.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Ventas.class.getResource("/pictures/background.jpg")));
		label_3.setBounds(349, -15, 415, 316);
		contentPane.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Ventas.class.getResource("/pictures/background.jpg")));
		label_4.setBounds(394, 293, 415, 316);
		contentPane.add(label_4);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Ventas.class.getResource("/pictures/background.jpg")));
		label_5.setBounds(383, 408, 415, 316);
		contentPane.add(label_5);
		
	}


	protected void goToSearchBook() {
		
		searchBook in=new searchBook();
		in.setVisible(true);
	}
	void numeros()
    {
        
        
        String c="";
        String SQL="select max(id_venta) from venta";
        //String SQL="select count(*) from boleta";
    //String SQL="SELECT MAX(cod_emp) AS cod_emp FROM empleado";
     //String SQL="SELECT @@identity AS ID";
        try {
            Statement st =(Statement) cn.getConnection().createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs.next())
            {              
                 c=rs.getString(1);
            }
            if(c==null){
                textFactura.setText("00000001");
            }
            else{
            int j=Integer.parseInt(c);
            GenerarNumero gen= new GenerarNumero();
            gen.generar(j);
             textFactura.setText(gen.serie());
            }
            
           
      
         
                  
           
           
         
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
}
