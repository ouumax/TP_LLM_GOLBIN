
// ---------------------------------------------
// Nom    : DEBRUYNE
// Prenom : Romuald
// ---------------------------------------------
import java.io.*;


/**
 * @author Romuald DEBRUYNE
 * @version 2020.2
 */
public class Clavier {
	static BufferedReader input =new BufferedReader (new InputStreamReader(System.in));

	/**
	 * Saisie au clavier d'un entier
	 * @return Retourne l'entier saisi par l'utilisateur si ce dernier saisit un entier representable par un int.
	 * Retourne Integer.MAX_VALUE dans le cas contraire (notamment si la saisie ne correspond pas a un entier) 
	 */
	public static int lireInt() {
		try {
			return Integer.parseInt(lireString().trim());
		} catch (Exception e) {
			return Integer.MAX_VALUE;
		}
	}
	
	/**
	 * Saisie au clavier d'un double
	 * @return Retourne la valeur de type double saisie par l'utilisateur si ce dernier saisit un nombre representable par un double.
	 * Retourne Double.MAX_VALUE dans le cas contraire (notamment si la saisie ne correspond pas a un double) 
	 */
	public static double lireDouble() {
		try {
			return Double.parseDouble(lireString().trim());
		} catch (Exception e) {
			return Double.MAX_VALUE;
		}
	}
	
	/**
	 * Saisie au clavier d'une chaine de caracteres.
	 * @return Retourne la chaine de caracteres saisie par l'utilisateur ("" en cas de levee d'exception)
	 */
	public static String lireString() {
		System.out.flush();
		try {
			return input.readLine();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * Saisie au clavier d'un caractere
	 * @return Retourne le caractere saisi par l'utilisateur ((char)0 en cas de levee d'exception)
	 */
	public static char lireChar() {
		try {
			return lireString().charAt(0);
		} catch (Exception e) {
			return (char)0;
		}
	}


   public static long lireLong() {
      try {
         return Long.parseLong(lireString().trim());
      } 
      catch (Exception e) {
         return 0L;
      }
   }
}

