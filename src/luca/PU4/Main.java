package tut.pr1.hsm.de.a1.base;

import java.io.IOException;
import java.util.Scanner;

import static tut.pr1.hsm.de.a1.base.Crypto.*;

// Hauptklasse, die die Benutzeroberfläche für das Programm zur Verfügung stellt
public class Main {
    private static Scanner scanner = new Scanner(System.in); // Erzeugt ein Scanner-Objekt für Eingaben über die Konsole

    public static void main(String[] args) throws IOException {
        // Deklaration der Variablen für den verschlüsselten Text
        String  encryptedText;
        int shift;

        // Endlosschleife, um dem Benutzer wiederholt Optionen anzubieten
        while (true) {  // Benutzeroberfläche mit den verfügbaren Optionen
            System.out.println("Choose an operation:");
            System.out.println("1. Write a note");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int selection = scanner.nextInt(); // Liest die Benutzerauswahl ein
            scanner.nextLine(); // Entfernt den übriggebliebenen Zeilenumbruch nach der Zahleingabe
            System.out.println();

            switch (selection) {
                case 1: // Option 1: Schreiben einer Notiz
                    // Eingabeaufforderung und -lesen für die Verschlüsselung
                    System.out.print("Enter text to encrypt: ");
                    String text = scanner.nextLine();
                    System.out.print("Enter shift value: ");
                    shift = scanner.nextInt();
                    scanner.nextLine(); // Entfernt den übriggebliebenen Zeilenumbruch nach der Zahleneingabe

                    encryptedText = Crypto.caesarEncrypt(text, shift); // Verschlüsselt den eingegebenen Text

                    // Anpassung des Shift-Wertes, falls nötig, und Vorbereitung des verschlüsselten Texts für die Dateiausgabe
                    String encryptedTextWithShiftPrefix = Crypto.normalizeShiftValueAndSetShiftAsPrefix(shift, encryptedText);

                    System.out.println("Encrypted text: " + encryptedTextWithShiftPrefix);
                    System.out.println();
                    break;

                case 0: // Option 0: Beenden des Programms
                    scanner.close(); // Schließen des Scanner-Objektes
                    System.exit(0); // Beendigung des Programms
                    break;

                default:
                    // Behandlung ungültiger Auswahl
                    System.out.println("Ungültige Auswahl, bitte versuchen Sie es erneut.");
                    break;
            }
        }
    }
}
