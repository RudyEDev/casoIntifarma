package menu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.guiProducto;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JDesktopPane escritorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setExtendedState(MAXIMIZED_BOTH);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sistema\r\n");
		mnNewMenu.setMnemonic('S');
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Cerrar");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_DOWN_MASK));
		mntmNewMenuItem.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/WhatsApp Image 2023-03-14 at 10.56.10 AM (2).jpeg")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Mantenimiento");
		mnNewMenu_1.setMnemonic('M');
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Clientes\r\n");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		mntmNewMenuItem_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/WhatsApp Image 2023-03-14 at 10.56.08 AM.jpeg")));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Productos");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = guiProducto.pro;
				try {
					
					if (p == null) {
						guiProducto pr = new guiProducto();
						escritorio.add(pr);
						pr.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "El formulario ya está abierto");
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
		mntmNewMenuItem_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/WhatsApp Image 2023-03-14 at 10.56.09 AM (1).jpeg")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Reporte");
		mnNewMenu_2.setMnemonic('R');
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Clientes");
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem_3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/WhatsApp Image 2023-03-14 at 10.56.10 AM (4).jpeg")));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Ventas");
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem_4.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/WhatsApp Image 2023-03-14 at 10.56.09 AM (5).jpeg")));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(SystemColor.activeCaption);
		contentPane.add(escritorio, BorderLayout.CENTER);
		escritorio.setLayout(null);
	}

}
