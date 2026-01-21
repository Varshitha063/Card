package card;

import java.util.Random;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then searches the array of cards for a hard-coded lucky card.
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

            // Print each card
            System.out.println(c.getSuit() + " " + c.getValue());
        }

        // STEP 3: Create hard-coded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");

        // STEP 4: Search for the lucky card
        boolean found = false;

        for (int i = 0; i < magicHand.length; i++)
        {
            if (magicHand[i].getValue() == luckyCard.getValue() &&
                magicHand[i].getSuit().equals(luckyCard.getSuit()))
            {
                found = true;
                break;
            }
        }

        // STEP 5: Report result
        if (found)
        {
            System.out.println("Congratulations! The lucky card is in the magic hand!");
        }
        else
        {
            System.out.println("Sorry! The lucky card is not in the magic hand.");
        }
    }
}
