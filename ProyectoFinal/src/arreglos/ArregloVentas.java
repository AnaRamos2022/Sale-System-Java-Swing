package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Venta;

public class ArregloVentas {
	private ArrayList<Venta> listadoVenta = new ArrayList<Venta>();

	// Constructor de clase
	public ArregloVentas() {
		cargarArchivoVentas();
	}

	// Metodos de acceso público: set/get
	public ArrayList<Venta> getListadoVenta() {
		return listadoVenta;
	}

	public void setListadoVenta(ArrayList<Venta> listadoVenta) {
		this.listadoVenta = listadoVenta;
	}

	// Método que adicionará Venta al pulsar el btn guardar.
	public void adicionarVenta(Venta sell) {
		listadoVenta.add(sell);
		archivarVentas();
	}

	// método tamaño
	public int tamaño() {
		return listadoVenta.size();
	}

	// Método para obtener la Venta ingresando una posición
	public Venta obtenerVenta(int i) {
		return listadoVenta.get(i);
	}

	// Método conseguir el último objeto venta y obtener su codigo. Calcular el
	// codigo correlativo.
	public int obtenerCodigoCorrelativo() {
		int ultimaPosicionArrayList = listadoVenta.size() - 1;
		if (listadoVenta.size() == 0) {
			return 3001;
		} else {
			// conseguir la venta de la última posición registrada.
			Venta utlimaVentaRegistrada = obtenerVenta(ultimaPosicionArrayList);
			return utlimaVentaRegistrada.getCodigoVenta() + 1;
		}
	}

	// Método para guardar la data de la Lista de Ventas en un archivo
	private void archivarVentas() {

		try {
			PrintWriter pw;
			Venta v;
			String fila;
			pw = new PrintWriter(new FileWriter("ventas.txt"));
			for (int i = 0; i < listadoVenta.size(); i++) {
				v = obtenerVenta(i);
				fila = v.getCodigoVenta() + ";" + v.getCodigoCliente() + ";" + v.getCodigoProducto() + ";"
						+ v.getCantidad() + ";" + v.getPrecio() + ";" + v.getFecha();
				pw.println(fila);
			}
			pw.close();
		} catch (Exception e) {

		}
	}

	// Método para leer el archivo de Ventas fila por fila.
	private void cargarArchivoVentas() {
		try {
			BufferedReader br;
			String linea, fecha;
			int codigoVenta, codigoCliente, codigoProducto, cantidad;
			double precio;
			String[] fila;
			br = new BufferedReader(new FileReader("ventas.txt"));
			while ((linea = br.readLine()) != null) {
				fila = linea.split(";");
				Venta v = new Venta();
				codigoVenta = Integer.parseInt(fila[0]);
				codigoCliente = Integer.parseInt(fila[1]);
				codigoProducto = Integer.parseInt(fila[2]);
				cantidad = Integer.parseInt(fila[3]);
				precio = Double.parseDouble(fila[4]);
				fecha = fila[5] + "";
				v.setCodigoVenta(codigoVenta);
				v.setCodigoCliente(codigoCliente);
				v.setCodigoProducto(codigoProducto);
				v.setCantidad(cantidad);
				v.setPrecio(precio);
				v.setFecha(fecha);
				listadoVenta.add(v);
			}
			br.close();
		} catch (Exception e) {
		}
	}
}
