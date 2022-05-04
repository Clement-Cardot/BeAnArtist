package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirModeRemplissage extends AbstractAction{

	private final PanneauDessin panneauDessin;
	
	public ActionChoisirModeRemplissage(PanneauDessin panneauDessin, Remplissage remplissage) {
		super(remplissage.getMode());
		this.panneauDessin = panneauDessin;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Remplissage.AUCUNE.getMode())){
			this.panneauDessin.setModeRemplissageCourant(Remplissage.AUCUNE);

		}
		else if (e.getActionCommand().equals(Remplissage.UNIFORME.getMode())) {
			this.panneauDessin.setModeRemplissageCourant(Remplissage.UNIFORME);

		}
	}

	
}
