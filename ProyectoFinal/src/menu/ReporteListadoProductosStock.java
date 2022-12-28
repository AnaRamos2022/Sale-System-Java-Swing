package menu;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import arreglos.ArregloProductos;

public class ReporteListadoProductosStock extends JInternalFrame {
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private ArregloProductos arregloProductos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteListadoProductosStock frame = new ReporteListadoProductosStock();
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
	public ReporteListadoProductosStock() {
		setTitle("Reportes | Listado de Productos Stock menor al m\u00EDnimo ");
		setClosable(true);
		setBounds(10, 10, 460, 520);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 428, 471);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		arregloProductos = new ArregloProductos();
		mostrarReporte();
	}
	
	private void stockProductos() {
		for (int i = 0; i < arregloProductos.tamaño(); i++) {
			if (arregloProductos.obtenerProducto(i).getStockActual()<arregloProductos.obtenerProducto(i).getStockMinimo()) {
				textArea.append("Código Producto:	" + arregloProductos.obtenerProducto(i).getCodigoProducto() + "\n");
				textArea.append("Nombre Producto: 	" + arregloProductos.obtenerProducto(i).getNombre() + "\n");
				textArea.append("Stock Actual:  		" + arregloProductos.obtenerProducto(i).getStockActual() + "\n");
				textArea.append("Stock Mínimo:		" + arregloProductos.obtenerProducto(i).getStockMinimo() + "\n");
				textArea.append("" + "\n");
			}
		}
	}
	
	private void mostrarReporte() {
		textArea.setText("");
		textArea.append("LISTADO DE PRODUCTOS" + "\n");
		textArea.append("==========================================================" + "\n");
		stockProductos();
	}
}
