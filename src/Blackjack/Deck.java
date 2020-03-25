package Blackjack;

import java.util.ArrayList;
import java.util.Random;

/*
 * Creates and shuffles a deck of 52 playing cards.
 */
class Deck {

    private ArrayList<Card> Deck;

    Deck() {
        Deck = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                Deck.add(new Card(i, j));
            }
        }
    }

   
    public void shuffleCards() {
        Random random = new Random();
        Card temp;
        for (int i = 0; i < 200; i++) {
            int index1 = random.nextInt(Deck.size() - 1);
            int index2 = random.nextInt(Deck.size() - 1);
            temp = Deck.get(index2);
            Deck.set(index2, Deck.get(index1));
            Deck.set(index1, temp);
        }
    }

    
    public Card draw() {
        return Deck.remove(0);
    }
}
