package Blackjack;

class Card {

   
    private int Card;
    private int Suit;
    private int Value;
    private static String[] Cards = {"Joker", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private static String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    
    Card(int suit, int values) {
        this.Card = values;
        this.Suit = suit;
    }

    
    public String toString() {
        return Cards[Card] + " of " + SUITS[Suit];
    }

 
    public int getRank() {
        return Card;
    }

    
    public int getSuit() {
        return Suit;
    }

    
    public int getValue() {
        if (Card > 10) {
            Value = 10;
        } else if (Card == 1) {
            Value = 11;
        } else {
            Value = Card;
        }
        return Value;
    }

    
    public void setValue(int set) {
        Value = set;
    }
}
