import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zadanie_6_6 {

	public static void main(String[] args) throws IOException {
		String plikwe="dohtml.txt";
		html(plikwe);

	}
	
	public static void html(String nazwaPliku) throws IOException {
		String sciezka = "C:\\Users\\test\\Desktop\\java\\";
		File plik = new File(sciezka+nazwaPliku);
		BufferedReader czyt = new BufferedReader(new FileReader(plik));
		BufferedWriter dod = new BufferedWriter(new FileWriter(new File(sciezka+"html.txt")));
		
		dod.write("<html><body>"+"\r\n");
		dod.write("<table>"+"\r\n");
		
		String linijka;
		while ((linijka=czyt.readLine())!=null) {
			dod.write("<tr><td>");
			for (int i=0; i<linijka.length(); i++) {
				if (Character.isWhitespace(linijka.charAt(i))==true){
					dod.write("</td><td>");
				}
				else {
					dod.write(linijka.charAt(i));
				}
			}
			dod.write("\r\n"+"</tr></td>"+"\r\n");
		}
		dod.write("</table>");
		dod.write("\r\n"+"</body></html>");
		
		czyt.close();
		dod.close();
		
	}

}
