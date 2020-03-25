package Blackjack;

import java.util.ArrayList;
import java.util.Arrays;


class Dealer {

    ArrayList<Card> HandList;
    private int HandValue = 0;
    private Card[] array;
    private int ACount;

    Dealer(Deck deck) {
        HandList = new ArrayList<>();
        array = new Card[]{};
        int AceCounter = 0;
        for (int i = 0; i < 2; i++) {
            HandList.add(deck.draw());
        }
        array = HandList.toArray(array);
        for (int i = 0; i < array.length; i++) {
            HandValue += array[i].getValue();
            if (array[i].getValue() == 11) {
                AceCounter++;
            }
            while (AceCounter > 0 && HandValue > 21) {
                HandValue -= 10;
                AceCounter--;
            }
        }
    }

    
    public void showCard() {
        Card[] firstCard = new Card[]{};
        firstCard = HandList.toArray(firstCard);
        System.out.println("[" + firstCard[0] + "]");
    }

   
    public void Hit(Deck deck) {
        HandList.add(deck.draw());
        array = HandList.toArray(array);
        HandValue = 0;
        for (int i = 0; i < array.length; i++) {
            HandValue += array[i].getValue();
            if (array[i].getValue() == 11) {
                ACount++;
            }
            while (ACount > 0 && HandValue > 21) {
                HandValue -= 10;
                ACount--;
            }
        }
    }

   
    public boolean DealerHit() {
        if (HandValue < 17) {
            return true;
        }
        return false;
    }

    
    public boolean BJ() {
        if (HandList.size() == 2 && HandValue == 21) {
            System.out.println("The dealer has blackjack!");
            return true;
        }
        return false;
    }

    
    public void show() {
        System.out.println(HandList);
    }

    
    public int getHandValue() {
        return HandValue;
    }

    
    public boolean bust(int handvalue) {
        if (handvalue > 21) {
            System.out.println("The dealer busted!");
            return true;
        }
        return false;
    }

    
    public int takeTurn(Deck deck) {
        while (DealerHit()) {
            System.out.println("The dealer hits");
            Hit(deck);
            if (bust(HandValue)) {
                break;
            }
        }
        if (HandValue <= 21) {
            System.out.print("The dealer stands.");
        }
        return HandValue;
    }
}
