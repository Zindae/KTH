package com.vinod.poker;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		Deck deck = new Deck();
		int noOfHands;

		do {
			noOfHands = KeyboardUtil.getInt("Enter the number of hands: ");
			if (noOfHands < 1 || noOfHands > 5) {
				System.out.println("Please enter a number between 1 and 5");
			}
		} while (noOfHands < 1 || noOfHands > 5);

		Hand[] hands = new Hand[noOfHands];

		for (int i = 0; i < hands.length; i++) {
			hands[i] = new Hand(deck);
		}
		for (int j = 0; j < hands.length; j++) {
			Hand hand = hands[j];
			System.out.print("Hand #" + (j + 1) + " ");
			System.out.println(hand);
			System.out.print("Classification: ");
			hand.display();
			Card drawnCard = hand.draw();
			System.out.println("Drawing card ... " + drawnCard);
			System.out.print("Dealing...");
			hand.deal();
			System.out.println();
			System.out.println("After dealing");
			System.out.print("Hand #" + (j + 1) + " ");
			System.out.println(hand);
			
			System.out.print("Classification: ");
			hand.display();
			
			deck.add(drawnCard);
			System.out.println();
			line();
		}

	}

	private static void line() {
		char[] chars = new char[80];
		Arrays.fill(chars, '-');
		System.out.println(new String(chars));
	}
}
