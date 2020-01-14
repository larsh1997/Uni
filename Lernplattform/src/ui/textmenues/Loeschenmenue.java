package ui.textmenues;

public enum Loeschenmenue implements Menuefunktionen  {
	
	LEHRVERANSTALTUNGLOESCHEN("v", "Lehrveranstaltung löschen"),
	LERNDOKUMENTLOESCHEN("l", "Lerndokument löschen"),
	AUSARBEITUNGLOESCHEN("a", "Ausarbeitung löschen"),
	ZURUECK("z", "zurück ins Hauptmenü");
	
	
	private final String funktionscode;
	private final String funktionstext;
	
	Loeschenmenue (String code, String text){
		funktionscode = code;
		funktionstext = text;
	}	
	
	@Override
	public String toString() {
		return funktionscode + " - " + funktionstext;
	}


}
