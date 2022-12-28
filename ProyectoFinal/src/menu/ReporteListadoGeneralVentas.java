package menu;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Venta;
import arreglos.ArregloVentas;

public class ReporteListadoGeneralVentas extends JInternalFrame {
	private JScrollPane scrollPane;
	private JTable tablaReporteVentas;
	private DefaultTableModel modelo;
	private ArregloVentas arregloVentas= new ArregloVentas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteListadoGeneralVentas frame = new ReporteListadoGeneralVentas();
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
	public ReporteListadoGeneralVentas() {
		setTitle("Reportes | Listado General de Ventas");
		setClosable(true);
		setBounds(10, 10, 560, 638);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 528, 589);
		getContentPane().add(scrollPane);
		
		tablaReporteVentas = new JTable();
		tablaReporteVentas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tablaReporteVentas);
		
		tablaReporteVentas = new JTable();
		tablaReporteVentas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tablaReporteVentas);
		modelo= new DefaultTableModel();
		modelo.addColumn("Cod. Venta");
		modelo.addColumn("Cod. Cliente");
		modelo.addColumn("Cod. Producto");
		modelo.addColumn("Fecha");
		modelo.addColumn("Imp. Subtotal");
		modelo.addColumn("Imp. IGV");
		modelo.addColumn("Imp. Total");
		tablaReporteVentas.setModel(modelo);
		
		listarVenta();
	}
	
	public void  listarVenta() {
		limpiarTabla();
		//Recorrido y creación del ArrayList ListadoProducto
		for (int i=0; i<arregloVentas.getListadoVenta().size(); i++) {
		Venta v = arregloVentas.getListadoVenta().get(i);
			pasarAtabla(v);
		}
	}
	
	public void pasarAtabla (Venta v) {
		Object[] fila = new Object[7];
		fila[0] = v.getCodigoVenta();
		fila[1] = v.getCodigoCliente();
		fila[2] = v.getCodigoProducto();
		fila[3] = v.getFecha();
		fila[4] = v.obtenerSubTotal();
		fila[5] = v.obtenerImporteIGV();
		fila[6] = v.obtenerImporteTotal();
		modelo.addRow(fila);
	}
	
	public void limpiarTabla() {
		//while (modelo.getRowCount() > 0) {
			//modelo.removeRow(0);
		//}
	modelo.setRowCount(0);
	}
}
