package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

@SuppressWarnings("serial")
public class PanneauBarreEtat extends JPanel implements MouseMotionListener{
	
	
	private JLabel valeurX;
	private JLabel valeurY;
	
	private final PanneauDessin panneauDessin;
	
	public PanneauBarreEtat(PanneauDessin panneauDessin){
		this.panneauDessin = panneauDessin;
		this.valeurX = new JLabel("x: 0");
		this.valeurY = new JLabel("y: 0");
		
		this.setLayout(new FlowLayout());
		
		this.add(this.valeurX);
		this.add(this.valeurY);
		
		this.panneauDessin.addMouseMotionListener(this);
		
	}
	
	public void mouseDragged(MouseEvent event) {
		Coordonnees coord = new Coordonnees(event.getX(), event.getY());
		this.mettreAJourAffichage(coord);
	}
	
	public void mouseMoved(MouseEvent event) {
		Coordonnees coord = new Coordonnees(event.getX(), event.getY());
		this.mettreAJourAffichage(coord);
	}
	
	private void mettreAJourAffichage(Coordonnees coord) {
		this.valeurX.setText( "x: " + coord.getAbscisse());
		this.valeurY.setText( "y: " + coord.getOrdonnee());
	}
}
