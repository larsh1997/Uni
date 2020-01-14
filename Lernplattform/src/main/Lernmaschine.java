package main;

import storage.*;
import ui.*;


/*
 * @author Lars Hansmann
 * @version 18.12.2019
 * 
 * 
 */
public class Lernmaschine {

	public static void main(String[] args) {
		
		Speicherschnittstelle db = new Datenbank_Datei();
		Benutzerschnittstelle bs = new Textschnittstelle(db);
		
		
		bs.start();
		

	}

}
