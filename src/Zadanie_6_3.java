import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zadanie_6_3 {

	public static void main(String[] args) throws IOException {
		String plik2 = "C:\\Users\\test\\Desktop\\java\\test.txt";
		sumujIZapisz(plik2);

	}

	public static void sumujIZapisz(String nazwaPliku) throws IOException {
		File plik = new File(nazwaPliku);
		if(plik.exists()==false) {
			BufferedWriter dodaj = new BufferedWriter(new FileWriter(plik));
			dodaj.write("1");
			dodaj.close();
		}
		else {
		BufferedReader czyt = new BufferedReader(new FileReader(plik));
		BufferedWriter dod = new BufferedWriter(new FileWriter(plik, true));
		
		String linijka;
		int suma = 0 ;
		while ((linijka = czyt.readLine()) != null) {
			suma+=Integer.valueOf(linijka);
		}
		
		

		czyt.close();
		dod.write("\r\n"+Integer.toString(suma));		
		dod.close();
		}
	}
}