package cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        // Default deck order:
        // Suit: 0–3   (♦, ♣, ♥, ♠)
        // Value: 0–12 (A … K)
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 0; value < 13; value++) {
                cards.add(new Card(suit, value));
            }
        }
    }

    /** Randomizes the deck. */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Moves cards [0, index) to the end of the deck.
     * Only allowed if deck has all 52 cards.
     */
    public void cut(int index) {
        if (cards.size() != 52) return;

        ArrayList<Card> top = new ArrayList<Card>(cards.subList(0, index));
        ArrayList<Card> bottom = new ArrayList<Card>(cards.subList(index, 52));

        cards.clear();
        cards.addAll(bottom);
        cards.addAll(top);
    }

    /** Removes and returns the top card, or null if empty. */
    public Card draw() {
        if (cards.isEmpty()) return null;
        return cards.remove(0);
    }

    /** Prints the first n cards on one line, separated by spaces. */
    public void print(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n && i < cards.size(); i++) {
            sb.append(cards.get(i).toString());
            if (i < n - 1) sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
