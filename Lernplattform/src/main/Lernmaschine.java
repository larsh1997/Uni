package main;

import java.util.TreeMap;

import storage.Format;
import storage.Kategorie;
import storage.Lehrveranstaltungen;
import storage.Lerndokument;

/*
 * @author Lars Hansmann
 * @version 18.12.2019
 * 
 * 
 */
public class Lernmaschine {

	public static void main(String[] args) {
		
		Lehrveranstaltungen test = new Lehrveranstaltungen("Mathe");
		
		String x = test.gibName();
		System.out.println(x);
		
		Lerndokument oby = new Lerndokument("SD", Kategorie.SKRIPT, "C:", Format.WORD);
		System.out.println(oby.gibName());
		System.out.println(oby.gibSpeicherort());
		System.out.println(oby.gibFormat());
		System.out.println(oby.gibKategorie());
		

	}

}
