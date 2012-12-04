package groupproject.wargame;

import android.graphics.RectF;
import sofia.graphics.ImageShape;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Matt
 * @version Dec 3, 2012
 */
public class BlackJackScreen
    extends ShapeScreen
{
    private Blackjack game;
    private float     height;
    private float     width;
    private float     cardHeight;
    private float     cardWidth;
    private ImageShape[][] dealerCardList;
    private ImageShape[][] playerCardList;


    public void initialize()
    {
        dealerCardList = new ImageShape[2][4];
        playerCardList = new ImageShape[2][4];

        setBackgroundColor(Color.green);
        height = getHeight();
        width = getWidth();
        cardWidth = 72;
        cardHeight = 96;

        int arrayIndexI = 0;

        for (float i = 0; i < cardWidth*4; i = i + cardWidth)
        {
            int arrayIndexJ = 0;
            for (float j = 0; j < 2 * cardHeight; j = j + cardHeight)
            {
                RectF rect = new RectF(0.0f, 0.0f, cardWidth, cardHeight);
                ImageShape topCardSpace = new ImageShape("cardspace", rect);
                topCardSpace.setPosition(i, j);
                //dealerCardList[arrayIndexI][arrayIndexJ] = topCardSpace;
                add(topCardSpace);

                arrayIndexJ++;
            }
            arrayIndexI++;
        }

        arrayIndexI = 0;
        for (float i = 0; i < cardWidth*4; i = i + cardWidth)
        {
            int arrayIndexJ = 0;
            for (float j = height; j > height - (2 * cardHeight + 1); j =
                j - cardHeight)
            {
                RectF rect = new RectF(0.0f, 0.0f, cardWidth, cardHeight);
                ImageShape bottomCardSpace = new ImageShape("cardspace", rect);
                bottomCardSpace.setPosition(i, j);
                //playerCardList[arrayIndexI][arrayIndexJ] = bottomCardSpace;
                add(bottomCardSpace);

                arrayIndexJ++;
            }
            arrayIndexI++;
        }
    }
}
