package EntornoGraficoAWT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JTextField;

import sql.eliminar;
import sql.introducir;
import sql.update;
import sql.visualizar;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowB {

	private JFrame frame;
	private JTextField Tnom;
	private JTextField Tap;
	private JTextField Tedad;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowB window = new WindowB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		introducir ob2 = new introducir();
		update ob1 = new update();
		eliminar ob3 = new eliminar();
		visualizar ob4 = new visualizar();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 0, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel aajNom = new JLabel("Nombre");
		aajNom.setBounds(101, 44, 46, 14);
		frame.getContentPane().add(aajNom);
		
		JLabel aajAp = new JLabel("Apellido");
		aajAp.setBounds(101, 78, 46, 14);
		frame.getContentPane().add(aajAp);
		
		JLabel aajEdad = new JLabel("Edad");
		aajEdad.setBounds(101, 109, 46, 14);
		frame.getContentPane().add(aajEdad);
		
		Tnom = new JTextField();
		Tnom.setBounds(173, 41, 86, 20);
		frame.getContentPane().add(Tnom);
		Tnom.setColumns(10);
		
		Tap = new JTextField();
		Tap.setColumns(10);
		Tap.setBounds(173, 75, 86, 20);
		frame.getContentPane().add(Tap);
		
		Tedad = new JTextField();
		Tedad.setColumns(10);
		Tedad.setBounds(173, 106, 86, 20);
		frame.getContentPane().add(Tedad);
		
		JButton consulta = new JButton("consultar");
		consulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			ob4.visualizar1();
			
			}
		});
		consulta.setBounds(10, 202, 89, 23);
		frame.getContentPane().add(consulta);
		
		JButton bmodificar = new JButton("modificar");
		bmodificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String a = "update pacientes set nombre = 'Fernando' where nombre = 'Manolo'";
				JOptionPane.showMessageDialog(null, "Ha cambiado el nombre manolo por fernando");
				
			ob1.update(a);
			}
		});
		bmodificar.setAction(action);
		bmodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bmodificar.setBounds(108, 202, 89, 23);
		frame.getContentPane().add(bmodificar);
		
		JButton bborrar = new JButton("borrar");
		bborrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ob3.eliminar1();
			}
		});
		bborrar.setBounds(210, 202, 89, 23);
		frame.getContentPane().add(bborrar);
		
		JButton añadir = new JButton("a\u00F1adir");
		añadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String nombre = Tnom.getText();
				String apellido = Tap.getText();
				int edad = Integer.parseInt(Tedad.getText());
				ob2.introducir(nombre, apellido, edad);
				System.out.println("datos introducidos");
				
				
			}
		});
		añadir.setBounds(313, 202, 89, 23);
		frame.getContentPane().add(añadir);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "modificar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
