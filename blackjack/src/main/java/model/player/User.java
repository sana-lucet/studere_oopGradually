package model.player;

import model.card.Card;
import model.card.CardDeck;

import java.util.ArrayList;

public class User extends Player {
    private final ArrayList<Card> hand = new ArrayList<Card>();
    private final CardDeck deck;
    private int totalPoints = 0;

    public User(CardDeck deck){
        this.deck = deck;
    }

    @Override
    protected void _emptyHands() {
        this.hand.clear();
        this.totalPoints = 0;
    }

    @Override
    protected void _hit() {
        Card card = deck.popCard();
        this.totalPoints += card.getPoint();
        this.hand.add(card);
    }

    protected int _totalPoints() {
        return this.totalPoints;
    }

    @Override
    ArrayList<Card> _getHand() {
//        return (ArrayList<Card>) hand.clone();
        return hand;
    }

    @Override
    void _debugPrint() {
        for (Card card : hand) {
            System.out.print(card.getRankSymbol() + "" + card.getSuitSymbol() + " ");
        }
        System.out.println("(합계: " + this.totalPoints + ")\n");
    }

    @Override
    public String toString() {
        return "플레이어";
    }


}
