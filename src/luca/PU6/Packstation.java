package luca.PU6;
import java.awt.Point;

public class Packstation {

    public Paket[][] station;

    /**
     * 1. überladener Konstruktor.
     * Erstellt eine Packstation mit der vom benutzer angegebenen Breite und Höhe.
     * @param breite → Breite der Packstation
     * @param hoehe → Breite der Packstation
     * @throws IllegalArgumentException Wenn die Breite oder Höhe kleiner oder gleich 0 ist.
     */
    public Packstation(int breite, int hoehe) throws IllegalArgumentException {
        if (breite <= 0 || hoehe <= 0) {
            throw new IllegalArgumentException("Breite und Höhe müssen größer als 0 sein.");
        }
        station = new Paket[breite][hoehe];
    }

    /**
     * 2. überladener Konstruktor.
     * Erstellt eine Packstation mit der Standardgröße von 4x5.
     */
    public Packstation() {
        station = new Paket[5][4];
    }

    /**
     * Legt ein Paket an einer freien Stelle in der Packstation ab und gibt die
     Position zurück.
     * @param paket: Das abzulegende Paket.
     * @return Ein Point-Objekt, das die Position (Spalte, Reihe) enthält, an der das
    Paket abgelegt wurde. Die kleinste Position für ein Paket ist x=0,y=0.
     * @throws IllegalStateException wenn kein Platz mehr in der Packstation ist.
     */
    public Point legePaketAb(Paket paket) throws IllegalArgumentException {
        for (int i = 0; i < station.length; i++) {
            for (int j = 0; j <= station[j].length; j++) {
                if (station[i][j] == null) {
                    station[i][j] = paket;
                    return new Point(i, j);
                }
            }
        }

        throw new IllegalArgumentException("Kein Platz mehr!");

    }

    /**
     * Zählt die Anzahl der freien Boxen in der Packstation.
     * @return Die Anzahl der freien Boxen als ganze Zahl.
     */
    public int zaehleFreieBoxen() {
        int freiePlaetze = 0;
        for (int i = 0; i < station.length; i++) {
            for (int j = 0; j < station[i].length; j++) {
                if (station[i][j] == null) {
                    freiePlaetze++;
                }
            }
        }
        return freiePlaetze;
    }

    /**
     * Liefert Informationen über den Empfänger und die Adresse des Pakets, das an der
     angegebenen Position abgelegt ist,
     * sofern die Box belegt ist. Andernfalls wird die Information zurückgegeben, dass
     die Box leer ist.
     * Falls die angegebene Box nicht existiert, wird eine IllegalArgumentException
     Exception geworfen.
     * @param spalte: Die Spalte der Box in der Packstation (beginnend bei 0).
     * @param reihe: Die Reihe der Box in der Packstation (beginnend bei 0) .
     * @return Ein String mit Informationen über den Empfänger und die Adresse des
    Pakets oder die Nachricht "Die Box ist leer".
     * @throws IllegalArgumentException Wenn die angegebene Box nicht existiert.
     */
    public String informationZumBoxenplatz(int spalte, int reihe) throws IllegalArgumentException {
        if (station[spalte][reihe] != null) {return station[spalte][reihe].toString();}
        if (station[spalte][reihe] == null) {return "Die Box ist leer!";}

        throw new IllegalArgumentException("Die angegebene Box existiert nicht.");


    }

}

