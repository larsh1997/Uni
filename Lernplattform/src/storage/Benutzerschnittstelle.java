package storage;

import java.util.Scanner;




public class Benutzerschnittstelle {
	
	private Scanner inputScanner = new Scanner(System.in);
	
	
	public Benutzerschnittstelle() {
		
		
		
		/*
		 * Willkommen bei der Lernmaschine
		 * 
		 */
		System.out.println("Willkommen bei der Lernmaschine!");
		System.out.println("--------------------------------");
		System.out.println("e - Informationen eintragen");
		System.out.println("l - Informationen l�schen!");
		System.out.println("a - Alle Informationen anzeigen");
		System.out.println("w - Lerndokumente ausw�hlen");
		System.out.println("b - Programm beenden");
		System.out.println("--------------------------------");
		String eingabe;
		
		
		do {
			System.out.println("Bitte w�hlen Sie aus: ");
			if (!inputScanner.hasNextLine()) {
				inputScanner = new Scanner(System.in);
				break;  //control Z
			}
			eingabe = inputScanner.nextLine().trim().toLowerCase();
			if(!(eingabe.length() == 1)) {
				System.out.println("Die Eingabe muss ein Zeichen lang sein!");
			 }	
		
		}	while(!(eingabe.length() == 1));	
		
		switch(eingabe) {
		case ("e"):
			System.out.println("Informationen eintragen");
			System.out.println("--------------------------------");
			System.out.println("v - Lehrveranstaltung eintragen");
			System.out.println("l - Lerndokument eintragen");
			System.out.println("a - Ausarbeitung eintragen");
			System.out.println("z - Zur�ck zum Hauptmen�");
			System.out.println("--------------------------------");
			
			break;
		case ("l"):
			System.out.println("Informationen l�schen");
			System.out.println("--------------------------------");
			System.out.println("v - Lehrveranstaltung l�schen");
			System.out.println("l - Lerndokument l�schen");
			System.out.println("a - Ausarbeitung l�schen");
			System.out.println("z - Zur�ck zum Hauptmen�");
			System.out.println("--------------------------------");
				
			break;
		case ("a"):
			//Hilfe?
			
			
			
			break;
		case ("w"):
			System.out.println("Lerndokument einer Lehrveranstaltung ausw�hlen");
			System.out.println("--------------------------------");
			System.out.println("n - Dokument nach Namen ausw�hlen");
			System.out.println("a - Dokument nach alter ausw�hlen");
			System.out.println("k - Dokument nach Kategorie ausw�hlen");
			System.out.println("b - Dokument nach Bewertung ausw�hlen");
			System.out.println("z - zur�ck zum Hauptmen�");
			System.out.println("--------------------------------");
			
			break;
		case ("b"):
			System.out.println("Programm wird beendet");
			System.exit(1);
			
			break;
			
		
		}
		
	}

	
		
	}


