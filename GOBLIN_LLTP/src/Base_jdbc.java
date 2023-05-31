import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class Base_jdbc {

	public Base_jdbc() {

	}

	public void drop_ALL() throws Exception{
		Class.forName( "org.hsqldb.jdbcDriver" );

		String url = "jdbc:hsqldb:file:Database"+File.separator+"GOBLIN;shutdown=true";
		String login = "sa"; 
		String password = "";

		try (Connection connection = DriverManager.getConnection( url, login, password )){
			String requete =
					"DROP TABLE clients IF EXISTS;"
							+"DROP TABLE entrepots IF EXISTS;"
							+"DROP TABLE routes IF EXISTS;"
							+"DROP TABLE sites IF EXISTS;";

			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
		}
		System.out.println("DROP ALL");
	}
	public void create_tables() throws Exception{
		Class.forName( "org.hsqldb.jdbcDriver" );

		String url = "jdbc:hsqldb:file:Database"+File.separator+"GOBLIN;shutdown=true";
		String login = "sa"; 
		String password = "";

		try (Connection connection = DriverManager.getConnection( url, login, password )){
			String requete =
					"CREATE TABLE sites (id_site int,position_x int,position_y int,PRIMARY KEY(id_site))"

					+"CREATE TABLE clients (nom varchar(50),mail varchar(100),id_site int,PRIMARY KEY(mail),"
					+ "FOREIGN KEY (id_site) REFERENCES sites(id_site))"

					+"CREATE TABLE entrepots (id_entrepot int,id_site int,cout_fixe int,stock int,"
					+ "PRIMARY KEY(id_entrepot),FOREIGN KEY (id_site) REFERENCES sites(id_site))"


					+"CREATE TABLE routes (origine int,destination int,distance int,PRIMARY KEY(origine,destination),\n"
					+"FOREIGN KEY (origine) REFERENCES sites(id_site),FOREIGN KEY (destination) REFERENCES sites(id_site))\n"
					;
			System.out.println("CREATE TABLES");
			try ( Statement statement = connection.createStatement() ) {
				statement.executeUpdate( requete );
			}
		}
	}
	public void INSERT_Clients(Entreprise e) throws Exception{
		Class.forName( "org.hsqldb.jdbcDriver" );

		String url = "jdbc:hsqldb:file:Database"+File.separator+"GOBLIN;shutdown=true";
		String login = "sa"; 
		String password = "";

		try (Connection connection = DriverManager.getConnection( url, login, password )){
			List<Client> listeClients = e.getClients();
			for (int i = 0;i<listeClients.size();i++){

				String nom = listeClients.get(i).getNom();
				String mail = listeClients.get(i).getMail();
				int idsite=listeClients.get(i).getId_site();
				String requete =
						"INSERT INTO CLIENTS VALUES \r\n"
								+ "('"+nom+"','"+mail+"',"+idsite+");"
								;

				try ( Statement statement = connection.createStatement() ) {
					statement.executeUpdate( requete );
				}
			}
		}
		System.out.println("INSERT CLIENTS");
	}
	public void INSERT_Sites(Entreprise e) throws Exception{
		System.out.println("insert sites");
		Class.forName( "org.hsqldb.jdbcDriver" );

		String url = "jdbc:hsqldb:file:Database"+File.separator+"GOBLIN;shutdown=true";
		String login = "sa"; 
		String password = "";

		try (Connection connection = DriverManager.getConnection( url, login, password )){
			List<Site> listeSites = e.getSites();
			for (int i = 0;i<listeSites.size();i++){

				int pos_x = listeSites.get(i).getPosition_x();
				int pos_y = listeSites.get(i).getPosition_y();
				int idsite=listeSites.get(i).getId_site();
				String requete =
						"INSERT INTO SITES VALUES \r\n"
								+ "('"+idsite+"','"+pos_x+"',"+pos_y+");"
								;	

				try ( Statement statement = connection.createStatement() ) {
					statement.executeUpdate( requete );
				}
			}
		}
	}
	public void INSERT_Entrepots(Entreprise e) throws Exception{
		System.out.println("insert entrepots");
		Class.forName( "org.hsqldb.jdbcDriver" );

		String url = "jdbc:hsqldb:file:Database"+File.separator+"GOBLIN;shutdown=true";
		String login = "sa"; 
		String password = "";

		try (Connection connection = DriverManager.getConnection( url, login, password )){
			List<Entrepot> listeEntrepots = e.getEntrepots();
			for (int i = 0;i<listeEntrepots.size();i++){
				
				 int id_entrepot=listeEntrepots.get(i).getId_entrepot();
				 int id_site=listeEntrepots.get(i).getId_site();
				 int cout_fixe=listeEntrepots.get(i).getCout_fixe();
				 int stock=listeEntrepots.get(i).getStock();
				String requete =
						"INSERT INTO ENTREPOTS VALUES \r\n"
								+ "('"+id_entrepot+"','"+id_site+"',"+cout_fixe+","+stock+");"
								;	

				try ( Statement statement = connection.createStatement() ) {
					statement.executeUpdate( requete );
				}
			}
		}
	}
	
	public void INSERT_Routes(Entreprise e) throws Exception{
		System.out.println("insert routes");
		Class.forName( "org.hsqldb.jdbcDriver" );

		String url = "jdbc:hsqldb:file:Database"+File.separator+"GOBLIN;shutdown=true";
		String login = "sa"; 
		String password = "";

		try (Connection connection = DriverManager.getConnection( url, login, password )){
			List<Route> listeRoutes = e.getRoutes();
			for (int i = 0;i<listeRoutes.size();i++){
				
				 int dest=listeRoutes.get(i).getDestination();
				 int origine=listeRoutes.get(i).getOrigine();
				 Route troncon = new Route(origine,dest);
				 int distance = troncon.creerDistance();

				String requete =
						"INSERT INTO ROUTES VALUES \r\n"
								+ "("+dest+","+origine+","+distance+");"
								;	

				try ( Statement statement = connection.createStatement() ) {
					statement.executeUpdate( requete );
				}
			}
		}
	}
	
	public static void main(String[] args){
		
	}
}
