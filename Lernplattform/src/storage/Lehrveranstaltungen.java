package storage;

import java.util.*;
import java.time.*;
/*
 * Die Klasse Lehrveranstaltungen beschreibt Lehrveranstaltungen und verweist auf dazugehörende Lerndokumente.
 */
import java.time.format.DateTimeFormatter;

public class Lehrveranstaltungen implements java.io.Serializable{
	
	private String name;
	private TreeMap<String, Lerndokument> lerndokumente;  //Name des Dokumentes verweist auf ein Dokument Schlüssel/Wertpaar
	
	
	/*
	 * Konstruktor für Objekte der Klasse Lehrveranstaltungen
	 * 
	 */
	public Lehrveranstaltungen(String name)   
	{
		this.name = name; 
		lerndokumente = new TreeMap();
	}
	


	/*
	 * Gibt Namen der Lehrveranstaltung wieder
	 * @return 		Name der Lehrveranstaltung
	 */
	public String gibName()					
	{
		return name; 
	}
	
	/*
	 * Lerndokument eintragen
	 * 
	 * @para	Lerndokument 	
	 * 
	 */
	public Lerndokument lerndokumentEintragen(Lerndokument ld) {
		
		assert ld != null;
		return(lerndokumente.put(ld.gibName(), ld));  //ld.gibName() = key, ld = value;
	}
	
	/*
	 * Lerndokument löschen
	 * 
	 * @para 	String 	Name des zulöschenden Lerndokumentes
	 * 
	 * @return			Lerndokument
	 */
	public Lerndokument lerndokumentLoeschen(String name) {
		
		return lerndokumente.remove(name);
			
	}
	
	
	/*
	 * Gibt die Anzahl der Lerndokumte wieder (Größe der TreeMap)
	 * 
	 * @return		Anzahl der Lerndokumente
	 */
	public int gibAnzahlLerndokumente()
	{
		return lerndokumente.size();
	}
	
	
	
	/*
	 * Gibt das Lerndokument mit gegebenem Namen zurück
	 * 
	 * @param 	name	Name des gesuchten Dokumentes 
	 * 
	 * @return			Das Dokumente mit dem gegebenem Namen, oder null, falls nicht vorhanden  
	 */
	public Lerndokument gibLerndokument(String name)
	{
		return lerndokumente.get(name);
	}
	
	
	/*
	 * Gibt alle Lerndokumente zurück
	 * 
	 * @return			Alle Lerndokumente
	 */
	public TreeMap<String,Lerndokument> gibLerndokumente() {
		
		return lerndokumente;
	}
	
	
	
	
	/*
	 * Gibt die Lerndokumente einer gegebenen Kategorie zurück
	 * 
	 * @param	kat		Kategorie der gesuchten Lerndokumente. Die Kategorie kann auch 
	 * 					Ausarbeitung sein, dann werden alle Ausarbeitungen zu einer Lehrveranstaltung herausgesucht
	 * @return			eine TreeMap mit den gesuchten Lerndokumenten
	 */
	public TreeMap<String,Lerndokument> gibLerndokumente(Kategorie kat)
	{
		TreeMap<String, Lerndokument> resultmap = new TreeMap<>();
		if(kat != Kategorie.AUSARBEITUNG) {
			lerndokumente.forEach(
					(k,v) -> {if (v.gibKategorie() == kat) resultmap.put(k,v);});
		} else { //Kategorie = Ausarbeitung
		lerndokumente.forEach(
				(k,v) -> resultmap.putAll(v.gibAusarbeitungen()));
		}
		
		return resultmap;		
	}
	
	
	/*
	 * Gibt ein Lerndokument seit einem bestimmen Datum zurück
	 * 
	 * @para	LocalDateTime	Datum ab welchem die Dokumente wiedergegeben werden sollen
	 * 
	 * @return			Die gesuchten Lerndokumente
	 */
	
	public TreeMap<String, Lerndokument> gibLerndokumenteSeit(LocalDateTime date) {
		
		TreeMap<String, Lerndokument> resultmapTime = new TreeMap<>();   
		
		LocalDateTime lerndokumenteSeit = date;
		if (lerndokumenteSeit != null){
		lerndokumente.forEach(
				(k,v) -> {if (v.gibDatum().isAfter(lerndokumenteSeit)) resultmapTime.put(k,v);});
		} else {
			throw new NullPointerException ("Es wurde kein Datum angegeben");
		}
			
		return resultmapTime;
		
		
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
		lerndokumente.forEach(
				(k,v) -> {if ((v.gibDatum().isAfter(ausarbeitungenSeit)) && (v.gibKategorie() == Kategorie.AUSARBEITUNG)) resultmapTime.put(k,v);});
		} else {
			throw new NullPointerException ("Es wurde kein zulässiges Datum eingegeben");
		}
			
		return resultmapTime;
	}

	
	/*
	 * Findet ein Lerndokument zu einer gegebenen Ausarbeitung
	 * 
	 * @para	Lerndokument	
	 * 
	 * @return					Lerndokument zur Arbeitung
	 */
	/*public Lerndokument findeLerndokumentZurAusarbeitung(Lerndokument ausa) {
		
	}*/
	
	/*
	 * Ist die Lehrveranstaltungen mit dem gegebenen Namen vorhanden
	 * 
	 * @para	String		Name der gesuchten Lehrveranstaltung
	 * 
	 * @return 				true/false
	 */
	public boolean istLehrveranstaltungVorhanden(String name) {
		return lerndokumente.containsKey(name);
	}

	
}

