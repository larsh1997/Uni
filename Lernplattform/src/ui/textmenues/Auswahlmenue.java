package ui.textmenues;

public enum Auswahlmenue implements Menuefunktionen {
	
	NACHNAME("n", "Dokument nach Namen ausw�hlen"),
	NACHALTER("a", "Dokument nach Alter ausw�hlen"),
	NACHKATEGORIE("k", "Dokument nach Kategorie ausw�hlen"),
	NACHBEWERTUNG("b", "Dokument nach Bewertung ausw�hlen"),
	ZURUECK("z", "zur�ck zum Hauptmen�");
	
	
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
