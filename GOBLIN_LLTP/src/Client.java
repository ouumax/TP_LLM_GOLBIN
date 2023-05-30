public class Client {
	private String nom;
	private String mail;
	private int id_site;
	
	public Client(String nom, String mail, int id_site) {
		this.nom = nom;
		this.mail = mail;
		this.id_site = id_site;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getId_site() {
		return id_site;
	}

	public void setId_site(int id_site) {
		this.id_site = id_site;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", mail=" + mail + ", id_site=" + id_site + "]";
	}
	
}
