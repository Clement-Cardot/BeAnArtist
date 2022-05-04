package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionOuvrir extends AbstractAction{

	public static final String NOM_ACTION = (Locale.getDefault().getLanguage().equals("fr"))?  "Ouvrir" : "Open";
	private PanneauDessin panneauDessin;
	
	public ActionOuvrir(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.openWindow();
		
	}
	
	@SuppressWarnings("unchecked")
	private void openWindow() {
		JFrame window = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files","txt");
		fileChooser.setFileFilter(filter);
		File fileToLoad = null;
		
		int userSelection = fileChooser.showOpenDialog(window);
		
		if(userSelection == JFileChooser.APPROVE_OPTION) {
			fileToLoad = fileChooser.getSelectedFile();
		    System.out.println("Save as file: " + fileToLoad.getAbsolutePath());
        }
		
		List<VueForme> vueFormes = null;
		try {
			ObjectInputStream ois = 
					new ObjectInputStream(
							new FileInputStream(fileToLoad));
			
			vueFormes = (List<VueForme>) ois.readObject();
			ois.close();
		}
		
		catch(Exception exeption) {
			exeption.printStackTrace();
		}
		
		this.panneauDessin.setVuesFormes(vueFormes);
		this.panneauDessin.repaint();
	}
}
