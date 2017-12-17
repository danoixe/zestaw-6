import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zadanie_6_4 {

	public static void main(String[] args) throws IOException {
		String plik2 = "ala.txt";
		String plik3 = "_ala.txt";
		int move = 85;
		szyfruj(plik2, move);
		deszyfruj(plik3, move);

	}
	
	public static void szyfruj(String nazwaWe, int przesun) throws IOException {
		String sciezka = "C:\\Users\\test\\Desktop\\java\\";
		File plik = new File(sciezka+nazwaWe);
		BufferedReader czyt = new BufferedReader(new FileReader(plik));
		BufferedWriter dod = new BufferedWriter(new FileWriter(new File(sciezka+"_"+nazwaWe)));
		
		String linijka; 
	
		while ((linijka = czyt.readLine()) != null) {
			for(int i=0; i<linijka.length(); i++) {
				if (Character.isWhitespace(linijka.charAt(i))==true){
					dod.write(" ");
				}
				else if (linijka.charAt(i)>64 && linijka.charAt(i)<91){
					dod.write((char) ((linijka.charAt(i)+przesun-65)%26)+65);
				}
				else if (linijka.charAt(i)>96 && linijka.charAt(i)<123){
					dod.write((char) ((linijka.charAt(i)+przesun-97)%26)+97);
				}
				
				
			}
		}
		dod.close();
		czyt.close();
	
	}
	
	
	public static void deszyfruj(String nazwaWe, int przesun) throws IOException {
		String sciezka = "C:\\Users\\test\\Desktop\\java\\";
		File plik = new File(sciezka+nazwaWe);
		BufferedReader czyt = new BufferedReader(new FileReader(plik));
		BufferedWriter dod = new BufferedWriter(new FileWriter(new File(sciezka+"_"+nazwaWe)));
		
		String linijka; 
	
		while ((linijka = czyt.readLine()) != null) {
			for(int i=0; i<linijka.length(); i++) {
				if (Character.isWhitespace(linijka.charAt(i))==true){
					dod.write(" ");
				}
				else if (linijka.charAt(i)>64 && linijka.charAt(i)<91){
					dod.write((char) ((((linijka.charAt(i)-przesun-65)%26)+26)%26)+65);
				}
				else if (linijka.charAt(i)>96 && linijka.charAt(i)<123){
					dod.write((char) ((((linijka.charAt(i)-przesun-97)%26)+26)%26)+97);
				}
				
				
			}
		}
		dod.close();
		czyt.close();
	}

}