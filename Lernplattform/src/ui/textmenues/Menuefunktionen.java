package ui.textmenues;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Stream;
import java.util.Scanner;

public interface Menuefunktionen {
	
	/*
	 * L�sst den Benutzer ein Element aus einer Liste ausw�hlen (Men�punkt oder
	 * Dokumentattribut). Die verwendeten enum-Klassen m�ssen die Methoden toString() 
	 * �berschreiben. Zur Men�anzeige m�ssen die verwendeten enum-Klassen die Methode 
	 * toString() in der Art "funktionscode + " - " + funktionstext" �berschreiben.
	 * 
	 * @param	enumClass Class-objekt des verwendeten enum-Objekts
	 * @return	ausgew�hltes enum-Element
	 */
	public static <E extends Enum<E>> E auswaehlen(Class<E> enumClass) {  // E muss enum extenden damit die Elemente E vom typen Enum sind?
		do {
			Set<E> enumElemente = EnumSet.allOf(enumClass); //Enth�lt alle Elemente einer enum als Sammlung vom Typ "Set"
															//EnumSet wird durch die statische Methode "allOf()" erzeugt
															//EnumSet implementiert das Set-Interface und kann nur Enum elemente enthalten 
			
			enumElemente.forEach(System.out::println); //den in den enum-Elementen gespeicherten Text ausgeben
													   // Das gleiche wie enumElemnte.forEach(x -> System.out.println(x));
			
			System.out.println("------------------------");
			String eingabe = fragen("Bitte w�hlen sie aus", 1); //Userinput einlesen, ruft methode "fragen" auf die einlie�t
			if (eingabe == null) eingabe = "-";
			eingabe = eingabe.toLowerCase();
			
			for (E element : enumElemente) { //ausgew�hltes Element bestimmen
				if (element.toString().toLowerCase().startsWith(eingabe)) {
					System.out.println();
					return element;
				}
			}
			System.out.println("Ung�ltige Auswahl!");
		} while (true);
	
		
	}
	
	public static String fragen(String prompt, int minLength) {
		Scanner inputScanner = new Scanner(System.in);
		String eingabe;
		
		do {
			System.out.println(prompt + ": ");
			if (!inputScanner.hasNextLine()) {
				return null;					//control + z exit
			}
			eingabe = inputScanner.nextLine().trim();
			if (eingabe.length() < minLength)
				System.out.println("Die Eingabe muss mindestens " + minLength + "Zeichen lang sein");
			
		} while (eingabe.length() < minLength);
		inputScanner.close();
		return eingabe;
	}
	
	/*
	 * Zeigt eine unterstrichene �berschrift an
	 */
	public static void titelAusgeben(String titel) {
		System.out.println();
		System.out.println(titel);
		Stream.generate(()-> '-').limit(titel.length()).forEach(System.out::print); //generate generiert unendlich viele '-' und wird in diesem Fall auf 
																					// die L�nge des Titels limitiert.
		System.out.println();
	}
	
	

}
