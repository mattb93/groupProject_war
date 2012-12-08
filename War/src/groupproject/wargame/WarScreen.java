package groupproject.wargame;

import android.widget.Toast;
import sofia.graphics.TextShape;
import sofia.graphics.Color;
import android.graphics.RectF;
import sofia.graphics.ImageShape;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 * The GUI for War.
 *
 * @author Kevin Olson (kevino93)
 * @author Matthew Bock (mattb93)
 * @author John Sebestin (jseb11)
 * @author Sonika Singh (sonika06)
 * @version Dec 7, 2012
 */
public class WarScreen
    extends ShapeScreen
{
    // The War game
    private War        game;
    private String     name;

    // Common dimensions we will need.
    private float      height;
    private float      width;
    private float      cardHeight;
    private float      cardWidth;

    private int        playerScore;
    private int        computerScore;

    private Boolean    tie = false;
    private Boolean    goButtonActive;
    private Boolean    resetText = false;

    // Shapes we need
    private RectF      rect;
    private ImageShape playerDeck;
    private ImageShape dealerDeck;
    private ImageShape playerSquare;
    private ImageShape dealerSquare;
    private ImageShape playerWinSpace;
    private ImageShape dealerWinSpace;
    private ImageShape playerCardShape;
    private ImageShape computerCardShape;
    private ImageShape tieShape;
    private TextShape  playerScoreShape;
    private TextShape  computerScoreShape;


    // ----------------------------------------------------------
    /**
     * Run as soon as the screen is created.
     *
     * @param nameFromLaunch
     *            the name entered in the launch screen.
     */
    public void initialize(String nameFromLaunch)
    {
        // initialize our fields
        game = new War();
        height = getHeight();
        width = getWidth();
        cardWidth = 72;
        cardHeight = 96;
        rect = new RectF(0.0f, 0.0f, cardWidth, cardHeight);
        name = nameFromLaunch;
        goButtonActive = true;
        playerScore = 0;
        computerScore = 0;

        if (resetText)
        {
            remove(playerScoreShape);
            remove(computerScoreShape);
        }

        if (tie)
        {
            remove(tieShape);
        }
        tie = false;

        // set the background color to green
        setBackgroundColor(Color.green);

        // set up the player's deck image
        playerDeck = new ImageShape("back", rect);
        float playerDeckX = width / 2 - cardWidth / 2;
        float playerDeckY = height - cardHeight - 15;
        playerDeck.setPosition(playerDeckX, playerDeckY);
        add(playerDeck);

        // set up the dealer's deck image
        dealerDeck = new ImageShape("back", rect);
        float dealerDeckX = width / 2 - cardWidth / 2;
        float dealerDeckY = 15;
        dealerDeck.setPosition(dealerDeckX, dealerDeckY);
        add(dealerDeck);

        // set up the player's image square where its cards will go
        playerSquare = new ImageShape("cardspace", rect);
        float playerSquareX = width / 2 - cardWidth / 2;
        float playerSquareY = height / 2 + 10;
        playerSquare.setPosition(playerSquareX, playerSquareY);
        add(playerSquare);

        // set up the dealer's image square where its cards will go
        dealerSquare = new ImageShape("cardspace", rect);
        float dealerSquareX = width / 2 - cardWidth / 2;
        float dealerSquareY = height / 2 - cardHeight - 10;
        dealerSquare.setPosition(dealerSquareX, dealerSquareY);
        add(dealerSquare);

        // set up the place where the player's won cards will go
        playerWinSpace = new ImageShape("cardspace", rect);
        float playerWinSpaceX = width / 2 + cardWidth;
        float playerWinSpaceY = height - cardHeight - 15;
        playerWinSpace.setPosition(playerWinSpaceX, playerWinSpaceY);
        add(playerWinSpace);

        // set up the place where the dealer's won cards will go
        dealerWinSpace = new ImageShape("cardspace", rect);
        float dealerWinSpaceX = width / 2 + cardWidth;
        float dealerWinSpaceY = 15;
        dealerWinSpace.setPosition(dealerWinSpaceX, dealerWinSpaceY);
        add(dealerWinSpace);

        playerScoreShape =
            new TextShape("" + name + ": " + playerScore, 10, playerDeck.getY()
                + cardHeight / 2);
        playerScoreShape.setTypeSize(5f);
        add(playerScoreShape);

        computerScoreShape =
            new TextShape("Computer: " + computerScore, 10, dealerDeck.getY()
                + cardHeight / 2);
        computerScoreShape.setTypeSize(5f);
        add(computerScoreShape);

        resetText = true;

        game.dealHand();
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @throws InterruptedException
     */
    public void goButtonClicked()
        throws InterruptedException
    {
        if (goButtonActive)
        {
            Card playerCard = game.flipPlayerCard();
            Card computerCard = game.flipComputerCard();

            playerCardShape = new ImageShape(playerCard.toGraphic(), rect);
            playerCardShape.setPosition(playerDeck.getX(), playerDeck.getY());
            add(playerCardShape);

            computerCardShape = new ImageShape(computerCard.toGraphic(), rect);
            computerCardShape.setPosition(dealerDeck.getX(), dealerDeck.getY());
            add(computerCardShape);

            if (game.returnPlayer().returnHand().isEmpty())
            {
                playerDeck.setImage("cardspace");
                dealerDeck.setImage("cardspace");
            }

            playerCardShape.animate(1000)
                .position(playerSquare.getX(), playerSquare.getY()).play();
            computerCardShape.animate(1000)
                .position(dealerSquare.getX(), dealerSquare.getY()).play();

            Thread.sleep(1000);

            if (game.checkWinner(playerCard, computerCard) == 1)
            {
                playerScore++;
                playerScore++;
                playerCardShape.animate(1000)
                    .position(playerWinSpace.getX(), playerWinSpace.getY())
                    .play();
                computerCardShape.animate(1000)
                    .position(playerWinSpace.getX(), playerWinSpace.getY())
                    .play();

                Thread.sleep(1000);

                if (tie)
                {
                    playerScore++;
                    playerScore++;
                    tieShape.animate(1000).position(
                        playerWinSpace.getX(),
                        playerWinSpace.getY());

                    Thread.sleep(1000);

                    remove(tieShape);
                    tie = false;
                }

                playerWinSpace.setImage("back");
                remove(playerCardShape);
                remove(computerCardShape);

                playerScoreShape.setText("" + name + ": " + playerScore);
            }

            if (game.checkWinner(playerCard, computerCard) == -1)
            {
                computerScore++;
                computerScore++;
                playerCardShape.animate(1000)
                    .position(dealerWinSpace.getX(), dealerWinSpace.getY())
                    .play();
                computerCardShape.animate(1000)
                    .position(dealerWinSpace.getX(), dealerWinSpace.getY())
                    .play();

                Thread.sleep(1000);

                if (tie)
                {
                    computerScore++;
                    computerScore++;
                    tieShape.animate(1000).position(
                        dealerWinSpace.getX(),
                        dealerWinSpace.getY());

                    Thread.sleep(1000);

                    remove(tieShape);
                    tie = false;
                }

                dealerWinSpace.setImage("back");
                remove(playerCardShape);
                remove(computerCardShape);

                computerScoreShape.setText("Computer: " + computerScore);
            }

            if (game.checkWinner(playerCard, computerCard) == 0)
            {
                tie = true;

                float tieX = width / 2 + cardWidth;
                float tieY = height / 2 - cardHeight / 2;

                tieShape = new ImageShape("back", rect);
                tieShape.setPosition(tieX, tieY);

                playerCardShape.animate(1000).position(tieX, tieY).play();
                computerCardShape.animate(1000).position(tieX, tieY).play();

                Thread.sleep(1000);

                add(tieShape);
                remove(playerCardShape);
                remove(computerCardShape);
            }

            if (game.returnPlayer().returnHand().isEmpty())
            {
                playerDeck.setImage("cardspace");
                dealerDeck.setImage("cardspace");

                if (playerScore > computerScore)
                {
                    String str = "You Win!  Press reset to play again.";
                    Toast.makeText(this, str, Toast.LENGTH_LONG).show();
                    goButtonActive = false;
                }

                if (playerScore < computerScore)
                {
                    String str = "You Lost!  Press reset to play again.";
                    Toast.makeText(this, str, Toast.LENGTH_LONG).show();
                    goButtonActive = false;
                }

                if (playerScore == computerScore)
                {
                    String str = "It's a tie!  Press reset to play again.";
                    Toast.makeText(this, str, Toast.LENGTH_LONG).show();
                    goButtonActive = false;
                }
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Called when the reset button is clicked.
     */
    public void resetButtonClicked()
    {
        initialize(name);
    }
}
