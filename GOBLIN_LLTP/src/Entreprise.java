import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.util.OpencsvUtils;



public class Entreprise {
	private  List<Client> clients;
	private  List<Entrepot> entrepots;
	private List<Route> routes;
	private List<Site> sites;
	
	public Entreprise () {
		this.clients = new ArrayList<>();
		this.entrepots = new ArrayList<>();
		this.routes = new ArrayList<>();
		this.sites = new ArrayList<>();
	}
	public  List<Client> getClients() {
		return clients;
	}	
	public List<Entrepot> getEntrepots() {
		return entrepots;
	}
	public List<Route> getRoutes() {
		return routes;  
	}
	public  List<Site> getSites() {
		return sites;
	}
	public void CreateClient(String file)
	{
		System.out.println("CreateClient");
		String nom ; 
		String mail ; 
		int id_site ;
		
	    try {
	        // Create an object of file reader class with CSV file as a parameter.
	        FileReader filereader = new FileReader(file);
	  
	        // create csvParser object with
	        // custom separator semi-colon
	        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
	  
	        // create csvReader object with parameter
	        // filereader and parser
	        CSVReader csvReader = new CSVReaderBuilder(filereader)
	                                  .withCSVParser(parser)
	                                  .build();
	  
	        // Read all data at once
	        List<String[]> allData = csvReader.readAll();
	  
	        // Print Data.
	        for (int i=1; i<allData.size(); i++) {
	        	String[] row = allData.get(i);
	        	nom = row[0];
	        	mail = row[1];
	        	id_site = Integer.parseInt(row[2]);
	        	this.clients.add(new Client(nom,mail,id_site));
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public  void CreateEntrepot(String file)
	{
		System.out.println("CreateEntrepot");
		int id_entrepot ; 
		int id_site ; 
		int cout_fixe ;
		int stock;
		
	    try {
	        // Create an object of file reader class with CSV file as a parameter.
	        FileReader filereader = new FileReader(file);
	  
	        // create csvParser object with
	        // custom separator semi-colon
	        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
	  
	        // create csvReader object with parameter
	        // filereader and parser
	        CSVReader csvReader = new CSVReaderBuilder(filereader)
	                                  .withCSVParser(parser)
	                                  .build();
	  
	        // Read all data at once
	        List<String[]> allData = csvReader.readAll();
	  
	        // Print Data.
	        for (int i=1; i<allData.size(); i++) {
	        	String[] row = allData.get(i);
	        	id_entrepot = Integer.parseInt(row[0]);
	        	id_site = Integer.parseInt(row[1]);
	        	cout_fixe = Integer.parseInt(row[2]);
	        	stock = Integer.parseInt(row[3]);
	        	this.entrepots.add(new Entrepot(id_entrepot,id_site,cout_fixe,stock));
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void CreateRoute(String file)
	{
		System.out.println("CreateRoute");
		int origine ; 
		int destination ;
		int distance;
		
	    try {
	        // Create an object of file reader class with CSV file as a parameter.
	        FileReader filereader = new FileReader(file);
	  
	        // create csvParser object with
	        // custom separator semi-colon
	        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
	  
	        // create csvReader object with parameter
	        // filereader and parser
	        CSVReader csvReader = new CSVReaderBuilder(filereader)
	                                  .withCSVParser(parser)
	                                  .build();
	  
	        // Read all data at once
	        List<String[]> allData = csvReader.readAll();
	  
	        // Print Data.
	        for (int i=1; i<allData.size(); i++) {
	        	String[] row = allData.get(i);
	        	origine = Integer.parseInt(row[0]);
	        	destination = Integer.parseInt(row[1]);
	        	this.routes.add(new Route(origine,destination));
	            for (String cell : row) {
	            }
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public  void CreateSite(String file)
	{
		
		System.out.println("CreateSite");
		int id_site ; 
		int position_x ;
		int position_y ;
		
	    try {
	        // Create an object of file reader class with CSV file as a parameter.
	        FileReader filereader = new FileReader(file);
	        // create csvParser object with
	        // custom separator semi-colon
	        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
	        // create csvReader object with parameter
	        // filereader and parser
	        CSVReader csvReader = new CSVReaderBuilder(filereader)
	                                  .withCSVParser(parser)
	                                  .build();
	        // Read all data at once
	        List<String[]> allData = csvReader.readAll();
	        // données dans la liste.
	        for (int i=1; i<allData.size(); i++) {
	        	String[] row = allData.get(i);
	        	id_site = Integer.parseInt(row[0]);
	        	position_x = Integer.parseInt(row[1]);
	        	position_y = Integer.parseInt(row[2]);
	        	this.sites.add(new Site(id_site,position_x,position_y));
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public static void main (String[] args){
		
		Base_jdbc BD = new Base_jdbc(); 
		int choix;
        String instance = "";
		Entreprise GOB = new Entreprise();
		do {
			
			System.out.println("+------------------------------------------------------+");
			System.out.println("| Que voulez vous faire ?                              |");
			System.out.println("| 1 : petite taille                     |");
			System.out.println("| 2 : moyenne taille          |");
			System.out.println("| 3 : grande taille                                 |");
			System.out.println("+------------------------------------------------------+");
			choix = Clavier.lireInt();
			switch (choix) {
            case 1 : instance = "Petite_taille";break;
            case 2 : instance = "Taille_moyenne";break;
            case 3 : instance = "Un_peu_plus_grand";break;
			}
			
		} while (choix != 1 && choix !=2 && choix !=3);
        String fichier_clients = "FichiersExcel" + File.separator + instance  + File.separator + "clients.csv";
        String fichier_entrepots = "FichiersExcel" + File.separator + instance  + File.separator + "entrepots.csv";
        String fichier_routes = "FichiersExcel" + File.separator + instance  + File.separator + "routes.csv";
        String fichier_sites = "FichiersExcel" + File.separator + instance  + File.separator + "sites.csv";
		System.out.println("fin menu :)");

		
		GOB.CreateSite(fichier_sites);
		GOB.CreateClient(fichier_clients);
		GOB.CreateRoute(fichier_routes);
		GOB.CreateEntrepot(fichier_entrepots);
		
        try {
			BD.drop_ALL();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BD.create_tables();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BD.INSERT_Sites(GOB);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			BD.INSERT_Clients(GOB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BD.INSERT_Entrepots(GOB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BD.INSERT_Routes(GOB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}
