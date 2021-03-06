package BlackJack.view;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class CardGraph extends Rectangle {
    private ImagePattern cardImage;
    private String suit;
    private String rank;
    private boolean faceUp;
    private final ImagePattern backCard = new ImagePattern(new Image(String.valueOf(getClass().getResource("/cardsPng/cardBack.jpg"))));


    public CardGraph(String suit, String rank, boolean faceUp) {
        this.suit = suit;
        this.rank = rank;
        this.faceUp = faceUp;
        cardImage = new ImagePattern(new Image(String.valueOf(getClass().getResource("/cardsPng/" + rank + "_of_" + suit + ".png"))));
        setStyling();
        changeFace();


    }

    public boolean getFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean state) {
        this.faceUp = state;
    }

    /**
     * if faceUp is true fill it with figure, if is false fill it with backSide
     */
    public void changeFace() {
        this.setFill((getFaceUp()) ? cardImage : backCard);
    }

    /**
     * Sets the styling for the graphic
     */
    private void setStyling() {
        this.setFill(cardImage);
        this.setWidth(80);
        this.setHeight(130);
        this.prefWidth(cardImage.getWidth());
        this.prefHeight(cardImage.getHeight());
        this.setArcHeight(10);
        this.setArcWidth(10);
    }

    /**
     * prints the suit and the rank of the card, for debugging use.
     * @return CardGraphs suit and rank string value
     */
    @Override
    public String toString() {
        return "Suit: " + suit + " number " + rank;
    }
}
