package ui;

import java.io.FileNotFoundException;

import storage.Lehrveranstaltungen;
import storage.Speicherschnittstelle;
import ui.textmenues.Eintragemenue;
import ui.textmenues.Hauptmenue;
import ui.textmenues.Menuefunktionen;

public class Textschnittstelle extends Benutzerschnittstelle  {

	public Textschnittstelle(Speicherschnittstelle db) {
		super(db);
		try {
			db.leseDatenEin();
		}
		catch(FileNotFoundException fnfex) {
			//Beim ersten start gibt es die Datenbank noch nicht
		}
		catch(Exception ex) {
			System.out.println("Die lokalen Daten konnten nicht eingelesen werden");
			System.out.println("Fehlerart: " + ex);
			System.exit(1);  		//Programm beenden
		}
		}
	

	@Override
	public void start() {
		System.out.println("User " +System.getProperty("user name")+ " , willkommen bei der Lernmaschine!"); //Gibt den Account Namen des Nutzers aus
																											 //user name ersetzt durch os.name würde OS Namen ausgeben
		if (db.gibAnzahlLehrveranstaltungen() == 0) {
			System.out.println("Die Datenbank ist noch leer.");
			System.out.println("Bitte tragen sie eine Lehrveranstaltung ein.");
			lehrveranstaltungEintragen();
		}
		
		//Hauptmenü zeigen
		do {
			Menuefunktionen.titelAusgeben("Hauptmenü");
			switch(Menuefunktionen.auswaehlen(Hauptmenue.class)) {
			case EINTRAGEN: eintragenMenueZeigen();
			break;
			case LOESCHEN: loeschenMenueZeigen();
			break;
			case ANZEIGEN: Lehrveranstaltungen lv = LehrveranstalungAuswaehlen();
						   if (lv == null) return; //Exit 
						   System.out.println("Alle Lerndokumente deer Lehrveranstaltung " + lv.gibName() + ":");
						   lv.gibLerndokumente().forEach((k, v) -> lerndokumentAnzeigen(v));
			break;
			case AUSWAEHLEN: auswahlMenueZeigen();
			break;
			case BEENDEN: return;
			} 
		} while (true);
		
	}
	public void eintragenMenueZeigen() {
		do {
			Menuefunktionen.titelAusgeben("Informationen eintragen");
			switch(Menuefunktionen.auswaehlen(Eintragemenue.class)) {
			case LEHRVERANSTALTUNGEINTRAGEN: lehrveranstaltungEintragen();
			break;
			case LERNDOKUMENTEINTRAGEN: lerndokumentEintragen();
			break;
			case AUSARBEITUNGEINTRAGEN: ausarbeitungEintragen();
			break;
			case ZURUECK: return; 
			
			}
		} while (true);
		
	}
	
	public void loeschenMenueZeigen() {
		do {
			
		}
		
	}
	
	public void auswahlMenueZeigen() {
		
	}

	


}
