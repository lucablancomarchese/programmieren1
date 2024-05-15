package luca.PU3;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.*;

public class ParkhausTest {

    private static int punkte = 0;

    ////////////////////////////////////////// METHODEN TESTS //////////////////////////////////////////////
    @Test
    public void guelitgeEinUndAusfahrtInMinutenRueckgabe() {
        String einfahrt = "06:00";
        String ausfahrt = "10:01";

        Assertions.assertTrue(Parkhaus.istEingabeGueltig(einfahrt, ausfahrt));
        punkte++;
    }

    @Test
    public void kostenlosesParkenEins() {
        String einfahrtZeit = "06:00";
        String ausfahrtZeit = "10:01";
        int erwartet = 0;

        int parkdauer = Parkhaus.berechneZuZahlendeParkdauer(einfahrtZeit, ausfahrtZeit);
        Assertions.assertEquals(erwartet, parkdauer);

        int gebuehr = Parkhaus.berechneParkgebuehr(parkdauer);
        Assertions.assertEquals(erwartet, gebuehr);

        punkte++;
    }

    @Test
    public void kostenlosesParkenZwei() {
        String einfahrtZeit = "06:00";
        String ausfahrtZeit = "11:00";
        int erwartet = 0;

        int parkdauer = Parkhaus.berechneZuZahlendeParkdauer(einfahrtZeit, ausfahrtZeit);
        Assertions.assertEquals(erwartet, parkdauer);

        int gebuehr = Parkhaus.berechneParkgebuehr(parkdauer);
        Assertions.assertEquals(erwartet, gebuehr);
        punkte++;
    }

    @Test
    public void kostenlosesParkenDrei() {
        String einfahrtZeit = "13:00";
        String ausfahrtZeit = "14:00";
        int erwartet = 0;

        int parkdauer = Parkhaus.berechneZuZahlendeParkdauer(einfahrtZeit, ausfahrtZeit);
        Assertions.assertEquals(erwartet, parkdauer);

        int gebuehr = Parkhaus.berechneParkgebuehr(parkdauer);
        Assertions.assertEquals(erwartet, gebuehr);
        punkte++;
    }

    @Test
    public void zahlungTestEins() {
        String einfahrtZeit = "10:00";
        String ausfahrtZeit = "12:30";
        int erwartet = 90;

        int parkdauer = Parkhaus.berechneZuZahlendeParkdauer(einfahrtZeit, ausfahrtZeit);
        Assertions.assertEquals(erwartet, parkdauer);

        //10 - 11Uhr -> gratis
        //11 - 12.30 -> 3 Euro
        erwartet = 300;
        int gebuehr = Parkhaus.berechneParkgebuehr(parkdauer);
        Assertions.assertEquals(erwartet, gebuehr);
        punkte++;
    }

    @Test
    public void zahlungTestZwei() {
        //7 - 11 -> free
        //11:00 - 12:30 -> 3 Euro
        //12:30 - 13:30 -> 4.50 Euro
        String einfahrtZeit = "07:00";
        String ausfahrtZeit = "13:10";
        int erwartet = 130;

        int parkdauer = Parkhaus.berechneZuZahlendeParkdauer(einfahrtZeit, ausfahrtZeit);
        Assertions.assertEquals(erwartet, parkdauer);

        erwartet = 450;
        int gebuehr = Parkhaus.berechneParkgebuehr(parkdauer);
        Assertions.assertEquals(erwartet, gebuehr);
        punkte++;
    }

    @Test
    public void zahlungTestDrei() {
        //11 -> free
        //12.30 -> 3
        //13.30 -> 4.50
        //14.30 -> 6
        String einfahrtZeit = "10:00";
        String ausfahrtZeit = "14:30";
        int erwartet = 210;

        int parkdauer = Parkhaus.berechneZuZahlendeParkdauer(einfahrtZeit, ausfahrtZeit);
        Assertions.assertEquals(erwartet, parkdauer);

        erwartet = 600;
        int gebuehr = Parkhaus.berechneParkgebuehr(parkdauer);
        Assertions.assertEquals(erwartet, gebuehr);
        punkte++;
    }

    @Test
    public void zahlungTestVier() {
        //11 -> free
        //12.30 -> 3
        //13.30 -> 4.50
        //14.30 -> 6
        //15.30 -> 7.50
        String einfahrtZeit = "10:00";
        String ausfahrtZeit = "15:30";
        int erwartet = 270;

        int parkdauer = Parkhaus.berechneZuZahlendeParkdauer(einfahrtZeit, ausfahrtZeit);
        Assertions.assertEquals(erwartet, parkdauer);

        erwartet = 750;
        int gebuehr = Parkhaus.berechneParkgebuehr(parkdauer);
        Assertions.assertEquals(erwartet, gebuehr);
        punkte++;
    }

    @Test
    public void zahlungTestFuenf() {
        //11 -> free
        //12.30 -> 3
        //13.30 -> 4.50
        //14.30 -> 6
        //15.30 -> 7.50
        //16.30 -> 9
        String einfahrtZeit = "10:00";
        String ausfahrtZeit = "16:30";
        int erwartet = 330;

        int parkdauer = Parkhaus.berechneZuZahlendeParkdauer(einfahrtZeit, ausfahrtZeit);
        Assertions.assertEquals(erwartet, parkdauer);

        erwartet = 900;
        int gebuehr = Parkhaus.berechneParkgebuehr(parkdauer);
        Assertions.assertEquals(erwartet, gebuehr);
        punkte++;
    }

    @Test
    public void zahlungTestSechs() {
        //bis 11 -> free
        //bis 12.30 -> 3
        //bis 13.30 -> 4.50
        //bis 14.30 -> 6
        //bis 15.30 -> 7.50
        //bis 16.30 -> 9
        //bis 17.30 -> 10
        String einfahrtZeit = "09:00";
        String ausfahrtZeit = "16:45";
        int erwartet = 345;

        int parkdauer = Parkhaus.berechneZuZahlendeParkdauer(einfahrtZeit, ausfahrtZeit);
        Assertions.assertEquals(erwartet, parkdauer);

        erwartet = 1000;
        int gebuehr = Parkhaus.berechneParkgebuehr(parkdauer);
        Assertions.assertEquals(erwartet, gebuehr);
        punkte++;
    }

    @Test
    public void zahlungTestSieben() {
        //11 -> free
        //12.30 -> 3
        //13.30 -> 4.50
        //14.30 -> 6
        //15.30 -> 7.50
        //16.30 -> 9
        //17.30 -> 10
        String einfahrtZeit = "09:00";
        String ausfahrtZeit = "19:30";
        int erwartet = 510;

        int parkdauer = Parkhaus.berechneZuZahlendeParkdauer(einfahrtZeit, ausfahrtZeit);
        Assertions.assertEquals(erwartet, parkdauer);

        erwartet = 1000;
        int gebuehr = Parkhaus.berechneParkgebuehr(parkdauer);
        Assertions.assertEquals(erwartet, gebuehr);
        punkte++;
    }

    @Test
    public void rueckgeldNurZweiEuro() {
        int cents = 1000;

        //Rueckgeld
        //2 Euro: 5
        //1 Euro: 0
        //50 Cent: 0
        //20 Cent: 0
        //10 Cent: 0
        Assertions.assertArrayEquals(new int[]{5, 0, 0, 0, 0}, Parkhaus.rueckgeld(cents));

        punkte++;
    }

    @Test
    public void rueckgeldNurEinEuro() {
        int cents = 100;

        //Rueckgeld
        //2 Euro: 0
        //1 Euro: 1
        //50 Cent: 0
        //20 Cent: 0
        //10 Cent: 0
        Assertions.assertArrayEquals(new int[]{0, 1, 0, 0, 0}, Parkhaus.rueckgeld(cents));
        punkte++;
    }

    @Test
    public void rueckgeldNurFuenfzigCent() {
        int cents = 50;

        //Rueckgeld
        //2 Euro: 0
        //1 Euro: 0
        //50 Cent: 1
        //20 Cent: 0
        //10 Cent: 0
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 0, 0}, Parkhaus.rueckgeld(cents));
        punkte++;
    }

    @Test
    public void rueckgeldZwanzigCent() {
        int cents = 20;

        //Rueckgeld
        //2 Euro: 0
        //1 Euro: 0
        //50 Cent: 0
        //20 Cent: 1
        //10 Cent: 0
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 1, 0}, Parkhaus.rueckgeld(cents));
        punkte++;
    }

    @Test
    public void rueckgeldZehnCent() {
        int cents = 10;

        //Rueckgeld
        //2 Euro: 0
        //1 Euro: 0
        //50 Cent: 0
        //20 Cent: 0
        //10 Cent: 1
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 1}, Parkhaus.rueckgeld(cents));
        punkte++;
    }

    @Test
    public void rueckgeldEins() {
        int cents = 780;

        //Rueckgeld
        //2 Euro: 3
        //1 Euro: 1
        //50 Cent: 1
        //20 Cent: 1
        //10 Cent: 1
        Assertions.assertArrayEquals(new int[]{3, 1, 1, 1, 1}, Parkhaus.rueckgeld(cents));
        punkte++;
    }

    @Test
    public void rueckgeldZwei() {
        int cents = 340;

        //Rueckgeld
        //2 Euro: 1
        //1 Euro: 1
        //50 Cent: 0
        //20 Cent: 2
        //10 Cent: 0
        Assertions.assertArrayEquals(new int[]{1, 1, 0, 2, 0}, Parkhaus.rueckgeld(cents));
        punkte++;
    }

    //////////////////////////////////////////// ERROR CHECK ///////////////////////////////////////////////////

    @Test
    public void parkhausGeschlossenFalscheEinfahrtszeit() {
        Assertions.assertFalse(Parkhaus.istEingabeGueltig("05:59", "22:00"));
        punkte++;
    }

    @Test
    public void parkhausGeschlossenFalscheAusfahrtszeit() {
        Assertions.assertFalse(Parkhaus.istEingabeGueltig("10:00", "05:59"));
        punkte++;
    }

    @Test
    public void parkhausOffenFalscheEinfahrtszeit() {
        Assertions.assertFalse(Parkhaus.istEingabeGueltig("13:00", "12:00"));
        punkte++;
    }

    @Test
    public void falscheEingabeEinfahrtEins() {
        Assertions.assertFalse(Parkhaus.istEingabeGueltig("10000", "22:00"));
        punkte++;
    }

    @Test
    public void falscheEingabeAusfahrtEins() {
        Assertions.assertFalse(Parkhaus.istEingabeGueltig("10:00", "19000"));
        punkte++;
    }

    @Test
    public void falscheEingabeEinfahrtZwei() {
        Assertions.assertFalse(Parkhaus.istEingabeGueltig("09:60", "12:30"));
        punkte++;
    }

    @Test
    public void falscheEingabeEinfahrtDrei() {
        Assertions.assertFalse(Parkhaus.istEingabeGueltig("09:99", "12:30"));
        punkte++;
    }

    @Test
    public void falscheEingabeAusfahrtZwei() {
        Assertions.assertFalse(Parkhaus.istEingabeGueltig("10:00", "11:60"));
        punkte++;
    }

    @Test
    public void falscheEingabeAusfahrtDrei() {
        Assertions.assertFalse(Parkhaus.istEingabeGueltig("10:00", "11:99"));
        punkte++;
    }

    @Test
    public void falscheEingabeAusfahrtVier() {
        Assertions.assertFalse(Parkhaus.istEingabeGueltig("10:00", "11 32"));
        punkte++;
    }

    @Test
    public void falscheEingabeEinfahrtVier() {
        Assertions.assertFalse(Parkhaus.istEingabeGueltig("09 10", "12:30"));
        punkte++;
    }

    @Test
    public void negativerEuroBetrag() {
        Assertions.assertEquals(-1, Parkhaus.zahlungGueltig("-07,50"));
        punkte++;
    }

    @Test
    public void negativerCentBetrag() {
        Assertions.assertEquals(-1, Parkhaus.zahlungGueltig("08,-5"));
        punkte++;
    }

    @Test
    public void ungueltigeGeldEingabe() {
        Assertions.assertEquals(-1, Parkhaus.zahlungGueltig("8,50"));
        punkte++;
    }

    @Test
    public void ungueltigeGeldEingabeLeerzeichen() {
        Assertions.assertEquals(-1, Parkhaus.zahlungGueltig("08 50"));
        punkte++;
    }

    @Test
    public void centIstNichtDurchZehnTeilbar() {
        Assertions.assertEquals(-1, Parkhaus.zahlungGueltig("07,55"));
        punkte++;
    }

    @Test
    public void zuGrosseGeldEingabe() {
        Assertions.assertEquals(-1, Parkhaus.zahlungGueltig("100,00"));
        punkte++;
    }

    ////////////////////////////////////////// HILFSMETHODEN ///////////////////////////////////////////////////

    @AfterAll
    public static void ausgabePunkte() {
        int gesamtPunkte = (ParkhausTest.class.getMethods().length - 10);
        System.out.println("Punkte insgesamt " + punkte + "/" + gesamtPunkte);
    }
}