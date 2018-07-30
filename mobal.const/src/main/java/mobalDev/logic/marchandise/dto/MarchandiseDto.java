package mobalDev.logic.marchandise.dto;

import java.time.LocalDate;

public class MarchandiseDto{
	
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int nbSacVendu;
	private int nbSacAnterieur;
	private int totalSacVendu;
	private int totalSacMarchandise;
	private int totalSacRestant;
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public int getNbSacVendu() {
		return nbSacVendu;
	}
	public void setNbSacVendu(int nbSacVendu) {
		this.nbSacVendu = nbSacVendu;
	}
	public int getNbSacAnterieur() {
		return nbSacAnterieur;
	}
	public void setNbSacAnterieur(int nbSacAnterieur) {
		this.nbSacAnterieur = nbSacAnterieur;
	}
	public int getTotalSacVendu() {
		return totalSacVendu;
	}
	public void setTotalSacVendu(int totalSacVendu) {
		this.totalSacVendu = totalSacVendu;
	}
	public int getTotalSacMarchandise() {
		return totalSacMarchandise;
	}
	public void setTotalSacMarchandise(int totalSacMarchandise) {
		this.totalSacMarchandise = totalSacMarchandise;
	}
	public int getTotalSacRestant() {
		return totalSacRestant;
	}
	public void setTotalSacRestant(int totalSacRestant) {
		this.totalSacRestant = totalSacRestant;
	}
	
}
