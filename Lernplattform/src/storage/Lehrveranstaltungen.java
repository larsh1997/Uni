package storage;

import java.util.*;
import java.time.*;
/*
 * Die Klasse Lehrveranstaltungen beschreibt Lehrveranstaltungen und verweist auf dazugehörende Lerndokumente.
 */

public class Lehrveranstaltungen {
	
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
	 * 
	 * 
	 */
	
	
	
	/*
	 * Gibt die Anzahl der Lerndokumte wieder (Größe der TreeMap)
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
	 * @return			Das Dokumente mit dem gegebenem Namen, oder null, falls nicht vorhanden 
	 * 
	 */
	public Lerndokument gibtLerndokument(String name)
	{
		return lerndokumente.get(name);
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
			lerndokumente.forEach((k,v) -> {if (v.gibKategorie() == kat) resultmap.put(k,v);});
		} else { //Kategorie = Ausarbeitung
		lerndokumente.forEach((k,v) -> resultmap.putAll(v.gibAusarbeitung()));
		}
		
		return resultmap;
			
		
	}

}

