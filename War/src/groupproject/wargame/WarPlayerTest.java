package groupproject.wargame;


// -------------------------------------------------------------------------
/**
 *  Test cases for the war card player.
 *
 * @author Kevin Olson (kevino93)
 * @author Matthew Bock (mattb93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Dec 7, 2012
 */
public class WarPlayerTest
    extends student.TestCase
{

    private WarPlayer player;

    // ----------------------------------------------------------
    /**
     * Create a new WarPlayerTest object.
     */
    public WarPlayerTest()
    {

    }

    // ----------------------------------------------------------
    /**
     * Tests returning the total.
     */
    public void testReturnTotal()
    {
        player = new WarPlayer();

        player.receiveCard(new Card(0, 7));
        player.receiveCard(new Card(2, 12));

        assertEquals(19, player.returnTotal());
    }
}
