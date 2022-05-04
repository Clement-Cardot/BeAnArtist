package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import java.util.Locale;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionAntiAliasing extends AbstractAction{

	public static final String NOM_ACTION = (Locale.getDefault().getLanguage().equals("fr"))? "Anti-Crénelage" : "Anti-Aliasing";
	private PanneauDessin panneauDessin;
	
	public ActionAntiAliasing(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.panneauDessin.setAntiAliasing(!this.panneauDessin.getAntiAliasing());
		this.panneauDessin.repaint();
	}
}
