package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class guiVenta extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiVenta frame = new guiVenta();
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
	public guiVenta() {
		setBounds(100, 100, 450, 300);

	}

}
