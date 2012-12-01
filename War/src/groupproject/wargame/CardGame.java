package groupproject.wargame;

// -------------------------------------------------------------------------
/**
 * The basic logic for card games. Different games with different sets of rules
 * will extend this one.
 *
 * @author Matthew Bock (mattb93)
 * @author Kevin Olson (kevino93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 26, 2012
 */
public abstract class CardGame
{
    private Deck       deck = new Deck();
    private CardPlayer player1;
    private CardPlayer player2;


    // ----------------------------------------------------------
    /**
     * Fills and shuffles the deck.
     */
    public void prepareCards()
    {
        deck.fill();
        deck.shuffle();
    }


    // ----------------------------------------------------------
    /**
     * Resets the deck, then fills and shuffles it again.
     */
    public void resetDeck()
    {
        deck = new Deck();
        deck.fill();
        deck.shuffle();
    }
}
