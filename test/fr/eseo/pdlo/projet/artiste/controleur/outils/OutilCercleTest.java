package fr.eseo.pdlo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilCercleTest {
	@Test
	private void testConstructeur() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		PanneauDessin panel = new PanneauDessin();
		OutilCercle outilCercle = new OutilCercle();
		
		fenetre.add(panel);
		panel.associerOutil(outilCercle);
		
		panel.paintComponents(panel.getGraphics());
		fenetre.setLocationRelativeTo(null);
		fenetre.setSize(500, 300);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}

	
	OutilCercleTest() {
		testConstructeur();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new OutilCercleTest();
			}
		});
		
	}
}
