package storage;
import java.util.*;
import java.time.*;
/*
 * Lerndokumenten gehören zu Lehrveranstaltungen. Lerndokumente können 
 * Ausarbeitungen enhalten
 * 
 * @author Lars Hansmann
 * @version 18.12.2019
 * 
 */
public class Lerndokument {
	//Attribute
	
	private String 			name;
	private double 			bewertung;
	private int 			anzahlBewertungen;
	private Kategorie 		kategorie;
	private String 			speicherort;
	private LocalDateTime 	date;
	private Format			format;
	private TreeMap<String, Lerndokument> ausarbeitungen;
	
	
	/*
	 * Konsturktor für Objekte der Klasse Lerndokument
	 * 
	 */
	public Lerndokument (String name, Kategorie kategorie,
						String speicherort, Format format) 
	{
		this.name = name;
		this.kategorie = kategorie;
		ausarbeitungen = new TreeMap<>();
		anzahlBewertungen = 0;
		this.speicherort = speicherort;
		this.format = format;
		date = LocalDateTime.now();   //Uhrzeit von der Systemuhr	
	}
	
	
	/*
	 * Gibt den Namen eines Lerndokumentes wieder.
	 * 
	 * @return 		Name eines Lerndokumentes
	 * 
	 */
	public String gibName() {
		return name; 
	}
	
	
	
	/*
	 * Gibt die Kategorie eines Lerndokumentes wieder.
	 * 
	 * @return 		Kategorie eines Lerndokumentes
	 */
	public Kategorie gibKategorie() {
		return kategorie;
	}
	
	
	/*
	 * Gibt den Speicherort eines Lerndokumentes wieder.
	 * 
	 * @return		Speicherort eines Lerndokumentes
	 */
	public String gibSpeicherort()  {
		return speicherort;
	}
	
	
	/*
	 * Gibt das anlege Datum eines Dokumentes wieder.
	 * 
	 * @return		Anlege Datum eines Dokumnetes
	 */
	public LocalDateTime gibDatum() {
		return date;
	}
	
	
	/*
	 * Gibt das Format eines Dokumentes wieder.
	 * 
	 * @return		Format eines Dokumentes
	 */
	public Format gibFormat() {
		return format;
	}
	
	/*
	 * Aktualsiert das Datum eine Dokumentes.
	 * 
	 */
	public void aktualisiereDatum() {
		 date = LocalDateTime.now();
	}
	
	
	/*
	 * Ändert den Speicherort eines Dokumentes
	 * 
	 */
	public void setzteSpeicherort(String ort) {
		speicherort = ort;
	}
	
	
	/*
	 * Trägt eine Ausarbeitung ein
	 * 
	 */
	/*public void ausarbeitungEintragen(Lerndokument ausa) {
		
		if (ausa.kategorie != Kategorie.AUSARBEITUNG) {
			throw new IllegalArgumentException("Das Lerndokument ist nicht vom Typen Ausarbeitung");
		}
		
		ausarbeitungen.put(ausa.gibName(), ausa);
	
	}*/
	public Lerndokument ausarbeitungEintragen(Lerndokument ausa) {
		
		if (ausa.kategorie != Kategorie.AUSARBEITUNG) {
			throw new IllegalArgumentException("Das Lerndokument ist nicht vom Typen Ausarbeitung");
		} else {
		
		return(ausarbeitungen.put(ausa.gibName(), ausa));
		}
	}
	
	
	
	/*
	 * Gibt alle Elemente der TreeMap wieder.
	 * 
	 * @return 		Alle Ausarbeitungen
	 */
	public TreeMap<String, Lerndokument> gibAusarbeitungen() {
		
		
		
		return ausarbeitungen;
		}
	
	/*
	 * Gibt Ausarbeitungen seit einem gegebenem Datum wieder
	 * 
	 * @para	datum	Gewünschtes Datum ab dem die Ausarbeitungen 
	 * 					wiedergegeben werden sollen
	 * @return 			Alle Ausarbeitungen seit gegebenem Datum
	 */
	public TreeMap<String, Lerndokument> gibAusarbeitungenSeit(LocalDateTime date) {
		
		TreeMap<String, Lerndokument> resultmapTime = new TreeMap<>();   
		
		LocalDateTime ausarbeitungenSeit = date;
		if (ausarbeitungenSeit != null)  {
		ausarbeitungen.forEach(
				(k,v) -> {if (v.gibDatum().isAfter(ausarbeitungenSeit)) resultmapTime.put(k,v);});
		} else {
			throw new NullPointerException ("Es wurde kein zulässiges Datum eingegeben");
		}
			
		return resultmapTime;
		
	}
	
		
	/*
	 * Gibt eine gesuchte Ausarbeitung wieder
	 * 
	 * @para	name	Name der gesuchten ausarbeitung 
	 * 
	 * @return			Ausarbeitung
	 */
	 public Lerndokument gibAusarbeitung (String name) {
	    	return ausarbeitungen.get(name);
	    }
	 /*
	  * Lerndokument bewerten
	  * 
	  * @para 	anzahlSterne 	Anzahl an Sternen die man geben will
	  */ 
	 public void bewerte (int anzahlSterne) {
		 anzahlBewertungen++;
		 if (anzahlSterne > 5) {
			 anzahlSterne = 5;
		 } else if (anzahlSterne < 0) {
			 anzahlSterne = 0;
		 }
		 bewertung = (bewertung + anzahlSterne)/anzahlBewertungen;
		
	 }
	 
	 
	 /*
	  * Gibt die Bewertung eines Lerndokumentes zurück
	  * 
	  * @return			Bewertung eines Lerndokumentes
	  */ 
	 public double gibBewertung() {
		 return bewertung;
	 }
	 
	 /*
	  * Anzahl der abgegebenen Bewertungen wiedergeben
	  * 
	  * @return 	int 	Anzahl der Bewertungen
	  */
	 public int gibAnzahlBewertungen() {
		 return anzahlBewertungen;
	 }
		
		
	}

