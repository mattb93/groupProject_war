package groupproject.wargame;

// -------------------------------------------------------------------------
/**
 * Player class for blackjack.
 *
 * @author Matthew Bock (mattb93)
 * @author Kevin Olson (kevino93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 26, 2012
 */
public class BlackJackPlayer
    extends CardPlayer
{
    private int total;


    // ----------------------------------------------------------
    /**
     * Determines and returns the total points in the player's hand.
     *
     * @return the points in the player's hand.
     */
    public int returnTotal()
    {
        total = 0;

        for (Card card : hand)
        {
            total = total + card.value();
        }

        return total;
    }


    // ----------------------------------------------------------
    /**
     * Checks if there is an ace in the player's hand.
     *
     * @return true if the player has an ace
     */
    public boolean hasAce()
    {
        for (Card card : hand)
        {
            if (card.value() == 11)
            {
                card.toggleAce();
                return true;
            }
        }

        return false;
    }
}
