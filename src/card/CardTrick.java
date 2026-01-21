package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card.
 * 
 * Modified by: Varshitha Umamaheswaran
 * Student Number: 991814357
 * Date Modified: 2026-01-20
 * 
 * @author srinivsi
 */
public class CardTrick {

    public static void main(String[] args)
    {
        // STEP 1: Create array for 7 cards
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        // STEP 2: Fill array with random cards
        for (int i = 0; i < magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1);          // values 1–13
            c.setSuit(Card.SUITS[rand.nextInt(4)]);   // suits 0–3

            magicHand[i] = c;

            // Print each card in the magic hand
            System.out.println(c.getSuit() + " " + c.getValue());
        }

        // STEP 3: Ask user to pick a card
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a card value (1-13): ");
        int userValue = input.nextInt();

        System.out.print("Enter a suit (0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int suitIndex = input.nextInt();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[suitIndex]);

        // STEP 4: Search for the user's card
        boolean found = false;

        for (int i = 0; i < magicHand.length; i++)
        {
            if (magicHand[i].getValue() == userCard.getValue() &&
                magicHand[i].getSuit().equals(userCard.getSuit()))
            {
                found = true;
                break;
            }
        }

        
        if (found)
        {
            System.out.println("Your card is in the magic hand!");
        }
        else
        {
            System.out.println("Sorry, Your card is NOT in the magic hand.");
        }

        input.close();
    }
}

