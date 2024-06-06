package luca.PU4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class Pflichtuebung4AbnahmeTests {

    @Nested
    class CryptoTest {

        private Crypto crypto;

        @BeforeEach
        public void setUp() {
            crypto = new Crypto();
        }

        @Test
        public void testCheckPassword() {
            assertTrue(crypto.checkPassword("thesupersecretcompanypassword"), "Checking the correct password");
            assertFalse(crypto.checkPassword("wrongpassword"), "Checking an incorrect password");
        }

        @Test
        public void testCheckPasswordCaseSensitivity() {
            assertTrue(Crypto.checkPassword("thesupersecretcompanypassword"));
            assertFalse(Crypto.checkPassword("TheSuperSecretCompanyPassword"));
        }

        @Test
        public void testCaesarDecryptWithPositiveShift() {
            assertEquals("Hello", crypto.caesarDecrypt("Khoor", 3), "Decrypting with a positive shift");
        }

        @Test
        public void testCaesarDecryptWithNegativeShift() {
            assertEquals("Hello", crypto.caesarDecrypt("Ebiil", -3), "Decrypting with a negative shift");
        }

        @Test
        public void testCaesarDecryptWithNonAlphabeticCharacters() {
            // Stellt sicher, dass Nicht-Buchstaben-Zeichen unverändert bleiben
            assertEquals("Jklm!?", crypto.caesarDecrypt("Mnop!?", 3), "Decrypting with non-alphabetic characters should leave them unchanged");
        }

        @Test
        public void testCaesarDecryptWithAlphabetOverflow() {
            // Testet die Entschlüsselung mit Überlauf von 'a' zurück zu 'z'
            assertEquals("Zabc", crypto.caesarDecrypt("Cdef", 3), "Decrypting with overflow at the alphabet's start");
        }
    }

    @Nested
    class FileHandlerTest {

        @TempDir
        Path tempDir; // JUnit erstellt und verwaltet ein temporäres Verzeichnis

        @Test
        public void testWriteToFile() throws IOException {
            String filename = "testfile.txt";
            String content = "This is a test.";

            FileHandler.defaultFilePath = tempDir.toString() + "/";
            FileHandler.writeToFile(filename, content);

            Path filePath = tempDir.resolve(filename);
            assertTrue(Files.exists(filePath));
            assertEquals(content, Files.readString(filePath).trim());
        }

        @Test
        public void testReadFromFile() throws IOException {
            String filename = "testfile.txt";
            String content = "This is a test.";

            Path filePath = tempDir.resolve(filename);
            Files.writeString(filePath, content);

            FileHandler.defaultFilePath = tempDir.toString() + "/";
            String readContent = FileHandler.readFromFile(filename).trim();
            assertEquals(content, readContent);
        }

        @Test
        public void testWriteAndReadFromFile() throws IOException {
            FileHandler fileHandler = new FileHandler();
            String filename = "testfile.txt";
            String content = "This is a test.";

            // Anpassen des Pfads zum temporären Verzeichnis
            fileHandler.defaultFilePath = tempDir.toString() + "/";

            fileHandler.writeToFile(filename, content);
            String readContent = fileHandler.readFromFile(filename);

            assertEquals(content, readContent.trim(), "The content read from the file should match the content written.");
        }

        
    }

    @Nested
    class CodebaseTest {

        private Crypto crypto;

        @BeforeEach
        public void setUp() {
            crypto = new Crypto();
        }

        @Test
        public void testNormalizeShiftValueWithLargePositiveValue() {
            // Testet die Normalisierung eines großen Shift-Wertes
            int largeShift = 53; // Effektiv ein Shift von 1
            assertEquals("Bcde", crypto.caesarEncrypt("Abcd", largeShift), "Encrypting with a large positive shift normalized to 1");
        }

        @Test
        public void testNormalizeShiftValueWithLargeNegativeValue() {
            // Testet die Normalisierung eines großen negativen Shift-Wertes
            int largeNegativeShift = -53; // Effektiv ein Shift von -1 bzw. 25
            assertEquals("Zabc", crypto.caesarEncrypt("Abcd", largeNegativeShift), "Encrypting with a large negative shift normalized to -1");
        }

        @Test
        public void testCaesarEncryptWithPositiveShift() {
            assertEquals("Khoor", crypto.caesarEncrypt("Hello", 3), "Encrypting with a positive shift");
        }

        @Test
        public void testCaesarEncryptWithNegativeShift() {
            assertEquals("Ebiil", crypto.caesarEncrypt("Hello", -3), "Encrypting with a negative shift");
        }

        @Test
        public void testCaesarEncryptWithNonAlphabeticCharacters() {
            // Stellt sicher, dass Nicht-Buchstaben-Zeichen unverändert bleiben
            assertEquals("Mnop!?", crypto.caesarEncrypt("Jklm!?", 3), "Encrypting with non-alphabetic characters should leave them unchanged");
        }

        @Test
        public void testCaesarEncryptWithAlphabetOverflow() {
            // Testet den Überlauf von 'z' zu 'a' mit einem Shift von 3
            assertEquals("Cdef", crypto.caesarEncrypt("Zabc", 3), "Encrypting with overflow at the alphabet's end");
        }

    }

}