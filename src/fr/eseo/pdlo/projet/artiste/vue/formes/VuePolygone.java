package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Polygone;

@SuppressWarnings("serial")
public class VuePolygone extends VueForme{

	public VuePolygone(Polygone polygone) {
		super(polygone);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Color couleurSauvegarde = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		//Fill Etoile
		Polygone polygone = (Polygone) this.getForme();
		if(polygone.getRemplissage() == Remplissage.UNIFORME) {
			g2d.fillPolygon(polygone.getPolygone());
		}
		//Draw Etoile
		g2d.drawPolygon(polygone.getPolygone());
		
		g2d.setColor(couleurSauvegarde);
	}

}
