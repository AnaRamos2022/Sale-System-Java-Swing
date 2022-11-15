package menu;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import arreglos.ArregloProductos;
import arreglos.ArregloVentas;
import clases.Producto;
import clases.Venta;

public class ReporteListadoProductosImporte extends JInternalFrame {
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
					ReporteListadoProductosImporte frame = new ReporteListadoProductosImporte();
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
	public ReporteListadoProductosImporte() {
		setClosable(true);
		setTitle("Reportes | Listado de Productos Importe total vendido");
		setBounds(10, 10, 460, 520);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 468);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		arregloProductos=new ArregloProductos();
		arregloVentas=new ArregloVentas();
		importeAcumuladoPorProducto();
	}

	//Método para conocer el importe total acumulado vendidos por modelo
		public void importeAcumuladoPorProducto() {
			for (int i = 0; i <arregloProductos.tamaño(); i++) {
				double importeTotal=0;
				for (int j=0; j<arregloVentas.tamaño(); j++) {
					if (arregloProductos.obtenerProducto(i).getCodigoProducto()==arregloVentas.obtenerVenta(j).getCodigoProducto()) {
						importeTotal=importeTotal+arregloVentas.obtenerVenta(j).obtenerImporteTotal();
					}
				}
				textArea.append("Código Producto:	" + arregloProductos.obtenerProducto(i).getCodigoProducto() + "\n");
				textArea.append("Nombre Producto: 	" + arregloProductos.obtenerProducto(i).getNombre() + "\n");
				textArea.append("El importe total acumulado:  	" + importeTotal + "\n");
				textArea.append("" + "\n");
			}
		}
}
