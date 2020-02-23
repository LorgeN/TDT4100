package org.tanberg.oving3;

import java.util.Arrays;

public class CardDeck {

    private final Card[] cards;

    public CardDeck(int n) {
        // Multiply by 4 to get total size of deck
        this.cards = new Card[n << 2];

        Card.CardColor[] colors = Card.CardColor.values();
        for (int i = 0; i < this.cards.length; i++) {
            this.cards[i] = new Card(colors[i / n], (i % n) + 1);
        }
    }

    public int getCardCount() {
        return this.cards.length;
    }

    public Card getCard(int n) {
        if (n < 0 || n >= this.cards.length) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        return this.cards[n];
    }

    public void shufflePerfectly() {
        int deckSize = this.getCardCount();
        int halfSize = deckSize >> 1;

        Card[] bottomHalf = Arrays.copyOfRange(this.cards, 0, halfSize);
        Card[] topHalf = Arrays.copyOfRange(this.cards, halfSize, deckSize);

        for (int i = 0; i < halfSize; i++) {
            int deckIndex = i << 1;
            this.cards[deckIndex] = bottomHalf[i];
            this.cards[deckIndex + 1] = topHalf[i];
        }
    }
}
