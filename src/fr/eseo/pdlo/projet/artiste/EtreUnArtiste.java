package fr.eseo.pdlo.projet.artiste;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste {
	
	static private final String DEFAULT_TITLE = "Etre un Artiste";
	static private final int DEFAULT_WIDTH = 640;
	static private final int DEFAULT_HEIGHT = 480;
	
	private JFrame window;
	private PanneauDessin panneauDessin;
	private PanneauBarreOutils barreOutils;
	private PanneauBarreEtat barreEtat;
	
	private EtreUnArtiste(String title, int height, int width) {
		this.window = new JFrame(title);
		
		panneauDessin = new PanneauDessin(height, width, Color.white);
		barreOutils = new PanneauBarreOutils(panneauDessin);
		barreEtat = new PanneauBarreEtat(panneauDessin);
		
		this.window.add(panneauDessin, BorderLayout.CENTER);
		this.window.add(barreEtat, BorderLayout.SOUTH);
		this.window.add(barreOutils, BorderLayout.EAST);
		//this.window.setLocationRelativeTo( window );
		this.window.pack();
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setVisible(true);
		
	}
	
	private EtreUnArtiste() {
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
					
					new EtreUnArtiste(title, width, height);
				}
				else if (args.length == 0) {
					new EtreUnArtiste();
				}
				else System.out.println("Arguments invalide !");
				
			}
		});
	}

}
