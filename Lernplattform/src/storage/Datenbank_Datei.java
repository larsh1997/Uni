package storage;

import java.util.TreeMap;
import java.io.*;

public class Datenbank_Datei implements Speicherschnittstelle {
	
	protected TreeMap<String, Lehrveranstaltungen> lehrveranstaltungen = new TreeMap<>();
	String dateiname;
	
	


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
	/*
	 * ÷ffnet die Datei und liest die serialisierte TreeMap ein
	 */
	@SuppressWarnings("unchecked")
	public void leseDatenEin() throws Exception {
		/*FileInputStream fis = new FileInputStream(dateiname);
		//Objektleser erzeugen
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		lehrveranstaltungen = (TreeMap<String, Lehrveranstaltungen>) ois.readObject();
		ois.close();
		*/
	}
	
	
	/*
	 * Speichert in Serialisierte TreeMap in einer Datei (Alle Lehrveranstaltungen)
	 */
	public void speichereDaten() throws Exception {
		/*
		//÷ffnen der Datendatei
		FileOutputStream fos = new FileOutputStream(dateiname);
		//Objektserialisierer erzeugen
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//TreeMap-Objekt in die Datei schreiben
		oos.writeObject(lehrveranstaltungen);
		//Datei Schlieﬂen
		oos.close();
		*/
	}

	/*
	 * Speichert eine neue Ausarbeitung nur in der Laufzeit-Objektstruktur 
	 */
	@Override
	public Lerndokument ausarbeitungAnlegen(Lehrveranstaltungen lv, Lerndokument ld, Lerndokument ausa)
			throws Exception {
		Lerndokument ldreturned = ld.ausarbeitungEintragen(ausa);
		
		speichereDaten();
		return ldreturned;
	}

	
	public Lerndokument ausarbeitungLoeschen(Lehrveranstaltungen lv, Lerndokument ld, Lerndokument ausa)
			throws Exception {
		
		Lerndokument ldreturned = ld.gibAusarbeitungen().remove(ausa.gibName());
		
		speichereDaten();
		return ldreturned;
		//return ld.gibAusarbeitungen().remove(ausa.gibName());
	}

	
	public Lerndokument lerndokumentAnlegen(Lehrveranstaltungen lv, Lerndokument ld) throws Exception {
		
		Lerndokument ldreturend = lv.lerndokumentEintragen(ld);
		
		speichereDaten();
		return ldreturend;
		//return lv.lerndokumentEintragen(ld);
	}

	
	public Lerndokument lerndokumentloeschen(Lehrveranstaltungen lv, Lerndokument ld) throws Exception {
		Lerndokument ldreturend = lv.gibLerndokumente().remove(ld.gibName());
		
		speichereDaten();
		return ldreturend;
		//return lv.gibLerndokumente().remove(ld.gibName());
	}

	
	public Lehrveranstaltungen lehrveranstaltungAnlegen(Lehrveranstaltungen lv) throws Exception {
		/*Lehrveranstaltungen lvreturend = lehrveranstaltungen.put(lv.gibName(), lv);
		
		speichereDaten();
		return lvreturend;
		*/
		return lehrveranstaltungen.put(lv.gibName(), lv);
	}
	
	


	
	

}
