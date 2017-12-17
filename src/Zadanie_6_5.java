import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Zadanie_6_5 {

	public static void main(String[] args) throws IOException {
		String plikwe="emeryt.txt";
		emerytura(plikwe);

	}
	
	public static void emerytura(String nazwaPliku) throws IOException {
		String sciezka = "C:\\Users\\test\\Desktop\\java\\";
		File plik = new File(sciezka+nazwaPliku);
		BufferedReader czyt = new BufferedReader(new FileReader(plik));
		BufferedWriter dodk = new BufferedWriter(new FileWriter(new File(sciezka+"kobiety.txt")));
		BufferedWriter dodm = new BufferedWriter(new FileWriter(new File(sciezka+"mezczyzni.txt")));

		String linijka, imie="", nazwisko="";
		int i=0, lata=0;
		while ((linijka=czyt.readLine())!=null) {
			imie=""; nazwisko=""; i=0; lata=0;
				while (i<linijka.length() && Character.isWhitespace(linijka.charAt(i))==false) {		// zapamietuje imie
					imie=imie+linijka.charAt(i);
					i++;
				}
				i++;
				
				while (i<linijka.length() && Character.isWhitespace(linijka.charAt(i))==false) {		// zapamietuje nazwisko
					nazwisko=nazwisko+linijka.charAt(i);
					i++;
				}
				
				for (int j=i+3; j<linijka.length(); j++) {												// wczytuje wiek
					lata = lata*10+Integer.valueOf(linijka.charAt(j)-'0');
				}
				i++;
				
				if (i<linijka.length() && linijka.charAt(i)=='K') {										// klasyfikuje jako kobieta/mezczyzna
					dodk.write(imie+" "+nazwisko+" "+(60-lata)+"\r\n");
				}
				else if (i<linijka.length() && linijka.charAt(i)=='M') {
					dodm.write(imie+" "+nazwisko+" "+(65-lata)+"\r\n");
				}
				
				
			
			
		}
		
		dodk.close();
		dodm.close();
		czyt.close();
		
		
	}

}
