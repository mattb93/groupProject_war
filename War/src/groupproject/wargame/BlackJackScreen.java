package groupproject.wargame;

import sofia.graphics.TextShape;
import sofia.graphics.RectangleShape;
import java.util.ArrayList;
import android.graphics.RectF;
import sofia.graphics.ImageShape;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Matthew Bock (mattb93)
 * @author Kevin Olson (kevino93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Dec 3, 2012
 */
public class BlackJackScreen
    extends ShapeScreen
{
    // The blackjack game
    private Blackjack             game;
    private String                name;

    // Common dimensions we will need.
    private float                 height;
    private float                 width;
    private float                 cardHeight;
    private float                 cardWidth;

    // Lists to handle the card images that are currently on the screen.
    private ArrayList<ImageShape> dealerCardList;
    private int                   nextDealerIndex;
    private ArrayList<ImageShape> playerCardList;
    private int                   nextPlayerIndex;

    // Booleans to control when the hit and stand buttons will work.
    private boolean               hitable;
    private boolean               standable;
    private boolean               resetText = false;

    // The box with the dealer's score.
    private RectangleShape        dealerBox;
    private TextShape             dealerName;
    private TextShape             dealerPointsShape;

    // The box with the player's score
    private RectangleShape        playerBox;
    private TextShape             playerName;
    private TextShape             playerPointsShape;

    // Text that will show up in the middle of the screen when the game is over.
    private TextShape             winResult;


    // ----------------------------------------------------------
    /**
     * Run when the screen is created.
     *
     * @param nameFromLaunch
     *            the name of the player, passed in from LaunchScreen.
     */
    public void initialize(String nameFromLaunch)
    {
        // Initialize necessary fields.
        game = new Blackjack();
        hitable = true;
        standable = true;
        nextDealerIndex = 0;
        nextPlayerIndex = 0;
        name = nameFromLaunch;

        if (resetText)
        {
            remove(winResult);
        }

        // Initialize the arrays that will hold the players' card images.
        dealerCardList = new ArrayList<ImageShape>(8);
        playerCardList = new ArrayList<ImageShape>(8);

        // Set the shapeScreen to be green and get its dimensions.
        setBackgroundColor(Color.green);
        height = getHeight();
        width = getWidth();
        cardWidth = 72;
        cardHeight = 96;

        // Draw the blank spaces to hold the dealer's cards
        for (float i = 0; i < 2 * cardHeight; i = i + cardHeight)
        {
            for (float j = 0; j < cardWidth * 4; j = j + cardWidth)
            {
                RectF rect = new RectF(0.0f, 0.0f, cardWidth, cardHeight);
                ImageShape topCardSpace = new ImageShape("cardspace", rect);
                topCardSpace.setPosition(j, i);
                dealerCardList.add(topCardSpace);
                add(topCardSpace);
            }
        }

        // Draw the blank spaces to hold the player's cards.
        for (float i = height - 2 * cardHeight; i < height; i = i + cardHeight)
        {
            for (float j = 0; j < cardWidth * 4; j = j + cardWidth)
            {
                RectF rect = new RectF(0.0f, 0.0f, cardWidth, cardHeight);
                ImageShape bottomCardSpace = new ImageShape("cardspace", rect);
                bottomCardSpace.setPosition(j, i);
                playerCardList.add(bottomCardSpace);
                add(bottomCardSpace);
            }
        }

        // Draw the box to the right of the dealer's cards.
        dealerBox = new RectangleShape(4 * cardWidth, 0, width, 2 * cardHeight);
        dealerBox.setColor(Color.black);
        dealerBox.setFillColor(Color.green);
        dealerBox.setFilled(true);
        add(dealerBox);

        // Add the dealer's name ("Dealer") to the box.
        dealerName = new TextShape("Dealer", 4 * cardWidth + 5, 5);
        dealerName.setColor(Color.black);
        dealerName.setTypeSize(5f);
        add(dealerName);

        // Set up the textView that will display the dealer's score.
        dealerPointsShape =
            new TextShape("" + 0, 4 * cardWidth + 5, cardHeight / 2);
        dealerPointsShape.setColor(Color.black);
        dealerPointsShape.setTypeSize(8f);
        add(dealerPointsShape);

        // Set up the box next to the player's cards.
        playerBox =
            new RectangleShape(
                4 * cardWidth,
                height - 2 * cardHeight,
                width,
                height);
        playerBox.setColor(Color.red);
        playerBox.setFillColor(Color.green);
        playerBox.setFilled(true);
        add(playerBox);

        // Set up the textView to display the player's name ("You").
        playerName =
            new TextShape(this.name, 4 * cardWidth + 5, height - 2 * cardHeight
                + 5);
        playerName.setColor(Color.black);
        playerName.setTypeSize(5f);
        add(playerName);

        // Set up the textView to display the player's score
        playerPointsShape =
            new TextShape("" + 0, 4 * cardWidth + 5, height - cardHeight);
        playerPointsShape.setColor(Color.black);
        playerPointsShape.setTypeSize(8f);
        add(playerPointsShape);

        // Deal the initial cards
        game.dealHand();

        // Get the players' scores after their first 2 cards
        for (Card c : game.returnPlayer().returnHand())
        {
            playerCardList.get(nextPlayerIndex).setImage(c.toGraphic());
            nextPlayerIndex++;
        }

        for (Card c : game.returnDealer().returnHand())
        {
            dealerCardList.get(nextDealerIndex).setImage(c.toGraphic());
            nextDealerIndex++;
        }

        dealerPointsShape.setText("" + game.returnDealer().returnTotal());
        playerPointsShape.setText("" + game.returnPlayer().returnTotal());
    }


    // ----------------------------------------------------------
    /**
     * Called when the player hits the "Hit Me!" button.
     */
    public void hitButtonClicked()
    {
        if (hitable)
        {
            Card hit = game.hit("Player");

            if (nextPlayerIndex > 7)
            {
                nextPlayerIndex = 0;
            }

            playerCardList.get(nextPlayerIndex).setImage(hit.toGraphic());
            nextPlayerIndex++;

            if (game.checkLose())
            {
                playerPointsShape.setText(""
                    + game.returnPlayer().returnTotal());
                playerLost();
            }

            playerPointsShape.setText("" + game.returnPlayer().returnTotal());
        }
    }


    // ----------------------------------------------------------
    /**
     * Called when the reset button is clicked, resets the whole screen.
     */
    public void resetButtonClicked()
    {

        initialize(name);
    }


    // ----------------------------------------------------------
    /**
     * Called when the player stands.
     */
    public void standButtonClicked()
    {
        if (standable)
        {
            hitable = false;
            standable = false;

            Boolean result = game.playerStand();

            dealerPointsShape.setText("" + game.returnDealer().returnTotal());

            if (result)
            {
                nextDealerIndex = 0;
                for (Card c : game.returnDealer().returnHand())
                {
                    dealerCardList.get(nextDealerIndex).setImage(c.toGraphic());
                    nextDealerIndex++;
                }
                playerLost();
            }

            if (!result)
            {
                nextDealerIndex = 0;
                for (Card c : game.returnDealer().returnHand())
                {
                    dealerCardList.get(nextDealerIndex).setImage(c.toGraphic());
                    nextDealerIndex++;
                }
                playerWon();
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Stuff to do when the player loses.
     */
    public void playerLost()
    {
        hitable = false;
        standable = false;

        String str = "You Lost! Press reset to play again.";
        winResult = new TextShape(str);
        winResult.setTypeSize(5f);

        resetText = true;

        float textWidth = winResult.getWidth();
        float textHeight = winResult.getHeight();

        winResult.setPosition((width / 2) - (textWidth / 2), (height / 2)
            - (textHeight / 2));
        winResult.setVisible(true);
        add(winResult);
    }


    // ----------------------------------------------------------
    /**
     * Stuff to do when the player wins.
     */
    public void playerWon()
    {
        hitable = false;
        standable = false;

        resetText = true;

        String str = "You Won! Press reset to play again.";
        winResult = new TextShape(str);
        winResult.setTypeSize(5f);

        float textWidth = winResult.getWidth();
        float textHeight = winResult.getHeight();

        winResult.setPosition((width / 2) - (textWidth / 2), (height / 2)
            - (textHeight / 2));
        winResult.setVisible(true);
        add(winResult);
    }
}
