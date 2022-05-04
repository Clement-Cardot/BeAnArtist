package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionExporter extends AbstractAction{

	public static final String NOM_ACTION = (Locale.getDefault().getLanguage().equals("fr"))? "Exporter" : "Export";
	private final PanneauDessin panneauDessin;
	
	public ActionExporter(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.exportingWindow();
	}
	
	private void exportingWindow() {
		JFrame window = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter(".jpg", "jpg"));
		fileChooser.setFileFilter(new FileNameExtensionFilter(".gif", "gif"));
		fileChooser.setFileFilter(new FileNameExtensionFilter(".png", "png"));
		File fileToSave = null;
		fileChooser.setDialogTitle("Specifiez le fichier à exporter");
		
		int userSelection = fileChooser.showSaveDialog(window);
		
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    fileToSave = fileChooser.getSelectedFile();
		}
		
		String extension = fileChooser.getFileFilter().getDescription();
		String fileName = fileToSave.getAbsolutePath().replaceAll(fileToSave.getName(), "")  
								+ this.filExtension(extension, fileToSave.getName());
		
		//System.out.println("Name : " + fileName);
		//System.out.println("Extension : " + extension);
		
		BufferedImage image = new BufferedImage(this.panneauDessin.getWidth(), this.panneauDessin.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2D = image.createGraphics();
		this.panneauDessin.printAll(g2D);
		g2D.dispose();
		
		try {
			ImageIO.write(image, extension.substring(1), new File(fileName));
		} catch(IOException exception){
			exception.printStackTrace();
		}
	}
	
	private String filExtension(String extension, String fileName) {
		if(fileName.endsWith(extension)) {
			return fileName;
		}
		else return fileName + extension;
	}

}
