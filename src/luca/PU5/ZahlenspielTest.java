package luca.PU5;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

public class ZahlenspielTest {

	//Test_A: umdrehen der Zahlen
    @Test
    public void testUmdrehenDerZahl() {
        assertEquals("Test_A01", 123, Zahlenspiel.umdrehenDerZahl(321));
        assertEquals("Test_A02", 987654321, Zahlenspiel.umdrehenDerZahl(123456789));
        assertEquals("Test_A03", 0, Zahlenspiel.umdrehenDerZahl(0));
    }

    //Test_B: Summe der Ziffern
    @Test
    public void testSummeDerZiffern() {
        assertEquals("Test_B01", 6, Zahlenspiel.summeDerZiffern(123));
        assertEquals("Test_B02", 45, Zahlenspiel.summeDerZiffern(123456789));
        assertEquals("Test_B03", 0, Zahlenspiel.summeDerZiffern(0));
    }

    //Test_C: Wette gewonnen
    @Test
    public void testWetteGewonnen() {
        assertTrue("Test_C01", Zahlenspiel.wetteGewonnen(10));
        assertTrue("Test_C02", Zahlenspiel.wetteGewonnen(20));
        assertFalse("Test_C03", Zahlenspiel.wetteGewonnen(15));
        assertFalse("Test_C04", Zahlenspiel.wetteGewonnen(25));
    }

    //Test_D: einzelne Zahl umdrehen
    @Test
    public void testUmdrehenDerZahlWithSingleDigit() {
        assertEquals("Test_G01", 5, Zahlenspiel.umdrehenDerZahl(5));
        assertEquals("Test_G02", 9, Zahlenspiel.umdrehenDerZahl(9));
        assertEquals("Test_G03", 7, Zahlenspiel.umdrehenDerZahl(7));
    }

    //Test_E: einzelne Zahl summieren
    @Test
    public void testSummeDerZiffernWithSingleDigit() {
        assertEquals("Test_H01", 5, Zahlenspiel.summeDerZiffern(5));
        assertEquals("Test_H02", 6, Zahlenspiel.summeDerZiffern(6));
        assertEquals("Test_H03", 1, Zahlenspiel.summeDerZiffern(1));

    }

    //Test_F: einzelne Zahl sortieren
    @Test
    public void testSingleDigit() {
        int[] result = Zahlenspiel.ziffernSortieren(5);
        assertArrayEquals("Test_F", new int[]{5}, result);
    }

    //Test_G: gleiche Ziffern sortieren
    @Test
    public void testAllSameDigits() {
        int[] result = Zahlenspiel.ziffernSortieren(1111);
        assertArrayEquals("Test_G", new int[]{1, 1, 1, 1}, result);
    }

    //Test_H: aufsteigende Ziffern sortieren
    @Test
    public void testAscendingDigits() {
        int[] result = Zahlenspiel.ziffernSortieren(12345);
        assertArrayEquals("Test_H", new int[]{5, 4, 3, 2, 1}, result);
    }

    //Test_I: absteigende Ziffern sortieren
    @Test
    public void testDescendingDigits() {
        int[] result = Zahlenspiel.ziffernSortieren(54321);
        assertArrayEquals("Test_I", new int[]{5, 4, 3, 2, 1}, result);
    }

    //Test_J: gemixte Ziffern sortieren
    @Test
    public void testMixedDigits() {
        int[] result = Zahlenspiel.ziffernSortieren(394857);
        assertArrayEquals("Test_J", new int[]{9, 8, 7, 5, 4, 3}, result);
    }

    //Test_K: nebeneinander gedoppelte Nullen sortieren
    @Test
    public void testNumberWithZeros() {
        int[] result = Zahlenspiel.ziffernSortieren(1002003);
        assertArrayEquals("Test_K", new int[]{3, 2, 1, 0, 0, 0, 0}, result);
    }

    //Test_L: die Ziffern einer großen Zahl sortieren
    @Test
    public void testLargeNumber() {
        int[] result = Zahlenspiel.ziffernSortieren(987654321);
        assertArrayEquals("Test_L", new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, result);
    }

    //Test_M: jegliche existierende Ziffern sortieren
    @Test
    public void testNumberWithAllDigits() {
        int[] result = Zahlenspiel.ziffernSortieren(1023456789);
        assertArrayEquals("Test_M", new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, result);
    }

    //Test_N: die Ziffer 0 sortieren
    @Test
    public void testZero() {
        int[] result = Zahlenspiel.ziffernSortieren(0);
        assertArrayEquals("Test_N", new int[]{0}, result);
    }

    //Test_O: sich wiederholende Ziffern sortieren
    @Test
    public void testRepeatedDigits() {
        int[] result = Zahlenspiel.ziffernSortieren(1223334444);
        assertArrayEquals("Test_O", new int[]{4, 4, 4, 4, 3, 3, 3, 2, 2, 1}, result);
    }
}
