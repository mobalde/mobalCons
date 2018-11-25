package mobalDev.logic.produit.dto;

public class ProduitDto {

	private Long id;
	private String libelle;
	private int quantiteCommande;
	private TypeProduitEnum type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getQuantiteCommande() {
		return quantiteCommande;
	}
	public void setQuantiteCommande(int quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}
	public TypeProduitEnum getType() {
		return type;
	}
	public void setType(TypeProduitEnum type) {
		this.type = type;
	}
}
