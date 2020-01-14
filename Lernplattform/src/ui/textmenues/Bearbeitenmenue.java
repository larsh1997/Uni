package ui.textmenues;

public enum Bearbeitenmenue implements Menuefunktionen  {

	ANZEIGEN("a", "Dokument anzeigen"),
	BEWERTEN("b", "Dokument bewerten"),
	AENDERN("s", "Speicherort �ndern"),
	AKTUALISIEREN("d", "�nderungsdatum aktualisieren"),
	ZURUECK("z", "zur�ck zum Auswahlmen�");
	
	
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
