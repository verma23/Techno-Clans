package Blackjack;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import static Blackjack.User.Bet;
import static Blackjack.User.Hit;
import static Blackjack.User.Lose;
import static Blackjack.User.Push;
import static Blackjack.User.Win;
import static Blackjack.User.hasBJ;
import static Blackjack.User.calculate;
import static Blackjack.User.yes_no;
import static Blackjack.User.FiveCard;
import static Blackjack.User.check;
import static Blackjack.User.Hit_Stand;


public class Game {

    public static void main(String[] args) {
        int Money;
        int BetMoney;
        int ACount;
        String Name;

        System.out.println("Hi! What is your name?");
        Scanner scan = new Scanner(System.in);
        Name = scan.nextLine();
        System.out.println("Hello, " + Name + ", lets play some BlackJack!");
        System.out.println("How much cash do you want to start with?");
        Scanner money = new Scanner(System.in);
        Money = money.nextInt();
        System.out.println("You start with cash: " + Money);
        while (Money > 0) {
            Deck deck = new Deck();
            deck.shuffleCards();
            ACount = 0;
            Dealer dealer = new Dealer(deck);
            List<Card> hand = new ArrayList<>();
            hand.add(deck.draw());
            hand.add(deck.draw());
            System.out.println("How much would you like to bet?");
            BetMoney = Bet(Money);
            System.out.println("Cash:" + (Money - BetMoney));
            System.out.println("Money on the table:" + BetMoney);
            System.out.println("Here is your hand: ");
            System.out.println(hand);
            int handvalue = calculate(hand, ACount);
            System.out.println("The dealer is showing: ");
            dealer.showCard();
            if (hasBJ(handvalue) && dealer.BJ())
            {
                Push(Money);
            } else if (hasBJ(handvalue))
            {
                System.out.println("You have BlackJack!");
                System.out.println("You win 2x your money back!");
                Money = Money + BetMoney;
                Money = Win(Money, BetMoney);
            } else if (dealer.BJ())
            {
                System.out.println("Here is the dealer's hand:");
                dealer.show();
                Money = Lose(Money, BetMoney);
            } else {
                if (2 * BetMoney < Money)
                {
                    System.out.println("Would you like to double down?");
                    Scanner doubledown = new Scanner(System.in);
                    String doubled = doubledown.nextLine();
                    while (!yes_no(doubled)) {
                        System.out.println("Please enter yes or no.");
                        doubled = doubledown.nextLine();
                    }
                    if (doubled.equals("yes")) {
                        System.out.println("You have opted to double down!");
                        BetMoney = 2 * BetMoney;
                        System.out.println("Cash:" + (Money - BetMoney));
                        System.out.println("Money on the table:" + BetMoney);
                    }
                }
                System.out.println("Would you like to hit or stand?");
                Scanner hitorstand = new Scanner(System.in);
                String hitter = hitorstand.nextLine();
                while (!Hit_Stand(hitter)) {
                    System.out.println("Please enter 'hit' or 'stand'.");
                    hitter = hitorstand.nextLine();
                }
                while (hitter.equals("hit"))
                {
                    Hit(deck, hand, handvalue, ACount);
                    System.out.println("Your hand is now:");
                    System.out.println(hand);
                    handvalue = calculate(hand, ACount);
                    if (check(handvalue))
                    {
                        Money = Lose(Money, BetMoney);
                        break;
                    }
                    if (handvalue <= 21 && hand.size() == 5)
                    {
                        FiveCard(Money, BetMoney);
                        break;
                    }
                    System.out.println("Would you like to hit or stand?");
                    hitter = hitorstand.nextLine();
                }
                if (hitter.equals("stand"))
                {
                    int dealerhand = dealer.takeTurn(deck);
                    System.out.println("");
                    System.out.println("Here is the dealer's hand:");
                    dealer.show();
                    if (dealerhand > 21)
                    {
                        Money = Win(Money, BetMoney);
                    } else {
                        int you = 21 - handvalue;
                        int deal = 21 - dealerhand;
                        if (you == deal) {
                            Push(Money);
                        }
                        if (you < deal) {
                            Money = Win(Money, BetMoney);
                        }
                        if (deal < you) {
                            Money = Lose(Money, BetMoney);
                        }
                    }
                }
            }
            System.out.println("Would you like to play again?");
            Scanner yesorno = new Scanner(System.in);
            String answer = yesorno.nextLine();
            while (!yes_no(answer)) {
                System.out.println("Please answer yes or no.");
                answer = yesorno.nextLine();
            }
            if (answer.equals("no")) {
                break;
            }
        }
        System.out.println("Your cash is: " + Money);
        if (Money == 0) {
            System.out.println("You ran out of cash!");
        } else {
            System.out.println("Enjoy your winnings, " + Name + "!");
        }
    }

}
