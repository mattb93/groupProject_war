package groupproject.wargame;

import sofia.graphics.Color;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 * The first screen of the War Game, the title Screen. If you can see this, it
 * worked.
 *
 * @author Matt
 * @version Oct 31, 2012
 */
public class LaunchScreen
    extends ShapeScreen
{
    // ----------------------------------------------------------
    /**
     * Run when the screen is created.
     */
    public void initialize()
    {
        setBackgroundColor(Color.green);
    }

    // ----------------------------------------------------------
    /**
     * Called when the BlackJack button is clicked.
     */
    public void blackJackButtonClicked()
    {
        presentScreen(BlackJackScreen.class);
    }
}
