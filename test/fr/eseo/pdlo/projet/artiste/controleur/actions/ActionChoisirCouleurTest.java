package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleurTest {
	@Test
	private void testConstructeurParDefaut() {
		JFrame fenetreDeTest = new JFrame("Etre un Artiste");
		PanneauDessin panel = new PanneauDessin();
		PanneauBarreOutils barreOutils = new PanneauBarreOutils(panel);
		OutilLigne outilLigne = new OutilLigne();
		
		fenetreDeTest.add(panel);
		
		panel.setLayout(new BorderLayout());
		panel.add(barreOutils, BorderLayout.EAST);
		panel.associerOutil(outilLigne);
		
		
		fenetreDeTest.setLocationRelativeTo(null);
		fenetreDeTest.setSize(500, 300);
		fenetreDeTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetreDeTest.setVisible(true);
	}
	
	public ActionChoisirCouleurTest() {
		testConstructeurParDefaut();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new ActionEffacerTest();
			}
		});
		
	}
}
