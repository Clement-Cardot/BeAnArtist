package fr.eseo.pdlo.projet.artiste;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.vue.ihm.BarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.MenuBar;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtatExtension;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessinExtension;

public class EtreUnArtisteExtension {
	static private final String DEFAULT_TITLE = "Etre un Artiste";
	static private final int DEFAULT_WIDTH = 640;
	static private final int DEFAULT_HEIGHT = 480;
	
	private JFrame window;
	private PanneauDessinExtension panneauDessin;
	//private PanneauBarreOutilsExtension barreOutils;
	private PanneauBarreEtatExtension barreEtat;
	private MenuBar menuBar;
	private	BarreOutils barreOutils;
	
	private EtreUnArtisteExtension(String title, int height, int width) {
		this.window = new JFrame(title);
		
		panneauDessin = new PanneauDessinExtension(height, width, Color.white);
		//barreOutils = new PanneauBarreOutilsExtension(panneauDessin);
		
		this.initMenu();
		
		barreEtat = new PanneauBarreEtatExtension(panneauDessin);
		
		this.window.add(panneauDessin, BorderLayout.CENTER);
		this.window.add(barreEtat, BorderLayout.SOUTH);
		//this.window.add(barreOutils, BorderLayout.EAST);
		//this.window.add(menuBar, BorderLayout.NORTH);
		//this.window.setLocationRelativeTo( window );
		this.window.pack();
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setVisible(true);
		
	}
	
	private EtreUnArtisteExtension() {
		this(DEFAULT_TITLE, DEFAULT_HEIGHT, DEFAULT_WIDTH);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				if(args.length == 3) {
					
					int width, height;
					String title = args[0];
					
					try { width = Integer.parseInt(args[1]);
					} catch(NumberFormatException e) {
						width = DEFAULT_WIDTH;
					}
					
					try { height = Integer.parseInt(args[2]);
					} catch(NumberFormatException e) {
						height = DEFAULT_HEIGHT;
					}
					
					new EtreUnArtisteExtension(title, width, height);
				}
				else if (args.length == 0) {
					new EtreUnArtisteExtension();
				}
				else System.out.println("Arguments invalide !");
				
			}
		});
	}

	private void initMenu() {
		
		JPanel northLayout = new JPanel();
		
		menuBar = new MenuBar(panneauDessin);
		barreOutils = new BarreOutils(this.panneauDessin);
		
		northLayout.add(menuBar);
		northLayout.add(barreOutils);
		
		this.window.add(northLayout, BorderLayout.NORTH);
	}
}
