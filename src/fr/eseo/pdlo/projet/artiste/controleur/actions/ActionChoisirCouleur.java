package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.pdlo.projet.artiste.vue.ihm.ColorChooserButton.ColorChangedListener;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirCouleur extends AbstractAction implements ColorChangedListener{

	public static final String NOM_ACTION = (Locale.getDefault().getLanguage().equals("fr"))? "Choisir Couleur" : "Choose Color";
	private final PanneauDessin panneauDessin;
	
	public ActionChoisirCouleur(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent e) {
		Color couleurChoisie = JColorChooser.showDialog(this.panneauDessin, NOM_ACTION, this.panneauDessin.getCouleurCourante());
		this.panneauDessin.setCouleurCourante(couleurChoisie);
	}

	/*
	@Override
	public void menuSelected(MenuEvent e) {
		Color couleurChoisie = JColorChooser.showDialog(this.panneauDessin, NOM_ACTION, this.panneauDessin.getCouleurCourante());
		this.panneauDessin.setCouleurCourante(couleurChoisie);
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	*/
	
	@Override
	public void colorChanged(Color newColor) {
		this.panneauDessin.setCouleurCourante(newColor);
	}

}
