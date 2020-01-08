package storage;
/*
 *Beschreibt welche Dokument-Kategorien es gibt.
 * 
 * @author Lars Hansmann
 * @version 18.12.2019
 * 
 */

public enum Kategorie {
	SKRIPT("Vorlesungsskript"),
	KLAUSUR("Klausur"),
	UEBUNGSBLATT("Übungsblatt"),
	AUSARBEITUNG("Ausarbeitung zu einem Lerndokument");
	
	private final String kategorietext;
	
	Kategorie(String text){
		kategorietext = text;
	}
	
	@Override
	public String toString() {
		return kategorietext;
	}

}
