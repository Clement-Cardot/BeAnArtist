package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionEffacer extends AbstractAction{
	
	public static final String NOM_ACTION = (Locale.getDefault().getLanguage().equals("fr"))? "Effacer Tout" : "Clear All";
	private final PanneauDessin panneauDessin;
	
	public ActionEffacer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		int confirmation = JOptionPane.showConfirmDialog(panneauDessin, 
										"Voulez vous vraiment suprimmer toutes les formes ?", 
										NOM_ACTION, 
										JOptionPane.YES_NO_OPTION);
		
		if (confirmation == JOptionPane.YES_OPTION) {
			this.panneauDessin.getVueFormes().clear();
			this.panneauDessin.repaint();
		}
	}
}
