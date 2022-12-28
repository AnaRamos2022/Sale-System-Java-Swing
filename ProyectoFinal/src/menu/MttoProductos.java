package menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloProductos;
import clases.Producto;
import icons.Icons;
import javax.swing.SwingConstants;

public class MttoProductos extends JInternalFrame implements ActionListener {
	private JPanel panelConsultar;
	private JButton btnIngreso;
	private JButton btnModificacion;
	private JButton btnEliminacion;
	private JPanel panelListado;
	private JScrollPane scrollPane;
	private JTable tablaProductos;
	private JLabel lblNewLabel;
	private JTextField textCodigo;
	private JButton btnBuscar;
	private JPanel panelDatos;
	private JLabel lblNewLabel_1;
	private JLabel lblPrecio;
	private JTextField textPrecio;
	private JLabel lblNewLabel_2;
	private JTextField textStockActual;
	private JLabel lblNewLabel_3;
	private JTextField textStockMinimo;
	private JLabel lblNewLabel_4;
	private JTextField textStockMaximo;
	private JButton btnGuardar;
	private DefaultTableModel modelo;
	//private ArrayList <Producto> listadoProducto = new ArrayList <Producto> ();
	private ArregloProductos arregloProductos= new ArregloProductos();
	private JTextField textNomProducto;
	private boolean ingresar=false;
	private boolean modificar=false;
	private JLabel lblProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MttoProductos frame = new MttoProductos();
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
	public MttoProductos() {
		setTitle("Mantenimiento | Productos");
		setClosable(true);
		setBounds(10, 10, 560, 638);
		getContentPane().setLayout(null);
		
		panelConsultar = new JPanel();
		panelConsultar.setLayout(null);
		panelConsultar.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Consultar", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		panelConsultar.setBounds(10, 11, 524, 70);
		getContentPane().add(panelConsultar);
		
		lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(10, 29, 55, 14);
		panelConsultar.add(lblNewLabel);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(57, 26, 96, 20);
		panelConsultar.add(textCodigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(398, 21, 99, 23);
		btnBuscar.setIcon(Icons.getIconoBuscar());
		panelConsultar.add(btnBuscar);
		
		btnModificacion = new JButton("Modificaci\u00F3n");
		btnModificacion.addActionListener(this);
		btnModificacion.setBounds(206, 92, 127, 23);
		btnModificacion.setIcon(Icons.getIconoModificar());
		getContentPane().add(btnModificacion);
		
		btnEliminacion = new JButton("Eliminaci\u00F3n");
		btnEliminacion.addActionListener(this);
		btnEliminacion.setBounds(343, 92, 121, 23);
		btnEliminacion.setIcon(Icons.getIconoEliminar());
		getContentPane().add(btnEliminacion);
		
		panelListado = new JPanel();
		panelListado.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Listado", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		panelListado.setBounds(10, 316, 524, 287);
		getContentPane().add(panelListado);
		panelListado.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 504, 251);
		panelListado.add(scrollPane);
		
		tablaProductos = new JTable();
		tablaProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tablaProductos);
		modelo= new DefaultTableModel();
		modelo.addColumn("Cod. Producto");
		modelo.addColumn("Nombre");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock Actual");
		modelo.addColumn("Stock Minimo");
		modelo.addColumn("Stock Maximo");
		tablaProductos.setModel(modelo);
		
		panelDatos = new JPanel();
		panelDatos.setLayout(null);
		panelDatos.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Datos del producto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		panelDatos.setBounds(10, 125, 524, 181);
		getContentPane().add(panelDatos);
		
		lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(20, 26, 99, 13);
		panelDatos.add(lblNewLabel_1);
		
		textNomProducto = new JTextField();
		textNomProducto.setColumns(10);
		textNomProducto.setBounds(129, 20, 227, 19);
		panelDatos.add(textNomProducto);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(20, 55, 99, 13);
		panelDatos.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(129, 49, 227, 19);
		panelDatos.add(textPrecio);
		
		lblNewLabel_2 = new JLabel("Stock Actual:");
		lblNewLabel_2.setBounds(20, 84, 99, 13);
		panelDatos.add(lblNewLabel_2);
		
		textStockActual = new JTextField();
		textStockActual.setColumns(10);
		textStockActual.setBounds(129, 78, 227, 19);
		panelDatos.add(textStockActual);
		
		lblNewLabel_3 = new JLabel("Stock Minimo:");
		lblNewLabel_3.setBounds(20, 113, 99, 13);
		panelDatos.add(lblNewLabel_3);
		
		textStockMinimo = new JTextField();
		textStockMinimo.setColumns(10);
		textStockMinimo.setBounds(129, 107, 227, 19);
		panelDatos.add(textStockMinimo);
		
		lblNewLabel_4 = new JLabel("Stock Maximo:");
		lblNewLabel_4.setBounds(20, 143, 99, 13);
		panelDatos.add(lblNewLabel_4);
		
		textStockMaximo = new JTextField();
		textStockMaximo.setColumns(10);
		textStockMaximo.setBounds(129, 137, 227, 19);
		panelDatos.add(textStockMaximo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(376, 21, 125, 23);
		btnGuardar.setIcon(Icons.getIconoGuardar());
		panelDatos.add(btnGuardar);
		
		lblProducto = new JLabel("");
		lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProducto.setBounds(386, 55, 115, 101);
		lblProducto.setIcon(Icons.getIconoProducto());
		panelDatos.add(lblProducto);

		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.setBounds(96, 91, 103, 23);
		getContentPane().add(btnIngreso);
		btnIngreso.setIcon(Icons.getIconoAdicionar());
		btnIngreso.addActionListener(this);

		habilitarCampos(false);
		listarProducto();
	}
	
	public void  listarProducto() {
		limpiarTabla();
		//Recorrido y creación del ArrayList ListadoProducto
		for (int i=0; i<arregloProductos.getListadoProducto().size(); i++) {
		Producto p = arregloProductos.getListadoProducto().get(i);
			pasarAtabla(p);
		}
	}
	
	public void pasarAtabla (Producto p) {
		Object[] fila = new Object[6];
		fila[0] = p.getCodigoProducto();
		fila[1] = p.getNombre();
		fila[2] = p.getPrecio();
		fila[3] = p.getStockActual();
		fila[4] = p.getStockMinimo();
		fila[5] = p.getStockMaximo();
		modelo.addRow(fila);
	}
	
	public void limpiarTabla() {
		modelo.setRowCount(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminacion) {
			actionPerformedBtnEliminacion(e);
		}
		if (e.getSource() == btnModificacion) {
			actionPerformedBtnModificacion(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnIngreso) {
			actionPerformedBtnIngreso(e);
		}
	}
	protected void actionPerformedBtnIngreso(ActionEvent e) {
		habilitarCampos(true);
		ingresar=true;
		modificar=false;
		this.btnModificacion.setEnabled(false);
		this.btnEliminacion.setEnabled(false);
		
	}
	public void habilitarCampos(boolean valor) {
		textNomProducto.setEnabled(valor);
		textPrecio.setEnabled(valor);
		textStockActual.setEnabled(valor);
		textStockMinimo.setEnabled(valor);
		textStockMaximo.setEnabled(valor);
		btnGuardar.setEnabled(valor);
	}
	
	public void limpiarDatos() {
		textNomProducto.setText("");
		textPrecio.setText("");
		textStockActual.setText("");
		textStockMinimo.setText("");
		textStockMaximo.setText("");
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		//Para verificar que todos los campos estén llenos
		if ((textNomProducto.getText().equals(""))|| (textPrecio.getText().equals(""))|| (textStockActual.getText().equals(""))|| (textStockMinimo.getText().equals("")) || (textStockMaximo.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Ingresar datos completos");
			return;
		}
		if (ingresar == true) {
			Producto productos = new  Producto();
			productos.setCodigoProducto(arregloProductos.obtenerCodigoCorrelativo());
			productos.setNombre(textNomProducto.getText());
			productos.setPrecio(Double.parseDouble(textPrecio.getText()));
			productos.setStockActual(Integer.parseInt(textStockActual.getText()));
			productos.setStockMinimo(Integer.parseInt(textStockMinimo.getText()));
			productos.setStockMaximo(Integer.parseInt(textStockMaximo.getText()));
			arregloProductos.adicionarProducto(productos);
			listarProducto();
			habilitarCampos(false);
			limpiarDatos();
			ingresar = false;
		}
		if (modificar == true) {
			Producto productos = new  Producto();
			int codigoBuscar=Integer.parseInt(textCodigo.getText());
			productos.setCodigoProducto(codigoBuscar);
			productos.setNombre(textNomProducto.getText());
			productos.setPrecio(Double.parseDouble(textPrecio.getText()));
			productos.setStockActual(Integer.parseInt(textStockActual.getText()));
			productos.setStockMinimo(Integer.parseInt(textStockMinimo.getText()));
			productos.setStockMaximo(Integer.parseInt(textStockMaximo.getText()));
			arregloProductos.modificarProducto(productos);
			listarProducto();
			habilitarCampos(false);
			limpiarDatos();
			habilitarCampos(false);
			limpiarDatos();
			modificar= false;
			btnIngreso.setEnabled(true);
			textCodigo.setText("");
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		//Para verificar que se haya ingresado un código de producto
		if ((textCodigo.getText().equals(""))){
			JOptionPane.showMessageDialog(this, "Ingresar código de Producto");
			return;
		}
		int codigoBuscar = Integer.parseInt(textCodigo.getText());
		Producto producto = arregloProductos.obtenerProductoCodigo(codigoBuscar);
		if (producto != null) {
			this.btnIngreso.setEnabled(false);
			this.btnModificacion.setEnabled(true);
			this.btnEliminacion.setEnabled(true);
			this.textNomProducto.setText(producto.getNombre());
			this.textPrecio.setText(producto.getPrecio() + "");
			this.textStockActual.setText(producto.getStockActual() + "");
			this.textStockMinimo.setText(producto.getStockMinimo() + "");
			this.textStockMaximo.setText(producto.getStockMaximo() + "");
		} else {
			JOptionPane.showMessageDialog(this, "No existe el código de Producto ingresado. Ingresar el código correcto");
		}
	}
	protected void actionPerformedBtnModificacion(ActionEvent e) {
		//Para verificar que todos los campos estén llenos
		if ((textNomProducto.getText().equals(""))|| (textPrecio.getText().equals(""))|| (textStockActual.getText().equals(""))|| (textStockMinimo.getText().equals("")) || (textStockMaximo.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Buscar código de Producto");
			return;
		}
		habilitarCampos(true);
		modificar=true;
		}
	protected void actionPerformedBtnEliminacion(ActionEvent e) {
		//Para verificar que todos los campos estén llenos
		if ((textNomProducto.getText().equals(""))|| (textPrecio.getText().equals(""))|| (textStockActual.getText().equals(""))|| (textStockMinimo.getText().equals("")) || (textStockMaximo.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Buscar código de Producto");
			return;
		}
		arregloProductos.eliminarProducto(Integer.parseInt(textCodigo.getText()));
		listarProducto();
		habilitarCampos(false);
		limpiarDatos();
	}
}
