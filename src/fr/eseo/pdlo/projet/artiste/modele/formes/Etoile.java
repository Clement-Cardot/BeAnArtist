package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Shape;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

@SuppressWarnings("serial")
public class Etoile extends Forme implements Remplissable{
	
	private Remplissage remplissage = Remplissage.AUCUNE;
	private Shape formeEtoile;
	private int numRays;

 	public Etoile(Coordonnees position, double diametre, int numRays) {
		super(position, diametre, diametre);
		this.setNumRays(numRays);
		if(diametre < 0) {
			throw new IllegalArgumentException("Valeur négative dans la variable diametre");
		}
	}

	public Etoile(double diametre, int numRays){
        super(diametre, diametre);
        this.setNumRays(numRays);
        if(diametre < 0) {
			throw new IllegalArgumentException("Valeur négative dans la variable diametre");
		}
    }

    public Etoile(Coordonnees position, int numRays){
        super(position);
        this.setNumRays(numRays);
    }

    public Etoile(int numRays){
        super();
        this.setNumRays(numRays);
    }
    
    public void setLargeur(double largeur) {
		super.setHauteur(largeur);
		super.setLargeur(largeur);
	}
	
	public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
	}
    
    public Shape getFormeEtoile() {
		return formeEtoile;
	}

	public void setFormeEtoile(Shape formeEtoile) {
		this.formeEtoile = formeEtoile;
	}
	
	@Override
	public double getCadreMinX() {
		return formeEtoile.getBounds().getMinX();
	}
	
	@Override
	public double getCadreMinY() {
		return formeEtoile.getBounds().getMinY();
	}
	
	@Override
	public double getCadreMaxX() {
		return formeEtoile.getBounds().getMaxX();
	}
	
	@Override
	public double getCadreMaxY() {
		return formeEtoile.getBounds().getMaxY();
	}
	
	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return 0;
	}

	@Override
	public boolean contient(Coordonnees coord) {
		return formeEtoile.contains(coord.getAbscisse(), coord.getOrdonnee());
	}

	@Override
	public Remplissage getRemplissage() {
		return this.remplissage;
	}

	@Override
	public void setRemplissage(Remplissage modeRemplissage) {
		this.remplissage = modeRemplissage;		
	}

	public int getNumRays() {
		return numRays;
	}

	public void setNumRays(int numRays) {
		this.numRays = numRays;
	}

	@Override
	public void deplacerVers(double nouvX, double nouvY) {
		this.getPosition().deplacerVers(nouvX, nouvY);
	}
	
	@Override
	public void deplacerDe(double deltaX, double deltaY) {
		this.getPosition().deplacerDe(deltaX, deltaY);
		
		double centerX = this.getPosition().getAbscisse() + this.getLargeur()/2;
		double centerY = this.getPosition().getOrdonnee() + this.getLargeur()/2;
		double innerRadius = this.getLargeur()/4;
		double outerRadius = this.getLargeur()/2;
		
		Shape newShape = OutilEtoile.createStar(centerX, centerY, innerRadius, outerRadius, this.numRays, 0);
		this.setFormeEtoile(newShape);
	}
}
