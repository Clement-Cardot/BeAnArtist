package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

public class PanneauBarreOutilsTest {

	@Test
	private void testBarreOutils() {
		JFrame fenetre = new JFrame("Etre un artiste");
		PanneauDessin panneauDessin = new PanneauDessin();
		
		fenetre.add(panneauDessin);
		
		PanneauBarreOutils barreOutils = new PanneauBarreOutils(panneauDessin);
		
		fenetre.add(barreOutils, BorderLayout.EAST);
		
		fenetre.setLocationRelativeTo(null);
		fenetre.setSize(500, 300);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	
	public PanneauBarreOutilsTest() {
		testBarreOutils();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new PanneauBarreOutilsTest();
			}
		});
		
	}
}
