package mobalDev.logic.marchandise.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import mobalDev.logic.produit.dto.ProduitDto;

public class MarchandiseDto{
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate dateDebut = LocalDate.now();
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate dateFin = LocalDate.now().plusDays(7);
	private int nbSacVendu = 0;
	private int nbSacAnterieur = 0;
	private int totalSacVendu = 0;
	private int totalSacMarchandise;
	private int totalSacRestant = 0;
	private ProduitDto produitDto;
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
	public ProduitDto getProduitDto() {
		return produitDto;
	}
	public void setProduitDto(ProduitDto produitDto) {
		this.produitDto = produitDto;
	}
}
