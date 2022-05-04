package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionnerExtension;

@SuppressWarnings("serial")
public class BarreOutils extends JToolBar{

	private final PanneauDessin panneauDessin;
	static private final int ICON_WIDTH = 20;
	static private final int ICON_HEIGHT = 20;
	
	ColorChooserButton btnCouleur;
	
	JToggleButton btnLigne;
	JToggleButton btnEllipse;
	JToggleButton btnCercle;
	JToggleButton btnRectangle;
	JToggleButton btnCarre;
	JToggleButton btnEtoile;
	JToggleButton btnPolygone;
	JToggleButton btnTrace;
	JToggleButton btnSelection;
	
	public BarreOutils(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		this.setLayout(new GridLayout(2, 5));
		
		this.initComponents();
	}
	
	private void initComponents() {
		this.initFormes();
		
		
		this.add(this.btnSelection);
		this.add(this.btnCarre);
		this.add(this.btnCercle);
		this.add(this.btnEtoile);
		this.add(this.btnCouleur);  
		this.add(this.btnLigne);
		this.add(this.btnRectangle);
		this.add(this.btnEllipse);
		this.add(this.btnPolygone);
		this.add(this.btnTrace);
	}
	
	private void initFormes() {
		
		this.btnCouleur = new ColorChooserButton(Color.white);
		btnCouleur.addColorChangedListener(new ActionChoisirCouleur(this.panneauDessin));
		
		ButtonGroup groupeBtn = new ButtonGroup();
		
		// Définitions des formes
		ActionChoisirForme actionLigne = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_LIGNE);
		ActionChoisirForme actionEllipse = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_ELLIPSE);
		ActionChoisirForme actionCercle = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_CERCLE);
		ActionChoisirForme actionRectangle = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_RECTANGLE);
		ActionChoisirForme actionCarre = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_CARRE);
		ActionChoisirForme actionEtoile = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_ETOILE);
		ActionChoisirForme actionPolygone = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_POLYGONE);
		ActionChoisirForme actionTrace = new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_TRACE);
		ActionSelectionnerExtension actionSelection = new ActionSelectionnerExtension(this.panneauDessin);
		
		// Définitions des Boutons Associés
		this.btnLigne = new JToggleButton(actionLigne);
		this.btnEllipse = new JToggleButton(actionEllipse);
		this.btnCercle = new JToggleButton(actionCercle);
		this.btnRectangle = new JToggleButton(actionRectangle);
		this.btnCarre = new JToggleButton(actionCarre);
		this.btnEtoile = new JToggleButton(actionEtoile);
		this.btnPolygone = new JToggleButton(actionPolygone);
		this.btnTrace = new JToggleButton(actionTrace);
		this.btnSelection = new JToggleButton(actionSelection);
		
		// Charger les Icones		
		ImageIcon imgSelection = new ImageIcon ( new ImageIcon("./img/Selection.png")
				.getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH));
		ImageIcon imgCarre = new ImageIcon ( new ImageIcon("./img/Carre.png")
				.getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH));
		ImageIcon imgCercle = new ImageIcon ( new ImageIcon("./img/Cercle.png")
				.getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH));
		ImageIcon imgEtoile = new ImageIcon ( new ImageIcon("./img/Etoile.png")
				.getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH));
		ImageIcon imgLigne = new ImageIcon ( new ImageIcon("./img/Ligne.png")
				.getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH));
		ImageIcon imgRectangle = new ImageIcon ( new ImageIcon("./img/Rectangle.png")
				.getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH));
		ImageIcon imgEllipse = new ImageIcon ( new ImageIcon("./img/Ellipse.png")
				.getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH));
		ImageIcon imgPolygone = new ImageIcon ( new ImageIcon("./img/Polygone.png")
				.getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH));
		ImageIcon imgTrace = new ImageIcon ( new ImageIcon("./img/Trace.png")
				.getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH));
		
		// Applique à chaque btn l'icone associé
		btnLigne.setIcon(imgLigne);
		btnEllipse.setIcon(imgEllipse);
		btnCercle.setIcon(imgCercle);
		btnRectangle.setIcon(imgRectangle);
		btnCarre.setIcon(imgCarre);
		btnEtoile.setIcon(imgEtoile);
		btnPolygone.setIcon(imgPolygone);
		btnTrace.setIcon(imgTrace);
		btnSelection.setIcon(imgSelection);
		
		groupeBtn.add(this.btnLigne);
		groupeBtn.add(this.btnEllipse);
		groupeBtn.add(this.btnCercle);
		groupeBtn.add(this.btnRectangle);
		groupeBtn.add(this.btnCarre);
		groupeBtn.add(this.btnEtoile);
		groupeBtn.add(this.btnPolygone);
		groupeBtn.add(this.btnTrace);
		groupeBtn.add(this.btnSelection);
		
	}

}
