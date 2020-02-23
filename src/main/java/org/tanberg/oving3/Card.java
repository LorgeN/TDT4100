package org.tanberg.oving3;

import java.util.Arrays;

public class Card {

	private final CardColor suit;
	private final byte face;

	public Card(char suit, int face) {
		this(CardColor.fromId(suit), face);
	}

	public Card(CardColor suit, int face) {
		this.suit = suit;

		if (face < 1 || face > 13) {
			throw new IllegalArgumentException("Invalid face value " + face);
		}

		this.face = (byte) face;
	}

	public char getSuit() {
		return this.suit.getId();
	}

	public int getFace() {
		return this.face;
	}
	
	
	@Override
	public String toString() {
		return this.getSuit() + String.valueOf(this.getFace());
	}

	public enum CardColor {
		SPADES('S'), HEARTS('H'), DIAMONDS('D'), CLUBS('C');

		private final char id;

		CardColor(char id) {
			this.id = id;
		}

		public char getId() {
			return this.id;
		}

		public static CardColor fromId(char id) {
			return Arrays.stream(CardColor.values()).filter(color -> color.getId() == id).findFirst()
					.orElseThrow(() -> new IllegalArgumentException("Unknown color \"" + id + "\"!"));
		}
	}
}
