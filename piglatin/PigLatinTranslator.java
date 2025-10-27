package piglatin;
import java.util.Scanner;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.
        for(int c = 0; c < input.getLineCount(); c ++){
            Scanner sc = new Scanner(input.getLine(c));
            while(sc.hasNextLine()){
                translatedBook.appendLine(translate(sc.nextLine()));
            }
        }
        

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";
        Scanner sc = new Scanner(input);
        while(sc.hasNext()){
            result += translateWord(sc.next());
            if(sc.hasNext()){
                result += " ";
            }
        }

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);

        return result;
    }

     private static String translateWord(String input) {
        //System.out.println("  -> translateWord('" + input + "')");
        String result = "";
        String test = "aeiouyAEIOUY";
        if(input.length() == 0 || input.charAt(0) == ' '){
            return "";
        }
        String tail = "";
        String punct = ".,;:?!";
        if(punct.indexOf(input.substring(input.length()-1)) >= 0){

            tail += input.substring(input.length()-1);
            input = input.substring(0,input.length()-1);
        }
        boolean firstLetterCapital = Character.isUpperCase(input.charAt(0));
        String change = (input.substring(0,1)).toLowerCase() + input.substring(1);
        if(test.indexOf(change.charAt(0)) != -1){
            result = input + "ay";
        }
        else{
            while(test.indexOf(change.charAt(0)) == -1){
                change = change.substring(1) + change.charAt(0);
            }
            result = change + "ay";
        }
        if(result.length() > 0 && firstLetterCapital){
            result = (result.substring(0,1)).toUpperCase() + result.substring(1);
            firstLetterCapital = false;
        }
        return result + tail;
    }
}
//fixed the test issue

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)


