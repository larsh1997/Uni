package ui.textmenues;

public enum Loeschenmenue implements Menuefunktionen  {
	
	LEHRVERANSTALTUNGLOESCHEN("v", "Lehrveranstaltung l�schen"),
	LERNDOKUMENTLOESCHEN("l", "Lerndokument l�schen"),
	AUSARBEITUNGLOESCHEN("a", "Ausarbeitung l�schen"),
	ZURUECK("z", "zur�ck ins Hauptmen�");
	
	
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
