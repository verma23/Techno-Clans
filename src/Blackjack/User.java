/*
 * Mateo Shkurti
 * Student ID: 991570115
 * Syst10199- Web Programming
 */
package Blackjack;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author shkur
 */
public class User {
     
    public static boolean hasBJ(int handValue) {
        if (handValue == 21) {
            return true;
        }
        return false;
    }

 
    public static int calculate(List<Card> hand,int AceCounter) {
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        int handvalue = 0;
        for (int i = 0; i < aHand.length; i++) {
            handvalue += aHand[i].getValue();
            if (aHand[i].getValue() == 11) {
                AceCounter++;
            }
            while (AceCounter > 0 && handvalue > 21) {
                handvalue -= 10;
                AceCounter--;
            }
        }
        return handvalue;
    }

   
    public static int Bet(int cash) {
        Scanner sc = new Scanner(System.in);
        int bet = sc.nextInt();
        while (bet > cash) {
            System.out.println("You cannot bet more cash than you have!");
            System.out.println("How much would you like to bet?");
            bet = sc.nextInt();
        }
        return bet;
    }

 
    public static int Win(int cash,int bet) {
        System.out.println("Congratulations, you win!");
        cash = cash + bet;
        System.out.println("Cash: " + cash);
        return cash;
    }

   
    public static int Lose(int cash, int bet) {
        System.out.println("Sorry, you lose!");
        cash = cash - bet;
        System.out.println("Cash: " + cash);
        return cash;
    }

 
    public static void Push(int cash) {
        System.out.println("It's a push!");
        System.out.println("You get your money back.");
        System.out.println("Cash: " + cash);
    }

 
    public static void Hit(Deck deck, List<Card> hand,int handvalue,int AceCounter) {
        hand.add(deck.draw());
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        handvalue = 0;
        for (int i = 0; i < aHand.length; i++) {
            handvalue += aHand[i].getValue();
            if (aHand[i].getValue() == 11) {
                AceCounter++;
            }
            while (AceCounter > 0 && handvalue > 21) {
                handvalue -= 10;
                AceCounter--;
            }
        }
    }

   
    public static boolean Hit_Stand(String hitter) {
        if (hitter.equalsIgnoreCase("hit") || hitter.equalsIgnoreCase("stand")) {
            return true;
        }
        return false;
    }

    
    public static boolean check(int handvalue) {
        if (handvalue > 21) {
            System.out.println("You have busted!");
            return true;
        }
        return false;
    }

    
    public static boolean yes_no(String answer) {
        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
            return true;
        }
        return false;
    }

   
    public static void FiveCard(int cash, int bet) {
        System.out.println("You have achieved a five card trick!");
        Win(cash,bet);
    }
}
