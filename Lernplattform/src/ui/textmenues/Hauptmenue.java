package ui.textmenues;

public enum Hauptmenue implements Menuefunktionen  {
	
	EINTRAGEN("e", "Informationen eintragen"),
	LOESCHEN("l", "Informationen l�schen"),
	ANZEIGEN("a", "alle Informationen anzeigen"),
	AUSWAEHLEN("w", "Lerndokumente ausw�hlen"),
	BEENDEN("b", "Programm beenden");
	
	private final String funktionscode;
	private final String funktionstext;
	
	Hauptmenue(String code, String text){
		funktionscode = code;
		funktionstext = text;
	}	
	
	@Override
	public String toString() {
		return funktionscode + " - " + funktionstext;
	}

}
