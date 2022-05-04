package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilSelectionnerExtension;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionSelectionnerExtension extends AbstractAction implements MenuListener{

	public static final String NOM_ACTION = (Locale.getDefault().getLanguage().equals("fr"))? "Selection" : "Select";
	private final PanneauDessin panneauDessin;
	
	public ActionSelectionnerExtension(PanneauDessin panneauDessin) {
		super();
		this.panneauDessin = panneauDessin;
		if(Locale.getDefault().getLanguage().equals("fr")) {
			this.putValue(Action.NAME, NOM_ACTION);
		}
		else if(Locale.getDefault().getLanguage().equals("en")) {
			this.putValue(Action.NAME, "Select");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		OutilSelectionnerExtension outil = new OutilSelectionnerExtension();
		this.panneauDessin.associerOutil(outil);
	}

	@Override
	public void menuSelected(MenuEvent e) {
		this.panneauDessin.associerOutil(new OutilSelectionnerExtension());
	}

	@Override
	public void menuDeselected(MenuEvent e) {
	}

	@Override
	public void menuCanceled(MenuEvent e) {
	}



}
