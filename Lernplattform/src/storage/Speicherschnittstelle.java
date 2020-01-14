package storage;

import java.util.TreeMap;
import java.io.*;



public interface Speicherschnittstelle {
	
	/*
	 * Gibt alle Lehrveranstaltungen wieder
	 */
	public abstract TreeMap<String, Lehrveranstaltungen> gibLehrveranstaltungen();
	
	
	/*
	 * Gibt Lehrveranstaltungen mit gesuchtem Namen zurück
	 */
	public abstract Lehrveranstaltungen gibLeherveranstaltung(String name);
	
	
	/*
	 * Prüft, ob eine Lehrveranstaltung mit gegebenem Namen vorhanden ist
	 */
	public abstract boolean istLehrveranstaltungVorhanden(String name);
	
	
	/*
	 * Gibt die Anzahl aller Lehrveranstaltungen zurück
	 */
	public abstract int gibAnzahlLehrveranstaltungen();
	
	
	/*
	 * Liest, die Daten aus dem Permenentspeicher in das TreeMap-Objekt der Lehrveranstaltungen ein, 
	 * wie muss eine Unterklasse definieren
	 */
	public abstract void leseDatenEin() throws Exception;
	
	
	/*
	 * Speichert eine neue Ausarbeitung in der Laufzit-Objektstruktur und 
	 * im Permanentspeicher, wie muss eine Unterklasse definieren 
	 */
	public abstract Lerndokument ausarbeitungAnlegen(Lehrveranstaltungen lv, Lerndokument ld, Lerndokument ausa) throws Exception;
	
	
	/*
	 * Löscht eine Ausarbeitung in der Laufzeit-Objektstruktur und im Permanentspeicher,
	 * wie muss eine Unterklasse definieren
	 */
	public abstract Lerndokument ausarbeitungLoeschen(Lehrveranstaltungen lv, Lerndokument ld, Lerndokument ausa) throws Exception;
	
	
	/*
	 * Speichert ein neues Lerndokument in der Laufzeut-Objekstruktur und
	 * im Permanentspeicher, wie muss eine Unterklasse definieren 
	 */
	public abstract Lerndokument lerndokumentAnlegen(Lehrveranstaltungen lv, Lerndokument ld) throws Exception;
	
	
	/*
	 * Löscht ein Lerndokument in der Laufzeit-Objektstruktur und 
	 * im Permanentspeicher, wie muss eine Unterklasse definieren 
	 */
	public abstract Lerndokument lerndokumentloeschen(Lehrveranstaltungen lv, Lerndokument ld) throws Exception;
	
	
	/*
	 * Speichert eine neue Lehrveranstaltung im TreeMap-Objekt der Lehrveranstaltungen und
	 * im Permanentspeicher, wie muss eine Unterklasse definieren 
	 */
	public abstract Lehrveranstaltungen lehrveranstaltungAnlegen(Lehrveranstaltungen lv) throws Exception;
	
}
