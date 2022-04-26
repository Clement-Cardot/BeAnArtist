package fr.eseo.pdlo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {
	@Test
	private void testConstructeur() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		PanneauDessin panel = new PanneauDessin();
		
		VueCercle testedVueCercle1 = new VueCercle(new Cercle(50));
		VueCercle testedVueCercle2 = new VueCercle(new Cercle(100));
		VueCercle testedVueCercle3 = new VueCercle(new Cercle(150));
		
		panel.ajouterVueForme(testedVueCercle1);
		panel.ajouterVueForme(testedVueCercle2);
		panel.ajouterVueForme(testedVueCercle3);
		
		panel.paintComponents(panel.getGraphics());
		fenetre.add(panel);
		fenetre.setLocationRelativeTo(null);
		fenetre.setSize(500, 300);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}

	
	VueCercleTest() {
		testConstructeur();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new VueCercleTest();
			}
		});
		
	}
}
