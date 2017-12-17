import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Zadanie_6_8 {

	public static void main(String[] args) throws IOException {
		String plikwe="dokument";
		zamiana(plikwe);

	}
	
	public static void zamiana(String nazwaPliku) throws IOException {
		String sciezka = "C:\\Users\\test\\Desktop\\java\\";
		File plik = new File(sciezka+nazwaPliku+".txt");
		BufferedReader czyt = new BufferedReader(new FileReader(plik));
		BufferedWriter dod = new BufferedWriter(new FileWriter(new File(sciezka+nazwaPliku+".html")));
		
		dod.write("<!DOCTYPE html>"+"\r\n");
		dod.write("<html lang=+\"en\">"+"\r\n");
		dod.write("<head>"+"\r\n");
		dod.write("<meta charset=\"utf-8\">"+"\r\n");
		dod.write("<title>Tytu³</title>"+"\r\n");
		dod.write("</head>"+"\r\n");
		dod.write("<body>"+"\r\n");
		
		String linia; int hash=0, hashstop=0, i=0; boolean otwarty=false;
		while ((linia=czyt.readLine())!=null) {
				hash=0; i=0;
				while (i<6) {
					if (i<linia.length() && linia.charAt(i)=='#') {
						hash++;
						i++;
					}
					else {
						break;
					}
				}
				if (hash>hashstop) {
					dod.write("<h"+Integer.toString(hash)+">");
					hashstop=hash;
					for (int j=i; j<linia.length(); j++) {
						dod.write(linia.charAt(j));
					}
					dod.write("</h"+Integer.toString(hash)+">");
				}	
				
				else if (linia.length()>0){
					if (otwarty == false) {
					dod.write("<p>\r\n");
					otwarty = true;
					}
					for (int j=0; j<linia.length(); j++) {
						if (linia.charAt(j)=='*') {
							i=j;
							while (Character.isWhitespace(linia.charAt(i))==false) {
								i++;
							}
							if (linia.charAt(i-1)=='*') {
								dod.write("<strong>");
								for (int k=j+1; k<i-1; k++) {
									dod.write(linia.charAt(k));
								}
								dod.write("</strong>");
								j=i-1;
							}
						}
						else {
						dod.write(linia.charAt(j));
						}
						
					}
				}
				else if (linia.length()==0) {
					if (otwarty == true) {
						dod.write("</p>\r\n");
					}
					dod.write("\r\n");
				}
				dod.write("\r\n"+"</body></html>");
		}
				
		czyt.close();
		dod.close();		
			
		
	}

}
