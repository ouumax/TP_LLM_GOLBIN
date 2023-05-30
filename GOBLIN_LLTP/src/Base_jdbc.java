import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Base_jdbc extends Entreprise{
	
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
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			finally {
				if(connection!=(null))connection.close();
			}
		}
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


					+"CREATE TABLE routes (origine int,destination int,taille int,PRIMARY KEY(origine,destination),\n"
					+"FOREIGN KEY (origine) REFERENCES sites(id_site),FOREIGN KEY (destination) REFERENCES sites(id_site))\n"
					;

			try ( Statement statement = connection.createStatement() ) {
					statement.executeUpdate( requete );
				}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			finally {
				if(connection!=(null))connection.close();
			}
		}
	}
	public void INSERT_() throws Exception{
		Class.forName( "org.hsqldb.jdbcDriver" );

		String url = "jdbc:hsqldb:file:Database"+File.separator+"GOBLIN;shutdown=true";
		String login = "sa"; 
		String password = "";
		
//		for(int i = 0;i<clei)
		Entreprise.client
		try (Connection connection = DriverManager.getConnection( url, login, password )){
			String requete =
					"INSERT INTO sites(id_site ,position_x ,position_y) VALUES "
					;

			try ( Statement statement = connection.createStatement() ) {
					statement.executeUpdate( requete );
				}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			finally {
				if(connection!=(null))connection.close();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Entreprise ULOG = new Entreprise();
		ULOG.CreateClient("FichiersExcel/init-clients-30-10-Carre.csv");
		System.out.println(ULOG.clients.get(2).getNom());
		//Base_jdbc BD = new Base_jdbc(); 
//		BD.drop_ALL();
//		BD.create_tables();
		
		
	}
}
