package ui.textmenues;

public enum Bearbeitenmenue implements Menuefunktionen  {

	
	  EINTRAG_ANZEIGEN	 	( "p", "Dokumentparameter anzeigen"),
	  AUFRUFEN 	  			( "a", "Dokumentbetrachter aufrufen"),
	  BEWERTEN		   	    ( "b", "Bewertung eintragen"),
	  DATUM_AKTUALISIEREN 	("d", "�nderungsdatum aktualsilisieren"),
	  SPEICHERORT_AENDERN 	("s", "Speicherort �ndern"),
	  ZURUECK				("z", "zur�ck zum Auswahlmen�");
	 

	
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
