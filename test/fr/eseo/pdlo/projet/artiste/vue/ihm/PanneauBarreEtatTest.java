package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

public class PanneauBarreEtatTest {
	@Test
	private void testConstructeurParDefaut() {
		JFrame fenetreDeTest = new JFrame("Etre un Artiste");
		PanneauDessin panel = new PanneauDessin();
		PanneauBarreEtat barreEtat = new PanneauBarreEtat(panel);
		
		fenetreDeTest.add(panel);
		
		panel.setLayout(new BorderLayout());
		panel.add(barreEtat, BorderLayout.SOUTH);
		
		
		fenetreDeTest.setLocationRelativeTo(null);
		fenetreDeTest.setSize(500, 300);
		fenetreDeTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetreDeTest.setVisible(true);
	}
	
	public PanneauBarreEtatTest() {
		testConstructeurParDefaut();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new PanneauBarreEtatTest();
			}
		});
		
	}
}
