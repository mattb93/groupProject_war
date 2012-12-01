package groupproject.wargame;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * This class contains the basic logic that will be used by players regardless
 * of which card game they are playing. As we add game modes, this class will be
 * exended by the individual games' player classes.
 *
 * @author Matthew Bock (mattb93)
 * @author Kevin Olson (kevino93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 26, 2012
 */
public abstract class CardPlayer
{
    /**
     * The player's hand.
     */
    protected ArrayList<Card> hand = new ArrayList<Card>(26);


    // ----------------------------------------------------------
    /**
     * Add's a card to the player's hand.
     *
     * @param card
     *            the card to add to the hand.
     */
    public void receiveCard(Card card)
    {
        hand.add(card);
    }


    // ----------------------------------------------------------
    /**
     * Removes and returns the n-th card in the player's hand.
     *
     * @param n
     *            the index of the card for the player to give.
     * @return the card that was removed.
     */
    public Card giveCard(int n)
    {
        return hand.remove(n);
    }


    // ----------------------------------------------------------
    /**
     * Empties the player's hand.
     */
    public void clearHand()
    {
        hand = new ArrayList<Card>(26);
    }


    // ----------------------------------------------------------
    /**
     * Returns the player's hand.
     *
     * @return the player's hand.
     */
    public ArrayList<Card> returnHand()
    {
        return hand;
    }
}
