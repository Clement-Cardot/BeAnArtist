package fr.eseo.pdlo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCarreTest {
	@Test
	private void testConstructeur() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		PanneauDessin panel = new PanneauDessin();
		
		VueCarre testedVueCarre1 = new VueCarre(new Carre(50));
		VueCarre testedVueCarre2 = new VueCarre(new Carre(100));
		VueCarre testedVueCarre3 = new VueCarre(new Carre(150));
		
		panel.ajouterVueForme(testedVueCarre1);
		panel.ajouterVueForme(testedVueCarre2);
		panel.ajouterVueForme(testedVueCarre3);
		
		panel.paintComponents(panel.getGraphics());
		fenetre.add(panel);
		fenetre.setLocationRelativeTo(null);
		fenetre.setSize(500, 300);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}

	
	VueCarreTest() {
		testConstructeur();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new VueCarreTest();
			}
		});
		
	}
}
