package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCarre;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilPolygone;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilRectangle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilTrace;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirForme extends AbstractAction {
	
	public static final String NOM_ACTION_LIGNE = (Locale.getDefault().getLanguage().equals("fr"))? "Ligne" : "Line";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_CERCLE = (Locale.getDefault().getLanguage().equals("fr"))? "Cercle" : "Circle";
	public static final String NOM_ACTION_RECTANGLE = "Rectangle";
	public static final String NOM_ACTION_CARRE = (Locale.getDefault().getLanguage().equals("fr"))? "Carre" : "Square";
	public static final String NOM_ACTION_ETOILE = (Locale.getDefault().getLanguage().equals("fr"))? "Etoile" : "Star";
	public static final String NOM_ACTION_POLYGONE = (Locale.getDefault().getLanguage().equals("fr"))? "Polygone" : "Polygon";
	public static final String NOM_ACTION_TRACE = (Locale.getDefault().getLanguage().equals("fr"))? "Trace" : "Plot";
	
	private PanneauDessin panneauDessin;
	
	public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauOutils, String nom) {
		this(panneauDessin, nom);
	}
	
	public ActionChoisirForme(PanneauDessin panneauDessin, String nom) {
		super(nom);
		this.panneauDessin = panneauDessin;		
	}
	
	public void actionPerformed(ActionEvent event) {
		this.forme(event);
		this.formeSym(event);
	}
	
	private void formeSym(ActionEvent event) {
		if (event.getActionCommand() == NOM_ACTION_CERCLE) {
			OutilCercle outilCercle = new OutilCercle();
			this.panneauDessin.associerOutil(outilCercle);
		}
		else if (event.getActionCommand() == NOM_ACTION_CARRE) {
			OutilCarre outilCarre = new OutilCarre();
			this.panneauDessin.associerOutil(outilCarre);
		}
		else if (event.getActionCommand() == NOM_ACTION_ETOILE) {
			this.panneauDessin.dissocierOutil();
			int numRays = Integer.parseInt(JOptionPane.showInputDialog("Nombre de branches ?"));
			OutilEtoile outilEtoile = new OutilEtoile(numRays);
			this.panneauDessin.associerOutil(outilEtoile);
		}
		else if (event.getActionCommand() == NOM_ACTION_POLYGONE) {
			this.panneauDessin.dissocierOutil();
			int numRays = Integer.parseInt(JOptionPane.showInputDialog("Nombre de côtés ?"));
			OutilPolygone outilPolygone = new OutilPolygone(numRays);
			this.panneauDessin.associerOutil(outilPolygone);
		}
	}
	
	private void forme(ActionEvent event) {
		if (event.getActionCommand() == NOM_ACTION_LIGNE) {
			OutilLigne outilLigne = new OutilLigne();
			this.panneauDessin.associerOutil(outilLigne);
		}
		else if (event.getActionCommand() == NOM_ACTION_ELLIPSE) {
			OutilEllipse outilEllipse = new OutilEllipse();
			this.panneauDessin.associerOutil(outilEllipse);
		}
		else if (event.getActionCommand() == NOM_ACTION_RECTANGLE) {
			OutilRectangle outilRectangle = new OutilRectangle();
			this.panneauDessin.associerOutil(outilRectangle);
		}
		else if (event.getActionCommand() == NOM_ACTION_TRACE) {
			OutilTrace outilTrace = new OutilTrace();
			this.panneauDessin.associerOutil(outilTrace);
		}
	}
	
}
