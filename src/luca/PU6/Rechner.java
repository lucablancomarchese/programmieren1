package luca.PU6;

import org.junit.platform.engine.support.descriptor.FileSystemSource;

import java.util.Scanner;

public class Rechner {

    final static int NEUSTART = -1;

    static String input = "";
    static boolean rechner = true;
    static char c;
    static int ergebnis = 0;


    /**
     * Der Haupteinstiegspunkt des Programms. Hier wird ein Menü
     * angezeigt und Benutzereingaben verarbeitet.
     */
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);

        char c;
        do {
            int ergebnis = 0;
            do {

                System.out.println("Welche Rechenart soll ausgeführt werden?");
                System.out.println("[ Multiplikation | Division | Exponent | Fakultät ]");
                System.out.println("[ m | d | e | f ]");
                System.out.print("Geben Sie das zugehörige Zeichen an: ");
                input = sc1.nextLine();
                if (input.length()!= 1) { System.out.println("Eingabe darf nur 1 Zeichen haben."); }
                c = input.charAt(0);
                ergebnis = berechnung(c);
            } while(input.length() != 1 || ergebnis == NEUSTART);
            System.out.println("Ergebnis lautet: " + ergebnis);
        } while (rechner);
    }

    /**
     * Führt die ausgewählte Berechnung basierend auf dem übergebenen Zeichen aus.
     * @param c Das Zeichen, das die gewünschte Berechnung angibt
     * ('m' für Multiplikation, 'd' für Division, 'e' für Exponentialfunktion, 'f'
     * für Fakultät)
     * @return Das Ergebnis der Berechnung oder -1 bei fehlerhafter Eingabe
     */
    public static int berechnung(char c) {
        Scanner sc2 = new Scanner(System.in);
        switch (c) {
            case 'm':
                System.out.print("Gebe den ersten Faktor deiner Multiplikation ein: ");
                int faktor1 = sc2.nextInt();
                System.out.print("Gebe den zweiten Faktor deiner Multiplikation ein: ");
                int faktor2 = sc2.nextInt();
                try {
                    // Versucht ein Ergebnis zu bekommen
                    return multiplizieren(faktor1, faktor2);
                } catch(IllegalArgumentException e) { // "Catch" sobald die Methode Exception wirft.
                    System.out.println(e);
                    // Programm von neu starten.
                    return NEUSTART;
                }

            case 'd':
                System.out.print("Gebe den Dividend deiner Division ein: ");
                int dividend = sc2.nextInt();
                System.out.print("Gebe den Divisor deiner Division ein: ");
                int divisor = sc2.nextInt();
                try {
                    // Ergebnis
                    return dividieren(dividend, divisor);
                } catch (Exception e) {
                    System.out.println(e);
                    // Programm von neu starten.
                    return NEUSTART;
                }

            case 'e':
                System.out.print("Gebe die Basis deiner Potenzrechnung an: ");
                int grundwert = sc2.nextInt();
                System.out.print("Gebe den Exponenten deiner Potenzrechnung an: ");
                int exponent = sc2.nextInt();
                try {
                    // Ergebnis
                    return exponent(grundwert, exponent);
                } catch (Exception e) {
                    System.out.println(e);
                    // Programm von neu starten.
                    return NEUSTART;
                }
            case 'f':
                System.out.print("Bitte gebe eine Zahl der zu berechnenden Fakultät an: ");
                int max = sc2.nextInt();
                try {
                    // Ergebnis
                    return fakultaet(max);
                } catch (Exception e) {
                    System.out.println(e);
                    // Programm von neu starten.
                    return NEUSTART;
                }
            default:
                System.out.println("Bitte gebe ein gültiges Zeichen ein.");

        }
        return NEUSTART;
    }
    /**
     * Berechnet rekursiv das Produkt von zwei ganzen positiven Zahlen.
     * @param faktor1 Der erste Faktor
     * @param faktor2 Der zweite Faktor
     * @return Das Produkt der beiden Faktoren
     * @throws IllegalArgumentException Wenn einer der Faktoren negativ ist
     */
    public static int multiplizieren (int faktor1, int faktor2) throws IllegalArgumentException {
        if(faktor1 < 0 || faktor2 < 0) {
            throw new IllegalArgumentException("Faktor darf nur positiv sein! \n");
        } else if (faktor1 == 0) {
            return 0;
        } else {
            return faktor2 + multiplizieren((faktor1 - 1), faktor2);
        }
    }

    /**
     * Berechnet rekursiv den Quotienten von zwei ganzen positiven Zahlen.
     * @param dividend Der Dividend
     * @param divisor Der Divisor
     * @return Der Quotient der beiden Zahlen
     * @throws IllegalArgumentException Wenn einer der Werte negativ ist
     * @throws ArithmeticException Wenn der Divisor 0 ist
     */
    public static int dividieren(int dividend, int divisor) throws ArithmeticException, IllegalArgumentException {
        // Überprüft, dass Teiler nicht 0 ist.
        if(divisor == 0) { throw new ArithmeticException("Nicht durch 0 teilen! \n");}
        // Überprüft, dass Eingaben nicht kleiner 0 sind.
        if (divisor < 0 || dividend < 0) {throw new IllegalArgumentException("Bitte nur positive Eingaben! \n");}

        // Methode ruft sich so lange selber bis der Dividend
        if(dividend < divisor) {
            return 0;
        }
        return 1 + dividieren(dividend - divisor, divisor);
    }

    /**
     * Berechnet rekursiv die Potenz, mit gegebenem positiven ganzen Grundwert und
     * Exponenten.
     * @param grundwert Die Basis
     * @param exponent Der Exponent der Basis
     * @return Das Ergebnis der Potenzierung
     * @throws IllegalArgumentException Wenn einer der Werte negativ ist
     */
    public static int exponent(int grundwert, int exponent) throws IllegalArgumentException {

        if(grundwert < 0 || exponent < 0) {
            throw new IllegalArgumentException("Bitte nur positive Eingaben! \n");
        }

        if (exponent == 0) {
            return 1;
        } else {
            return multiplizieren(grundwert, exponent(grundwert, exponent -1));
        }

    }

    /**
     * Berechnet rekursiv die Fakultät einer ganzen positiven Zahl.
     * @param n Die Zahl, deren Fakultät berechnet werden soll
     * @return Die Fakultät der Zahl
     * @throws IllegalArgumentException Wenn die Zahl negativ ist
     */
    public static int fakultaet(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Bitte gebe nur positive Zahlen ein");
        }
        if(n == 0) {
            return 1;
        } else {
            return fakultaet(n - 1) * n;

        }

    }
}
