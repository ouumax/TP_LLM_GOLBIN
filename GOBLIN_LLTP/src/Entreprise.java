import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.util.OpencsvUtils;

import mediatheque.Clavier;



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

	            //System.out.println();
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
	           
	          //      System.out.print(cell + "\t");
	            }
	           // System.out.println();
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
	public static int lireInt() {
		try {
			return Integer.parseInt(lireString().trim());
		} catch (Exception e) {
			return Integer.MAX_VALUE;
		}
	}
	public static void main (String[] args){
		
		
		
		
		
		Entreprise GOB = new Entreprise();
		GOB.CreateSite("FichiersExcel/init-sites-30-Carre.csv");
		GOB.CreateClient("FichiersExcel/init-clients-30-10-Carre.csv");
		GOB.CreateRoute("FichiersExcel/init-routes-30-45-Carre.csv");
		GOB.CreateEntrepot("FichiersExcel/init-entrepots-30-5-Carre.csv");
		
		Base_jdbc BD = new Base_jdbc(); 
		int choix;
		do {
			System.out.println("+------------------------------------------------------+");
			System.out.println("| Que voulez vous faire ?                              |");
			System.out.println("| 1 : Afficher la liste des livres                     |");
			System.out.println("| 2 : Rechercher un livre via son numero ISBN          |");
			System.out.println("| 3 : Ajouter un livre                                 |");
			System.out.println("| 4 : Enregistrer un nouvel abonne                     |");
			System.out.println("| 5 : Consulter la fiche d'un abonne                   |");
			System.out.println("| 6 : Recherche un livre via une info partielle        |");
			System.out.println("| 7 : Enregistrer un nouvel emprunt                    |");
			System.out.println("| 100 : Quitter                                        |");
			System.out.println("+------------------------------------------------------+");
			choix = Clavier.lireInt();
			switch (choix) {
			case 1 : System.out.println(bib.toString());break;
			case 2 : bib.menuRechercherLivreViaISBN();break;
			case 3 : bib.ajouterlivre();break;
			case 4 : bib.ajouterabonne();break;
			case 5 : bib.consulterabonne();break;
			case 6 : bib.recherchelivreinfopartielle(); break;
			}
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
