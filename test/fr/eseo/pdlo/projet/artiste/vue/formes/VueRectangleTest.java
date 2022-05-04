package fr.eseo.pdlo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueRectangleTest {
	@Test
	private void testConstructeur() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		PanneauDessin panel = new PanneauDessin();
		
		VueRectangle testedVueRectangle1 = new VueRectangle(new Rectangle(200,100));
		VueRectangle testedVueRectangle2 = new VueRectangle(new Rectangle(new Coordonnees(200,0),20,250));
		VueRectangle testedVueRectangle3 = new VueRectangle(new Rectangle(100,200));
		
		panel.ajouterVueForme(testedVueRectangle1);
		panel.ajouterVueForme(testedVueRectangle2);
		panel.ajouterVueForme(testedVueRectangle3);
		
		panel.paintComponents(panel.getGraphics());
		fenetre.add(panel);
		fenetre.setLocationRelativeTo(null);
		fenetre.setSize(500, 300);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	
	VueRectangleTest() {
		testConstructeur();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new VueRectangleTest();
			}
		});
		
	}
}
