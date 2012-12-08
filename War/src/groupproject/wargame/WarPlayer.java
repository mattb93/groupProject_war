package groupproject.wargame;

// -------------------------------------------------------------------------
/**
 * The player class for War. Extends the base card player class.
 *
 * @author Kevin Olson (kevino93)
 * @author Matthew Bock (mattb93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Dec 7, 2012
 */
public class WarPlayer
    extends CardPlayer
{
    private int total;


    // ----------------------------------------------------------
    /**
     * Create a new WarPlayer object.
     */
    public WarPlayer()
    {
        // empty
    }


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
            total = total + card.type();
        }

        return total;
    }

}
