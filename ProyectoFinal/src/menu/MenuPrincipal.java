package menu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import icons.Icons;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MenuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private MttoClientes formClientes;
	private MttoProductos formProductos;
	private RegistroVenta formVenta;
	private ActualizarAlmacen formAlmacen;
	private ReporteListadoGeneralVentas formListadoGeneral;
	private ReporteListadoProductosStock formListadoProductoStock;
	private ReporteListadoProductosVendidos formListadoProductosVendidos;
	private ReporteListadoProductosImporte formListadoProductosImporte;
	private JDesktopPane desktopPane;
	private JMenu mnVentas;
	private JMenuItem mntmProductos;
	private JMenuItem mntmRegistroVenta;
	private JMenu mnAlmacen;
	private JMenuItem mntmActualizarAlmacen;
	private JMenuItem mntmReporteListadoGeneralVentas;
	private JMenuItem mntmReporteListadoProductosStock;
	private JMenuItem mntmReporteListadoProductosVendidos;
	private JMenuItem mntmReporteListadoProductosImporte;
	private JLabel lblFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		int ANCHO = 300, ALTO = 400;
				
		setTitle("Sistema de Ventas - Men\u00FA Principal / Ana C. Ramos Neira");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 792);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMtto = new JMenu("Mantenimiento");
		menuBar.add(mnMtto);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formClientes=new MttoClientes();
				desktopPane.add(formClientes);
				formClientes.show();
			}
		});
		mnMtto.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mnMtto.add(mntmProductos);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.addActionListener(this);
		menuBar.add(mnVentas);
		
		mntmRegistroVenta = new JMenuItem("Registro Venta");
		mntmRegistroVenta.addActionListener(this);
		mnVentas.add(mntmRegistroVenta);
		
		mnAlmacen = new JMenu("Almac\u00E9n");
		mnAlmacen.addActionListener(this);
		menuBar.add(mnAlmacen);
		
		mntmActualizarAlmacen = new JMenuItem("Actualizar Almacen");
		mntmActualizarAlmacen.addActionListener(this);
		mnAlmacen.add(mntmActualizarAlmacen);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mntmReporteListadoGeneralVentas = new JMenuItem("Listado General de Ventas");
		mntmReporteListadoGeneralVentas.addActionListener(this);
		mnReportes.add(mntmReporteListadoGeneralVentas);
		
		mntmReporteListadoProductosStock = new JMenuItem("Productos menor a Stock Min");
		mntmReporteListadoProductosStock.addActionListener(this);
		mnReportes.add(mntmReporteListadoProductosStock);
		
		mntmReporteListadoProductosVendidos = new JMenuItem("Productos por unidad vendida");
		mntmReporteListadoProductosVendidos.addActionListener(this);
		mnReportes.add(mntmReporteListadoProductosVendidos);
		
		mntmReporteListadoProductosImporte = new JMenuItem("Productos por Importe Total");
		mntmReporteListadoProductosImporte.addActionListener(this);
		mnReportes.add(mntmReporteListadoProductosImporte);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 51, 102));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		lblFondo = new JLabel("");
		lblFondo.setBackground(Color.GRAY);
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setBounds(0, 0, 592, 703);
		lblFondo.setIcon(Icons.getIconoFondo());
		desktopPane.add(lblFondo);
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmReporteListadoProductosImporte) {
			actionPerformedMntmReporteListadoProductosImporte(e);
		}
		if (e.getSource() == mntmReporteListadoProductosVendidos) {
			actionPerformedMntmReporteListadoProductosVendidos(e);
		}
		if (e.getSource() == mntmReporteListadoProductosStock) {
			actionPerformedMntmReporteListadoProductoStock(e);
		}
		if (e.getSource() == mntmReporteListadoGeneralVentas) {
			actionPerformedMntmReporteListadoGeneralVentas(e);
		}
		if (e.getSource() == mntmActualizarAlmacen) {
			actionPerformedMntmActualizarAlmacen(e);
		}
		if (e.getSource() == mntmRegistroVenta) {
			actionPerformedMntmRegistroVenta(e);
		}
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
	}

	protected void actionPerformedMntmProductos(ActionEvent e) {
		if (formProductos == null || formProductos.isClosed()) {
			formProductos=new MttoProductos();
			desktopPane.add(formProductos);
			formProductos.show();
		}
	}
	protected void actionPerformedMntmRegistroVenta(ActionEvent e) {
		if (formVenta == null || formVenta.isClosed()) {
			formVenta= new RegistroVenta();
			desktopPane.add(formVenta);
			formVenta.show();	
		}
	}
	protected void actionPerformedMntmActualizarAlmacen(ActionEvent e) {
		if (formAlmacen == null || formAlmacen.isClosed()) {
			formAlmacen= new ActualizarAlmacen();
			desktopPane.add(formAlmacen);
			formAlmacen.show();
		}
	}
	protected void actionPerformedMntmReporteListadoGeneralVentas(ActionEvent e) {
		if (formListadoGeneral == null || formListadoGeneral.isClosed()) {
			formListadoGeneral= new ReporteListadoGeneralVentas();
			desktopPane.add(formListadoGeneral);
			formListadoGeneral.show();
		}
	}
	protected void actionPerformedMntmReporteListadoProductoStock(ActionEvent e) {
		if (formListadoProductoStock == null || formListadoProductoStock.isClosed()) {
			formListadoProductoStock= new ReporteListadoProductosStock();
			desktopPane.add(formListadoProductoStock);
			formListadoProductoStock.show();
		}
	}
	protected void actionPerformedMntmReporteListadoProductosVendidos(ActionEvent e) {
		if (formListadoProductosVendidos == null || formListadoProductosVendidos.isClosed()) {
			formListadoProductosVendidos= new ReporteListadoProductosVendidos();
			desktopPane.add(formListadoProductosVendidos);
			formListadoProductosVendidos.show();
		}
	}
	protected void actionPerformedMntmReporteListadoProductosImporte(ActionEvent e) {
		if (formListadoProductosImporte == null || formListadoProductosImporte.isClosed()) {
			formListadoProductosImporte= new ReporteListadoProductosImporte();
			desktopPane.add(formListadoProductosImporte);
			formListadoProductosImporte.show();
		}
	}
}
