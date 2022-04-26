package fr.eseo.pdlo.projet.artiste.modele.formes.dt;

public enum DTLigneAngle {
	DT1 (0, 0, 0),
	DT2 (1, 0, 0),
	DT3 (1, 1, 45),
	DT4 (0, 1, 90),
	DT5 (-1, 1, 135),
	DT6 (-1, 0, 180),
	DT7 (-1, -1, 225),
	DT8 (0, -1, 270),
	DT9 (1, -1, 315),
	DT10(1, -0.001, 360);
	
	public double testedLargeur;
	public double testedHauteur;
	public double expectedAngle;
	
	DTLigneAngle(double testedLargeur, double testedHauteur, double expectedAngle){
		this.testedLargeur = testedLargeur;
		this.testedHauteur = testedHauteur;
		this.expectedAngle = expectedAngle;
	}
}
