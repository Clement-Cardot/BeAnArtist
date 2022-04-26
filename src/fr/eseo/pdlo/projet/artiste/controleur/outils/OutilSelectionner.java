package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;

public class OutilSelectionner extends Outil{
	
	private Forme formeSelectionnee;
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(this.getPanneauDessin().getVueFormes().isEmpty()) {
			// System.out.println("Il n'y a pas de forme ici !");
		}
		else {
			for(int i = this.getPanneauDessin().getVueFormes().size() - 1; i >= 0; i--) {
				if(this.getPanneauDessin().getVueFormes().get(i).getForme().contient(new Coordonnees(event.getX(), event.getY()))) {
					formeSelectionnee = this.getPanneauDessin().getVueFormes().get(i).getForme();
					break;
				}
			}
			if(formeSelectionnee != null) {
				JOptionPane.showMessageDialog(this.getPanneauDessin(), 
							(Object) formeSelectionnee.toString(), 
							ActionSelectionner.NOM_ACTION, 
							JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}