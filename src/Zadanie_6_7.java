import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Zadanie_6_7 {

	public static void main(String[] args) throws IOException 
	{
		String plikwe="tekst.txt";
		wykres(plikwe);

	}
	
	public static void wykres(String nazwaPliku) throws IOException 
	{
		String sciezka = "C:\\Users\\test\\Desktop\\java\\";
		File plik = new File(sciezka+nazwaPliku);
		BufferedReader czyt = new BufferedReader(new FileReader(plik));
		BufferedWriter dod = new BufferedWriter(new FileWriter(new File(sciezka+"wykres.txt")));
		
		String linia; char litera = 'a'; int max=0;
		
		//liczba liter w tekscie
		int[] ilosc = new int[26];
		while ((linia=czyt.readLine())!=null) {
			for (int i=0; i<linia.length(); i++) {
				if (linia.charAt(i)>96 && linia.charAt(i)<123) {
				ilosc[linia.charAt(i)-97]++;
				}
			}
		}
		
		// najczestsza litera
		for (int i=0; i<ilosc.length; i++) {
			if (ilosc[i]>max) {
				max = ilosc[i];
			}
		}
		
		
		while (litera<='z') {
			int t = ilosc[litera-97]*50/max;
			dod.write(litera+" ");
			for (int i=0; i<t; i++) {
				dod.write('*');
			}
			for (int i=0; i<50-t; i++) {
				dod.write(" ");
			}
			dod.write(Integer.toString(ilosc[litera-97]));
			dod.write("\r\n");
			litera++;
		}	
		
		czyt.close();
		dod.close();
	}

}
