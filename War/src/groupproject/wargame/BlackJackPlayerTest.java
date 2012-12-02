package groupproject.wargame;

// -------------------------------------------------------------------------
/**
 * Testing class for BlackJackPlayer
 *
 * @author Matthew Bock (mattb93)
 * @author Kevin Olson (kevino93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 26, 2012
 */

public class BlackJackPlayerTest
    extends student.TestCase
{

    private BlackJackPlayer player = new BlackJackPlayer();


    // ----------------------------------------------------------
    /**
     * Create a new BlackJackPlayerTest object.
     */
    public BlackJackPlayerTest()
    {
        // empty
    }


    // ----------------------------------------------------------
    /**
     * Test the hasAce functionality.
     */
    public void testHasAce()
    {
        player.receiveCard(new Card(2, 9));
        assertFalse(player.hasAce());

        player.receiveCard(new Card(2, 14));
        assertTrue(player.hasAce());
        assertEquals(1, player.giveCard(1).value());
    }


    // ----------------------------------------------------------
    /**
     * test return total functonality.
     */
    public void testReturnTotal()
    {
        player.clearHand();
        player.receiveCard(new Card(0, 4));
        player.receiveCard(new Card(0, 5));
        player.receiveCard(new Card(0, 6));
        assertEquals(15, player.returnTotal());

        player.clearHand();
        player.receiveCard(new Card(0, 12));
        player.receiveCard(new Card(0, 14));
        assertEquals(21, player.returnTotal());

        player.hasAce();
        assertEquals(11, player.returnTotal());
    }
}
