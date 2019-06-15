
package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
///
import java.awt.Graphics;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicDesktopPaneUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class Menu extends JFrame {

	private JPanel contentPane;
	public static JMenuBar menuBar;
	public static JMenu MenuVentas;
	private static JMenu RegistrarLibro;
	public static JMenu	ActualizarLibro;
	public static JMenu Consultar;
	public static JMenu Acercade;
	public static JMenu Salir;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/pictures/books-icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450,200, 840, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		/*JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnInsertar.setBounds(33, 262, 89, 40);
		contentPane.add(btnInsertar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		btnModificar.setBounds(168, 262, 89, 40);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(299, 262, 89, 40);
		contentPane.add(btnEliminar);
		*/
		initComponents();
		
		
	}
	private void initComponents() {
		menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		
		menuBar.setBackground(Color.WHITE);
        menuBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuBar.setToolTipText("");
        menuBar.setAlignmentX(0.2F);
        menuBar.setAlignmentY(0.2F);
        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuBar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuBar.setOpaque(true);
        menuBar.setBounds(0, 0, 894, 78);
		contentPane.add(menuBar);
		
	    MenuVentas = new JMenu();
	    MenuVentas.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		sales();
	    	}
	    });
	    MenuVentas.setBackground(Color.GRAY);
        MenuVentas.setForeground(new java.awt.Color(245, 245, 245));
        MenuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Sale-icon.png"))); // NOI18N
        MenuVentas.setText("Vender");
        MenuVentas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        MenuVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuVentas.setOpaque(true);
        menuBar.add(MenuVentas);
        
        
        RegistrarLibro = new JMenu();
        RegistrarLibro.setEnabled(false);
        RegistrarLibro.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Insert();
        	}
        });
        RegistrarLibro.setBackground(Color.GRAY);
        RegistrarLibro.setForeground(new java.awt.Color(245, 245, 245));
        RegistrarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Document-write-icon.png"))); // NOI18N
        RegistrarLibro.setText("Registrar libro");
        RegistrarLibro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        RegistrarLibro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegistrarLibro.setOpaque(true);
     
        menuBar.add(RegistrarLibro);
        
        ActualizarLibro = new JMenu();
        ActualizarLibro.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		modificar();
        	}
        });
        ActualizarLibro.setBackground(Color.GRAY);
        ActualizarLibro.setForeground(new java.awt.Color(245, 245, 245));
        ActualizarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Download-Database-icon.png"))); // NOI18N
        ActualizarLibro.setText("Actualizar libro");
        ActualizarLibro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ActualizarLibro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ActualizarLibro.setOpaque(true);
        menuBar.add(ActualizarLibro);
        
        Consultar = new JMenu();
        Consultar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		consult();
        	}
        });
       
        Consultar.setBackground(Color.GRAY);
        Consultar.setForeground(new java.awt.Color(245, 245, 245));
        Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/picture-search-icon.png"))); // NOI18N
        Consultar.setText("Consultar");
        Consultar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Consultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Consultar.setOpaque(true);
        menuBar.add(Consultar);
       
        Salir = new JMenu();
        Salir.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		goOut();
        	}
        });
       
        Salir.setBackground(Color.GRAY);
        Salir.setForeground(new java.awt.Color(245, 245, 245));
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/application-arrow-right-icon.png"))); // NOI18N
        Salir.setText("Salir");
        Salir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Salir.setOpaque(true);
        menuBar.add(Salir);
        
        Acercade = new JMenu();
        Acercade.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		about();
        	}
        });
       
        Acercade.setBackground(Color.GRAY);
        Acercade.setForeground(new java.awt.Color(245, 245, 245));
        Acercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/profile-icon.png"))); // NOI18N
        Acercade.setText("About Software");
        Acercade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Acercade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Acercade.setOpaque(true);
        menuBar.add(Acercade);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/pictures/pexels-photo-256541.jpeg")));
        lblNewLabel.setBounds(0, 0, 824, 599);
        contentPane.add(lblNewLabel);
	}
	protected void about() {
		AboutSoftware de=new AboutSoftware();
		//de.setVisible(true);
		////this.dispose();
        de.setVisible(true);
        
		
	}

	protected void eliminar() {
		// TODO Auto-generated method stub
		Eliminar de=new Eliminar();
		de.setVisible(true);
		//this.dispose();
	}

	protected void modificar() {
		// TODO Auto-generated method stub
		Modificar mo=new Modificar();
		mo.setVisible(true);
	//	this.dispose();
	}
	private void Insert(){
		// TODO Auto-generated method stub
		  Insertar in=new Insertar();
		 //   this.setLocationRelativeTo(null);
	      //  in.toFront();
	        in.setVisible(true);
	      //  this.setExtendedState(MAXIMIZED_BOTH);
	}
	protected void sales(){
		// TODO Auto-generated method stub
		Ventas in=new Ventas();
		in.setVisible(true);
		//this.dispose();
	}
	protected void consult(){
		// TODO Auto-generated method stub
		Consultar in=new Consultar();
		in.setVisible(true);
		//this.dispose();
	}
	protected void goOut() {
		System.exit(0);
		
	}
}
