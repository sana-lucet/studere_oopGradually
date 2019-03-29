package model.card;

import java.util.ArrayList;

public class CardHand {
    private final CardDeck deck;
    private ArrayList<Card> hand = new ArrayList<Card>();

    public CardHand(){
        this.deck = CardDeck.getDeck();
    }

    public void add(){
        Card card = this.deck.popCard();
        this.hand.add(card);
    }

    public int total(){
        int total = 0;
        for (Card card : hand){
            total += card.getPoint();
        }
        return total;
    }

    public void debugPrint(){
        for (Card card : hand) {
            System.out.println(card.getRankSymbol() + " : " + card.getSuitSymbol());
        }
    }
}
