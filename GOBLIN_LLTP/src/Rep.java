import java.io.File;

public class Rep {
public static void main(String[] args) {
	File f = new File("FichiersExcel");
	File[] fics= f.listFiles();
	for ( File fi : fics) {
		if (fi.getAbsolutePath().contains("clients"))
		System.out.println(fi);
	}
}
}
