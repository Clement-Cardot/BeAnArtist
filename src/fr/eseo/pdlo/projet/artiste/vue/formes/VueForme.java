package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Graphics2D;
import java.io.Serializable;

import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;

@SuppressWarnings("serial")
public abstract class VueForme implements Serializable{
	
	protected final Forme forme;
	
	public VueForme(Forme forme){
		this.forme = forme;
	}
	
	public Forme getForme() {
		return this.forme;
	}
	
	public abstract void affiche(Graphics2D g2d);

}
