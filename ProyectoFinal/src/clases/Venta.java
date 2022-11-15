package clases;

public class Venta {
	//Atributos privados
	private int codigoVenta, codigoCliente, codigoProducto, cantidad;
	private String fecha;
	private double precio;
	
	//Metodos de acceso público: set/get
	public int getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//Metodos de acceso público 
	public double obtenerSubTotal() {
		return Math.round((precio*cantidad)*100)/100;
	}
	
	public double obtenerImporteIGV() {
		return Math.round((obtenerSubTotal() * 0.18)*100)/100;
	}
	
	public double obtenerImporteTotal() {
		return Math.round((obtenerSubTotal() + obtenerImporteIGV())*100)/100;
	}
}
