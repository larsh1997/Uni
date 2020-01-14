package storage;

import java.util.TreeMap;
import java.io.*;

public class Datenbank_Datei implements Speicherschnittstelle {
	
	String dateiname;
	protected TreeMap<String, Lehrveranstaltungen> lehrveranstaltungen = new TreeMap<>();
	
	
	


	@Override
	public TreeMap<String, Lehrveranstaltungen> gibLehrveranstaltungen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lehrveranstaltungen gibLeherveranstaltung(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean istLehrveranstaltungVorhanden(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int gibAnzahlLehrveranstaltungen() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void leseDatenEin() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lerndokument ausarbeitungAnlegen(Lehrveranstaltungen lv, Lerndokument ld, Lerndokument ausa)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lerndokument ausarbeitungLoeschen(Lehrveranstaltungen lv, Lerndokument ld, Lerndokument ausa)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lerndokument lerndokumentAnlegen(Lehrveranstaltungen lv, Lerndokument ld) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lerndokument lerndokumentloeschen(Lehrveranstaltungen lv, Lerndokument ld) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lehrveranstaltungen lehrveranstaltungAnlegen(Lehrveranstaltungen lv) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
