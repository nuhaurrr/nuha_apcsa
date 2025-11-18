package cards;


public class Deck {
    
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        String[] suits = {"♦", "♣", "♥", "♠"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7",
                           "8", "9", "10", "J", "Q", "V"};

        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    /** Randomizes the order of the cards */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /** 
     * Moves the first `index` cards to the end, preserving order.
     * Only valid on a full (52-card) deck.
     */
    public void cut(int index) {
        if (cards.size() != 52) return;  // only allowed on a full deck

        ArrayList<Card> top = new ArrayList<Card>(cards.subList(0, index));
        ArrayList<Card> bottom = new ArrayList<Card>(cards.subList(index, 52));

        cards.clear();
        cards.addAll(bottom);
        cards.addAll(top);
    }

    /** Removes and returns the top card of the deck */
    public Card draw() {
        if (cards.isEmpty())
            return null;
        return cards.remove(0);
    }

    /** Prints the first n cards on one line separated by spaces */
    public void print(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n && i < cards.size(); i++) {
            sb.append(cards.get(i).toString());
            if (i < n - 1) sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}


