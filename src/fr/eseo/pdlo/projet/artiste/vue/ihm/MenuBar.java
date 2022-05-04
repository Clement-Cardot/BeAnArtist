package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.util.Locale;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionAntiAliasing;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionExporter;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionOuvrir;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSauvegarder;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionnerExtension;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar{
	
	private JMenu fileMenu;
	private JMenuItem enregistrerItem, effacertoutItem, sauvegarderItem, ouvrirItem;
	
	private JMenu selectionMenu;
	
	private JMenu formeMenu;
	private JMenuItem ligneItem, ellipseItem, cercleItem, rectangleItem, carreItem, etoileItem, polygoneItem;
	
	private JMenu remplissageMenu;
	private JMenuItem aucuneItem, uniformeItem;
	
	private JMenu affichageMenu;
	private JMenuItem antialiasingItem;
	
	private PanneauDessin panneauDessin;
	
	public MenuBar(PanneauDessin panneauDessin) {
		super();
		
		this.panneauDessin = panneauDessin;
		
		this.initFileMenu();
		this.initSelectionMenu();
		this.initFormeMenu();
		this.initRemplissageMenu();
		this.initAffichageMenu();
	}
	
	private void initFileMenu() {
		if(Locale.getDefault().getLanguage().equals("fr")) {
			this.fileMenu = new JMenu("Fichier");
		}
		else if(Locale.getDefault().getLanguage().equals("en")) {
			this.fileMenu = new JMenu("File");
		}
		
		this.ouvrirItem = new JMenuItem(new ActionOuvrir(this.panneauDessin));
		this.sauvegarderItem = new JMenuItem(new ActionSauvegarder(this.panneauDessin));
		this.enregistrerItem = new JMenuItem(new ActionExporter(this.panneauDessin));
		this.effacertoutItem = new JMenuItem(new ActionEffacer(this.panneauDessin));
		
		this.fileMenu.add(this.ouvrirItem);
		this.fileMenu.add(this.sauvegarderItem);
		this.fileMenu.add(this.enregistrerItem);
		this.fileMenu.add(this.effacertoutItem);
		
		this.add(fileMenu);
	}
	
	private void initSelectionMenu() {
		if(Locale.getDefault().getLanguage().equals("fr")) {
			this.selectionMenu = new JMenu("Selectionner");
		}
		else if(Locale.getDefault().getLanguage().equals("en")) {
			this.selectionMenu = new JMenu("Select");
		}
		
		this.selectionMenu.addMenuListener(new ActionSelectionnerExtension(this.panneauDessin));
		this.add(this.selectionMenu);
	}
	
	private void initFormeMenu() {
		if(Locale.getDefault().getLanguage().equals("fr")) {
			this.formeMenu = new JMenu("Formes");
		}
		else if(Locale.getDefault().getLanguage().equals("en")) {
			this.formeMenu = new JMenu("Shapes");
		}
		
		this.ligneItem = new JMenuItem(new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_LIGNE));
		this.rectangleItem = new JMenuItem(new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_RECTANGLE));
		this.carreItem = new JMenuItem(new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_CARRE));
		this.ellipseItem = new JMenuItem(new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_ELLIPSE));
		this.cercleItem = new JMenuItem(new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_CERCLE));
		this.etoileItem = new JMenuItem(new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_ETOILE));
		this.polygoneItem = new JMenuItem(new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_POLYGONE));

		this.formeMenu.add(ligneItem);
		this.formeMenu.add(rectangleItem);
		this.formeMenu.add(carreItem);
		this.formeMenu.add(ellipseItem);
		this.formeMenu.add(cercleItem);
		this.formeMenu.add(etoileItem);
		this.formeMenu.add(polygoneItem);
		
		this.add(formeMenu);
	}
		
	private void initRemplissageMenu() {
		if(Locale.getDefault().getLanguage().equals("fr")) {
			this.remplissageMenu = new JMenu("Remplissage");
		}
		else if(Locale.getDefault().getLanguage().equals("en")) {
			this.remplissageMenu = new JMenu("Filling");
		}
		
		this.aucuneItem = new JMenuItem(new ActionChoisirModeRemplissage(this.panneauDessin, Remplissage.AUCUNE));
		this.uniformeItem = new JMenuItem(new ActionChoisirModeRemplissage(this.panneauDessin, Remplissage.UNIFORME));
		
		this.remplissageMenu.add(aucuneItem);
		this.remplissageMenu.add(uniformeItem);
		
		this.add(this.remplissageMenu);
	}
	
	private void initAffichageMenu() {
		if(Locale.getDefault().getLanguage().equals("fr")) {
			this.affichageMenu = new JMenu("Affichage");
		}
		else if(Locale.getDefault().getLanguage().equals("en")) {
			this.affichageMenu = new JMenu("Display");
		}
		
		this.antialiasingItem = new JMenuItem(new ActionAntiAliasing(this.panneauDessin));
		
		this.affichageMenu.add(antialiasingItem);
		
		this.add(affichageMenu);
	}

}
