package ui.textmenues;

public enum Eintragemenue implements Menuefunktionen  {

	LEHRVERANSTALTUNGEINTRAGEN("v", "Lehrveranstaltung eintragen"),
	LERNDOKUMENTEINTRAGEN("l", "Lerndokument eintragen"),
	AUSARBEITUNGEINTRAGEN("a", "Ausarbeitung eintragen"),
	ZURUECK("z", "zurück zum Hauptmenü");
	
	
	private final String funktionscode;
	private final String funktionstext;
	
	Eintragemenue (String code, String text){
		funktionscode = code;
		funktionstext = text;
	}	
	
	@Override
	public String toString() {
		return funktionscode + " - " + funktionstext;
	}

}
