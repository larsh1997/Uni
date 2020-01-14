package storage;

import java.util.TreeMap;
import java.io.*;

/*
 * Stelle eine Implementierung der Speicherschnittstelle da. Im ersten 
 * Ansatz wird nur in einer TreeMap gespeichert.
 */


public class Datenbank implements Speicherschnittstelle {
	
	/*
	 * Alle Methoden für spätere I/O Operationen sind mit "throws Exception" gekennzeichnet
	 */
	
	protected TreeMap<String, Lehrveranstaltungen> lehrveranstaltungen = new TreeMap<>();
	
	


	public TreeMap<String, Lehrveranstaltungen> gibLehrveranstaltungen() {
		return lehrveranstaltungen;
	}


	public Lehrveranstaltungen gibLeherveranstaltung(String name) {
		return lehrveranstaltungen.get(name);
		
	}

	
	public boolean istLehrveranstaltungVorhanden(String name) {
		return lehrveranstaltungen.containsKey(name);
	}

	
	public int  gibAnzahlLehrveranstaltungen() {
		return lehrveranstaltungen.size();
	}
	
	
	public void leseDatenEin() throws Exception {
		//nichts wird eingelesen
	}

	/*
	 * Speichert eine neue Ausarbeitung nur in der Laufzeit-Objektstruktur 
	 */
	@Override
	public Lerndokument ausarbeitungAnlegen(Lehrveranstaltungen lv, Lerndokument ld, Lerndokument ausa)
			throws Exception {
		return ld.ausarbeitungEintragen(ausa);
	}

	
	public Lerndokument ausarbeitungLoeschen(Lehrveranstaltungen lv, Lerndokument ld, Lerndokument ausa)
			throws Exception {
		return ld.gibAusarbeitungen().remove(ausa.gibName());
	}

	
	public Lerndokument lerndokumentAnlegen(Lehrveranstaltungen lv, Lerndokument ld) throws Exception {
		return lv.lerndokumentEintragen(ld);
	}

	
	public Lerndokument lerndokumentloeschen(Lehrveranstaltungen lv, Lerndokument ld) throws Exception {
		return lv.gibLerndokumente().remove(ld.gibName());
	}

	
	public Lehrveranstaltungen lehrveranstaltungAnlegen(Lehrveranstaltungen lv) throws Exception {
		return lehrveranstaltungen.put(lv.gibName(), lv);
	}

}
