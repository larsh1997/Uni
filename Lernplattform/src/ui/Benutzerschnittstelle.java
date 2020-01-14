package ui;

import storage.Format;
import storage.Speicherschnittstelle;
import java.awt.Desktop;



public abstract class Benutzerschnittstelle {  
	
	protected Speicherschnittstelle db;
	
	
	
	public Benutzerschnittstelle(Speicherschnittstelle db) {
		
		this.db = db;
	}
	
	/*
	 * Startet die Benutzeroberfläche
	 */
	public abstract void start();
		
	public static void zeigeDokument(Format format, String speicherort) throws Exception{
		switch(format) {
		case PDF:
			Desktop.getDesktop().open(new java.io.File(speicherort));
			break;
		case TEXT:
			Desktop.getDesktop().open(new java.io.File(speicherort));
			break;
		case URL:
			Desktop.getDesktop().browse(java.net.URI.create(speicherort));
			break;
		default:
			Desktop.getDesktop().open(new java.io.File(speicherort));
			
		}
	}

	
		
	}


