package piglatin;

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
        String change = input;
        String vowels = "aeiouy";
        if (input.substring(0,1).equals("a")||input.substring(0,1).equals("e")||input.substring(0,1).equals("i")||input.substring(0,1).equals("o")||input.substring(0,1).equals("u")||input.substring(0,1).equals("y"))
        {
            result = input + "ay";
            return result;

        }
        else
        {
            while (vowels.indexOf(change.substring(0,1)) == -1 )
            {
                change = change.substring(1) + change.substring(0,1);
            }
            result = change + "ay";
        }

        
        return result;
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
