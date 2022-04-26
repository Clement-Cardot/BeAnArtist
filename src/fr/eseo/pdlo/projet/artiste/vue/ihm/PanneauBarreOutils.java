package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class PanneauBarreOutils extends JPanel{
	
	private final PanneauDessin panneauDessin;
	
	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		this.setLayout(new BoxLayout(this, 1));
		
		this.initComponents();
	}
	
	private void initComponents() {
		// Effacer Tout
		JButton btnEffacerTout = new JButton(new ActionEffacer(this.panneauDessin));
		this.add(ActionEffacer.NOM_ACTION, btnEffacerTout);
		btnEffacerTout.setName(ActionEffacer.NOM_ACTION);
				
		// Groupe de Bouton Formes
		JLabel forme = new JLabel("Forme :");
		this.add(forme);
		
		ButtonGroup groupeBtn = new ButtonGroup();
		
		ActionChoisirForme actionLigne = new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE);
		ActionChoisirForme actionEllipse = new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE);
		ActionChoisirForme actionCercle = new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE);
		ActionSelectionner actionSelection = new ActionSelectionner(this.panneauDessin);
		
		
		JToggleButton btnLigne = new JToggleButton(actionLigne);
		JToggleButton btnEllipse = new JToggleButton(actionEllipse);
		JToggleButton btnCercle = new JToggleButton(actionCercle);
		JToggleButton btnSelection = new JToggleButton(actionSelection);
		
		
		btnLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		btnEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		btnCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		btnSelection.setName(ActionSelectionner.NOM_ACTION);
		
		groupeBtn.add(btnLigne);
		groupeBtn.add(btnEllipse);
		groupeBtn.add(btnCercle);
		groupeBtn.add(btnSelection);
		
		this.add(ActionChoisirForme.NOM_ACTION_LIGNE, btnLigne);
		this.add(ActionChoisirForme.NOM_ACTION_ELLIPSE, btnEllipse);
		this.add(ActionChoisirForme.NOM_ACTION_CERCLE, btnCercle);
		this.add(ActionSelectionner.NOM_ACTION, btnSelection);
		
		// Choix Couleur
		JLabel couleur = new JLabel("Couleur :");
		this.add(couleur);
		
		JButton btnChoisirCouleur = new JButton(new ActionChoisirCouleur(this.panneauDessin));
		this.add(ActionChoisirCouleur.NOM_ACTION, btnChoisirCouleur);
		btnChoisirCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
		
		// Groupe de Bouton Remplissage
		JLabel remplissage = new JLabel("Remplissage :");
		this.add(remplissage);
		
		ButtonGroup groupeBtnRemplissage = new ButtonGroup();
		
		ActionChoisirModeRemplissage actionRemplissageAucun = new ActionChoisirModeRemplissage(this.panneauDessin, Remplissage.AUCUNE);
		ActionChoisirModeRemplissage actionRemplissageUniforme = new ActionChoisirModeRemplissage(this.panneauDessin, Remplissage.UNIFORME);

		JToggleButton btnAucun = new JToggleButton(actionRemplissageAucun);
		JToggleButton btnUniforme = new JToggleButton(actionRemplissageUniforme);
		
		groupeBtnRemplissage.add(btnAucun);
		groupeBtnRemplissage.add(btnUniforme);
		
		btnAucun.doClick();

		this.add(Remplissage.AUCUNE.getMode(), btnAucun);
		this.add(Remplissage.UNIFORME.getMode(), btnUniforme);

		

	}
}
