package piglatin;
import java.util.Scanner;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.
        

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";

        // TODO: Replace this code to correctly translate a single word.
        // Start here first!
        // This is the first place to work.
     
    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");
        String result = "";

        // TODO: Replace this code to correctly translate a single word. 
        // Start here first!
        // This is the first place to work.

        if (input.length() == 0)
        {
            return "";
        }

        String vowels = "aeiouy";
        String newinput = input;
       

        String punctuation = "";
        if (!Character.isLetter(newinput.charAt(newinput.length() - 1))) {
            punctuation = newinput.substring(newinput.length() - 1);
            newinput = newinput.substring(0, newinput.length() - 1);

        }

        boolean firstCap = Character.isUpperCase(newinput.charAt(0));
        boolean secondCap = newinput.length() > 1 && Character.isUpperCase(newinput.charAt(1));

        newinput = newinput.toLowerCase();

        if (vowels.indexOf(newinput.substring(0, 1)) != -1) {
            result = newinput + "ay";
        } else {
            // Move first consonant(s) to the end
            while (vowels.indexOf(newinput.substring(0, 1)) == -1 && newinput.length() > 1) {
                newinput = newinput.substring(1) + newinput.substring(0, 1);
            }
            result = newinput + "ay";
        }
        if (firstCap && !secondCap) {
            result = result.substring(0, 1).toUpperCase() + result.substring(1);
        } else if (firstCap && secondCap) {
            result = result.substring(0, 2).toUpperCase() + result.substring(2);
        }

        result += punctuation;

        return result;
    }     
    
}




    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
