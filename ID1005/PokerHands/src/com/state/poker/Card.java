package com.vinod.poker;


/**
 * @author Christopher
 * 
 * An instance of this class represents a single card. A card has a rank
 * and belongs to a suit (Heart, Club, Spade, Diamond)
 */
public class Card implements Comparable<Card>{
	private Suit suit;
	private int rank;

	private static String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "Jack", "Queen", "King"};

	public static String rankAsString(int rank) {
		return ranks[rank];
	}

	public Card(Suit suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return String.format("%s of %s", ranks[rank], suit);
	}

	@Override
	public int compareTo(Card other) {
		return this.rank - other.rank;
	}
}
