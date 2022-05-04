package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilSelectionnerExtension;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.ihm.ColorChooserButton.ColorChangedListener;

@SuppressWarnings("serial")
public class PanneauBarreEtatExtension extends JPanel implements MouseMotionListener, ColorChangedListener, MouseInputListener, ItemListener{
	
	
	private JLabel valeurX;
	private JLabel valeurY;
	
	private JLabel nomForme;
	private JLabel largeurForme;
	private JLabel hauteurForme;
	
	private ColorChooserButton couleurForme = new ColorChooserButton(Color.white);
	
	private String typeRemplissage[] = {Remplissage.AUCUNE.getMode(), Remplissage.UNIFORME.getMode()};
	private JComboBox<String> remplissageForme = new JComboBox<String>(typeRemplissage);
	
	private VueForme vueFormeSurvole;
	private VueForme vueFormeSelectionnee = null;
	
	private final PanneauDessin panneauDessin;
	
	public PanneauBarreEtatExtension(PanneauDessin panneauDessin){
		this.panneauDessin = panneauDessin;
		this.valeurX = new JLabel("x: 0");
		this.valeurY = new JLabel("y: 0");
		
		this.nomForme = new JLabel();
		this.largeurForme = new JLabel();
		this.hauteurForme = new JLabel();
		
		this.nomForme.setVisible(false);
		this.largeurForme.setVisible(false);
		this.hauteurForme.setVisible(false);
		this.couleurForme.setVisible(false);
		this.couleurForme.addColorChangedListener(this);
		this.remplissageForme.setVisible(false);
		this.remplissageForme.addItemListener(this);
		
		this.setLayout(new FlowLayout());
		
		this.add(this.nomForme);
		this.add(this.largeurForme);
		this.add(this.hauteurForme);
		this.add(this.couleurForme);
		this.add(this.remplissageForme);

		this.add(this.valeurX);
		this.add(this.valeurY);
		
		this.panneauDessin.addMouseMotionListener(this);
		this.panneauDessin.addMouseListener(this);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(this.panneauDessin.getOutilCourant() != null) {
			if(this.panneauDessin.getOutilCourant().getClass().getSimpleName().equals("OutilSelectionnerExtension")) {
				OutilSelectionnerExtension outilSelectionner = (OutilSelectionnerExtension) this.panneauDessin.getOutilCourant();
				outilSelectionner.mouseClicked(event);
				this.vueFormeSelectionnee = outilSelectionner.getVueFormeSelectionne();
				
				if(this.vueFormeSelectionnee == null) {
					this.vueFormeSelectionnee = null;
					Coordonnees coord = new Coordonnees(event.getX(), event.getY());
					this.mettreAJourVueFormeSurvole(coord);
				}
			}
			
		}
		else {
			this.vueFormeSelectionnee = null;
			Coordonnees coord = new Coordonnees(event.getX(), event.getY());
			this.mettreAJourVueFormeSurvole(coord);
		}
	}
	
	public void mouseDragged(MouseEvent event) {
		Coordonnees coord = new Coordonnees(event.getX(), event.getY());
		this.mettreAJourAffichageCoordonnees(coord);
		this.mettreAJourVueFormeSurvole(coord);
	}
	
	public void mouseMoved(MouseEvent event) {
		Coordonnees coord = new Coordonnees(event.getX(), event.getY());
		this.mettreAJourAffichageCoordonnees(coord);
		this.mettreAJourVueFormeSurvole(coord);
	}
	
	private void mettreAJourAffichageCoordonnees(Coordonnees coord) {
		this.valeurX.setText( "x: " + coord.getAbscisse());
		this.valeurY.setText( "y: " + coord.getOrdonnee());
	}
	
	private void mettreAJourAffichageForme(String nom, Color couleur, Remplissage remplissage, String largeur, String hauteur) {
		this.nomForme.setVisible(true);
		this.largeurForme.setVisible(true);
		this.hauteurForme.setVisible(true);
		this.couleurForme.setVisible(true);
		this.remplissageForme.setVisible(true);
		
		this.nomForme.setText(nom);
		this.largeurForme.setText(largeur);
		this.hauteurForme.setText(hauteur);
		this.couleurForme.setSelectedColor(couleur);
		this.remplissageForme.setSelectedItem(remplissage.getMode());
	}
	
	private void mettreAJourVueFormeSurvole(Coordonnees coord){
		if(this.vueFormeSelectionnee == null) {
			this.vueFormeSurvole = null;
			
			for(int i = this.panneauDessin.getVueFormes().size() - 1; i >= 0; i--) {
				
				if(this.panneauDessin.getVueFormes().get(i).getForme()
						.contient(new Coordonnees(coord.getAbscisse(), coord.getOrdonnee()))) {
					
					this.vueFormeSurvole = this.panneauDessin.getVueFormes().get(i);
					break;
				}
			}
			if(this.vueFormeSurvole != null) {
				String name = this.vueFormeSurvole.getForme().getClass().getSimpleName();
				Color couleur = this.vueFormeSurvole.getForme().getCouleur();
				Remplissage remplissage = this.vueFormeSurvole.getForme().getRemplissage();
				String largeur = "Largeur :" + String.valueOf(this.vueFormeSurvole.getForme().getLargeur());
				String hauteur = "Hauteur :" + String.valueOf(this.vueFormeSurvole.getForme().getHauteur());
				this.mettreAJourAffichageForme(name, couleur, remplissage, largeur, hauteur);
				
			}
			else {
				this.nomForme.setVisible(false);
				this.largeurForme.setVisible(false);
				this.hauteurForme.setVisible(false);
				this.couleurForme.setVisible(false);
				this.remplissageForme.setVisible(false);
			}
		}
		else {
			String name = this.vueFormeSelectionnee.getForme().getClass().getSimpleName();
			Color couleur = this.vueFormeSelectionnee.getForme().getCouleur();
			Remplissage remplissage = this.vueFormeSurvole.getForme().getRemplissage();
			String largeur = "Largeur :" + String.valueOf(this.vueFormeSelectionnee.getForme().getLargeur());
			String hauteur = "Hauteur :" + String.valueOf(this.vueFormeSelectionnee.getForme().getHauteur());
			this.mettreAJourAffichageForme(name, couleur, remplissage, largeur, hauteur);
		}
	}
	
	@Override
	public void colorChanged(Color newColor) {
		if(this.vueFormeSelectionnee != null) {
			if(this.vueFormeSelectionnee.getForme().getCouleur() != newColor) {
				this.vueFormeSelectionnee.getForme().setCouleur(newColor);
				this.panneauDessin.repaint();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(this.vueFormeSelectionnee != null) {
			if(this.vueFormeSelectionnee.getForme().getRemplissage().getMode() != this.remplissageForme.getSelectedItem()) {
				this.vueFormeSelectionnee.getForme().setRemplissage(
								Remplissage.valueOf(((String)this.remplissageForme.getSelectedItem()).toUpperCase()));
				this.panneauDessin.repaint();
			}
		}
	}
}
