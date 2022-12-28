package menu;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import arreglos.ArregloProductos;
import arreglos.ArregloVentas;

public class ReporteListadoProductosVendidos extends JInternalFrame {
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private ArregloProductos arregloProductos;
	private ArregloVentas arregloVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteListadoProductosVendidos frame = new ReporteListadoProductosVendidos();
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
	public ReporteListadoProductosVendidos() {
		setClosable(true);
		setTitle("Reportes | Listado de Productos Cantidad total vendida");
		setBounds(10, 10, 460, 520);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 468);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		arregloProductos=new ArregloProductos();
		arregloVentas=new ArregloVentas();
		cantidadProductosVendidos();
	}
	
	//Método para conocer la cantidad de productos vendidos por modelo
	public void cantidadProductosVendidos() {
		for (int i = 0; i <arregloProductos.tamaño(); i++) {
			int cantidadTotal=0;
			for (int j=0; j<arregloVentas.tamaño(); j++) {
				if (arregloProductos.obtenerProducto(i).getCodigoProducto()==arregloVentas.obtenerVenta(j).getCodigoProducto()) {
					cantidadTotal=cantidadTotal+arregloVentas.obtenerVenta(j).getCantidad();
				}
			}
			textArea.append("Código Producto:	" + arregloProductos.obtenerProducto(i).getCodigoProducto() + "\n");
			textArea.append("Nombre Producto: 	" + arregloProductos.obtenerProducto(i).getNombre() + "\n");
			textArea.append("Cantidad vendida acumulada:  	" + cantidadTotal + "\n");
			textArea.append("" + "\n");
		}
	}
}
