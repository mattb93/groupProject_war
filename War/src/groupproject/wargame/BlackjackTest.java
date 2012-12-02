package groupproject.wargame;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * Testing for the blackjack game class.
 *
 * @author Kevin Olson (kevino93)
 * @author Matthew Bock (mattb93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 29, 2012
 */

public class BlackjackTest
    extends TestCase
{
    private Blackjack game = new Blackjack();


    // ----------------------------------------------------------
    /**
     * Create a new BlackjackTest object.
     *
     */
    public BlackjackTest()
    {
        // empty
    }


    // ----------------------------------------------------------
    /**
     * re-initialize the game before every test.
     */
    public void setUp()
    {
        game = new Blackjack();
    }


    // ----------------------------------------------------------
    /**
     * Test dealing out the initial cards.
     */
    public void testDealHand()
    {
        game.dealHand();
        assertEquals(2, game.returnPlayer().returnHand().size());
        assertEquals(2, game.returnDealer().returnHand().size());
    }


    // ----------------------------------------------------------
    /**
     * Testing the hit functionality.
     */
    public void testHit()
    {
        game.deck.top();
        game.deck.top();
        game.deck.top();
        game.deck.add(new Card(3, 14));
        game.deck.add(new Card(2, 14));
        game.deck.add(new Card(1, 14));

        assertEquals("Ace of Hearts", game.hit("Player").toString());
        assertEquals("Ace of Hearts", game.returnPlayer().giveCard(0)
            .toString());

        assertEquals("Ace of Diamonds", game.hit("Dealer").toString());
        assertEquals("Ace of Diamonds", game.returnDealer().giveCard(0)
            .toString());

        try
        {
            game.hit("hnbufgivofnewbv");
        }
        catch (IllegalStateException e)
        {
            assertEquals(
                "You can only hit the Player or the Dealer",
                e.getMessage());
        }

    }


    // ----------------------------------------------------------
    /**
     * Testing the checkLose functionality if the player goes over 21.
     */
    public void testCheckLoseOver21()
    {

        game.deck.clear();
        game.deck.add(new Card(0, 13));
        game.deck.add(new Card(1, 13));
        game.deck.add(new Card(2, 13));

        game.hit("Player");
        game.hit("Player");
        game.hit("Player");

        assertTrue(game.checkLose());
    }


    // ----------------------------------------------------------
    /**
     * Testing the check lose functionality if the player is at 21.
     */
    public void testCheckLoseAt21()
    {
        game.deck.clear();
        game.deck.add(new Card(0, 13));
        game.deck.add(new Card(0, 14));

        game.hit("Player");
        game.hit("Player");

        assertFalse(game.checkLose());
    }


    // ----------------------------------------------------------
    /**
     * Testing the check lose functionality if the player is below 21.
     */
    public void testCheckLoseBelow21()
    {
        game.deck.clear();
        game.deck.add(new Card(0, 13));
        game.deck.add(new Card(1, 13));

        game.hit("Player");
        game.hit("Player");

        assertFalse(game.checkLose());
    }


    // ----------------------------------------------------------
    /**
     * The player gets dealt 21, the computer hits until it gets 21, computer
     * wins.
     */
    public void testTie()
    {
        game.deck.clear();
        game.deck.add(new Card(0, 6));
        game.deck.add(new Card(0, 10));
        game.deck.add(new Card(0, 3));
        game.deck.add(new Card(0, 14));
        game.deck.add(new Card(0, 2));
        game.deck.add(new Card(0, 13));

        game.dealHand();

        assertTrue(game.playerStand());
    }


    // ----------------------------------------------------------
    /**
     * Both players are under 21, the dealer has more points. The dealer wins.
     */
    public void testDealerBeatsPlayer()
    {
        game.deck.clear();
        game.deck.add(new Card(0, 13));
        game.deck.add(new Card(0, 7));
        game.deck.add(new Card(0, 6));
        game.deck.add(new Card(0, 3));
        game.deck.add(new Card(0, 10));

        game.dealHand();

        assertTrue(game.playerStand());
    }


    // ----------------------------------------------------------
    /**
     * The player gets 20, the dealer gets 16. The dealer keeps hitting to try
     * to beat the player, but busts.
     */
    public void testDealerBust()
    {
        game.deck.clear();
        game.deck.add(new Card(0, 11));
        game.deck.add(new Card(0, 14));
        game.deck.add(new Card(0, 6));
        game.deck.add(new Card(0, 12));
        game.deck.add(new Card(0, 10));
        game.deck.add(new Card(0, 13));

        game.dealHand();

        assertFalse(game.playerStand());
    }


    // ----------------------------------------------------------
    /**
     * The player likes to live dangerously, but hits until he busts.
     */
    public void testPlayerBust()
    {
        game.deck.clear();
        game.deck.add(new Card(0, 13));
        game.deck.add(new Card(0, 14));
        game.deck.add(new Card(0, 9));
        game.deck.add(new Card(0, 7));
        game.deck.add(new Card(0, 10));
        game.deck.add(new Card(0, 12));

        game.dealHand();

        assertFalse(game.checkLose());

        game.hit("Player"); // player gets the ace, ace toggles
        assertFalse(game.checkLose());

        game.hit("Player"); // player gets the queen and busts
        assertTrue(game.checkLose());
    }
}
