package mobalDev.logic.banque.dto;

import java.time.LocalDate;

public class BanqueDto {

	private Long id;
	private LocalDate dateDepot;
	private String agenceDepot;
	private String numeroTicket;
	private Double argentDepose;
	private Double total;
	private boolean isDepot;
	private boolean isRetrait;
	
	public LocalDate getDateDepot() {
		return dateDepot;
	}
	public void setDateDepot(LocalDate dateDepot) {
		this.dateDepot = dateDepot;
	}
	public String getAgenceDepot() {
		return agenceDepot;
	}
	public void setAgenceDepot(String agenceDepot) {
		this.agenceDepot = agenceDepot;
	}
	public String getNumeroTicket() {
		return numeroTicket;
	}
	public void setNumeroTicket(String numeroTicket) {
		this.numeroTicket = numeroTicket;
	}
	public boolean isDepot() {
		return isDepot;
	}
	public void setDepot(boolean isDepot) {
		this.isDepot = isDepot;
	}
	public boolean isRetrait() {
		return isRetrait;
	}
	public void setRetrait(boolean isRetrait) {
		this.isRetrait = isRetrait;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getArgentDepose() {
		return argentDepose;
	}
	public void setArgentDepose(Double argentDepose) {
		this.argentDepose = argentDepose;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
}
