package cards;

public class Card {

    private int suit;   // 0–3
    private int value;  // 0–12

    public Card(int suit, int value) {
        // Clamp suit
        if (suit < 0) suit = 0;
        if (suit > 3) suit = 3;
        this.suit = suit;

        // Clamp value
        if (value < 0) value = 0;
        if (value > 12) value = 12;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        String[] suits = {"♦", "♣", "♥", "♠"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7",
                           "8", "9", "10", "J", "Q", "K"};

        return suits[suit] + values[value];
    }
}



