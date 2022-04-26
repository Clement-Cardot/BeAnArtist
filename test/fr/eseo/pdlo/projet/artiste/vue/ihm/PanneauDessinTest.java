package fr.eseo.pdlo.projet.artiste.vue.ihm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

public class PanneauDessinTest {
	
	@Test
	private void testConstructeurParDefaut() {
		JFrame fenetreDeTest = new JFrame("Etre un Artiste");
		PanneauDessin testedPanel = new PanneauDessin();
		
		fenetreDeTest.add(testedPanel);
		
		assertEquals(PanneauDessin.COULEUR_FOND_PAR_DEFAUT, testedPanel.getBackground());
		assertEquals(new Dimension(PanneauDessin.LARGEUR_PAR_DEFAUT, PanneauDessin.HAUTEUR_PAR_DEFAUT), testedPanel.getPreferredSize());
		
		fenetreDeTest.setLocationRelativeTo(null);
		fenetreDeTest.setSize(500, 300);
		fenetreDeTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetreDeTest.setVisible(true);
	}
	
	@Test
	private void testConstructeur() {
		JFrame fenetreDeTest = new JFrame("Blues du Businessman");
		PanneauDessin testedPanel = new PanneauDessin(400, 400, Color.cyan);
		
		fenetreDeTest.add(testedPanel);
		
		assertEquals(Color.cyan, testedPanel.getBackground());
		assertEquals(new Dimension(400, 400), testedPanel.getPreferredSize());
		
		fenetreDeTest.setLocationRelativeTo(null);
		fenetreDeTest.setSize(500, 300);
		fenetreDeTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetreDeTest.setVisible(true);
	}
	
	PanneauDessinTest() {
		testConstructeurParDefaut();
		testConstructeur();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new PanneauDessinTest();
			}
		});
		
	}
}
