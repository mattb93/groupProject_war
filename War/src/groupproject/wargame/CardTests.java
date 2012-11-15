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
     * Tests getting the card's integer suit value.
     */
    public void testSuitValue()
    {
        card = new Card(0, 4);
        assertEquals(0, card.suitValue());

        card = new Card(1, 4);
        assertEquals(1, card.suitValue());

        card = new Card(2, 4);
        assertEquals(2, card.suitValue());

        card = new Card(3, 4);
        assertEquals(3, card.suitValue());
    }
}
