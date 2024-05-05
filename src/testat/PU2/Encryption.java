package testat.PU2;

import java.util.Scanner;

public class Encryption {

	/*
	 * Programm, dass die jeweiligen Buchstaben eines Wortes um eins weiter
	 * verschiebt und somit verschlüsselt.
	 */

	public static void main(String[] args) {

		// Erstellung eines Scanner-Objekts um Benutzereingabe zu lesen.
		Scanner in = new Scanner(System.in);

		System.out.println("Bitte geben Sie den zu verschlüsselnden Text ein:");

		String s = in.nextLine();

		// Neue Zeichenkette für das neue Wort.
		String newS = "";

		if (s.isEmpty()) {
			return;
		}

		// Durchgang der einzelnen Zeichen der Zeichenkette.
		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			int j;

			if ((c >= 'a' && c < 'z') || (c >= 'A' && c < 'Z')) {
				j = c;
				j++;
				c = (char) j;
			} else if (c == 'z') {
				c = 'a';
			} else if (c == 'Z') {
				c = 'A';
			}
			// Das neue Zeichen wird mit dem neuen Wort konkateniert.
			newS += c;

		}

		// Ausgabe des Verschlüsselten Wortes
		System.out.println("Verschlüsselter Text: " + newS);

		in.close();
	}

}
