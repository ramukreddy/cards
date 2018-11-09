package cards;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 *
 * @author ramareddy
 */
public class DeckOfCards {

    private final Stack<Card> deck;

    private final int NUMBER_OF_CARDS = 52;
    private final Random randomNumbers; // random number generator

    public DeckOfCards() {
        this.deck = initCards();
        this.randomNumbers = new Random(); // create random number generator

    }

    // setting up initial cards
    private Stack<Card> initCards() {
        final Stack<Card> cards = new Stack<>();
        EnumSet.allOf(Suit.class).forEach(suit -> {
            EnumSet.allOf(Face.class).forEach(face -> {
                cards.push(new Card(face, suit));

            });
        });

        return cards;
    }

    // shuffle deck of Cards 
    public void shuffle() {
        // create tempDeck to store all cards 
        Stack<Card> tempDeck = new Stack<>();
        tempDeck.addAll(deck);
        // clear the main deck 
        deck.clear();
        // just loop through number of cards, and randomly pick cards and push to deck stack
        IntStream.range(0, tempDeck.size()).forEach(
                nbr -> {
                    int randomLocation = randomNumbers.nextInt(NUMBER_OF_CARDS);
                    deck.push(tempDeck.get(randomLocation));
                }
        );
        
        // we can choose to clear tempDeck
        tempDeck.clear();

    } 

    // deal one Card
    public Optional<Card> dealOneCard() {
        return this.deck.empty() ? Optional.empty() : Optional.of(this.deck.pop());
    }
    
    // return the size of deck
    public int getDeckSize() {
    	
    	return deck.size();
    	
    }

}
