import java.util.Arrays;

/**
 * 
 * @author Christopher
 * 
 *         The player is known as a "hand". Initially, each hand is given 5
 *         cards from deck randomly.
 */
public class Hand implements Comparable<Hand> {
	private Card[] cards = new Card[5];
	private int[] value = new int[6];

	private Deck deck;

	/**
	 * When a hand is created, 5 cards is drawn from the deck and classified.
	 * 
	 * @param deck
	 *            - The deck, from where the cards are drawn.
	 */
	public Hand(Deck deck) {
		this.deck = deck;
		for (int i = 0; i < 5; i++) {
			cards[i] = deck.drawFromDeck();
		}
		classify();
	}

	/**
	 * Logic to find where a hand stands based on the cards
	 */
	public void classify() {

		int[] orderedRanks = new int[7];
		boolean flush = true, straight = false;
		int sameCards = 1, sameCards2 = 1;
		int largeGroupRank = 0, smallGroupRank = 0;
		int index = 0;
		int topStraightValue = 0;
		int[] ranks = new int[14];

		Arrays.fill(ranks, 0);

		/*
		 * Fill the ranks array with a value of "1" in those indices,
		 * corresponding to which the hand has cards. If the hand has two or
		 * more cards of the same rank, then ranks[n] will be incremented again.
		 * At the end, the ranks array contains the information as how many
		 * cards of a given rank exists in the hand
		 */
		for (Card card : cards) {
			ranks[card.getRank()]++;
		}

		/*
		 * Check if "Flush"
		 */
		for (int i = 0; i < cards.length - 1; i++) {
			if (cards[i].getSuit() != cards[i + 1].getSuit())
				flush = false;
		}

		/*
		 * Check how many "Same cards" the hand has
		 */
		for (int i = 13; i >= 1; i--) {
			if (ranks[i] > sameCards) {
				// if sameCards was not the default value
				if (sameCards != 1) {
					sameCards2 = sameCards;
					smallGroupRank = i;
				}

				sameCards = ranks[i];
				largeGroupRank = i;

			} else if (ranks[i] > sameCards2) {
				sameCards2 = ranks[i];
				smallGroupRank = i;
			}
		}

		// if ace, run this before because ace is highest card
		if (ranks[1] == 1) {
			orderedRanks[index] = 14;
			index++;
		}

		for (int i = 13; i >= 2; i--) {
			if (ranks[i] == 1) {
				orderedRanks[index] = i; // if ace
				index++;
			}
		}

		// can't have straight with lowest value of more than 10
		for (int x = 1; x <= 9; x++) {
			if (ranks[x] == 1 && ranks[x + 1] == 1 && ranks[x + 2] == 1
					&& ranks[x + 3] == 1 && ranks[x + 4] == 1) {
				straight = true;
				topStraightValue = x + 4; // 4 above bottom value
				if (ranks[topStraightValue + 1] == 1) {
					topStraightValue = x + 5;
				} else if (ranks[topStraightValue + 2] == 1) {
					topStraightValue = x + 6;
				}
				break;
			}
		}

		if (ranks[10] == 1 && ranks[11] == 1 && ranks[12] == 1
				&& ranks[13] == 1 && ranks[1] == 1) // ace high
		{
			straight = true;
			topStraightValue = 14; // higher than king
		}

		Arrays.fill(value, 0);

		// start hand evaluation
		if (sameCards == 1) {
			value[0] = 1;
			value[1] = orderedRanks[0];
			value[2] = orderedRanks[1];
			value[3] = orderedRanks[2];
			value[4] = orderedRanks[3];
			value[5] = orderedRanks[4];
		}

		if (sameCards == 2 && sameCards2 == 1) {
			value[0] = 2;
			value[1] = largeGroupRank; // rank of pair
			value[2] = orderedRanks[0];
			value[3] = orderedRanks[1];
			value[4] = orderedRanks[2];
		}

		if (sameCards == 2 && sameCards2 == 2) // two pair
		{
			value[0] = 3;
			value[1] = largeGroupRank > smallGroupRank ? largeGroupRank
					: smallGroupRank; // rank of greater pair
			value[2] = largeGroupRank < smallGroupRank ? largeGroupRank
					: smallGroupRank;
			value[3] = orderedRanks[0]; // extra card
		}

		if (sameCards == 3 && sameCards2 != 2) {
			value[0] = 4;
			value[1] = largeGroupRank;
			value[2] = orderedRanks[0];
			value[3] = orderedRanks[1];
		}

		if (straight && !flush) {
			value[0] = 5;
			value[1] = topStraightValue;
		}

		if (flush && !straight) {
			value[0] = 6;
			value[1] = orderedRanks[0]; // tie determined by ranks of cards
			value[2] = orderedRanks[1];
			value[3] = orderedRanks[2];
			value[4] = orderedRanks[3];
			value[5] = orderedRanks[4];
		}

		if (sameCards == 3 && sameCards2 == 2) {
			value[0] = 7;
			value[1] = largeGroupRank;
			value[2] = smallGroupRank;
		}

		if (sameCards == 4) {
			value[0] = 8;
			value[1] = largeGroupRank;
			value[2] = orderedRanks[0];
		}

		if (straight && flush) {
			value[0] = 9;
			value[1] = topStraightValue;
		}

	}

	/**
	 * Print the cards in the current hand
	 */
	public void showHand() {
		for (Card card : cards) {
			System.out.println(card);
		}
		System.out.println();
	}

	/**
	 * Display the current value of the hand
	 */
	public void display() {
		String s;
		switch (value[0]) {

		case 1:
			s = "high card";
			break;
		case 2:
			s = "pair of " + Card.rankAsString(value[1]) + "\'s";
			break;
		case 3:
			s = "two pair " + Card.rankAsString(value[1]) + " "
					+ Card.rankAsString(value[2]);
			break;
		case 4:
			s = "three of a kind " + Card.rankAsString(value[1]) + "\'s";
			break;
		case 5:
			s = Card.rankAsString(value[1]) + " high straight";
			break;
		case 6:
			s = "flush";
			break;
		case 7:
			s = "full house " + Card.rankAsString(value[1]) + " over "
					+ Card.rankAsString(value[2]);
			break;
		case 8:
			s = "four of a kind " + Card.rankAsString(value[1]);
			break;
		case 9:
			s = "straight flush " + Card.rankAsString(value[1]) + " high";
			break;
		default:
			s = "error in Hand.display: value[0] contains invalid value";
		}

		System.out.println(s);
		System.out.println();
	}

	/**
	 * Compare this hand with another hand
	 */
	@Override
	public int compareTo(Hand other) {
		for (int i = 0; i < 6; i++) {
			if (this.value[i] > other.value[i]) {
				return 1;
			} else if (this.value[i] < other.value[i]) {
				return -1;
			}
		}
		return 0;
	}

	/**
	 * HS-Analysis alogrithm
	 * 
	 * @return
	 */
	public String doHsAnalysis() {
		char[] chars = new char[13];

		/*
		 * Fill all 13 cards as holes
		 */
		Arrays.fill(chars, 'h');

		/*
		 * Fill those places where there are cards with "s" (sequence)
		 */
		for (int i = 0; i < cards.length; i++) {
			chars[cards[i].getRank()] = 's';
		}

		/*
		 * Output for the hs analysis
		 */
		String output = "" + chars[0];
		char prev = chars[0];
		int count = 1;

		/*
		 * For each consecutive "h" or "s" find the count, and the suffix with
		 * either "h" or "s"
		 */
		for (int i = 1; i < chars.length; i++) {
			char curr = chars[i];
			if (prev != curr) {
				prev = curr;
				output += count;
				output += prev;
				count = 1;
			} else {
				count++;
			}
		}

		/*
		 * return the result of hs-analysis
		 */
		return output;
	}

	/*
	 * Draw the least valuable card based on the value.
	 */
	public Card draw() {
		int rankToDiscard = -1;

		/*
		 * If "high-hand" or "pair", then apply the hs-analysis
		 */
		if (value[0] == 1 || value[1] == 1) {
			// apply hs-analysis
			String hsAnalysis = doHsAnalysis();

			/*
			 * Based on the hs-analysis, return the card with lowest rank
			 */
			if (hsAnalysis.contains("s2s3h1") || hsAnalysis.contains("s3h1s2")
					|| hsAnalysis.matches("s1h[1-8]s4")) {
				Card[] temp = new Card[cards.length];
				System.arraycopy(cards, 0, temp, 0, cards.length);
				Arrays.sort(temp);

				Card cardToDiscard;
				for (int i = 0; i < cards.length; i++) {
					if (cards[i].equals(temp[0])) {
						cardToDiscard = cards[i];
						cards[i] = null;
						return cardToDiscard;
					}
				}
			} else if (hsAnalysis.matches("s4h[1-8]s1")) {
				Card[] temp = new Card[cards.length];
				System.arraycopy(cards, 0, temp, 0, cards.length);
				Arrays.sort(temp);
				Card cardToDiscard;
				for (int i = 0; i < cards.length; i++) {
					if (cards[i].equals(temp[temp.length - 1])) {
						cardToDiscard = cards[i];
						cards[i] = null;
						return cardToDiscard;
					}
				}
			}

		}

		/*
		 * If hs-analysis could not suggest the card to discard, apply the
		 * default logic for discarding the least valued card
		 */
		switch (value[0]) {
		case 1: // "highcard"
			if (value[1] == 14) {
				rankToDiscard = 14;
			} else {
				if (value[5] == 0) {
					rankToDiscard = value[4];
				} else {
					rankToDiscard = value[5];
				}
			}
			break;
		case 2: // pair-of-single
			if (value[2] == 14) {
				rankToDiscard = 14;
			} else {
				if (value[4] == 0) {
					rankToDiscard = value[3];
				} else {
					rankToDiscard = value[4];
				}
			}
			break;
		case 3: // 2 pairs
			if (value[3] == 14) {
				rankToDiscard = 14;
			} else {
				rankToDiscard = value[3];
			}
		case 4: // three of a kind
			if (value[2] == 14) {
				rankToDiscard = 14;
			} else {
				if (value[3] == 0) {
					rankToDiscard = value[2];
				} else {
					rankToDiscard = value[3];
				}
			}
			break;
		default:
			display();
		}

		int index = getCardIndexWithRank(rankToDiscard);
		if (index == -1) {
			return null;
		}
		Card cardToDiscard = cards[index];
		cards[index] = null;
		return cardToDiscard;
	}

	/**
	 * Deal - take a new card from the deck and classify again
	 */
	public void deal() {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				cards[i] = deck.drawFromDeck();
				System.out.println("Got this new card: " + cards[i]);
				break;
			}
		}
		classify();
	}

	/**
	 * We need the card's index with a given rank. If there are multiple cards
	 * with a given rank, then the first one is returned.
	 * 
	 * @param rank
	 * @return - Index of the card with the given rank
	 */
	public int getCardIndexWithRank(int rank) {
		if (rank == 14) {
			rank = 1;
		}
		int index;
		for (index = 0; index < cards.length; index++) {
			if (cards[index].getRank() == rank) {
				return index;
			}
		}
		return -1;
	}

	public int[] getValue() {
		return value;
	}

	@Override
	public String toString() {
		String output = "[";
		for (Card card : cards) {
			output += card + ", ";
		}
		output = output.substring(0, output.length() - 2) + "]";

		return output;
	}
}
