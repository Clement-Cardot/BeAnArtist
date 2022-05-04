package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.Shape;
import java.awt.geom.Path2D;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Etoile;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilEtoile extends OutilForme{
	private int numRays;
	
	public OutilEtoile(int numRays) {
		super();
		this.numRays = numRays;
	}
	
	@Override
	public VueForme creerVueForme() {
		double diametre;
		double largeur;
		double hauteur;
		Coordonnees position = this.getDebut();
		
		if(this.getDebut().getAbscisse() == this.getFin().getAbscisse() && this.getDebut().getOrdonnee() == this.getFin().getOrdonnee()) {
			diametre = Etoile.LARGEUR_PAR_DEFAUT;
		}
		else {
			diametre = Math.max(Math.abs(this.getFin().getAbscisse() - this.getDebut().getAbscisse()) , 
					   Math.abs(this.getFin().getOrdonnee() - this.getDebut().getOrdonnee()));
			
			largeur = this.getFin().getAbscisse() - this.getDebut().getAbscisse();		
			hauteur = this.getFin().getOrdonnee() - this.getDebut().getOrdonnee();
			
			double abscisse;
			double ordonnee;
			
			if( hauteur < 0) {
				ordonnee = this.getFin().getOrdonnee();
			}
			else ordonnee = this.getDebut().getOrdonnee();
			
			if( largeur < 0) {
				abscisse = this.getFin().getAbscisse();
			}
			else abscisse = this.getDebut().getAbscisse();
			
			position = new Coordonnees(abscisse, ordonnee);
			
			
		}
		
		Etoile etoile = new Etoile(position, diametre, this.numRays);
		double centerX = position.getAbscisse() + diametre/2;
		double centerY = position.getOrdonnee() + diametre/2;
		double innerRadius = diametre/4;
		double outerRadius = diametre/2;
		
		etoile.setFormeEtoile(createStar(centerX, centerY, innerRadius, outerRadius, this.numRays, 0));
		etoile.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		return new VueEtoile(etoile);
	}
	
	public static Shape createStar(double centerX, double centerY, double innerRadius, 
									double outerRadius, int numRays, double startAngleRad){
		
	        Path2D path = new Path2D.Double();
	        double deltaAngleRad = Math.PI / numRays;
	        for (int i = 0; i < numRays * 2; i++)
	        {
	            double angleRad = startAngleRad + i * deltaAngleRad;
	            double ca = Math.cos(angleRad);
	            double sa = Math.sin(angleRad);
	            double relX = ca;
	            double relY = sa;
	            if ((i & 1) == 0)
	            {
	                relX *= outerRadius;
	                relY *= outerRadius;
	            }
	            else
	            {
	                relX *= innerRadius;
	                relY *= innerRadius;
	            }
	            if (i == 0)
	            {
	                path.moveTo(centerX + relX, centerY + relY);
	            }
	            else
	            {
	                path.lineTo(centerX + relX, centerY + relY);
	            }
	        }
	        path.closePath();
	        return path;
	    }

}
