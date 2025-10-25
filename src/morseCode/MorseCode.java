package morseCode;

import java.util.Scanner;

public class MorseCode {

    // Morse Code Importing into an Array
    private static final String[] code = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..",
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
            "---..", "----.", "/" };

    // English Strings
    private static final char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0' };

    public static String morseToEnglish(String[] code, String morseCode) {
        // Split the morse code spaces into a String Array
        StringBuilder wordResult = new StringBuilder();
        String[] array = morseCode.trim().split("   ");

        // Morse Code to English For Loop using String Array Length
        for (String arrays : array) {
            String[] morseLetters = arrays.split(" "); // Single space for letter separation within a word
            for (String morseLetter : morseLetters) {
                // Find the corresponding English character
                for (int i = 0; i < code.length; i++) {
                    if (morseLetter.equals(code[i])) {
                        wordResult.append(letters[i]);
                        break; // Found the match, move to the next Morse letter
                    }
                }
            }
            wordResult.append(" ");
        }
        return wordResult.toString().trim();

    }

    public static String englishToMorse(String[] code, String englishLang, char[] letters) {
        String[] array = englishLang.split(" ");
        StringBuilder morseResult = new StringBuilder();
        // Another For Loop using String Length and String Array
        for (int i = 0; i < englishLang.length(); i++) {
            char currentChar = englishLang.charAt(i);
            boolean found = false;

            for (int j = 0; j < letters.length; j++) {
                if (currentChar == letters[j]) {
                    morseResult.append(code[j]).append(" ");
                    found = true;
                    break;
                }
            }
            // Character/Letter not found in Array
            if (!found && currentChar != ' ') {
                System.err.println("Warning: Character/Letter: " + currentChar + " is not supported.");
            }
        }
        return morseResult.toString().trim();
    }

    public static void main(String[] args) {

        // Creating a Scanner Object
        Scanner scanner = new Scanner(System.in);

        // Prompting for Answers
        System.out.println("Enter your Morse Code (Enter if not needed): ");
        String morseCode = scanner.nextLine();

        System.out.println("Enter your English Word (Enter if not needed): ");
        String englishLang = scanner.nextLine().toLowerCase();

        scanner.close();
        
        // Morse to English
        String english = morseToEnglish(code, morseCode);

        // English to Morse Code
        String morse = englishToMorse(code, englishLang, letters);

        // Print out the End Results
        System.out.println("The English Word is: " + english);
        System.out.println("The Morse Code is: " + morse);
    }
}
