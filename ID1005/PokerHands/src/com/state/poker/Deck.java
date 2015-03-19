package com.vinod.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Christopher
 * 
 *         An instance of this class represents a pack of cards a.k.a deck. It
 *         has all the cards of each suit, total of 52 cards.
 */
public class Deck {
	/**
	 * This member is represents a bunch of 52 cards.
	 */
	private List<Card> cards;

	/**
	 * Initialize the deck by adding all 52 cards, 13 cards from each suit.
	 */
	public Deck() {
		cards = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				cards.add(new Card(Suit.values()[i], j));
			}
		}

		/*
		 * shuffle the cards, so that each time you pick a deck, the cards are
		 * in random order
		 */
		Collections.shuffle(cards);
	}

	/**
	 * Each time a hand throws a card, it is replaced with another card from the deck.
	 * You call this method to get a fresh card.
	 * 
	 * @return - A card to replace the thrown card by a hand
	 */
	public Card drawFromDeck() {
		return cards.remove(0);
	}

	/**
	 * How many cards are still there in the deck?
	 * @return - A count of the remaining cards in the deck.
	 */
	public int getRemainingCards() {
		return cards.size();
	}

	/**
	 * The card thrown (discarded) by a hand is added to the deck, and being shuffled, so that
	 * it is not immediately available to another hand for drawing
	 * 
	 * @param card - A card discarded by a hand
	 */
	public void add(Card card) {
		cards.add(card);
		Collections.shuffle(cards);
	}
}
