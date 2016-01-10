package ue11;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

import java.awt.event.*; // Eventhandling
import java.text.NumberFormat;

public class MyCountingFrame extends JFrame {

	/**
	 * Da JFrame das Serializable Interface implementiert, sollte diese UID
	 * definiert werden. Wir setzten sie der Einfachheit halber auf 1:
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variablendeklarationen von JButton & JTextField aus dem Konstruktor
	 * verschoben
	 */
	private JButton button;
	private JTextField textfield;
	private JTextField textFieldLog;
	/** Zaehlrichtung: true = aufwaerts */
	private boolean richtung = true;
	/** Anzahl Klicks */
	private int count = 0;

	/** Konstruktor */
	public MyCountingFrame() {
		/*
		 * Fenster konfigurieren:
		 */
		// Frame-Erzeugung ueber Konstruktor von JFrame
		super("My Counting Frame");
		// Groesse des Frames
		this.setLayout(new GridLayout(1, 4, 1, 1));
		this.setBounds(200, 200, 800, 150);

		// Schliesse das Fenster bei Klick auf das Kreuz
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Anlegen einer Menuzeile
		JMenuBar menubar = new JMenuBar();
		// Eintragen der Menuzeile in den Frame
		this.setJMenuBar(menubar);

		// Anlegen eines Eintrags in der Menuezeile
		JMenu myMenu = new JMenu("Mein Menue");
		// Eintragen des Menupunkts in die Menuezeile
		menubar.add(myMenu);

		// Menuunterpunkt "Reset" anlegen
		JMenuItem resetItem = new JMenuItem("Reset");
		// und in das Menu myMenu eintragen
		myMenu.add(resetItem);

		// Zugriff auf geerbten ContentPane
		Container conPane = this.getContentPane();

		// Anlegen eines Panelbereichs
		JPanel panel = new JPanel();
		JPanel panelDown = new JPanel();
		
		panel.setLayout(new GridLayout(1, 1));
		panelDown.setLayout(new GridLayout(1, 1));
		panelDown.setBounds(1, 1, this.getWidth(), 300);
		
		conPane.setLayout(new GridLayout(2, 1));
		
		// Eintragen des Panels in den Frame
		conPane.add(panel);
		conPane.add(panelDown);

		/*
		 * Inhalte des Panels definieren:
		 */
		// Erzeugen eines Buttons
		button = new JButton("Click me");
		// und Eintragen in das ContentPane
		panel.add(button);

		// Erzeugen eines Textfeldes
		textfield = new JTextField();
		textFieldLog = new JTextField();

		// und Eintragen in das ContentPane
		panel.add(textfield);
		panelDown.add(textFieldLog);

		// RadioButtons anlegen, "aufwaerts" ist initial markiert
		JRadioButton auf = new JRadioButton("aufwaerts", true);
		JRadioButton ab = new JRadioButton("abwaerts");
		// und zum Panel hinzufuegen
		panel.add(auf);
		panel.add(ab);

		// Zusammenfassen der RadioButtons zu einer Gruppe
		ButtonGroup group = new ButtonGroup();
		group.add(auf);
		group.add(ab);

		// Anzeigen des Frames
		setVisible(true);

		/*
		 * Definition und Anmelden der ActionListener:
		 */
		// Klicken auf die RadioButtons "auf" und "ab"
		auf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// Setze Richtung = 'aufwaerts'
				richtung = true;
			}
		});
		ab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// Setze Richtung = 'abwaerts'
				richtung = false;
			}
		});

		// Klicken auf button
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonActionPerformed();
			}
		});

		textfield.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCounterActionPerformed();

			}
		});
		// Klicken auf das MenuItem "Reset"
		resetItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetActionPerformed();
			}
		});
	} // Ende des Konstruktors MyCountingFrame()

	/*
	 * DEFINITION DER von den ActionListenern verwendeten METHODEN:
	 */
	/** Aktionen nach Klick auf Button */
	private void buttonActionPerformed() {
		if (richtung)
			count++; // Aufwaerts zaehlen
		else
			count--; // Abwaerts zaehlen
		button.setText("bis " + count + " gezaehlt");
	}

	/** Aktion nach klicken auf Textfield */
	private void setCounterActionPerformed() {
		try {
			int value = Integer.parseInt(textfield.getText());
			count = value;
			button.setText("Counter auf " + count + " gesetzt");
		} catch (NumberFormatException numError) {
			Object[] stackTrace = new Object[numError.getStackTrace().length];
			stackTrace = numError.getStackTrace();
			
			for(Object x: stackTrace){
				textFieldLog.setText("Contract violated in <" + x.toString() + ">: " + numError.getMessage());	
			}
			
		} catch (Exception e) {
			// NOP
		}
	}

	/** Aktionen nach Klick auf Reset */
	private void resetActionPerformed() {
		button.setText("Click me");
		count = 0;
		richtung = true;
	}

	/**
	 * Main Methode: Erzeugen des Fensters
	 */
	public static void main(String args[]) {
		new MyCountingFrame();
	}
}