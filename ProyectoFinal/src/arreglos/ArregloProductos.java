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

	// Metodos de acceso p�blico: set/get
	public void setListadoProducto(ArrayList<Producto> listadoProducto) {
		this.listadoProducto = listadoProducto;
	}
	
	public ArrayList<Producto> getListadoProducto() {
		return listadoProducto;
	}

	// M�todo que adicionar� productos al pulsar el btn guardar.
	public void adicionarProducto(Producto prod) {
		listadoProducto.add(prod);
		this.archivarProductos();
	}
	
	//m�todo tama�o
	public int tama�o() {
		return listadoProducto.size();
	}
	
	//M�todo obtenerProducto
	public Producto obtenerProducto(int i) {
		return listadoProducto.get(i);
	}

	// M�todo conseguir la posicion del ultimo producto
	public int obtenerCodigoCorrelativo() {
		int ultimaPosicionArrayList = listadoProducto.size() - 1;
		if (listadoProducto.size() == 0) {
			return 2001;
		} else {
			// conseguir el producto de la �ltima posici�n registrado.
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
	
	// M�todo que guardar� productos modificados al pulsar el btn guardar.
		public void modificarProducto(Producto producto) {
			listadoProducto.set(posicionProductoCodigo(producto.getCodigoProducto()), producto);
			this.archivarProductos();
		}

		// M�todo para obtener la posici�n del producto en el arrayList por c�digo de
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
		
		//M�todo que elimina el producto cuyo codigo ha sido seleccionado
		public void eliminarProducto (int codigo) {
			int posicionEliminar = posicionProductoCodigo(codigo);
			listadoProducto.remove(posicionEliminar);
			this.archivarProductos();
		}
		
		//M�todo para guardar la data de la Lista de Productos en un archivo
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
		
		//M�todo para leer el archivo de Clientes fila por fila.
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
