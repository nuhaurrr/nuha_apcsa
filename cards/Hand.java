package cards;

public class Hand {

    private Card[] cards;   // fixed-size array
    private int size;       // how many cards are actually stored

    /** 
     * Creates a Hand that can store up to maxCards cards. 
     */
    public Hand(int maxCards) {
        cards = new Card[maxCards];
        size = 0;
    }

    /**
     * Adds a card to the Hand.
     * If Hand is full, nothing is added (assignment does not specify behavior).
     */
    public void add(Card c) {
        if (size < cards.length) {
            cards[size] = c;
            size++;
        }
    }

    /**
     * Returns the number of cards currently stored.
     */
    public int length() {
        return size;
    }

    /**
     * Returns the card at the given index without removing it.
     * Valid index is 0 to length-1.
     */
    public Card get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return cards[index];
    }

    /**
     * Removes and returns the card at the given index.
     * All cards after index shift left by one position.
     */
    public Card remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Card removed = cards[index];

        // shift left
        for (int i = index; i < size - 1; i++) {
            cards[i] = cards[i + 1];
        }

        cards[size - 1] = null; // cleanup
        size--;

        return removed;
    }

    /**
     * Returns a string representation of the Hand.
     * Format example:  "♦A ♦5 ♣10"
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(cards[i]);
            if (i < size - 1) sb.append(" ");
        }

        return sb.toString();
    }
}

//finished it!

