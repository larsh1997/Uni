package ui.textmenues;

public enum Datumauswahl implements Menuefunktionen  {
	
	TAG("t", "nicht älter als 1 Tag"),
	WOCHE("w", "nicht älter als 1 Woche"),
	MONAT("m", "nicht älter als 1 Monat"),
	JAHR("j", "nicht älter als 1 Jahr");
	
	
	private final String funktionscode;
	private final String funktionstext;
	
	Datumauswahl(String code, String text){
		funktionscode = code;
		funktionstext = text;
	}	
	
	@Override
	public String toString() {
		return funktionscode + " - " + funktionstext;

} 
}