package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;
import clases.Producto;

public class ArregloProductos {
	private ArrayList<Producto> listadoProducto = new ArrayList<Producto>();

	// Constructor de clase
		public ArregloProductos() {
			cargarArchivoProductos();
		}

	// Metodos de acceso público: set/get
	public void setListadoProducto(ArrayList<Producto> listadoProducto) {
		this.listadoProducto = listadoProducto;
	}
	
	public ArrayList<Producto> getListadoProducto() {
		return listadoProducto;
	}

	// Método que adicionará productos al pulsar el btn guardar.
	public void adicionarProducto(Producto prod) {
		listadoProducto.add(prod);
		this.archivarProductos();
	}
	
	//método tamaño
	public int tamaño() {
		return listadoProducto.size();
	}
	
	//Método obtenerProducto
	public Producto obtenerProducto(int i) {
		return listadoProducto.get(i);
	}

	// Método conseguir la posicion del ultimo producto
	public int obtenerCodigoCorrelativo() {
		int ultimaPosicionArrayList = listadoProducto.size() - 1;
		if (listadoProducto.size() == 0) {
			return 2001;
		} else {
			// conseguir el producto de la última posición registrado.
			Producto utlimoProductoRegistrado = listadoProducto.get(ultimaPosicionArrayList);
			return utlimoProductoRegistrado.getCodigoProducto() + 1;
		}
	}
	
	//Metodo consultar para obtener producto por codigo.
	public Producto obtenerProductoCodigo(int codProd) {
		for (int i=0; i<listadoProducto.size(); i++) {
			if (codProd==listadoProducto.get(i).getCodigoProducto()) {
				return listadoProducto.get(i);
			}
		}
		return null;
	}
	
	// Método que guardará productos modificados al pulsar el btn guardar.
		public void modificarProducto(Producto producto) {
			listadoProducto.set(posicionProductoCodigo(producto.getCodigoProducto()), producto);
			this.archivarProductos();
		}

		// Método para obtener la posición del producto en el arrayList por código de
		// cliente.
		public int posicionProductoCodigo(int codigo) {
			for (int i = 0; i < listadoProducto.size(); i++) {
				int codigoCliente = listadoProducto.get(i).getCodigoProducto(); // devuelve el atributo codCliente del
																				// cliente en la posicion i
				if (codigoCliente == codigo) {
					return i;
				}
			}
			return -1;
		}
		
		//Método que elimina el producto cuyo codigo ha sido seleccionado
		public void eliminarProducto (int codigo) {
			int posicionEliminar = posicionProductoCodigo(codigo);
			listadoProducto.remove(posicionEliminar);
			this.archivarProductos();
		}
		
		//Método para guardar la data de la Lista de Productos en un archivo
		private void archivarProductos() {
			
			try {
				PrintWriter pw;
				Producto p;
				String fila;
				pw=new PrintWriter(new FileWriter("productos.txt"));
				for(int i=0; i<listadoProducto.size(); i++) {
					p=listadoProducto.get(i);
					fila=p.getCodigoProducto() + ";" + p.getNombre() + ";" + p.getPrecio() + ";" + p.getStockActual() + ";" + p.getStockMinimo() + ";" + p.getStockMaximo();
					pw.println(fila);
				}
				pw.close();
			}
			catch (Exception e) {
				
			}
		}
		
		//Método para leer el archivo de Clientes fila por fila.
		private void cargarArchivoProductos() {
			try {
				BufferedReader br;
				String linea, nombre;
				int codigoProducto, stockActual, stockMinimo, stockMaximo;
				double precio;
				String[] fila;
				br = new BufferedReader(new FileReader("productos.txt"));
				while ((linea = br.readLine()) != null) {
					fila = linea.split(";");
					Producto p = new Producto ();
					codigoProducto = Integer.parseInt(fila[0]);
					nombre = fila[1];
					precio = Double.parseDouble(fila[2]);
					stockActual = Integer.parseInt(fila[3]);
					stockMinimo = Integer.parseInt(fila[4]);
					stockMaximo = Integer.parseInt(fila[5]);
					p.setCodigoProducto(codigoProducto);
					p.setNombre(nombre);
					p.setPrecio(precio);
					p.setStockActual(stockActual);
					p.setStockMinimo(stockMinimo);
					p.setStockMaximo(stockMaximo);
					listadoProducto.add(p);
				}
				br.close();
			} catch (Exception e) {
			}
		}
}
