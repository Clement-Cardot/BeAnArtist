package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionAntiAliasing;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionExporter;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionnerExtension;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

@SuppressWarnings("serial")
public class PanneauBarreOutilsExtension extends JPanel{
	
	private final PanneauDessin panneauDessin;
	
	public PanneauBarreOutilsExtension(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		this.setLayout(new BoxLayout(this, 1));
		
		this.initComponents();
	}
	
	private void initComponents() {
		this.initEffacerTout();
		this.initChoixForme();
		this.initChoixCouleur();	
		this.initChoixRemplissage();
		this.initAntiAliasSetting();
		this.initExporterTool();
	}
	
	private void initEffacerTout() {
		// Effacer Tout
		JButton btnEffacerTout = new JButton(new ActionEffacer(this.panneauDessin));
		this.add(ActionEffacer.NOM_ACTION, btnEffacerTout);
		btnEffacerTout.setName(ActionEffacer.NOM_ACTION);
	}
	
	private void initChoixForme(){
		// Groupe de Bouton Formes
		JLabel forme = new JLabel("Forme :");
		this.add(forme);
		
		ButtonGroup groupeBtn = new ButtonGroup();
		// Définitions des formes
		ActionChoisirForme actionLigne = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_LIGNE);
		ActionChoisirForme actionEllipse = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_ELLIPSE);
		ActionChoisirForme actionCercle = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_CERCLE);
		ActionChoisirForme actionRectangle = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_RECTANGLE);
		ActionChoisirForme actionCarre = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_CARRE);
		ActionChoisirForme actionEtoile = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_ETOILE);
		ActionSelectionnerExtension actionSelection = new ActionSelectionnerExtension(this.panneauDessin);
		// Définitions des Boutons Associés
		JToggleButton btnLigne = new JToggleButton(actionLigne);
		JToggleButton btnEllipse = new JToggleButton(actionEllipse);
		JToggleButton btnCercle = new JToggleButton(actionCercle);
		JToggleButton btnRectangle = new JToggleButton(actionRectangle);
		JToggleButton btnCarre = new JToggleButton(actionCarre);
		JToggleButton btnEtoile = new JToggleButton(actionEtoile);
		JToggleButton btnSelection = new JToggleButton(actionSelection);
		
		// Applique à chaque btn le nom associé
		btnLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		btnEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		btnCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		btnRectangle.setName(ActionChoisirForme.NOM_ACTION_RECTANGLE);
		btnCarre.setName(ActionChoisirForme.NOM_ACTION_CARRE);
		btnEtoile.setName(ActionChoisirForme.NOM_ACTION_ETOILE);
		btnSelection.setName(ActionSelectionner.NOM_ACTION);
		
		groupeBtn.add(btnLigne);
		groupeBtn.add(btnEllipse);
		groupeBtn.add(btnCercle);
		groupeBtn.add(btnRectangle);
		groupeBtn.add(btnCarre);
		groupeBtn.add(btnEtoile);
		groupeBtn.add(btnSelection);
		
		this.add(ActionChoisirForme.NOM_ACTION_LIGNE, btnLigne);
		this.add(ActionChoisirForme.NOM_ACTION_ELLIPSE, btnEllipse);
		this.add(ActionChoisirForme.NOM_ACTION_CERCLE, btnCercle);
		this.add(ActionChoisirForme.NOM_ACTION_RECTANGLE, btnRectangle);
		this.add(ActionChoisirForme.NOM_ACTION_CARRE, btnCarre);
		this.add(ActionChoisirForme.NOM_ACTION_ETOILE, btnEtoile);
		this.add(ActionSelectionner.NOM_ACTION, btnSelection);
	}
	
	private void initChoixCouleur() {
		// Choix Couleur
		JLabel couleur = new JLabel("Couleur :");
		this.add(couleur);
		
		JButton btnChoisirCouleur = new JButton(new ActionChoisirCouleur(this.panneauDessin));
		this.add(ActionChoisirCouleur.NOM_ACTION, btnChoisirCouleur);
		btnChoisirCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
	}
	
	private void initChoixRemplissage() {
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

	private void initAntiAliasSetting() {
		JLabel remplissage = new JLabel("Anti-aliasing :");
		this.add(remplissage);
		
		ActionAntiAliasing actionAntiAliasing = new ActionAntiAliasing(this.panneauDessin);
		
		JToggleButton btnAntiAliasing = new JToggleButton(actionAntiAliasing);
		this.add(ActionAntiAliasing.NOM_ACTION, btnAntiAliasing);
	}
	
	private void initExporterTool() {
		ActionExporter actionExporter = new ActionExporter(this.panneauDessin);
		JButton btnExporter = new JButton(actionExporter);
		this.add(btnExporter);
		btnExporter.setName(ActionExporter.NOM_ACTION);
	}

}
