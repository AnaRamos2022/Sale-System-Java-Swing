package menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import arreglos.ArregloClientes;
import arreglos.ArregloProductos;
import arreglos.ArregloVentas;
import clases.Cliente;
import clases.Producto;
import clases.Venta;
import icons.Icons;
import javax.swing.SwingConstants;

public class RegistroVenta extends JInternalFrame implements ActionListener {
	private JPanel panelConsultar;
	private JLabel lblNewLabel;
	private JTextField textCodCliente;
	private JPanel panelConsultar_1;
	private JLabel lblCdigoProducto;
	private JTextField textCodProducto;
	private JPanel panelDatos;
	private JLabel lblNewLabel_1;
	private JTextField textCodCliente1;
	private JLabel lblNombreDelProducto;
	private JTextField textNomCliente;
	private JLabel lblNewLabel_2;
	private JTextField textCodProducto1;
	private JLabel lblNewLabel_3;
	private JTextField textNomProducto;
	private JLabel lblNewLabel_4;
	private JTextField textCantidad;
	private JButton btnGuardar;
	private JLabel lblNewLabel_5;
	private JTextField textPrecio;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel_6;
	private JTextField textCodVenta;
	private JButton btnBuscar;
	private ArregloVentas arregloVentas;
	private ArregloProductos arregloProductos;
	private ArregloClientes arregloClientes;
	private JLabel lblVentas;
	private int stockActual;
	private Producto producto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroVenta frame = new RegistroVenta();
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
	public RegistroVenta() {
		setClosable(true);
		setTitle("Registro de Venta");
		setBounds(10, 10, 560, 669);
		getContentPane().setLayout(null);
		
		panelConsultar = new JPanel();
		panelConsultar.setLayout(null);
		panelConsultar.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Consultar", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		panelConsultar.setBounds(10, 7, 524, 88);
		getContentPane().add(panelConsultar);
		
		lblNewLabel = new JLabel("C\u00F3digo Cliente:");
		lblNewLabel.setBounds(10, 22, 109, 14);
		panelConsultar.add(lblNewLabel);
		
		textCodCliente = new JTextField();
		textCodCliente.setColumns(10);
		textCodCliente.setBounds(140, 20, 96, 20);
		panelConsultar.add(textCodCliente);
		
		lblCdigoProducto = new JLabel("C\u00F3digo Producto:");
		lblCdigoProducto.setBounds(10, 52, 109, 14);
		panelConsultar.add(lblCdigoProducto);
		
		textCodProducto = new JTextField();
		textCodProducto.setColumns(10);
		textCodProducto.setBounds(140, 50, 96, 20);
		panelConsultar.add(textCodProducto);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(398, 21, 99, 23);
		btnBuscar.setIcon(Icons.getIconoBuscar());
		panelConsultar.add(btnBuscar);
		
		panelConsultar_1 = new JPanel();
		panelConsultar_1.setLayout(null);
		panelConsultar_1.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Boleta de Venta", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		panelConsultar_1.setBounds(10, 362, 524, 260);
		getContentPane().add(panelConsultar_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 504, 229);
		panelConsultar_1.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		panelDatos = new JPanel();
		panelDatos.setLayout(null);
		panelDatos.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Detalle de Venta", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		panelDatos.setBounds(10, 108, 524, 241);
		getContentPane().add(panelDatos);
		
		lblNewLabel_1 = new JLabel("C\u00F3digo de Cliente:");
		lblNewLabel_1.setBounds(12, 58, 154, 13);
		panelDatos.add(lblNewLabel_1);
		
		textCodCliente1 = new JTextField();
		textCodCliente1.setEnabled(false);
		textCodCliente1.setColumns(10);
		textCodCliente1.setBounds(176, 58, 169, 19);
		panelDatos.add(textCodCliente1);
		
		lblNombreDelProducto = new JLabel("Nombres y Apellidos:");
		lblNombreDelProducto.setBounds(12, 87, 154, 13);
		panelDatos.add(lblNombreDelProducto);
		
		textNomCliente = new JTextField();
		textNomCliente.setEnabled(false);
		textNomCliente.setColumns(10);
		textNomCliente.setBounds(176, 87, 169, 19);
		panelDatos.add(textNomCliente);
		
		lblNewLabel_2 = new JLabel("C\u00F3digo de Producto:");
		lblNewLabel_2.setBounds(12, 116, 154, 13);
		panelDatos.add(lblNewLabel_2);
		
		textCodProducto1 = new JTextField();
		textCodProducto1.setEnabled(false);
		textCodProducto1.setColumns(10);
		textCodProducto1.setBounds(176, 116, 169, 19);
		panelDatos.add(textCodProducto1);
		
		lblNewLabel_3 = new JLabel("Nombre del producto:");
		lblNewLabel_3.setBounds(12, 149, 154, 13);
		panelDatos.add(lblNewLabel_3);
		
		textNomProducto = new JTextField();
		textNomProducto.setEnabled(false);
		textNomProducto.setColumns(10);
		textNomProducto.setBounds(176, 145, 169, 19);
		panelDatos.add(textNomProducto);
		
		lblNewLabel_4 = new JLabel("Cantidad:");
		lblNewLabel_4.setBounds(12, 209, 154, 13);
		panelDatos.add(lblNewLabel_4);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(176, 209, 169, 19);
		panelDatos.add(textCantidad);
		
		lblNewLabel_5 = new JLabel("Precio:");
		lblNewLabel_5.setBounds(12, 181, 154, 13);
		panelDatos.add(lblNewLabel_5);
		
		textPrecio = new JTextField();
		textPrecio.setEnabled(false);
		textPrecio.setColumns(10);
		textPrecio.setBounds(176, 177, 169, 19);
		panelDatos.add(textPrecio);
		
		lblNewLabel_6 = new JLabel("C\u00F3digo de Venta:");
		lblNewLabel_6.setBounds(12, 26, 154, 13);
		panelDatos.add(lblNewLabel_6);
		
		textCodVenta = new JTextField();
		textCodVenta.setEnabled(false);
		textCodVenta.setColumns(10);
		textCodVenta.setBounds(176, 26, 169, 19);
		panelDatos.add(textCodVenta);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(376, 21, 125, 23);
		btnGuardar.setIcon(Icons.getIconoGuardar());
		panelDatos.add(btnGuardar);
		
		lblVentas = new JLabel("");
		lblVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentas.setBounds(376, 72, 125, 122);
		lblVentas.setIcon(Icons.getIconoVentas());
		panelDatos.add(lblVentas);
		
		this.arregloVentas= new ArregloVentas();
		this.arregloProductos=new ArregloProductos();
		this.arregloClientes=new ArregloClientes();
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		//Para verificar que los códigos de cliente y producto estén ingresados.
		if ((textCodCliente.getText().equals("")) || (textCodProducto.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Ingresar datos de búsqueda");
			return;
		}
		int codCliente = Integer.parseInt(textCodCliente.getText());
		int codProducto = Integer.parseInt(textCodProducto.getText());
		textCodVenta.setText(String.valueOf(arregloVentas.obtenerCodigoCorrelativo()));

		// Buscar código cliente:
		Cliente cliente = arregloClientes.obtenerClienteCodigo(codCliente);
		if (cliente != null) {
			this.textCodCliente1.setText(cliente.getCodigoCliente() + "");
			this.textNomCliente.setText(cliente.getNombres() + " " + cliente.getApellidos());
		} else {
			JOptionPane.showMessageDialog(this,
					"No existe el código de Cliente ingresado. Ingresar el código correcto");
		}

		// Buscar código producto:
		producto = arregloProductos.obtenerProductoCodigo(codProducto);
		if (producto != null) {
			this.textCodProducto1.setText(producto.getCodigoProducto() + "");
			this.textNomProducto.setText(producto.getNombre());
			this.textPrecio.setText(producto.getPrecio() + "");
			stockActual = producto.getStockActual();
		} else {
			JOptionPane.showMessageDialog(this,
					"No existe el código de Producto ingresado. Ingresar el código correcto");
		}
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		if ((textCodCliente1.getText().equals("")) || (textNomCliente.getText().equals(""))
				|| (textCodProducto1.getText().equals("")) || (textNomProducto.getText().equals(""))
				|| (textPrecio.getText().equals("")) || (textCantidad.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Ingresar datos completos");
			return;
		}
		int cantidad = Integer.parseInt(textCantidad.getText());
		if (cantidad > stockActual) {
			JOptionPane.showMessageDialog(this, "La cantidad supera el Stock Actual del producto");
		} else {
			Venta venta = new Venta();
			venta.setPrecio(Double.parseDouble(textPrecio.getText()));
			venta.setCantidad(Integer.parseInt(textCantidad.getText()));
			venta.setCodigoCliente(Integer.parseInt(textCodCliente.getText()));
			venta.setCodigoProducto(Integer.parseInt(textCodProducto.getText()));
			venta.setCodigoVenta(Integer.parseInt(textCodVenta.getText()));
			venta.setFecha(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

			textArea.setText("");
			textArea.append("BOLETA DE VENTA" + "\n");
			textArea.append("====================================================================" + "\n");
			textArea.append("Código de Venta:		" + textCodVenta.getText() + "\n");
			textArea.append("Fecha: 			" + venta.getFecha() + "\n");
			textArea.append("Código de Cliente: 		" + textCodCliente.getText() + "\n");
			textArea.append("Nombres y Apellidos del Cliente: 	" + textNomCliente.getText() + "\n");
			textArea.append("Código de Producto: 		" + textCodProducto.getText() + "\n");
			textArea.append("Nombre de Producto: 		" + textNomProducto.getText() + "\n");
			textArea.append("Cantidad de unidades adquiridas: 	" + textCantidad.getText() + "\n");
			textArea.append("Precio Unitario: 			" + textPrecio.getText() + "\n");
			textArea.append("Importe Subtotal: 		" + venta.obtenerSubTotal() + "\n");
			textArea.append("Importe IGV: 			" + venta.obtenerImporteIGV() + "\n");
			textArea.append("Importe Total: 			" + venta.obtenerImporteTotal() + "\n");
			arregloVentas.adicionarVenta(venta);
			producto.setStockActual(producto.getStockActual() - cantidad);
			arregloProductos.modificarProducto(producto);
		}
	}
}
