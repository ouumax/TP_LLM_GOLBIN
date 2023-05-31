import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Route {
	private int origine;
	private int destination;
	private int distance;

	public Route(int origine, int destination) throws Exception {
		this.origine = origine;
		this.destination = destination;
//		this.distance = creerDistance();
	}

	public int getOrigine() {
		return origine;
	}

	public void setOrigine(int origine) {
		this.origine = origine;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int appel_position_x(int site) throws Exception {
		//System.out.println("Appel_variable");
		Class.forName( "org.hsqldb.jdbcDriver" );

		String url = "jdbc:hsqldb:file:Database"+File.separator+"GOBLIN;shutdown=true";
		String login = "sa"; 
		String password = "";

		try (Connection connection = DriverManager.getConnection( url, login, password )){

			String requete =
					"SELECT POSITION_X from SITES "
							+ "WHERE ID_SITE = "+site+";";	

			try ( Statement statement = connection.createStatement() ) {
				ResultSet resultat =statement.executeQuery( requete );
				int position_x = 0;
				if (resultat.next()) {
					position_x = resultat.getInt("POSITION_X");
					return position_x;
				}
			}
		}
		return 0;
	}

	public int appel_position_y(int site) throws Exception {
		//System.out.println("Appel_variable");
		Class.forName( "org.hsqldb.jdbcDriver" );

		String url = "jdbc:hsqldb:file:Database"+File.separator+"GOBLIN;shutdown=true";
		String login = "sa"; 
		String password = "";

		try (Connection connection = DriverManager.getConnection( url, login, password )){

			String requete =
					"SELECT POSITION_Y from SITES "
							+ "WHERE ID_SITE = "+site+";";	

			try ( Statement statement = connection.createStatement() ) {
				ResultSet resultat =statement.executeQuery( requete );
				int position_y = 0;
				if (resultat.next()) {
					position_y = resultat.getInt("POSITION_Y");
					return position_y;
				}
			}
		}
		return 0;
	}
	
	public int  creerDistance() throws Exception {
		
		distance = (int)(Math.ceil( Math.sqrt(Math.pow(appel_position_x(destination)-appel_position_x(origine),2)
				+Math.pow(appel_position_y(destination)-appel_position_y(origine),2))));
		return distance;
	}


}
