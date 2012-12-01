package groupproject.wargame;


// -------------------------------------------------------------------------
/**
 * Blackjack game class Logic we need for BlackJack
 *
 * @author Kevin Olson (kevino93)
 * @author Matthew Bock (mattb93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 29, 2012
 */
public class Blackjack
    extends CardGame
{
    /**
     * The deck to be used by the game.
     */
    public Deck             deck;
    private BlackJackPlayer player;
    private BlackJackPlayer dealer;
    private int             score = 0;


    // ----------------------------------------------------------
    /**
     * Create a new Blackjack object.
     */
    public Blackjack()
    {
        deck = new Deck();
        player = new BlackJackPlayer();
        dealer = new BlackJackPlayer();

        deck.fill();
        deck.shuffle();
    }


    // ----------------------------------------------------------
    /**
     * Gives the players two cards to start the game off.
     */
    public void dealHand()
    {
        player.receiveCard(deck.top());
        dealer.receiveCard(deck.top());
        player.receiveCard(deck.top());
        dealer.receiveCard(deck.top());
    }


    // ----------------------------------------------------------
    /**
     * Gives a player a card.
     *
     * @param receiver
     *            the player to receive the card.
     * @return the card that was given to the player.
     */
    public Card hit(BlackJackPlayer receiver)
    {
        Card newCard = deck.top();
        receiver.receiveCard(newCard);
        return newCard;
    }


    // ----------------------------------------------------------
    /**
     * Checks if the player loses.
     *
     * @return true if the
     */
    public boolean checkLose()
    {
        int total = player.returnTotal();

        if (total > 21)
        {
            score--;
            return true;
        }

        else
        {
            return false;
        }

    }


    // ----------------------------------------------------------
    /**
     * Runs when the player is done hitting and hits the stand button. Also
     * contains all of the logic for the computer player.
     *
     * @return true if the computer wins, false if it loses.
     */
    public boolean playerStand()
    {
        int computerTotal = dealer.returnTotal();
        int playerTotal = player.returnTotal();

        while (computerTotal < playerTotal && computerTotal < 21)
        {
            hit(dealer);
            computerTotal = dealer.returnTotal();
            if (computerTotal > 21)
            {
                dealer.hasAce();
                computerTotal = dealer.returnTotal();
            }
        }

        if (computerTotal >= playerTotal && computerTotal < 22)
        {
            score--;
            return true;
        }

        else
        {
            score++;
            return false;
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns the player's score.
     *
     * @return the player's score.
     */
    public int getScore()
    {
        return score;
    }


    // ----------------------------------------------------------
    /**
     * Returns the deck. For testing and stuff.
     *
     * @return the deck being used by the game.
     */
    public Deck getDeck()
    {
        return deck;
    }
}
