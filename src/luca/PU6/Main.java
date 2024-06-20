package luca.PU6;

import java.awt.*;
import java.util.Scanner;

public class Main {

    static String input, empfaenger, adresse;
    static boolean packstationEinrichtung, programmEnde;
    static Packstation station;


    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);



        do {

            if (!packstationEinrichtung) {
                do {
                    System.out.println("Willkommen bei der Packstation, welche Größe der Packstation möchten Sie einrichten ?");
                    System.out.println("[ Defaultgröße | Benutzerdefiniert ]");
                    System.out.println("[ d | b ]");
                    System.out.print("Geben Sie das zugehörige Zeichen an: ");
                    input = sc1.nextLine();
                    if (input.equals("d")) {
                        packstationEinrichtung = true;
                        station = new Packstation();
                    } else if (input.equals("b")) {
                        System.out.print("Geben Sie die Breite der Station an: ");
                        int breite = sc1.nextInt();
                        System.out.print("Geben Sie die Höhe der Station an: ");
                        int hoehe = sc1.nextInt();
                        station = new Packstation(breite, hoehe);
                        packstationEinrichtung = true;
                    } else {
                        System.out.println("Geben sie ein gültiges Zeichen an!");
                    }
                } while (!packstationEinrichtung);
                System.out.println("Packstation erfolgreich eingerichtet!");
            }

            System.out.println("Wählen sie einer der Möglichkeiten aus! ");
            System.out.println("[ Paket ablegen | Freie Boxen ausgeben | Information über Boxenplatz | Packstation beenden ]");
            System.out.println("[ p | a | i | b ]");
            System.out.print("Geben Sie das zugehörige Zeichen an: ");
            sc1 = new Scanner(System.in);
            input = sc1.nextLine();

            switch (input) {
                case "p":
                    System.out.print("Geben sie den Empfänger an: ");
                    empfaenger = sc1.nextLine();
                    System.out.print("Geben Sie die Adresse des Empfängers an: ");
                    adresse = sc1.nextLine();
                    Paket paket = new Paket(empfaenger, adresse);
                    Point p1 = new Point();
                    p1 = station.legePaketAb(paket);
                    System.out.println("Paket abgelegt an Stelle " + p1.x + ", " + p1.y);
                    break;
                case "a":
                    System.out.print("Anzahl der freien Boxen:  ");
                    try {
                        System.out.println(station.zaehleFreieBoxen());
                    } catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case "i":
                    System.out.println("Geben sie den Boxenstellplatz ein: ");
                    System.out.print("Spalte: ");
                    int spalte = sc1.nextInt();
                    System.out.print("Reihe: ");
                    int reihe = sc1.nextInt();
                    System.out.println("Paketinformation zum Boxenplatz " + spalte + ", " + reihe + " : ");
                    try {
                        System.out.println(station.informationZumBoxenplatz(spalte, reihe));
                    } catch(Exception e) {
                        System.out.println(e);
                    }
                    break;
                case "b":
                    programmEnde = true;
                    System.out.println("Packstation wurde beendet!");
                default:

            }
        } while(!programmEnde);

    }
}



