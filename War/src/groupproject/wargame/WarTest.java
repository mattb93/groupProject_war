package groupproject.wargame;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 * @author Kevin Olson (kevino93)
 * @author Matthew Bock (mattb93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Dec 7, 2012
 */
public class WarTest
    extends TestCase
{
    private War game;

    // ----------------------------------------------------------
    /**
     * Create a new WarTest object.
     */
    public WarTest()
    {
        // empty
    }

    // ----------------------------------------------------------
    /**
     * Test the initial dealing.
     */
    public void testDeal()
    {
        game = new War();

        game.dealHand();

        assertEquals(26, game.returnPlayer().returnHand().size());
        assertEquals(26, game.returnDealer().returnHand().size());
    }

    // ----------------------------------------------------------
    /**
     * Test flipping the cards.
     */
    public void testFlipCards()
    {
        game = new War();

        game.deck.clear();
        for (int i = 0; i <= 50; i++)
        {
            game.deck.add(new Card(0, 5));
        }
        game.deck.add(new Card(0, 2));
        game.deck.add(new Card(0, 3));

        game.dealHand();

        assertEquals(3, game.flipPlayerCard().type());
        assertEquals(2, game.flipComputerCard().type());
    }

    // ----------------------------------------------------------
    /**
     * Tests Winners of each game.
     */
    public void testWinners()
    {
        game = new War();

        Card winner = new Card(0, 14);
        Card loser = new Card(0, 2);

        assertEquals(1, game.checkWinner(winner, loser));
        assertEquals(-1, game.checkWinner(loser, winner));
        assertEquals(0, game.checkWinner(loser, loser));
    }

}
