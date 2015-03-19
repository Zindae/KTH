package com.vinod.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				cards.add(new Card(Suit.values()[i], j));
			}
		}
		Collections.shuffle(cards);
	}

	public Card drawFromDeck() {
		return cards.remove(0);
	}

	public int getRemainingCards() {
		return cards.size();
	}

	public void add(Card card) {
		cards.add(card);
		Collections.shuffle(cards);
	}
}
