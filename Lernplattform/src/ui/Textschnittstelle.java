package ui;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.TreeMap;

import storage.Kategorie;
import storage.Lehrveranstaltungen;
import storage.Lerndokument;
import storage.Speicherschnittstelle;
import ui.textmenues.Bearbeitenmenue;
import ui.textmenues.Datumauswahl;
import ui.textmenues.Eintragemenue;
import ui.textmenues.Hauptmenue;
import ui.textmenues.Loeschenmenue;
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
						   System.out.println("Alle Lerndokumente der Lehrveranstaltung " + lv.gibName() + ":");
						   lv.gibLerndokumente().forEach((k, v) -> lerndokumentAnzeigen(v));
			break;
			case AUSWAEHLEN: auswahlMenueZeigen();
			break;
			case BEENDEN: return;
			} 
		} while (true);
		
	}
	
	
	private void lehrveranstaltungEintragen() {
		
		
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

	
	private void lerndokumentEintragen() {
		
		do { 
			System.out.println("Bitte wählen sie eine Lehrveranstaltung aus: ");
			Lehrveranstaltungen lv = LehrveranstalungAuswaehlen();
			if (lv == null) return;
			lv.forEach((k,v) -> System.out.println(k));
			String lvname = Menuefunktionen.fragen("Bitte geben sie den Name der Lehrveranstaltung ein: ", 0); 
			String lvformat = Menuefunktionen.fragen("Welches Format hat das Dokument? ", 0);
			
			
			
			
		}
		
	}


	public void loeschenMenueZeigen() {
		do {
			Menuefunktionen.titelAusgeben("Informationen löschen");
			switch(Menuefunktionen.auswaehlen(Loeschenmenue.class)) {
			case LEHRVERANSTALTUNGLOESCHEN: lehrveranstaltungEintragen();
			break;
			case LERNDOKUMENTLOESCHEN: lerndokumentEintragen();
			break;
			case AUSARBEITUNGLOESCHEN: ausarbeitungEintragen();
			break;
			case ZURUECK: return; 
			
			}
			
		} while (true);
		 
	}
	
	public void auswahlMenueZeigen() {
		
	}
	private Lerndokument nachKategorieAuswaehlen(Lehrveranstaltungen lv) {
		
		Kategorie kategorie = Menuefunktionen.auswaehlen(Kategorie.class);
		TreeMap<String, Lerndokument> docmap = lv.gibLerndokumente(kategorie);
		return dokumentAuswaehlen(docmap);	
		
	}
	
	private Lerndokument nachNameAuswaehlen(Lehrveranstaltungen lv) {
		
		do {
		System.out.println("Bitte wählen sie ein Dokument aus: ");
		lv.gibLerndokumente().forEach((k,v) -> System.out.println(k));
		
		System.out.println("-------------");
		System.out.println("Ausarebitungen: ");
		System.out.println("-------------");
		lv.gibLerndokumente(Kategorie.AUSARBEITUNG).forEach((k,v) -> System.out.println(k));
		
		String ldname = Menuefunktionen.fragen("Bitte geben sie den Namens des Lerndokumentes ein", 0); 
		if (ldname == null) return null;
		
		if(lv.gibLerndokument(ldname) != null) {
			return lv.gibLerndokument(ldname);
		}
		else if 
			(lv.gibLerndokumente(Kategorie.AUSARBEITUNG).containsKey(ldname)) {
		
			return lv.gibLerndokumente(Kategorie.AUSARBEITUNG).get(ldname);
		}
		else  {
				System.out.println("Ungültige Auswahl!");
			}	
		} while (true);
	}
		
	
	
	
	/*
	 * Zeigt die in einem Lerndokument gespeicherten Informationen an
	 */
	private void lerndokumentAnzeigen (Lerndokument le){
		
		boolean istAusarbeitung = le.gibKategorie() == Kategorie.AUSARBEITUNG;
		String indent = "";
		if (istAusarbeitung) indent = "    "; //Ausarbeitungen werden eingerückt
		System.out.println("---------------------------");
		System.out.println("Name: " +le.gibName());
		System.out.println("Speicherort: " +le.gibSpeicherort());
		System.out.println("Datum: " +le.gibDatum());
		System.out.println("Kategorie: " +le.gibKategorie());
		System.out.println("Format: " +le.gibFormat());
		System.out.println("Bewertung" +le.gibBewertung());
		System.out.println("Anzahl Bewertungen: " +le.gibAnzahlBewertungen());
		if (!istAusarbeitung) {
			System.out.println("Anzahl Ausarbeitungen" +le.gibAusarbeitungen().size());
			le.gibAusarbeitungen().values().forEach(this::lerndokumentAnzeigen);
			System.out.println(indent +"---------------------------");
		}
	}
	
	
	
	
	private Lerndokument nachDatumAuswaehlen(Lehrveranstaltungen lv) {
		LocalDateTime date = LocalDateTime.now();
		Menuefunktionen.titelAusgeben("Alter des Dokumentes auswählen");
		switch(Menuefunktionen.auswaehlen(Datumauswahl.class)) {
		case TAG: 		date = date.minusDays(1);
		break;
		case WOCHE:		date = date.minusWeeks(1);
		break;
		case MONAT:		date = date.minusMonths(1);
		break;
		case JAHR:		date = date.minusYears(1);
	}
	TreeMap<String, Lerndokument> docmap = lv.gibLerndokumenteSeit(date);
	return dokumentAuswaehlen(docmap);

	}
	
	
	
	
	private Lerndokument dokumentAuswaehlen(TreeMap<String, Lerndokument> docmap) {
		
		if(docmap.size() == 0) {
			System.out.println("Es wurde kein Dokument der gewählten Art gefunden! ");
			return null;
		}
		else if (docmap.size() == 1) {
			System.out.println("Es wurde ein Dokument gefunden: " +docmap.firstEntry().getKey()); //Gibt den Key zum ersten gefunden element aus
			return docmap.firstEntry().getValue(); //Gibt den Wert des ersten und einzigen Elementes zurück
		}
		System.out.println("Bitte wählen sie ein Dokument aus der Liste aus: ");
		for (Lerndokument ld : docmap.values()) {
			if(ld.gibKategorie() == Kategorie.AUSARBEITUNG) {
				System.out.println(ld.gibName() + " (Ausarbeitung");
			}
			else { 
				System.out.println(ld.gibName());
			}
			String wahl = Menuefunktionen.fragen("Diese Dokument auswählen? j/n", 0);
			if (wahl == null) return null;
			if (wahl.toLowerCase().startsWith("j")) return ld;
		}
		System.out.println("Es wurde kein Dokument ausgewählt! ");
		return null;
		
		
	}
	
	
	
	
	
	private Lerndokument nachBewertungAuswaehlen(Lehrveranstaltungen lv) {
		
		boolean eingabe_ok = false;
		int mindestbewertung = 0;
		
		do {
			String eingabe = Menuefunktionen.fragen("Welche Bewertung sollen die Dokumente mindestens haben? [0-5]", 0);
			try {
				mindestbewertung = Integer.parseInt(eingabe);
			}
			catch (NumberFormatException numbex) {
				System.out.println("Bitte geben Sie einen ganzzahligen Wert ein");
				continue; //Zum Ende der Schleifen
			} 
			if (mindestbewertung < 0 || mindestbewertung > 5) {
				System.out.println("Bitte nur Werte zwischen 0 und 5 ");
			}
			else {
				eingabe_ok = true;
			}			
		} while (!eingabe_ok);
		
		final int minb = mindestbewertung;
		TreeMap<String, Lerndokument> resultmap = new TreeMap<>();
		//Alle Lerndokumente und Ausarbeitungen durchsuchen und in die resultmap kopieren
		
		lv.gibLerndokumente().forEach((k,v) -> 
		{ if(v.gibBewertung() >= minb) resultmap.put(k,v);
			v.gibAusarbeitungen().forEach((ka,va) ->
			{if (va.gibBewertung() >= minb) resultmap.put(ka,va);
			
			});
		});
		System.out.println("Liste aller Dokumente mit einer Mindestbewertung von " +minb +" Sternen");
		return dokumentAuswaehlen(resultmap);
	}
	
	
	
	
	private void bearbeitenMenueZeigen(Lehrveranstaltungen lv, Lerndokument ld) {
		if (ld == null) return;
		
		do {
			Menuefunktionen.titelAusgeben("Lerndokument " +ld.gibName() +" bearbeiten");
			switch(Menuefunktionen.auswaehlen(Bearbeitenmenue.class)) {
			case EINTRAG_ANZEIGEN: 			lerndokumentAnzeigen(ld);
			break;
			case AUFRUFEN:  				try {
												Thread.currentThread();
												Thread.sleep(1000);
												zeigeDokument(ld.gibFormat(), ld.gibSpeicherort());
											} catch (Exception e) {
												System.out.println("Das Dokument " +ld.gibSpeicherort() +" kann nicht angezeigt werden:" +e);
											}
			break;
			case BEWERTEN: 					dokumentBewerten(ld);
											speicherAktualisieren(lv, ld);
			break;	
			case DATUM_AKTUALISIEREN:		 ld.aktualisiereDatum();
											 System.out.println("Das Erstelldatum des Dokuments " +ld.gibName() +" wurded aktualisiert");
											 speicherAktualisierung(lv,ld);
											
			break;
			case SPEICHERORT_AENDERN: 		String ort = Menuefunktionen.fragen("Neuer Speicherort: ", 5);
											if (ort == null) return;
											ld.setzteSpeicherort(ort);
											speicherAktualsieren(lv, ld);
			break;
			case ZURUECK:	return;
			}
		} while (true);
	}
	
	 
	
		
	
	
	

	

	}

