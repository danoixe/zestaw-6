import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class Zadanie_6_2 {

	public static void main(String[] args) throws IOException{
		String wejscie = "C:\\Users\\test\\Desktop\\java\\test.txt";
		String wyjscie = "C:\\Users\\test\\Desktop\\java\\test2.txt";
		String slowo = "egzamin";
		szukaj(wejscie, wyjscie, slowo);
	}
	
	public static void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo) throws IOException{
		File plikwe = new File(nazwaPlikWe);
		File plikwy = new File(nazwaPlikWy);
		BufferedWriter dod = new BufferedWriter(new FileWriter(plikwy));
		BufferedReader czyt = new BufferedReader(new FileReader(plikwe));
		String linijka;
		int k=0;
		while ((linijka=czyt.readLine())!=null) {
			k++;
				if (linijka.indexOf(slowo)>-1) {
					
					dod.write(k+": "+linijka+"\r\n"); 
					
			}
		}
		dod.close();
		czyt.close();
			
		
	}

}
