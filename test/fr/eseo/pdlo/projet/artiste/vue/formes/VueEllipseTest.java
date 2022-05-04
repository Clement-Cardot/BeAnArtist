package fr.eseo.pdlo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {
	@Test
	private void testConstructeur() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		PanneauDessin panel = new PanneauDessin();
		
		VueEllipse testedVueEllipse1 = new VueEllipse(new Ellipse(200,200));
		VueEllipse testedVueEllipse2 = new VueEllipse(new Ellipse(new Coordonnees(200,0),20,200));
		VueEllipse testedVueEllipse3 = new VueEllipse(new Ellipse(100,200));
		
		panel.ajouterVueForme(testedVueEllipse1);
		panel.ajouterVueForme(testedVueEllipse2);
		panel.ajouterVueForme(testedVueEllipse3);
		
		panel.paintComponents(panel.getGraphics());
		fenetre.add(panel);
		fenetre.setLocationRelativeTo(null);
		fenetre.setSize(500, 300);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	

	
	VueEllipseTest() {
		testConstructeur();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new VueEllipseTest();
			}
		});
		
	}
}
