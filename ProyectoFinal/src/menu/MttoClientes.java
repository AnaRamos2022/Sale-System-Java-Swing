package menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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

import arreglos.ArregloClientes;
import clases.Cliente;
import clases.Producto;
import icons.Icons;
import javax.swing.SwingConstants;

public class MttoClientes extends JInternalFrame implements ActionListener {
	private JButton btnIngreso;
	private JButton btnModificacion;
	private JButton btnEliminacion;
	private JLabel lblNewLabel;
	private JButton btnBuscar;
	private JPanel panelConsultar; 
	private JPanel panelListado;
	private JTextField textCodigo;
	private JScrollPane scrollPane;
	private JTable tablaClientes;
	private JPanel panelDatos;
	private JTextField textNombres;
	private JLabel lblNombres;
	private JLabel lblNewLabel_2;
	private JTextField textDni;
	private JLabel lblNewLabel_3;
	private JTextField textDireccion;
	private JLabel lblNewLabel_4;
	private JTextField textTelefono;
	private JButton btnGuardar;
	private DefaultTableModel modelo;
	//private ArrayList <Cliente> listadoClientes = new ArrayList <Cliente> ();
	private ArregloClientes arregloClientes = new ArregloClientes();
	private JTextField textApellidos;
	private JLabel lblNewLabel_5;
	private boolean ingresar=false;
	private boolean modificar=false;
	private JLabel lblCliente;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MttoClientes frame = new MttoClientes();
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
	public MttoClientes() {
		setClosable(true);
		setTitle("Mantenimiento | Clientes");
		setBounds(10, 10, 560, 638);
		getContentPane().setLayout(null);
		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.addActionListener(this);
		btnIngreso.setBounds(93, 92, 103, 23);
		btnIngreso.setIcon(Icons.getIconoAdicionar());
		getContentPane().add(btnIngreso);
		
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
		
		panelConsultar = new JPanel();
		panelConsultar.setBounds(10, 11, 524, 70);
		getContentPane().add(panelConsultar);
		panelConsultar.setLayout(null);
		panelConsultar.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Consultar", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(398, 21, 99, 23);
		btnBuscar.setIcon(Icons.getIconoBuscar());
		panelConsultar.add(btnBuscar);
		
		lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(10, 34, 55, 14);
		panelConsultar.add(lblNewLabel);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(57, 31, 96, 20);
		panelConsultar.add(textCodigo);
		
		panelListado = new JPanel();
		panelListado.setBounds(10, 312, 524, 287);
		getContentPane().add(panelListado);
		panelListado.setLayout(null);
		panelListado.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Listado", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 504, 255);
		panelListado.add(scrollPane);
		
		tablaClientes = new JTable();
		tablaClientes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tablaClientes);
		modelo= new DefaultTableModel();
		modelo.addColumn("Cod. Cliente");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Dni");
		modelo.addColumn("Dirección");
		modelo.addColumn("Teléfono");
		tablaClientes.setModel(modelo);
		
		panelDatos = new JPanel();
		panelDatos.setLayout(null);
		panelDatos.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Datos del producto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		panelDatos.setBounds(10, 121, 524, 181);
		getContentPane().add(panelDatos);
		
		textNombres = new JTextField();
		textNombres.setColumns(10);
		textNombres.setBounds(129, 20, 227, 19);
		panelDatos.add(textNombres);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(20, 26, 99, 13);
		panelDatos.add(lblNombres);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(129, 49, 227, 19);
		panelDatos.add(textApellidos);
		
		lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setBounds(20, 55, 99, 13);
		panelDatos.add(lblNewLabel_2);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(129, 78, 227, 19);
		panelDatos.add(textDni);
		
		lblNewLabel_3 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_3.setBounds(20, 113, 99, 13);
		panelDatos.add(lblNewLabel_3);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(129, 107, 227, 19);
		panelDatos.add(textDireccion);
		
		lblNewLabel_4 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_4.setBounds(20, 143, 99, 13);
		panelDatos.add(lblNewLabel_4);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(129, 137, 227, 19);
		panelDatos.add(textTelefono);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(376, 21, 125, 23);
		btnGuardar.setIcon(Icons.getIconoGuardar());
		panelDatos.add(btnGuardar);
		
		lblNewLabel_5 = new JLabel("Dni:");
		lblNewLabel_5.setBounds(20, 81, 99, 13);
		panelDatos.add(lblNewLabel_5);
		
		lblCliente = new JLabel("");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setBounds(375, 52, 126, 104);
		lblCliente.setIcon(Icons.getIconoCliente());
		panelDatos.add(lblCliente);

		habilitarCampos(false);
		listarClientes();
	}

	public void  listarClientes() {
		limpiarTabla();
		//Recorrido y creación del ArrayList ListadoProducto
		for (int i=0; i<arregloClientes.tamaño(); i++) {
		Cliente c = arregloClientes.obtenerCliente(i);
			pasarAtabla(c);
		}
	}
	
	public void pasarAtabla (Cliente c) {
		Object[] fila = new Object[6];
		fila[0] = c.getCodigoCliente();
		fila[1] = c.getNombres();
		fila[2] = c.getApellidos();
		fila[3] = c.getDni();
		fila[4] = c.getDireccion();
		fila[5] = c.getTelefono();
		modelo.addRow(fila);
	}
	
	public void limpiarTabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
	}
	public void habilitarCampos(boolean valor) {
		textApellidos.setEnabled(valor);
		textNombres.setEnabled(valor);
		textDni.setEnabled(valor);
		textDireccion.setEnabled(valor);
		textTelefono.setEnabled(valor);
		btnGuardar.setEnabled(valor);
	}
	
	public void limpiarDatos() {
		textApellidos.setText("");
		textNombres.setText("");
		textDni.setText("");
		textDireccion.setText("");
		textTelefono.setText("");
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
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		if ((textNombres.getText().equals(""))|| (textApellidos.getText().equals(""))|| (textDni.getText().equals(""))|| (textDireccion.getText().equals("")) || (textTelefono.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Ingresar datos completos");
			return;
		}
		if (ingresar == true) {
			Cliente c = new Cliente();
			c.setCodigoCliente(arregloClientes.obtenerCodigoCorrelativo());
			c.setNombres(textNombres.getText());
			c.setApellidos(textApellidos.getText());
			c.setDni(textDni.getText());
			c.setDireccion(textDireccion.getText());
			c.setTelefono(textTelefono.getText());
			arregloClientes.adicionarCliente(c);
			listarClientes();
			habilitarCampos(false);
			limpiarDatos();
			ingresar = false;
		}
		if (modificar == true) {
			Cliente c = new Cliente();
			int codigoBuscar=Integer.parseInt(textCodigo.getText());
			c.setCodigoCliente(codigoBuscar);
			c.setNombres(textNombres.getText());
			c.setApellidos(textApellidos.getText());
			c.setDni(textDni.getText());
			c.setDireccion(textDireccion.getText());
			c.setTelefono(textTelefono.getText());
			arregloClientes.modificarCliente(c);
			listarClientes();
			habilitarCampos(false);
			limpiarDatos();
			modificar= false;
			btnIngreso.setEnabled(true);
			textCodigo.setText("");
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		if ((textCodigo.getText().equals(""))){
			JOptionPane.showMessageDialog(this, "Ingresar código de Cliente");
			return;
		}
		int codigoBuscar=Integer.parseInt(textCodigo.getText());
		Cliente cliente=arregloClientes.obtenerClienteCodigo(codigoBuscar);
		if (cliente !=null) {
			this.btnIngreso.setEnabled(false);
			this.btnModificacion.setEnabled(true);
			this.btnEliminacion.setEnabled(true);
			this.textApellidos.setText(cliente.getApellidos());
			this.textDni.setText(cliente.getDni());
			this.textNombres.setText(cliente.getNombres());
			this.textDireccion.setText(cliente.getDireccion());
			this.textTelefono.setText(cliente.getTelefono());
		} else {
			JOptionPane.showMessageDialog(this, "No existe el código de Cliente ingresado. Ingresar el código correcto");
		}
	}

	
	protected void actionPerformedBtnModificacion(ActionEvent e) {
		if ((textNombres.getText().equals(""))|| (textApellidos.getText().equals(""))|| (textDni.getText().equals(""))|| (textDireccion.getText().equals("")) || (textTelefono.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Buscar código de Cliente");
			return;
		}
		habilitarCampos(true);
		modificar=true;
	}
	protected void actionPerformedBtnEliminacion(ActionEvent e) {
		if ((textNombres.getText().equals(""))|| (textApellidos.getText().equals(""))|| (textDni.getText().equals(""))|| (textDireccion.getText().equals("")) || (textTelefono.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Buscar código de Cliente");
			return;
		}
		arregloClientes.eliminarCliente(Integer.parseInt(textCodigo.getText()));
		listarClientes();
		habilitarCampos(false);
		limpiarDatos();
	}
}
