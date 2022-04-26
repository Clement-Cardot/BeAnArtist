package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends AbstractAction {
	
	public static final String NOM_ACTION_LIGNE = "Ligne";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_CERCLE = "Cercle";
	
	private PanneauDessin panneauDessin;
	
	public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauOutils, String nom) {
		super(nom);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == NOM_ACTION_LIGNE) {
			OutilLigne outilLigne = new OutilLigne();
			this.panneauDessin.associerOutil(outilLigne);
		}
		else if (event.getActionCommand() == NOM_ACTION_ELLIPSE) {
			OutilEllipse outilEllipse = new OutilEllipse();
			this.panneauDessin.associerOutil(outilEllipse);
		}
		else if (event.getActionCommand() == NOM_ACTION_CERCLE) {
			OutilCercle outilCercle = new OutilCercle();
			this.panneauDessin.associerOutil(outilCercle);
		}
		else {
			System.out.println(event.paramString());
		}
	}
	
}
