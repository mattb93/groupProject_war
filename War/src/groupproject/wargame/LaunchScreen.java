package groupproject.wargame;

import android.widget.EditText;
import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 * The first screen of the War Game, the title Screen. If you can see this, it
 * worked.
 *
 * @author Matt
 * @version Oct 31, 2012
 */
public class LaunchScreen
    extends Screen
{
    private EditText nameField;
    // ----------------------------------------------------------
    /**
     * Called when the BlackJack button is clicked.
     */
    public void blackJackButtonClicked()
    {
        String name = nameField.getText().toString();

        presentScreen(BlackJackScreen.class, name);
    }

    // ----------------------------------------------------------
    /**
     * Called when the War button is clicked.
     */
    public void warButtonClicked()
    {
        String name = nameField.getText().toString();

        presentScreen(WarScreen.class, name);
    }
}
