package groupproject.wargame;

// -------------------------------------------------------------------------
/**
 * Tests cases for the Card's functionality.
 *
 * @author Matthew Bock (mattb93)
 * @author Kevin Olson (kevino93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 14, 2012
 */
public class CardTests
    extends student.TestCase
{
    private Card card;


    // ----------------------------------------------------------
    /**
     * Create a new CardTests object.
     */
    public CardTests()
    {
        // empty
    }


    // ----------------------------------------------------------
    /**
     * Tests getting the card's integer and string suit values.
     */
    public void testSuits()
    {
        card = new Card(0, 4);
        assertEquals(0, card.suitValue());
        assertEquals("Clubs", card.suit());

        card = new Card(1, 4);
        assertEquals(1, card.suitValue());
        assertEquals("Hearts", card.suit());

        card = new Card(2, 4);
        assertEquals(2, card.suitValue());
        assertEquals("Diamonds", card.suit());

        card = new Card(3, 4);
        assertEquals(3, card.suitValue());
        assertEquals("Spades", card.suit());
    }


    // ----------------------------------------------------------
    /**
     * Tests that the integer and face values are correct.
     */
    public void testValues()
    {
        card = new Card(0, 11);
        assertEquals(11, card.value());
        assertEquals("Joker", card.faceValue());

        card = new Card(0, 12);
        assertEquals(12, card.value());
        assertEquals("Queen", card.faceValue());

        card = new Card(0, 13);
        assertEquals(13, card.value());
        assertEquals("King", card.faceValue());

        card = new Card(0, 14);
        assertEquals(14, card.value());
        assertEquals("Ace", card.faceValue());
    }

    public void testToString()
    {
        card = new Card(2, 12);
        assertEquals("Queen of Diamonds", card.toString());
    }
}
