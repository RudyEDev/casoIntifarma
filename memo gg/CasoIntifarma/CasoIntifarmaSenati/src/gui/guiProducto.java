package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;

import entidad.Producto;
import operaciones.LsProducto;

import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class guiProducto extends JInternalFrame {
	
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JTable table;
	private JTextField txtCantidad;
	private JPanel panel;
	
	private JLabel lblCodigo;
	private JLabel lblProducto;
	private JLabel lblTipo;
	private JLabel lblStock;
	private JLabel lblPrecio;
	private JComboBox comboBoxTipo;
	
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnConsultar;
	private JButton btnCerrar;
	private JLabel lblCantidad;
	private JButton btnQuitar;
	private JScrollPane scrollPane;
	
	DefaultTableModel mimodelo;
	public static String pro;
	
	LsProducto ldProd = new LsProducto();
	
		
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//guiProducto frame = new guiProducto();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guiProducto() {
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosed(InternalFrameEvent e) {
				pro = null;
			}
		});
		pro = "pro";
		setTitle("Mantenimiento del Producto");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 399);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 139)), "Registro de producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(10, 11, 256, 179);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(21, 28, 46, 14);
		panel.add(lblCodigo);
		
		lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(21, 56, 66, 14);
		panel.add(lblProducto);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(21, 81, 66, 14);
		panel.add(lblTipo);
		
		lblStock = new JLabel("Stock:");
		lblStock.setBounds(21, 106, 66, 14);
		panel.add(lblStock);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(21, 131, 66, 14);
		panel.add(lblPrecio);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(77, 25, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtProducto = new JTextField();
		txtProducto.setColumns(10);
		txtProducto.setBounds(77, 53, 86, 20);
		panel.add(txtProducto);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(77, 106, 86, 20);
		panel.add(txtStock);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(77, 131, 86, 20);
		panel.add(txtPrecio);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Limpieza ", "Orgánicos", "Cosméticos"}));
		comboBoxTipo.setBounds(77, 77, 86, 22);
		panel.add(comboBoxTipo);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarProducto();
			}
		});
		btnNuevo.setBounds(305, 32, 89, 23);
		getContentPane().add(btnNuevo);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(305, 66, 89, 23);
		getContentPane().add(btnEditar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(305, 100, 89, 23);
		getContentPane().add(btnConsultar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				pro = null;
			}
		});
		btnCerrar.setBounds(305, 134, 89, 23);
		getContentPane().add(btnCerrar);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(117, 341, 59, 14);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setEnabled(false);
		txtCantidad.setEditable(false);
		txtCantidad.setBounds(180, 338, 86, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnQuitar = new JButton("");
		btnQuitar.setIcon(new ImageIcon(guiProducto.class.getResource("/imagenes/WhatsApp Image 2023-03-14 at 10.56.09 AM (2).jpeg")));
		btnQuitar.setBounds(276, 202, 36, 35);
		getContentPane().add(btnQuitar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 201, 256, 125);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		//scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		crearEncabezado();
		

	}
	
	void crearEncabezado() {
		
		mimodelo = new DefaultTableModel();
		
		mimodelo.addColumn("Código");
		mimodelo.addColumn("Descripción");
		mimodelo.addColumn("Tipo");
		mimodelo.addColumn("Stock");
		mimodelo.addColumn("Precio");
		
		table.setModel(mimodelo);
		
	}
	
	void listarProducto() {
		mimodelo.setRowCount(0);
		
		for(int i=0; i<ldProd.tamanio(); i++) {
			
			Object objdatos[] = {
					
							ldProd.obtenerProductoXindice(i).getCodigo(),
							ldProd.obtenerProductoXindice(i).getDescripcion(),
							ldProd.obtenerProductoXindice(i).getPrecio(),
							ldProd.obtenerProductoXindice(i).getTipo(),
							ldProd.obtenerProductoXindice(i).getStock(),
				};
			mimodelo.addRow(objdatos);
		}
	}
	
	void adicionarProducto() {
		
		Producto p = ldProd.buscarProductoXcodigo(obtenerCodigo());
		
		if(p==null) {
			
			p = new Producto(obtenerCodigo(), obtenerDescripcion(), obtenerPrecio(), obtenerStock(), obtenerTipo());
			ldProd.adicionar(p);
			listarProducto();
			JOptionPane.showMessageDialog(null, "Registrado Correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Este Codigo Ya Existe");
		}
	}
	
	String obtenerCodigo() {
		return txtCodigo.getText();		
		
	}
	
	String obtenerDescripcion() {
		return txtProducto.getText();	
		
	}
	
	double obtenerPrecio() {
		return Double.parseDouble(txtPrecio.getText());		
		
	}
	
	String obtenerTipo() {
		return (String)comboBoxTipo.getSelectedItem();	
		
	}
	
	int obtenerStock() {
		return Integer.parseInt(txtStock.getText());
	}
}
