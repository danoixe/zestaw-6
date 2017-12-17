import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
public class Zadanie_6_1 {

	public static void main(String[] args) throws IOException{
		File plik1 = new File("C:\\Users\\test\\Desktop\\java\\test.txt");
		for (int j=0; j<licznik(plik1).length; j++) {
			System.out.println(licznik(plik1)[j]);
		}
		
	}
	public static int[] licznik(File plik) throws IOException{
		int[] tab = new int[3];
		int k=0, l=0, m=0, i=0;
		BufferedReader czyt = new BufferedReader(new FileReader(plik));
		String linijka;
		while ((linijka=czyt.readLine())!=null) {
			k=k+linijka.length();
			
			for(int j=0; j<linijka.length(); j++) {
				if (Character.isWhitespace(linijka.charAt(j))==true){
					l++;
				}
			}
			
			boolean czy = true;
			i=0;
			while (i<linijka.length()) {
				
				while (i<linijka.length() && Character.isWhitespace(linijka.charAt(i))==true){
					i++;			
				}
				if (i<linijka.length() && Character.isWhitespace(linijka.charAt(i))==false) {
				while (i<linijka.length() && Character.isWhitespace(linijka.charAt(i))==false){
					i++;			
				}
				m++;
				}
				 
			}
		}
		czyt.close();
		tab[0]=k;
		tab[1]=l;
		tab[2]=m;
		
		return tab;
	}

}
