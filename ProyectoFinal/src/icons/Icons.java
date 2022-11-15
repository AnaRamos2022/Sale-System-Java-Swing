package icons;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Icons {
	private static ImageIcon iconoModificar;
	private static ImageIcon  iconoAdicionar;
	private static ImageIcon  iconoEliminar;
	private static ImageIcon iconoBuscar;
	private static ImageIcon iconoGuardar;
	private static ImageIcon iconoAlmacen;
	private static ImageIcon iconoCliente;
	private static ImageIcon iconoProducto;
	private static ImageIcon iconoVentas;
	private static ImageIcon iconoFondo;
	
	public static ImageIcon getIconoModificar() {
		try {
			if (iconoModificar == null) {
				iconoModificar = new ImageIcon(ImageIO.read(Icons.class.getClassLoader().getResource("Icons/modificar.png")));
			}			
			return iconoModificar;
		} catch(IOException e) {
			return null;
		}		
	}
	
	
	public static ImageIcon getIconoAdicionar() {
		try {
			if (iconoAdicionar == null) {
				iconoAdicionar = new ImageIcon(ImageIO.read(Icons.class.getClassLoader().getResource("Icons/adicionar.png")));
			}			
			return iconoAdicionar;
		} catch(IOException e) {
			return null;
		}		
	}

	public static ImageIcon getIconoEliminar() {
		try {
			if (iconoEliminar == null) {
				iconoEliminar = new ImageIcon(ImageIO.read(Icons.class.getClassLoader().getResource("Icons/eliminar.png")));
			}			
			return iconoEliminar;
		} catch(IOException e) {
			return null;
		}		
	}
	
	public static ImageIcon getIconoBuscar() {
		try {
			if (iconoBuscar == null) {
				iconoBuscar = new ImageIcon(ImageIO.read(Icons.class.getClassLoader().getResource("Icons/buscar.png")));
			}			
			return iconoBuscar;
		} catch(IOException e) {
			return null;
		}		
	}
	
	public static ImageIcon getIconoGuardar() {
		try {
			if (iconoGuardar == null) {
				iconoGuardar = new ImageIcon(ImageIO.read(Icons.class.getClassLoader().getResource("Icons/guardar.png")));
			}			
			return iconoGuardar;
		} catch(IOException e) {
			return null;
		}		
	}
	
	public static ImageIcon getIconoAlmacen() {
		try {
			if (iconoAlmacen == null) {
				iconoAlmacen = new ImageIcon(ImageIO.read(Icons.class.getClassLoader().getResource("Icons/almacen.png")));
			}			
			return iconoAlmacen;
		} catch(IOException e) {
			return null;
		}		
	}
	
	public static ImageIcon getIconoCliente() {
		try {
			if (iconoCliente == null) {
				iconoCliente = new ImageIcon(ImageIO.read(Icons.class.getClassLoader().getResource("Icons/cliente.png")));
			}			
			return iconoCliente;
		} catch(IOException e) {
			return null;
		}		
	}
	
	public static ImageIcon getIconoProducto() {
		try {
			if (iconoProducto == null) {
				iconoProducto = new ImageIcon(ImageIO.read(Icons.class.getClassLoader().getResource("Icons/producto.png")));
			}			
			return iconoProducto;
		} catch(IOException e) {
			return null;
		}		
	}

	public static ImageIcon getIconoVentas() {
		try {
			if (iconoVentas == null) {
				iconoVentas = new ImageIcon(ImageIO.read(Icons.class.getClassLoader().getResource("Icons/ventas.png")));
			}			
			return iconoVentas;
		} catch(IOException e) {
			return null;
		}		
	}
	
	public static ImageIcon getIconoFondo() {
		try {
			if (iconoFondo == null) {
				iconoFondo = new ImageIcon(ImageIO.read(Icons.class.getClassLoader().getResource("Icons/fondo.JPG")));
			}			
			return iconoFondo;
		} catch(IOException e) {
			return null;
		}		
	}
}
