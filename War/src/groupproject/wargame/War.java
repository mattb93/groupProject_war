package groupproject.wargame;

// -------------------------------------------------------------------------
/**
 * Logic for the war Card Game.
 *
 * @author Kevin Olson (kevino93)
 * @author Matthew Bock (mattb93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Dec 7, 2012
 */
public class War
    extends CardGame
{

    /**
     * The deck used by War.
     */
    public Deck       deck;
    private WarPlayer player;
    private WarPlayer computer;


    // ----------------------------------------------------------
    /**
     * Create a new War object.
     */
    public War()
    {
        deck = new Deck();
        player = new WarPlayer();
        computer = new WarPlayer();

        deck.fill();
        deck.shuffle();
    }


    // ----------------------------------------------------------
    /**
     * Deals cards out to players
     */
    public void dealHand()
    {
        for (int i = 0; i <= 51; i++)
        {
            if (i % 2 == 0)
            {
                player.receiveCard(deck.top());
            }
            else
            {
                computer.receiveCard(deck.top());
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Shows the cards from the top of the player's deck.
     *
     * @return the player's card.
     */
    public Card flipPlayerCard()
    {
        return player.giveCard(0);
    }


    // ----------------------------------------------------------
    /**
     * Shows the card from the top of the computer's deck.
     *
     * @return the player's card.
     */
    public Card flipComputerCard()
    {
        return computer.giveCard(0);
    }


    // ----------------------------------------------------------
    /**
     * Checks to see who won between the two cards. ALso accounts for ties.
     * @param playerCard the card given by the player.
     * @param dealerCard the card given by the dealer.
     *
     * @return -1 if the computer wins, 0 if they tie, and 1 if the player wins.
     */
    public int checkWinner(Card playerCard, Card dealerCard)
    {
        int playerTotal = playerCard.type();
        int computerTotal = dealerCard.type();

        if (playerTotal > computerTotal)
        {
            return 1;
        }
        else if (computerTotal > playerTotal)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns the human player.
     *
     * @return the human player.
     */
    public WarPlayer returnPlayer()
    {
        return player;
    }


    // ----------------------------------------------------------
    /**
     * Returns the computer player.
     *
     * @return the computer player.
     */
    public WarPlayer returnDealer()
    {
        return computer;
    }
}
