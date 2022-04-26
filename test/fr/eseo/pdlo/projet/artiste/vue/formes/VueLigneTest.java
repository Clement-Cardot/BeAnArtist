package fr.eseo.pdlo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {
	@Test
	private void testConstructeur() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		PanneauDessin panel = new PanneauDessin();
		
		VueForme testedVueLigne1 = new VueLigne(new Ligne(200,200));
		VueForme testedVueLigne2 = new VueLigne(new Ligne(new Coordonnees(200,0),-200,200));
		VueForme testedVueLigne3 = new VueLigne(new Ligne(100,200));
		
		panel.ajouterVueForme(testedVueLigne1);
		panel.ajouterVueForme(testedVueLigne2);
		panel.ajouterVueForme(testedVueLigne3);
		
		panel.paintComponents(panel.getGraphics());
		fenetre.add(panel);
		fenetre.setLocationRelativeTo(null);
		fenetre.setSize(500, 300);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}

	
	VueLigneTest() {
		testConstructeur();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new VueLigneTest();
			}
		});
		
	}
}
