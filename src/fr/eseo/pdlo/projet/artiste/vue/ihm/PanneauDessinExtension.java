package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilSelectionnerExtension;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

@SuppressWarnings("serial")
public class PanneauDessinExtension extends PanneauDessin{
	 
		public static final int LARGEUR_PAR_DEFAUT = 400;
		public static final int HAUTEUR_PAR_DEFAUT = 240;
		public static final Color COULEUR_FOND_PAR_DEFAUT = Color.white;
		
		private final List<VueForme> vueFormes = new ArrayList<VueForme>();
		private Outil outilCourant;
		private Color couleurCourante;
		private Remplissage remplissage = Remplissage.AUCUNE;
		private boolean antiAliasing = false;
		
		//private JPanel panneau;
		
		public PanneauDessinExtension(int largeur, int hauteur, Color fond){
			//panneau = new JPanel();
			super();
			super.setPreferredSize(new Dimension(largeur, hauteur));
			super.setBackground(fond);
			this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
		}
		
		public PanneauDessinExtension(){
			this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
		}
		
		public List<VueForme> getVueFormes(){
			return this.vueFormes;
		}
		
		public void setVuesFormes(List<VueForme> newVueFormes) {
			this.vueFormes.clear();
			this.vueFormes.addAll(newVueFormes);
		}
		
		public Outil getOutilCourant() {
			return this.outilCourant;
		}
		
		public void setOutilCourant(Outil outil) {
			this.outilCourant = outil;
		}
		
		public Color getCouleurCourante() {
			return this.couleurCourante;
		}
		
		public boolean getAntiAliasing() {
			return this.antiAliasing;
		}
		
		public void setCouleurCourante(Color couleurCourante) {
			this.couleurCourante = couleurCourante;
		}
		
		public Remplissage getModeRemplissageCourant() {
			return this.remplissage;
		}
		
		public void setModeRemplissageCourant(Remplissage modeRemplissage) {
			this.remplissage = modeRemplissage;
		}
		
		public void setAntiAliasing(boolean antiAliasing) {
			this.antiAliasing = antiAliasing;
		}
		
		public void ajouterVueForme(VueForme vueForme) {
			vueForme.getForme().setCouleur(this.couleurCourante);
			this.vueFormes.add(vueForme);
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2D = (Graphics2D)g.create();
			
			if(this.antiAliasing) {
				g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			}
			
			for(VueForme vueForme : this.getVueFormes()) {
				vueForme.affiche(g2D);
			}
			
			g2D.dispose();
		}
		
		public void associerOutil(Outil outil) {
			if(outil != null) {
				if(this.outilCourant != null) {
					this.dissocierOutil();
				}
				this.setOutilCourant(outil);
				this.outilCourant.setPanneauDessin(this);
				this.addMouseListener(this.outilCourant);
				this.addMouseMotionListener(this.outilCourant);
			}
		}
		
		public void dissocierOutil() {
			if(this.outilCourant != null) {
				if(this.outilCourant.getClass().getSimpleName().equals("OutilSelectionnerExtension")) {
					OutilSelectionnerExtension outilSelection = (OutilSelectionnerExtension) this.outilCourant;
					outilSelection.effacerAncienCadre();
					outilSelection.keyboardHook.removeKeyListener(outilSelection);
					outilSelection.keyboardHook.shutdownHook();
				}
				
				this.outilCourant.setPanneauDessin(null);
				this.removeMouseListener(outilCourant);
				this.removeMouseMotionListener(outilCourant);
				this.setOutilCourant(null);
			}
		}


	}
