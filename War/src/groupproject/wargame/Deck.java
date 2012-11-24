package groupproject.wargame;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Constructs Deck of cards for the player
 *
 * @author Matthew Bock (mattb93)
 * @author Kevin Olson (kevino93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 14, 2012
 */

public class Deck
{

    /**
     * An Array List of type Card
     */
    ArrayList<Card> decks;


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
            throw new EmptyStackException();
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


    /**
     * Randomly shuffles the pile .removes the top card and puts another card to
     * that position
     */
    public void shuffle()
    {
        Random rand = new Random();

        for (int i = 0; i < decks.size(); i++)

        {

            if (size() > 0)
            {

                Card top = decks.remove(decks.size() - 1);
                int now = rand.nextInt(decks.size());

                decks.add(now, top);

            }

        }

    }


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

}
