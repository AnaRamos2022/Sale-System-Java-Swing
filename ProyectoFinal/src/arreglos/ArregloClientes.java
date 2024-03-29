package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;

public class ArregloClientes {
	private ArrayList<Cliente> listadoClientes = new ArrayList<Cliente>();

	// Constructor de clase
	public ArregloClientes() {
		cargarArchivoClientes();
	}

	// Metodos de acceso p�blico: set/get
	public ArrayList<Cliente> getListadoClientes() {
		return listadoClientes;
	}

	public void setListadoClientes(ArrayList<Cliente> listadoClientes) {
		this.listadoClientes = listadoClientes;
	}

	// M�todo que adicionar� clientes al pulsar el btn guardar.
	public void adicionarCliente(Cliente cliente) {
		listadoClientes.add(cliente);
		archivarClientes();
	}

	// M�todo tama�o
	public int tama�o() {
		return listadoClientes.size();
	}

	// M�todo para obtener el cliente ingresando una posici�n
	public Cliente obtenerCliente(int i) {
		return listadoClientes.get(i);
	}

	// M�todo obtiene la posici�n del �ltimo cliente y devuelve el c�digo correlativo incrementado en 1.
	public int obtenerCodigoCorrelativo() {
		int ultimaPosicionArrayList = listadoClientes.size() - 1;
		if (listadoClientes.size() == 0) {
			return 1001;
		} else {
			// conseguir el cliente de la �ltima posici�n registrado.
			Cliente utlimoClienteRegistrado = obtenerCliente(ultimaPosicionArrayList);
			return utlimoClienteRegistrado.getCodigoCliente() + 1;
		}
	}

	// Metodo consultar para obtener el cliente por c�digo correlativo ingresado.
	public Cliente obtenerClienteCodigo(int codCliente) {
		for (int i = 0; i < listadoClientes.size(); i++) {
			if (codCliente == obtenerCliente(i).getCodigoCliente()) {
				return obtenerCliente(i);
			}
		}
		return null;
	}

	// M�todo que guardar� clientes modificados al pulsar el btn guardar.
	public void modificarCliente(Cliente cliente) {
		listadoClientes.set(posicionClienteCodigo(cliente.getCodigoCliente()), cliente);
		archivarClientes();
	}

	// M�todo para obtener la posici�n del cliente en el arrayList por c�digo de cliente.
	public int posicionClienteCodigo(int codigo) {
		for (int i = 0; i < listadoClientes.size(); i++) {
			int codigoCliente = obtenerCliente(i).getCodigoCliente(); // devuelve el atributo codCliente del cliente en la posicion i
			if (codigoCliente == codigo) {
				return i;
			}
		}
		return -1;
	}

	// M�todo que elimina el cliente cuyo codigo ha sido seleccionado
	public void eliminarCliente(int codigo) {
		int posicionEliminar = posicionClienteCodigo(codigo);
		listadoClientes.remove(posicionEliminar);
		archivarClientes();
	}

	// M�todo para guardar la data de la Lista de Clientes en un archivo
	private void archivarClientes() {
		try {
			PrintWriter pw;
			Cliente c;
			String fila;
			pw = new PrintWriter(new FileWriter("clientes.txt"));
			for (int i = 0; i < listadoClientes.size(); i++) {
				c = obtenerCliente(i);
				fila = c.getCodigoCliente() + ";" + c.getNombres() + ";" + c.getApellidos() + ";" + c.getDni() + ";"
						+ c.getDireccion() + ";" + c.getTelefono();
				pw.println(fila);
			}
			pw.close();
		} catch (Exception e) {

		}
	}

	// M�todo para leer la data en el archivo de Clientes fila por fila.
	private void cargarArchivoClientes() {
		try {
			BufferedReader br;
			String linea, nombres, apellidos, dni, direccion, telefono;
			int codigoCliente;
			String[] fila;
			br = new BufferedReader(new FileReader("clientes.txt"));
			while ((linea = br.readLine()) != null) {
				fila = linea.split(";");
				Cliente c = new Cliente();
				codigoCliente = Integer.parseInt(fila[0]);
				nombres = fila[1];
				apellidos = fila[2];
				dni = fila[3];
				direccion = fila[4];
				telefono = fila[5];
				c.setCodigoCliente(codigoCliente);
				c.setNombres(nombres);
				c.setApellidos(apellidos);
				c.setDni(dni);
				c.setDireccion(direccion);
				c.setTelefono(telefono);
				listadoClientes.add(c);
			}
			br.close();
		} catch (Exception e) {
		}
	}
}
