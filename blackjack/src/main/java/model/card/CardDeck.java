package model.card;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    public static CardDeck DECK;
    public ArrayList<Card> cardset = new ArrayList<Card>();

    private CardDeck(){
        ArrayList<Card> cardset = new ArrayList<Card>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                this.cardset.add(new Card(rank, suit));;
            }
        }
    }

    public static CardDeck getDeck() {
        if (DECK == null){
            DECK = new CardDeck();
        }
        DECK._shuffle();
        return DECK;
    }

    public Card popCard(){
        Card card = this.cardset.get(0);
        this.cardset.remove(0);
        return card;
    }

    private void _shuffle(){
        Collections.shuffle(this.cardset);
    }

    public void debugPrint(){
        for (Card card : cardset) {
            System.out.println(card.getRankSymbol() + " : " + card.getSuitSymbol());
        }
    }
}
