package luca.PU4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Klasse FileHandler zur Verwaltung der Dateioperationen
public class FileHandler {
    static String defaultFilePath = "data/"; // Variable für den Standardpfad der Dateien

    // Methode zum Schreiben eines Textes in eine Datei
    public static void writeToFile(String filename, String text) throws IOException {
    	FileWriter ausgabestrom = new FileWriter(defaultFilePath + filename);
		PrintWriter ausgabe = new PrintWriter(ausgabestrom);
		ausgabe.println(text);
		ausgabe.close();
		
    }

    // Methode zum Lesen eines Textes aus einer Datei
    public static String readFromFile(String filename) throws IOException {
    	File file = new File(defaultFilePath + filename);
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);
		
		String text = "";
		String line = reader.readLine();
		
		while(line != null) {
			text = text + line + "\n";
			line = reader.readLine();
		}
		reader.close();
    	
    	return text;
    }
}

