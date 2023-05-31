public class Site {
	private int id_site;
	private int position_x;
	private int position_y;

	public Site(int id_site, int position_x, int position_y) {
		this.id_site = id_site;
		this.position_x = position_x;
		this.position_y = position_y;
	}

	public int getId_site() {
		return id_site;
	}

	public void setId_site(int id_site) {
		this.id_site = id_site;
	}

	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int psotition_x) {
		this.position_x = psotition_x;
	}

	public int getPosition_y() {
		return position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}


}