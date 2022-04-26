package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;


public class PanneauDessin extends JPanel{
 
	public static final int LARGEUR_PAR_DEFAUT = 400;
	public static final int HAUTEUR_PAR_DEFAUT = 240;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.white;
	
	private final List<VueForme> vueFormes = new ArrayList<VueForme>();
	private Outil outilCourant;
	private Color couleurCourante;
	private Remplissage remplissage = Remplissage.AUCUNE;
	
	//private JPanel panneau;
	
	public PanneauDessin(int largeur, int hauteur, Color fond){
		//panneau = new JPanel();
		super();
		super.setPreferredSize(new Dimension(largeur, hauteur));
		super.setBackground(fond);
		this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
	}
	
	public PanneauDessin(){
		this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
	}
	
	public List<VueForme> getVueFormes(){
		return this.vueFormes;
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
	
	public void setCouleurCourante(Color couleurCourante) {
		this.couleurCourante = couleurCourante;
	}
	
	public Remplissage getModeRemplissageCourant() {
		return this.remplissage;
	}
	
	public void setModeRemplissageCourant(Remplissage modeRemplissage) {
		this.remplissage = modeRemplissage;
	}
	
	public void ajouterVueForme(VueForme vueForme) {
		vueForme.getForme().setCouleur(this.couleurCourante);
		this.vueFormes.add(vueForme);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D)g.create();
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
		this.outilCourant.setPanneauDessin(null);
		this.removeMouseListener(outilCourant);
		this.removeMouseMotionListener(outilCourant);
		this.setOutilCourant(null);
	}
}
