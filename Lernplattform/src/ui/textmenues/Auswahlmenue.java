package ui.textmenues;

public enum Auswahlmenue implements Menuefunktionen {
	
	NACHNAME("n", "Dokument nach Namen auswählen"),
	NACHALTER("a", "Dokument nach Alter auswählen"),
	NACHKATEGORIE("k", "Dokument nach Kategorie auswählen"),
	NACHBEWERTUNG("b", "Dokument nach Bewertung auswählen"),
	ZURUECK("z", "zurück zum Hauptmenü");
	
	
	private final String funktionscode;
	private final String funktionstext;
	
	Auswahlmenue (String code, String text){
		funktionscode = code;
		funktionstext = text;
	}	
	
	@Override
	public String toString() {
		return funktionscode + " - " + funktionstext;

}
}
