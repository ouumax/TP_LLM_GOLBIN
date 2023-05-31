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
	
	public Route(int origine, int destination) throws Exception{    
		this.origine = origine;
		this.destination = destination;
		this.distance = creerDistance();
	}

	public int getOrigine() {
		return origine;
	}

	public void setOrigine(int origine) {
		this.origine = origine;
	}

	public int getDistance() {
		return distance;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}
	
	 public int appel_position_x(int site) throws Exception {
	        System.out.println("Appel_variable");
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
	        System.out.println("Appel_variable");
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
	                int position_y = 0;
	                if (resultat.next()) {
	                    position_y = resultat.getInt("POSITION_Y");
	                    return position_y;
	                }
	            }
	        }
	        return 0;
	    }
	
	
	public int  creerDistance() throws Exception{
		distance = (int)(Math.ceil( Math.sqrt(Math.pow(appel_position_x(destination)-appel_position_x(origine),2)
				+Math.pow(appel_position_y(destination)-appel_position_y(origine),2))));
		return distance;
	}

	public int[][] MatriceRoute(List<Site> sites) throws Exception{
		int [][] matdist = new int[sites.size()][sites.size()];
		for(int i=0; i<sites.size(); i++) {
			int id1=i+1;
			for(int j=0; j<sites.size(); j++) {
				int id2=j+1;
				Route troncon = new Route(id1,id2);
				int dist = troncon.creerDistance();
				if(i==j) {
					matdist[i][j]=0;
					System.out.println();
				}else {
					if(dist!=0) {
						matdist [i][j]=dist;
					}else {
						matdist [i][j]= Integer.MAX_VALUE; 
					}
				}
			}
		}
		return matdist;
	}
	
	public int[][] pluscourtchem(int[][] matdist, List<Site> sites) throws Exception{
		int [][] M = MatriceRoute(sites);
		int n = sites.size();
		for (int k=0; k<n; k++) {
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (M[i][k]+M[k][j]<M[i][j]) {
						M[i][j]= M[i][k]+M[k][j];
					}
				}
			}
		} 
		return M;
	}

	public static void main (String[] args){
		
	}

}