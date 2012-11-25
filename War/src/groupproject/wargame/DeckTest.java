package groupproject.wargame;

import student.TestCase;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Tests for the Deck class
 *
 * @author Matthew Bock (mattb93)
 * @author Kevin Olson (kevino93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 14, 2012
 */

public class DeckTest
    extends TestCase
{
    private Deck deck;


    // ----------------------------------------------------------
    /**
     * Creates a brand new empty stack for test.
     */

    public void setUp()

    {
        deck = new Deck();
        deck.fill();
    }


    // ----------------------------------------------------------
    /**
     * Tests the fill method to make sure that the deck is full of valid cards.
     */
    public void testFill()
    {
        System.out.println(deck.toString());
    }


    // ----------------------------------------------------------
    /**
     * Tests the top method, including if there are no cards and only one card
     * in the deck.
     */
    public void testTop()
    {
        assertEquals("Ace of Spades", deck.top().toString());
        assertEquals("King of Spades", deck.top().toString());

        deck.clear();

        try
        {
            deck.top();
        }
        catch (IllegalStateException e)
        {
            assertEquals("There are no cards in the deck.", e.getMessage());
        }

        deck.add(new Card(0, 2));
        assertEquals("2 of Clubs", deck.top().toString());
    }


    // ----------------------------------------------------------
    /**
     * Tests shuffling the deck.
     */
    public void testShuffle()
    {
        String before = deck.toString();
        System.out.println(deck.toString());

        deck.shuffle();

        String after = deck.toString();
        System.out.println(deck.toString());

        assertFalse(before == after);
    }
}
