package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme{
	
	protected VueForme creerVueForme() {
		double largeur;
		double hauteur;
		if(this.getDebut().getAbscisse() == this.getFin().getAbscisse() && this.getDebut().getOrdonnee() == this.getFin().getOrdonnee()) {
			largeur = Ligne.LARGEUR_PAR_DEFAUT;
			hauteur = Ligne.HAUTEUR_PAR_DEFAUT;
		}
		else {
			largeur = this.getFin().getAbscisse() - this.getDebut().getAbscisse();
			hauteur = this.getFin().getOrdonnee() - this.getDebut().getOrdonnee();
		}
		return new VueLigne(new Ligne(this.getDebut(), largeur, hauteur));
	}
}
