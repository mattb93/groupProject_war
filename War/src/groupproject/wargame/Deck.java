package groupproject.wargame;

import java.util.Random;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Constructs Deck of cards for the player.
 *
 * @author Matthew Bock (mattb93)
 * @author Kevin Olson (kevino93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 14, 2012
 */

public class Deck
{

    private ArrayList<Card> decks;


    // ----------------------------------------------------------
    /**
     * Create a new Deck object.
     */
    public Deck()
    {
        // We can set the arrayList to have a specific size, since we know how
        // many cards will be in it when it is full
        decks = new ArrayList<Card>(52);
    }


    // ----------------------------------------------------------
    /**
     * It adds the card at end of the pile.
     *
     * @param card
     *            the card to put on the stack
     */
    public void add(Card card)
    {
        decks.add(card);
    }


    // ----------------------------------------------------------
    /**
     * It removes and returns the top card.
     *
     * @return the card at the top
     */
    public Card top()

    {
        if (decks.size() == 0)
        {
            throw new IllegalStateException("There are no cards in the deck.");
        }
        else
        {
            return decks.remove(decks.size() - 1);
        }

    }


    // ----------------------------------------------------------
    /**
     * Gives size of the deck.
     *
     * @return size of the deck
     */
    public int size()

    {
        return decks.size();
    }


    // ----------------------------------------------------------
    /**
     * Randomly shuffles the deck. Takes cards randomly out of the deck and
     * copies them into a new ArrayList. Resets the decks field to be that new
     * ArrayList.
     */
    public void shuffle()
    {
        Random rand = new Random();
        ArrayList<Card> newDeck = new ArrayList<Card>(52);

        for (int i = 0; i < 52; i++)
        {
            int take = rand.nextInt(decks.size());
            newDeck.add(decks.remove(take));
        }

        decks = newDeck;
    }


    // ----------------------------------------------------------
    /**
     * It clears the deck
     */
    public void clear()

    {

        decks.clear();

    }


    // ----------------------------------------------------------
    /**
     * Fills the deck with a proper set of 52 cards
     */
    public void fill()
    {
        for (int suit = 0; suit <= 3; suit++)
        {
            for (int value = 2; value <= 14; value++)
            {
                add(new Card(suit, value));
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * returns a string representing the cards in the deck
     *
     * @return a list of the cards in the deck.
     */
    public String toString()
    {
        String result = "Deck makeup:";
        String newLine = System.getProperty("line.separator");

        for (Card card : decks)
        {
            result = result + newLine;
            result = result + card.toString();
        }

        return result;
    }
}
