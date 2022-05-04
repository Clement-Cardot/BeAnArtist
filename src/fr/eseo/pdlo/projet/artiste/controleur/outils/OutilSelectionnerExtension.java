package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.Color;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.modele.formes.Etoile;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.modele.formes.Polygone;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueRectangle;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.keyboard.event.GlobalKeyListener;

public class OutilSelectionnerExtension extends Outil implements GlobalKeyListener{
	
	private VueForme vueFormeSelectionnee;
	private VueRectangle vueCadre;
	private VueCercle[] vuePoints = new VueCercle[4];
	private int anchor = -1;
	public GlobalKeyboardHook keyboardHook;
	
	public OutilSelectionnerExtension() {
		this.keyboardHook = new GlobalKeyboardHook(true);
		this.keyboardHook.addKeyListener(this);
	}
	
	public VueForme getVueFormeSelectionne() {
		return this.vueFormeSelectionnee;
	}
	
 	private void afficheCadre() {
		// Affiche un cadre autour de la forme
		Rectangle cadre = new Rectangle(new Coordonnees(vueFormeSelectionnee.getForme().getCadreMinX(),
												vueFormeSelectionnee.getForme().getCadreMinY()),
									Math.abs(vueFormeSelectionnee.getForme().getLargeur()), 
									Math.abs(vueFormeSelectionnee.getForme().getHauteur()));
		this.vueCadre = new VueRectangle(cadre);
		this.getPanneauDessin().ajouterVueForme(vueCadre);
		this.vueCadre.getForme().setCouleur(Color.red);
		
		//Affiche des points aux quatres coins du cadre pour modifier les dimensions
		int rayonPoint = 3;
		
		Coordonnees c1Pos = new Coordonnees(cadre.getCadreMinX() - rayonPoint, cadre.getCadreMinY() - rayonPoint);
		Coordonnees c2Pos = new Coordonnees(cadre.getCadreMaxX() - rayonPoint, cadre.getCadreMinY() - rayonPoint);
		Coordonnees c3Pos = new Coordonnees(cadre.getCadreMinX() - rayonPoint, cadre.getCadreMaxY() - rayonPoint);
		Coordonnees c4Pos = new Coordonnees(cadre.getCadreMaxX() - rayonPoint, cadre.getCadreMaxY() - rayonPoint);
		
		Cercle c1 = new Cercle(c1Pos, rayonPoint*2);
		Cercle c2 = new Cercle(c2Pos, rayonPoint*2);
		Cercle c3 = new Cercle(c3Pos, rayonPoint*2);
		Cercle c4 = new Cercle(c4Pos, rayonPoint*2);
		
		c1.setRemplissage(Remplissage.UNIFORME);
		c2.setRemplissage(Remplissage.UNIFORME);
		c3.setRemplissage(Remplissage.UNIFORME);
		c4.setRemplissage(Remplissage.UNIFORME);
		
		c1.setCouleur(Color.red);
		c2.setCouleur(Color.red);
		c3.setCouleur(Color.red);
		c4.setCouleur(Color.red);
		
		this.vuePoints[0] = new VueCercle(c1);
		this.vuePoints[1] = new VueCercle(c2);
		this.vuePoints[2] = new VueCercle(c3);
		this.vuePoints[3] = new VueCercle(c4);
		
		this.getPanneauDessin().getVueFormes().add(this.vuePoints[0]);
		this.getPanneauDessin().getVueFormes().add(this.vuePoints[1]);
		this.getPanneauDessin().getVueFormes().add(this.vuePoints[2]);
		this.getPanneauDessin().getVueFormes().add(this.vuePoints[3]);
		
		this.getPanneauDessin().repaint();
	}
	
	//Affiche les points d'une Ligne
	private void affichePoints() {
		
		int rayonPoint = 3;
		
		Ligne l = (Ligne) this.vueFormeSelectionnee.getForme();
		
		Coordonnees c1Pos = new Coordonnees(l.getC1().getAbscisse() - rayonPoint, l.getC1().getOrdonnee() - rayonPoint);
		Coordonnees c2Pos = new Coordonnees(l.getC2().getAbscisse() - rayonPoint, l.getC2().getOrdonnee() - rayonPoint);
		
		Cercle c1 = new Cercle(c1Pos, rayonPoint*2);
		Cercle c2 = new Cercle(c2Pos, rayonPoint*2);
		
		c1.setRemplissage(Remplissage.UNIFORME);
		c2.setRemplissage(Remplissage.UNIFORME);
		
		c1.setCouleur(Color.red);
		c2.setCouleur(Color.red);

		this.vuePoints[0] = new VueCercle(c1);
		this.vuePoints[1] = new VueCercle(c2);
		
		this.getPanneauDessin().getVueFormes().add(this.vuePoints[0]);
		this.getPanneauDessin().getVueFormes().add(this.vuePoints[1]);
		
		this.getPanneauDessin().repaint();
	}
	
	public void selectionNouvelleForme() {
		effacerAncienCadre();
		if(vueFormeSelectionnee.getClass().getSimpleName().equals("VueLigne")) {
			this.affichePoints();
		}
		else {
			this.afficheCadre();
		}
		this.getPanneauDessin().getVueFormes().remove(this.vueFormeSelectionnee);
		this.getPanneauDessin().getVueFormes().add(this.vueFormeSelectionnee);
	}
	
	public void effacerAncienCadre() {
		if(this.vueFormeSelectionnee != null) {
			this.getPanneauDessin().getVueFormes().remove(this.vueCadre);
			this.getPanneauDessin().getVueFormes().remove(this.vuePoints[0]);
			this.getPanneauDessin().getVueFormes().remove(this.vuePoints[1]);
			this.getPanneauDessin().getVueFormes().remove(this.vuePoints[2]);
			this.getPanneauDessin().getVueFormes().remove(this.vuePoints[3]);
			this.getPanneauDessin().repaint();
		}
	}
	
	private void cornerSelected() {
		this.anchor = -1;
		
		int vuePointLenght = (this.vueFormeSelectionnee.getClass().getSimpleName().equals("VueLigne"))? 2:4;
		
		for(int i = 0; i < vuePointLenght; i++) {
			if(this.vuePoints[i].getForme().contient(this.getDebut())){
				this.anchor = i;
			}
		}
	}
	
	private double calculDelta0(double deltaX, double deltaY) {
		double delta = (Math.abs(deltaX) > Math.abs(deltaY))? deltaX : deltaY;
		return delta;
	}
	
	private double calculDelta1(double deltaX, double deltaY) {
		double delta = (Math.abs(deltaX) > Math.abs(deltaY))? -deltaX : deltaY;
		return delta;
	}
	
	private double calculDelta2(double deltaX, double deltaY) {
		double delta = (Math.abs(deltaX) > Math.abs(deltaY))? deltaX : -deltaY;
		return delta;
	}
	
	private double calculDelta3(double deltaX, double deltaY) {
		double delta = (Math.abs(deltaX) > Math.abs(deltaY))? -deltaX : -deltaY;
		return delta;
	}
	
	private void redimensionnerCarreCercle(double deltaX, double deltaY) {
		double delta = 0;
		
		switch(this.anchor) {
			case 0:
				delta = calculDelta0(deltaX, deltaY);
				this.vueFormeSelectionnee.getForme().deplacerDe(delta, delta);
				break;
			case 1:
				delta = calculDelta1(deltaX, deltaY);
				this.vueFormeSelectionnee.getForme().deplacerDe(0, delta);
				break;
			case 2:
				delta = calculDelta2(deltaX, deltaY);
				this.vueFormeSelectionnee.getForme().deplacerDe(delta, 0);
				break;
			case 3:
				delta = calculDelta3(deltaX, deltaY);
				break;
			default:
				break;
		}
		this.vueFormeSelectionnee.getForme().setLargeur(this.vueFormeSelectionnee.getForme().getLargeur() - delta);
	}
	
	private void redimensionnerEtoile(double deltaX, double deltaY) {
		Etoile etoile = (Etoile) this.vueFormeSelectionnee.getForme();
		
		double delta = 0;
		
		switch(this.anchor) {
			case 0:
				delta = calculDelta0(deltaX, deltaY);
				etoile.deplacerDe(delta, delta);
				break;
			case 1:
				delta = calculDelta1(deltaX, deltaY);
				etoile.deplacerDe(0, delta);
				break;
			case 2:
				delta = calculDelta2(deltaX, deltaY);
				this.vueFormeSelectionnee.getForme().deplacerDe(delta, 0);
				break;
			case 3:
				delta = calculDelta3(deltaX, deltaY);
				break;
			default:
				break;
		}
		
		etoile.setLargeur(etoile.getLargeur() - delta);
		double centerX = etoile.getPosition().getAbscisse() + etoile.getLargeur()/2;
		double centerY = etoile.getPosition().getOrdonnee() + etoile.getLargeur()/2;
		double innerRadius = etoile.getLargeur()/4;
		double outerRadius = etoile.getLargeur()/2;
		int numRays = etoile.getNumRays();
		
		Shape newShape = OutilEtoile.createStar(centerX, centerY, innerRadius, outerRadius, numRays, 0);
		etoile.setFormeEtoile(newShape);
	}
	
	private void redimensionnerPolygone(double deltaX, double deltaY) {
		Polygone polygone = (Polygone) this.vueFormeSelectionnee.getForme();
		
		double delta = 0;
		
		switch(this.anchor) {
			case 0:
				delta = calculDelta0(deltaX, deltaY);
				polygone.deplacerDe(delta, delta);
				break;
			case 1:
				delta = calculDelta1(deltaX, deltaY);
				polygone.deplacerDe(0, delta);
				break;
			case 2:
				delta = calculDelta2(deltaX, deltaY);
				this.vueFormeSelectionnee.getForme().deplacerDe(delta, 0);
				break;
			case 3:
				delta = calculDelta3(deltaX, deltaY);
				break;
			default:
				break;
		}
		
		polygone.setLargeur(polygone.getLargeur() - delta);
		double centerX = polygone.getPosition().getAbscisse() + polygone.getLargeur()/2;
		double centerY = polygone.getPosition().getOrdonnee() + polygone.getLargeur()/2;
		double radius = polygone.getLargeur()/2;
		int numCote = polygone.getNumCote();
		
		polygone.setPolygone(OutilPolygone.createPolygone(centerX, centerY, radius, numCote, 0));
	}
	
	private void redimensionnerLigne(double deltaX, double deltaY) {
		if(this.vuePoints[0].getForme().contient(this.getDebut())){
			this.vueFormeSelectionnee.getForme().deplacerDe(deltaX, deltaY);
			this.vueFormeSelectionnee.getForme().setLargeur(this.vueFormeSelectionnee.getForme().getLargeur() - deltaX);
			this.vueFormeSelectionnee.getForme().setHauteur(this.vueFormeSelectionnee.getForme().getHauteur() - deltaY);
		}
		else if(this.vuePoints[1].getForme().contient(this.getDebut())) {
			//this.vueFormeSelectionnee.getForme().deplacerDe(0, deltaY);
			this.vueFormeSelectionnee.getForme().setLargeur(this.vueFormeSelectionnee.getForme().getLargeur() + deltaX);
			this.vueFormeSelectionnee.getForme().setHauteur(this.vueFormeSelectionnee.getForme().getHauteur() + deltaY);
		}
	}
	
	private void redimensionnerDefault(double deltaX, double deltaY) {
		if(this.vuePoints[0].getForme().contient(this.getDebut())){
			this.vueFormeSelectionnee.getForme().deplacerDe(deltaX, deltaY);
			this.vueFormeSelectionnee.getForme().setLargeur(this.vueFormeSelectionnee.getForme().getLargeur() - deltaX);
			this.vueFormeSelectionnee.getForme().setHauteur(this.vueFormeSelectionnee.getForme().getHauteur() - deltaY);
		}
		else if(this.vuePoints[1].getForme().contient(this.getDebut())) {
			this.vueFormeSelectionnee.getForme().deplacerDe(0, deltaY);
			this.vueFormeSelectionnee.getForme().setLargeur(this.vueFormeSelectionnee.getForme().getLargeur() + deltaX);
			this.vueFormeSelectionnee.getForme().setHauteur(this.vueFormeSelectionnee.getForme().getHauteur() - deltaY);
		}
		else if(this.vuePoints[2].getForme().contient(this.getDebut())) {
			this.vueFormeSelectionnee.getForme().deplacerDe(deltaX, 0);
			this.vueFormeSelectionnee.getForme().setLargeur(this.vueFormeSelectionnee.getForme().getLargeur() - deltaX);
			this.vueFormeSelectionnee.getForme().setHauteur(this.vueFormeSelectionnee.getForme().getHauteur() + deltaY);
		}
		else if(this.vuePoints[3].getForme().contient(this.getDebut())) {
			this.vueFormeSelectionnee.getForme().setLargeur(this.vueFormeSelectionnee.getForme().getLargeur() + deltaX);
			this.vueFormeSelectionnee.getForme().setHauteur(this.vueFormeSelectionnee.getForme().getHauteur() + deltaY);
		}
	}
	
	private void redimensionner(double deltaX, double deltaY) {
		if(this.vueFormeSelectionnee.getClass().getSimpleName().equals("VueCercle") 
		|| this.vueFormeSelectionnee.getClass().getSimpleName().equals("VueCarre")) {
			this.redimensionnerCarreCercle(deltaX, deltaY);
		}
		else if(this.vueFormeSelectionnee.getClass().getSimpleName().equals("VueEtoile")){
			this.redimensionnerEtoile(deltaX, deltaY);
		}
		else if(this.vueFormeSelectionnee.getClass().getSimpleName().equals("VuePolygone")){
			this.redimensionnerPolygone(deltaX, deltaY);
		}
		else if (this.vueFormeSelectionnee.getClass().getSimpleName().equals("VueLigne")) {
			redimensionnerLigne(deltaX, deltaY);
		}
		else {
			redimensionnerDefault(deltaX, deltaY);
		}
	}
	
	private void copierForme() {
		Forme nouvelleForme;
		Forme formeSelectionne = this.vueFormeSelectionnee.getForme();
		VueForme nouvelleVueForme;
		
		try {
			nouvelleForme = formeSelectionne.getClass().getDeclaredConstructor().newInstance();
			
			nouvelleForme.setPosition( 
					new Coordonnees(formeSelectionne.getPosition().getAbscisse(), 
									formeSelectionne.getPosition().getAbscisse()));
			
			nouvelleForme.deplacerDe(+15, +15);
			
			nouvelleForme.setLargeur(formeSelectionne.getLargeur());
			nouvelleForme.setHauteur(formeSelectionne.getHauteur());
			
			nouvelleForme.setCouleur(formeSelectionne.getCouleur());
			nouvelleForme.setRemplissage(formeSelectionne.getRemplissage());
			
			nouvelleVueForme = this.vueFormeSelectionnee.getClass().getDeclaredConstructor(
					this.vueFormeSelectionnee.getForme().getClass()).newInstance(nouvelleForme);
			
			this.getPanneauDessin().getVueFormes().add(nouvelleVueForme);
			this.vueFormeSelectionnee = nouvelleVueForme;
			this.selectionNouvelleForme();
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		this.getPanneauDessin().repaint();
	}
	
	@Override
 	public void mouseClicked(MouseEvent event) {
		this.setDebut(new Coordonnees(event.getX(), event.getY()));
		if(this.getPanneauDessin().getVueFormes().isEmpty()) {
			// System.out.println("Il n'y a pas de forme ici !");
		}
		else {
			VueForme vueformeClicked = null;
			for(int i = this.getPanneauDessin().getVueFormes().size() - 1; i >= 0; i--) {
				if(this.getPanneauDessin().getVueFormes().get(i).getForme().contient(new Coordonnees(event.getX(), event.getY()))) {
					vueformeClicked = this.getPanneauDessin().getVueFormes().get(i);
					break;
				}
			}
			// Selection de Vide -> Enlever le cadre de selection
			if(vueformeClicked == null) {
				effacerAncienCadre();
				this.vueFormeSelectionnee = null;
			}
			// Click sur une Forme déjà selectionné
			else if(vueformeClicked == this.vueFormeSelectionnee) {
				//System.out.println( this.vueFormeSelectionnee.getClass().getSimpleName());
			}
			// Click sur un nouvel Forme
			else {
				this.vueFormeSelectionnee = vueformeClicked;
				selectionNouvelleForme();
			}
			
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		this.setFin(new Coordonnees(event.getX(), event.getY()));
		if(this.vueFormeSelectionnee != null) {
			
			double deltaX = this.getFin().getAbscisse() - this.getDebut().getAbscisse();
			double deltaY = this.getFin().getOrdonnee() - this.getDebut().getOrdonnee();
			
			//Si l'utilisateur selectionne un des points du cadre :
			if(this.anchor != -1 && !this.vueFormeSelectionnee.getClass().getSimpleName().equals("VueTrace")) {
				
				this.redimensionner(deltaX, deltaY);
			}
			//Sinon si il veut faire glisser la forme :
			else {				
				this.vueFormeSelectionnee.getForme().deplacerDe(deltaX, deltaY);
				selectionNouvelleForme();
			}
			
			selectionNouvelleForme();
			this.setDebut(this.getFin());
			this.getPanneauDessin().repaint();
			
		}
	}

	@Override
	public void mousePressed(MouseEvent event) {
		this.setDebut(new Coordonnees(event.getX(), event.getY()));
		if(this.vueFormeSelectionnee != null) {
			this.cornerSelected();
		}
	}


	@Override
	public void keyPressed(GlobalKeyEvent event) {
		if(event.getVirtualKeyCode() == 8 || event.getVirtualKeyCode() == 46) {
			this.getPanneauDessin().getVueFormes().remove(vueFormeSelectionnee);
			this.effacerAncienCadre();
			this.getPanneauDessin().repaint();
			this.vueFormeSelectionnee = null;
		}
		else if(event.getKeyChar() == 'v' && event.isControlPressed()) {
			this.copierForme();
		}
		
	}

	@Override
	public void keyReleased(GlobalKeyEvent event) {
		
	}
}