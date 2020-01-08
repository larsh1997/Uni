package storage;
/*
 * Enthält die unterstützen Dokumentformate.
 * 
 * @author Lars Hansmann
 * @version 18.12.2019
 * 
 */

public enum Format {
	PDF("PDF-Format"),
	WORD("Word-Format"),
	TEXT("Text-Format"),
	HTML("HTML-Format");
	
	private final String formatext;
	
	Format (String text) {
		formatext = text;
	}
	@Override
	public String toString() {
		return formatext;
	}

}
