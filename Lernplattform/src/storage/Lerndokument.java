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
	public void ausarbeitungEintragen(Lerndokument ausa) {
		ausarbeitungen.put(name, ausa);
	}
	
	
	/*
	 * Gibt alle Elemente der TreeMap wieder.
	 * 
	 * @return 		Alle Ausarbeitungen
	 */
	public ausarbeitungen gibAusarbeitungen() {
		
		for (String x : ausarbeitungen.keySet()) {
			return(ausarbeitungen.get(x));
		}
		
	
		
		
	}
}
