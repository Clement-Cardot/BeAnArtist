package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionSelectionner extends AbstractAction{

	public static final String NOM_ACTION = "Selection";
	private final PanneauDessin panneauDessin;
	
	public ActionSelectionner(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		this.panneauDessin.associerOutil(new OutilSelectionner());
	}
}