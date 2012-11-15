package groupproject.wargame;

// -------------------------------------------------------------------------
/**
 * The data representation for a playing card.
 *
 * @author Matthew Bock (mattb93)
 * @author Kevin Olson (kevino93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Nov 14, 2012
 */
public class Card
{
    private int suit;
    /**
     * 0 is clubs, 1 is hearts, 2 is diamonds, 3 is spades
     */

    private int value;


    /**
     * 2 through 10 are normal cards, 11 is joker, 12 is queen, 13 is king, 14
     * is ace
     */

    /**
     * Create a new Card object.
     *
     * @param suit
     *            The suit to classify the card under.
     * @param value
     *            The value the card has. Face cards are 11 for joker, 12 for
     *            queen, 13 for king, and 14 for ace.
     */
    public Card(int suit, int value)
    {
        this.suit = suit;
        this.value = value;
    }


    // ----------------------------------------------------------
    /**
     * Returns the integer representation of this card's suit. 0 is clubs, 1 is
     * hearts, 2 is diamonds, 3 is spades.
     *
     * @return the card's suit value.
     */
    public int suitValue()
    {
        return suit;
    }


    // ----------------------------------------------------------
    /**
     * Returns the card's integer value.
     *
     * @return the card's integer value.
     */
    public int value()
    {
        return this.value;
    }


    // ----------------------------------------------------------
    /**
     * Returns the card's suit.
     *
     * @return the card's suit as a string.
     */
    public String suit()
    {
        if (suit == 0)
        {
            return "Clubs";
        }

        else if (suit == 1)
        {
            return "Hearts";
        }

        else if (suit == 2)
        {
            return "Diamonds";
        }

        else
        {
            return "Spades";
        }
    }


    // ----------------------------------------------------------
    /**
     * If the card is a face card, it will return the card's face type as a
     * string. Otherwise, an exception will be thrown.
     *
     * @return the card's face value.
     */
    public String faceValue()
    {
        if (value == 11)
        {
            return "Joker";
        }

        else if (value == 12)
        {
            return "Queen";
        }

        else if (value == 13)
        {
            return "King";
        }

        else if (value == 14)
        {
            return "Ace";
        }

        else
        {
            return "Not a face card";
        }
    }
}
