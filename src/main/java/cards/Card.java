package cards;

/**
 *
 * @author ramareddy
 */
public class Card {

    private final Face face;
    private final Suit suit;

    // initialize face of card and suit
    public Card(final Face face, final Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    // return String representation of Card
    @Override
    public String toString() {
        return face + " of " + suit;
    }
}
