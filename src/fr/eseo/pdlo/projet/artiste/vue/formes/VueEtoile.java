package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Etoile;

@SuppressWarnings("serial")
public class VueEtoile extends VueForme{

	public VueEtoile(Etoile etoile) {
		super(etoile);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Color couleurSauvegarde = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		//Fill Etoile
		Etoile etoile = (Etoile) this.getForme();
		if(etoile.getRemplissage() == Remplissage.UNIFORME) {
			g2d.fill(etoile.getFormeEtoile());
		}
		//Draw Etoile
		g2d.draw(etoile.getFormeEtoile());
		
		g2d.setColor(couleurSauvegarde);
	}

}
