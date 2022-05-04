package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;

@SuppressWarnings("serial")
public class VueRectangle extends VueForme{

	public VueRectangle(Rectangle rectangle){
		super(rectangle);
	}
	
	public void affiche(Graphics2D g2d) {	
		Color couleurSauvegarde = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		
		int x = (int)Math.round(this.forme.getPosition().getAbscisse());
		int y = (int)Math.round(this.forme.getPosition().getOrdonnee());
		
		int height = (int)Math.round(this.forme.getHauteur());
		int width = (int)Math.round(this.forme.getLargeur());
		
		Rectangle rectangle = (Rectangle) this.getForme();
		if(rectangle.getRemplissage() == Remplissage.UNIFORME) {
			g2d.fillRect(x, y, width, height);
		}

		g2d.drawRect(x, y, width, height);
		
		g2d.setColor(couleurSauvegarde);
	}
}
