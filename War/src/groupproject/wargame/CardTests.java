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
        assertEquals("clubs", card.suit());

        card = new Card(1, 4);
        assertEquals(1, card.suitValue());
        assertEquals("hearts", card.suit());

        card = new Card(2, 4);
        assertEquals(2, card.suitValue());
        assertEquals("diamonds", card.suit());

        card = new Card(3, 4);
        assertEquals(3, card.suitValue());
        assertEquals("spades", card.suit());
    }


    // ----------------------------------------------------------
    /**
     * Tests that the integer and face values are correct.
     */
    public void testValues()
    {
        card = new Card(0, 11);
        assertEquals(10, card.value());
        assertEquals("jack", card.faceValue());

        card = new Card(0, 12);
        assertEquals(10, card.value());
        assertEquals("queen", card.faceValue());

        card = new Card(0, 13);
        assertEquals(10, card.value());
        assertEquals("king", card.faceValue());

        card = new Card(0, 14);
        assertEquals(11, card.value());
        assertEquals("ace", card.faceValue());
    }

    // ----------------------------------------------------------
    /**
     * Tests toString
     */
    public void testToString()
    {
        card = new Card(2, 12);
        assertEquals("queen of diamonds", card.toString());
    }

    // ----------------------------------------------------------
    /**
     * Testing the type functionality.
     */
    public void testTypes()
    {
        card = new Card(2, 4);
        assertEquals(4, card.type());

        card = new Card(1, 12);
        assertEquals(12, card.type());
    }

    // ----------------------------------------------------------
    /**
     * Test changing the values in aces.
     */
    public void testToggleAce()
    {
        card = new Card(2, 14);
        assertEquals(11, card.value());

        card.toggleAce();
        assertEquals(1, card.value());
    }

    // ----------------------------------------------------------
    /**
     * Tests getting the graphic representing this card.
     */
    public void testGraphics()
    {
        card = new Card(0, 7);
        assertEquals("clubs7", card.toGraphic());
    }
}
