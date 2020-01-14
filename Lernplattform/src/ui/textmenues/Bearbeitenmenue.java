package ui.textmenues;

public enum Bearbeitenmenue implements Menuefunktionen  {

	ANZEIGEN("a", "Dokument anzeigen"),
	BEWERTEN("b", "Dokument bewerten"),
	AENDERN("s", "Speicherort ändern"),
	AKTUALISIEREN("d", "Änderungsdatum aktualisieren"),
	ZURUECK("z", "zurück zum Auswahlmenü");
	
	
	private final String funktionscode;
	private final String funktionstext;
	
	Bearbeitenmenue (String code, String text){
		funktionscode = code;
		funktionstext = text;
	}	
	
	@Override
	public String toString() {
		return funktionscode + " - " + funktionstext;

}
}
