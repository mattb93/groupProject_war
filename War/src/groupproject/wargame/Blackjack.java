package groupproject.wargame;

// -------------------------------------------------------------------------
/**
 * Blackjack game class
 *
 * Logic we need for BlackJack
 *
 *
 * @author Kevin Olson (kevino93)
 * @author Matthew Bock (mattb93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 29, 2012
 */
public class Blackjack extends CardGame
{
    public Deck deck;
    private CardPlayer player;


    // ----------------------------------------------------------
    /**
     * Creates a deck with cards and then shuffles them
     */
    public void setUp()
    {
        deck = new Deck();
        deck.fill();
        deck.shuffle();
    }



}
