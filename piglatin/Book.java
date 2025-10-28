package piglatin;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    Book() {
        // Empty book - no code needed here.
    }

    // Helper to debug code
    // Prints out a range of lines from a book
    public void printlines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    int getLineCount() {
        return text.size();
    }

    void appendLine(String line) {
        text.add(line);
    }

    public void readFromString(String title, String string) {
        // load a book from an input string.
        this.title = title;
        text.clear();

        Scanner sc = new Scanner(string);
        while (sc.hasNextLine()) {
            text.add(sc.nextLine());
        }
        sc.close();
        // TODO: use Scanner to populate the book
        // use: text.add(line) to add a line to the book.
    }

    public void readFromUrl(String title, String url) {
        // load a book from a URL.
        // https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
        this.title = title;

        try {
            URL bookUrl = URI.create(url).toURL();
            Scanner sc = new Scanner(bookUrl.openStream());

            while (sc.hasNextLine()) {
                text.add(sc.nextLine());
            }

            sc.close();
            // TODO: use Scanner to populate the book
            // Scanner can open a file on a URL like this:
            // Scanner(bookUrl.openStream())
            // use: text.add(line) to add a line to the book.
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void writeToFile(String name) {
        try (PrintWriter out = new PrintWriter(new FileWriter(name))) {
            for (String line : text) {
                out.println(line);
            }
            System.out.println("Book \"" + title + "\" written to file: " + name);
        } catch (IOException ex) {
            System.err.println("Error writing book to file: " + name);
            ex.printStackTrace();
        }
        // TODO: Add code here to write the contents of the book to a file.
        // Must write to file using provided name.
    }
            public static void main(String[] args) {
        Book myBook = new Book();
        myBook.readFromUrl("Alice in Wonderland", 
            "https://www.gutenberg.org/files/11/11-0.txt");

        // Print a few lines to verify it loaded correctly
        myBook.printlines(0, 5);

        // Save it locally (optional)
        myBook.writeToFile("AliceInWonderland.txt");
    }
}


