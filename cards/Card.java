package cards;

public class Card {
    private int suit;
    private int value;
    private String[] SUIT {"♦", "♣", "♥", "♠"}
    private String[] VALUE {"A","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}

    public Card(int suit, int value){

        this.suit = suit;
        this.value = value;

    }
    public getValue(){
        
        return value;

    }
    public String toString(){

        return "" + SUIT[suit] + VALUE[value];



    }



}
