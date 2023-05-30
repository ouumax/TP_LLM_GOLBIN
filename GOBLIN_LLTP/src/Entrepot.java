
public class Entrepot {
	private int id_entrepot;
	private int id_site;
	private int cout_fixe;
	private int stock;
	
	public Entrepot(int id_entrepot, int id_site, int cout_fixe, int stock) {
		this.id_entrepot = id_entrepot;
		this.id_site = id_site;
		this.cout_fixe = cout_fixe;
		this.stock = stock;
	}

	public int getId_entrepot() {
		return id_entrepot;
	}

	public void setId_entrepot(int id_entrepot) {
		this.id_entrepot = id_entrepot;
	}

	public int getId_site() {
		return id_site;
	}

	public void setId_site(int id_site) {
		this.id_site = id_site;
	}

	public int getCout_fixe() {
		return cout_fixe;
	}

	public void setCout_fixe(int cout_fixe) {
		this.cout_fixe = cout_fixe;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
