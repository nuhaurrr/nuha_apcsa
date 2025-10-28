package piglatin;
import java.util.Scanner;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.
        for (int c = 0; c < input.getLineCount(); c++) {
            String line = input.getLine(c);
            translatedBook.appendLine(translate(line));
        }

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        StringBuilder result = new StringBuilder();
        Scanner sc = new Scanner(input);
        while (sc.hasNext()) {
            String word = sc.next();
            result.append(translateWord(word));
            if (sc.hasNext()) {
                result.append(" ");
            }
        }

        sc.close();
        return result.toString();
    }

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        
        private static String translateWord(String input) {
        if (input == null || input.trim().isEmpty()) {
            return input;
        }

        String vowels = "aeiouyAEIOUY";
        String punctuationMarks = ".,;:?!";
        String word = input;
        String punctuation = "";

        // Handle punctuation at the end
        if (punctuationMarks.indexOf(word.charAt(word.length() - 1)) != -1) {
            punctuation = word.substring(word.length() - 1);
            word = word.substring(0, word.length() - 1);
        }

        boolean wasCapitalized = Character.isUpperCase(word.charAt(0));
        word = word.toLowerCase();

        String result;
        if (vowels.indexOf(word.charAt(0)) != -1) {
            // Word starts with a vowel
            result = word + "yay";
        } else {
            // Move consonants from start to first vowel to the end
            int firstVowelIndex = findFirstVowel(word);
            if (firstVowelIndex == -1) {
                // No vowels found
                result = word + "ay";
            } else {
                result = word.substring(firstVowelIndex) + word.substring(0, firstVowelIndex) + "ay";
            }
        }

        // Restore capitalization
        if (wasCapitalized && result.length() > 0) {
            result = capitalizeFirstLetter(result);
        }

        // Reattach punctuation
        return result + punctuation;
    }

    private static int findFirstVowel(String word) {
        String vowels = "aeiouy";
        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) != -1) {
                return i;
            }
        }
        return -1;
    }

    private static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}

     
//fixed the test issue

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)


