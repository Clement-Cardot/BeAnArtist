package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionSauvegarder extends AbstractAction{

	public static final String NOM_ACTION = (Locale.getDefault().getLanguage().equals("fr"))? "Sauvegarder" : "Save";
	private PanneauDessin panneauDessin;
	
	public ActionSauvegarder(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.savingWindow();
	}
	
	private void savingWindow() {
		JFrame window = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		File fileToSave = null;
		fileChooser.setDialogTitle("Specifiez le fichier à sauvegarder");
		
		int userSelection = fileChooser.showSaveDialog(window);
		
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    fileToSave = fileChooser.getSelectedFile();
		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		}
		
		try {
			ObjectOutputStream oos = 
					new ObjectOutputStream(
							new FileOutputStream(
									new File(fileToSave.getAbsolutePath())));
			
			oos.writeObject(this.panneauDessin.getVueFormes());
			oos.close();
		}
		catch(Exception exeption) {
			exeption.printStackTrace();
		}
	}
}
