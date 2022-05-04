package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.util.ArrayList;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

@SuppressWarnings("serial")
public class Trace extends Forme{

	public static final double EPSILON = 5;
	private ArrayList<Coordonnees> pixels;
	
	public Trace() {
		super();
		this.pixels = new ArrayList<Coordonnees>();
	}
	
	public ArrayList<Coordonnees> getPixels() {
		return pixels;
	}
	
	public void setPixels(ArrayList<Coordonnees> pixels) {
		this.pixels = pixels;
	}
	


	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return 0;
	}

	public double perimetre(Coordonnees c1, Coordonnees c2) {
		double largeur = c2.getAbscisse()- c1.getAbscisse();
		double hauteur = c2.getOrdonnee()- c1.getOrdonnee();
		return Math.sqrt(Math.pow(largeur, 2) + Math.pow(hauteur, 2));
	}
	
	@Override
	public boolean contient(Coordonnees coordonnees) {
		for(int i = 0; i < this.pixels.size()-1; i++) {
			Coordonnees c1 = this.pixels.get(i);
			Coordonnees c2 = this.pixels.get(i+1);
			double distanceC1 = Math.abs(c1.distanceVers(coordonnees));
			double distanceC2 = Math.abs(c2.distanceVers(coordonnees));
			if (distanceC1 + distanceC2 - this.perimetre(c1, c2) <= EPSILON) {
				return true;
			}
		}
		return false;
	}

	@Override
	public double getCadreMinX() {
		double minX = 99999;
		for(Coordonnees pixel : this.pixels) {
			if(pixel.getAbscisse() < minX) minX = pixel.getAbscisse();
		}
		return minX;
	}
	
	@Override
	public double getCadreMinY() {
		double minY = 99999;
		for(Coordonnees pixel : this.pixels) {
			if(pixel.getOrdonnee() < minY) minY = pixel.getOrdonnee();
		}
		return minY;	
	}
	
	@Override
	public double getCadreMaxX() {
		double maxX = 0;
		for(Coordonnees pixel : this.pixels) {
			if(pixel.getAbscisse() > maxX) maxX = pixel.getAbscisse();
		}
		return maxX;
	}
	
	@Override
	public double getCadreMaxY() {
		double maxY = 0;
		for(Coordonnees pixel : this.pixels) {
			if(pixel.getOrdonnee() > maxY) maxY = pixel.getOrdonnee();
		}
		return maxY;
	}
	
	@Override
	public void deplacerVers(double nouvX, double nouvY) {
		this.getPosition().deplacerVers(nouvX, nouvY);
		for(Coordonnees pixel : this.pixels) {
			pixel.deplacerDe(nouvX - pixel.getAbscisse(), nouvY - pixel.getOrdonnee());
		}
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		this.getPosition().deplacerDe(deltaX, deltaY);
		for(Coordonnees pixel : this.pixels) {
			pixel.deplacerDe(deltaX, deltaY);
		}
	}
}
