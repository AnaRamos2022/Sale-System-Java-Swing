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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import arreglos.ArregloProductos;
import clases.Producto;
import icons.Icons;
import javax.swing.SwingConstants;

public class ActualizarAlmacen extends JInternalFrame implements ActionListener {
	private JPanel panelConsultar;
	private JLabel lblNewLabel;
	private JTextField textCodigo;
	private JButton btnBuscar;
	private JPanel panelCantidad;
	private JButton btnGuardar;
	private JLabel lblCantidadUnidades_1;
	private JTextField textCantidad;
	private JPanel panelDatos;
	private JLabel lblNewLabel_1;
	private JTextField textNomProducto;
	private JLabel lblPrecio;
	private JTextField textPrecio;
	private JLabel lblNewLabel_2;
	private JTextField textStockActual;
	private JLabel lblNewLabel_3;
	private JTextField textStockMinimo;
	private JLabel lblNewLabel_4;
	private JTextField textStockMaximo;
	private ArregloProductos arregloProductos= new ArregloProductos();
	private JLabel lblAlmacen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarAlmacen frame = new ActualizarAlmacen();
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
	public ActualizarAlmacen() {
		setClosable(true);
		setTitle("Actualizar Almacen");
		setBounds(10, 10, 560, 500);
		getContentPane().setLayout(null);
		
		panelConsultar = new JPanel();
		panelConsultar.setLayout(null);
		panelConsultar.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Consultar", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		panelConsultar.setBounds(10, 10, 524, 70);
		getContentPane().add(panelConsultar);
		
		lblNewLabel = new JLabel("C\u00F3digo de Producto:");
		lblNewLabel.setBounds(10, 29, 117, 14);
		panelConsultar.add(lblNewLabel);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(160, 27, 96, 20);
		panelConsultar.add(textCodigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(398, 21, 99, 23);
		btnBuscar.setIcon(Icons.getIconoBuscar());
		panelConsultar.add(btnBuscar);
		
		panelCantidad = new JPanel();
		panelCantidad.setLayout(null);
		panelCantidad.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Cantidad de Unidades a Ingresar", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		panelCantidad.setBounds(10, 115, 524, 70);
		getContentPane().add(panelCantidad);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(376, 21, 125, 23);
		btnGuardar.setIcon(Icons.getIconoGuardar());
		panelCantidad.add(btnGuardar);
		
		lblCantidadUnidades_1 = new JLabel("Cantidad Unidades:");
		lblCantidadUnidades_1.setBounds(10, 29, 140, 14);
		panelCantidad.add(lblCantidadUnidades_1);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(160, 27, 96, 20);
		panelCantidad.add(textCantidad);
		
		panelDatos = new JPanel();
		panelDatos.setLayout(null);
		panelDatos.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Datos del producto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLUE));
		panelDatos.setBounds(10, 215, 524, 181);
		getContentPane().add(panelDatos);
		
		lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(20, 26, 99, 13);
		panelDatos.add(lblNewLabel_1);
		
		textNomProducto = new JTextField();
		textNomProducto.setEnabled(false);
		textNomProducto.setColumns(10);
		textNomProducto.setBounds(129, 20, 227, 19);
		panelDatos.add(textNomProducto);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(20, 55, 99, 13);
		panelDatos.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setEnabled(false);
		textPrecio.setColumns(10);
		textPrecio.setBounds(129, 49, 227, 19);
		panelDatos.add(textPrecio);
		
		lblNewLabel_2 = new JLabel("Stock Actual:");
		lblNewLabel_2.setBounds(20, 84, 99, 13);
		panelDatos.add(lblNewLabel_2);
		
		textStockActual = new JTextField();
		textStockActual.setEnabled(false);
		textStockActual.setColumns(10);
		textStockActual.setBounds(129, 78, 227, 19);
		panelDatos.add(textStockActual);
		
		lblNewLabel_3 = new JLabel("Stock Minimo:");
		lblNewLabel_3.setBounds(20, 113, 99, 13);
		panelDatos.add(lblNewLabel_3);
		
		textStockMinimo = new JTextField();
		textStockMinimo.setEnabled(false);
		textStockMinimo.setColumns(10);
		textStockMinimo.setBounds(129, 107, 227, 19);
		panelDatos.add(textStockMinimo);
		
		lblNewLabel_4 = new JLabel("Stock Maximo:");
		lblNewLabel_4.setBounds(20, 143, 99, 13);
		panelDatos.add(lblNewLabel_4);
		
		textStockMaximo = new JTextField();
		textStockMaximo.setEnabled(false);
		textStockMaximo.setColumns(10);
		textStockMaximo.setBounds(129, 137, 227, 19);
		panelDatos.add(textStockMaximo);
		
		lblAlmacen = new JLabel("");
		lblAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlmacen.setBounds(380, 26, 118, 130);
		lblAlmacen.setIcon(Icons.getIconoAlmacen());
		panelDatos.add(lblAlmacen);

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
		if ((textCodigo.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Ingresar código de Producto");
			return;
		}
		int codigoBuscar = Integer.parseInt(textCodigo.getText());
		Producto producto = arregloProductos.obtenerProductoCodigo(codigoBuscar);
		if (producto != null) {
			this.textNomProducto.setText(producto.getNombre());
			this.textPrecio.setText(producto.getPrecio() + "");
			this.textStockActual.setText(producto.getStockActual() + "");
			this.textStockMinimo.setText(producto.getStockMinimo() + "");
			this.textStockMaximo.setText(producto.getStockMaximo() + "");
		} else {
			JOptionPane.showMessageDialog(this, "No existe el código de Producto ingresado. Ingresar el código correcto");
		}
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		if ((textCantidad.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Ingresar cantidad");
			return;
		}
		int cantidadIngreso = Integer.parseInt(textCantidad.getText());
		int codigoBuscar = Integer.parseInt(textCodigo.getText());
		if ((Integer.parseInt(textStockActual.getText()) + cantidadIngreso) <= Integer
				.parseInt(textStockMaximo.getText())) {
			Producto producto = new Producto();
			producto.setCodigoProducto(codigoBuscar);
			producto.setNombre(textNomProducto.getText());
			producto.setPrecio(Double.parseDouble(textPrecio.getText()));
			producto.setStockActual(Integer.parseInt(textStockActual.getText()) + cantidadIngreso);
			producto.setStockMinimo(Integer.parseInt(textStockMinimo.getText()));
			producto.setStockMaximo(Integer.parseInt(textStockMaximo.getText()));
			this.textStockActual.setText(producto.getStockActual() + "");
			arregloProductos.modificarProducto(producto);
		} else {
			JOptionPane.showMessageDialog(this, "El Stock Actual supera al Stock Máximo");
		}
		
	}
}
